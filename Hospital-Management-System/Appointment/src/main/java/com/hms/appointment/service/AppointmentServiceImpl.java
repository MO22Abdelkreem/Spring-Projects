package com.hms.appointment.service;

import com.hms.appointment.clients.ProfileClient;
import com.hms.appointment.dto.*;
import com.hms.appointment.entity.Appointment;
import com.hms.appointment.exception.HmException;
import com.hms.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ProfileClient profileClient;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ProfileClient profileClient) {
        this.appointmentRepository = appointmentRepository;
        this.profileClient = profileClient;
    }

    @Override
    public Long scheduleAppointment(AppointmentDTO appointmentDTO) throws HmException {
        if (appointmentDTO == null) {
            throw new HmException("INVALID_APPOINTMENT");
        }

        if (appointmentDTO.getAppointmentTime() == null || appointmentDTO.getAppointmentTime().isBefore(LocalDateTime.now())) {
            throw new HmException("INVALID_APPOINTMENT_TIME");
        }

        if (appointmentDTO.getPatientId() == null) {
            throw new HmException("PATIENT_NOT_FOUND");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isDoctor = authentication != null && authentication.getAuthorities().stream()
                .anyMatch(a -> "ROLE_DOCTOR".equals(a.getAuthority()));

        if (isDoctor) {
            String currentDoctorEmail = authentication.getName();
            Long currentDoctorId = profileClient.getDoctorByEmail(currentDoctorEmail);

            if (appointmentDTO.getDoctorId() != null && !appointmentDTO.getDoctorId().equals(currentDoctorId)) {
                throw new HmException("UNAUTHORIZED_DOCTOR_ACCESS");
            }
            appointmentDTO.setDoctorId(currentDoctorId);
        } else {
            if (appointmentDTO.getDoctorId() == null || !Boolean.TRUE.equals(profileClient.doctorExists(appointmentDTO.getDoctorId()))) {
                throw new HmException("DOCTOR_NOT_FOUND");
            }
        }

        if (!Boolean.TRUE.equals(profileClient.patientExists(appointmentDTO.getPatientId()))) {
            throw new HmException("PATIENT_NOT_FOUND");
        }

        if (appointmentRepository.existsByDoctorIdAndAppointmentTimeAndStatus(
                appointmentDTO.getDoctorId(), appointmentDTO.getAppointmentTime(), Status.SCHEDULED)) {
            throw new HmException("DOCTOR_UNAVAILABLE_SLOT");
        }

        appointmentDTO.setStatus(Status.SCHEDULED);
        return appointmentRepository.save(appointmentDTO.toEntity()).getId();
    }

    @Override
    public void cancelledAppointment(Long appointmentId)throws HmException {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()->new HmException("APPOINTMENT_NOT_FOUND"));
        if(appointment.getStatus().equals(Status.CANCELLED)){
            throw new HmException("APPOINTMENT_ALREADY_CANCELLED");
        }
        appointment.setStatus(Status.CANCELLED);
        appointmentRepository.save(appointment);
    }

    @Override
    public void rescheduleAppointment(Long appointmentId, LocalDateTime newDateTime) throws HmException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new HmException("APPOINTMENT_NOT_FOUND"));
        if (appointment.getStatus().equals(Status.CANCELLED)) {
            throw new HmException("APPOINTMENT_ALREADY_CANCELLED");
        }
        if (appointment.getStatus().equals(Status.COMPLETED)) {
            throw new HmException("APPOINTMENT_ALREADY_COMPLETED");
        }
        if (newDateTime == null || newDateTime.isBefore(LocalDateTime.now())) {
            throw new HmException("INVALID_APPOINTMENT_TIME");
        }
        if (appointmentRepository.existsByDoctorIdAndAppointmentTimeAndStatus(
                appointment.getDoctorId(), newDateTime, Status.SCHEDULED)) {
            throw new HmException("DOCTOR_UNAVAILABLE_SLOT");
        }
        appointment.setAppointmentTime(newDateTime);
        appointmentRepository.save(appointment);
    }

    @Override
    public void completeAppointment(Long appointmentId) throws HmException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new HmException("APPOINTMENT_NOT_FOUND"));
        if (appointment.getStatus().equals(Status.CANCELLED)) {
            throw new HmException("APPOINTMENT_ALREADY_CANCELLED");
        }
        if (appointment.getStatus().equals(Status.COMPLETED)) {
            throw new HmException("APPOINTMENT_ALREADY_COMPLETED");
        }
        appointment.setStatus(Status.COMPLETED);
        appointmentRepository.save(appointment);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId).stream().map(Appointment::toDTO).toList();
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId).stream().map(Appointment::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientDTO> getMyPatients() throws HmException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new HmException("UNAUTHORIZED");
        }
        String doctorEmail = authentication.getName();

        Long doctorId = profileClient.getDoctorByEmail(doctorEmail);
        if (doctorId == null) {
            throw new HmException("DOCTOR_NOT_FOUND");
        }

        List<Long> patientIds = appointmentRepository.findDistinctPatientIdsByDoctorId(doctorId);

        if (patientIds == null || patientIds.isEmpty()) {
            return Collections.emptyList();
        }

        return profileClient.getPatientsByIds(patientIds);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppointmentDTO> getUpcomingAppointmentsPatient(Long patientId, AppointmentTimeframe timeframe) {
        LocalDateTime now = LocalDateTime.now();

        List<Appointment> appointments;

        if (timeframe == AppointmentTimeframe.TODAY) {
            LocalDateTime endOfToday = now.toLocalDate().atTime(LocalTime.MAX);
            appointments = appointmentRepository
                    .findByPatientIdAndStatusAndAppointmentTimeBetweenOrderByAppointmentTimeAsc
                            (patientId, Status.SCHEDULED, now, endOfToday);
        } else if (timeframe == AppointmentTimeframe.WEEK) {
            LocalDateTime endOfWeek = now.toLocalDate().plusDays(7).atTime(LocalTime.MAX);
            appointments = appointmentRepository.findByPatientIdAndStatusAndAppointmentTimeBetweenOrderByAppointmentTimeAsc
                    (patientId, Status.SCHEDULED, now, endOfWeek);
        } else {
            appointments = appointmentRepository
                    .findByPatientIdAndStatusAndAppointmentTimeGreaterThanEqualOrderByAppointmentTimeAsc
                            (patientId, Status.SCHEDULED, now);

        }
        return appointments.stream().map(Appointment::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppointmentDTO> getUpcomingAppointmentsDoctor(Long doctorId, AppointmentTimeframe timeframe) {
        LocalDateTime now = LocalDateTime.now();

        List<Appointment> appointments;

        if (timeframe == AppointmentTimeframe.TODAY) {
            LocalDateTime endOfToday = now.toLocalDate().atTime(LocalTime.MAX);
            appointments = appointmentRepository
                    .findByDoctorIdAndStatusAndAppointmentTimeBetweenOrderByAppointmentTimeAsc(
                            doctorId, Status.SCHEDULED, now, endOfToday);
        } else if (timeframe == AppointmentTimeframe.WEEK) {
            LocalDateTime endOfWeek = now.toLocalDate().plusDays(7).atTime(LocalTime.MAX);
            appointments = appointmentRepository
                    .findByDoctorIdAndStatusAndAppointmentTimeBetweenOrderByAppointmentTimeAsc(
                            doctorId, Status.SCHEDULED, now, endOfWeek);
        } else {
            appointments = appointmentRepository
                    .findByDoctorIdAndStatusAndAppointmentTimeGreaterThanEqualOrderByAppointmentTimeAsc(
                            doctorId, Status.SCHEDULED, now);
        }

        return appointments.stream().map(Appointment::toDTO).toList();
    }

    @Override
    public AppointmentDTO getAppointmentDetails(Long appointmentId)throws HmException {
        return appointmentRepository.findById(appointmentId).orElseThrow(()->new HmException("APPOINTMENT_NOT_FOUND")).toDTO();

    }

    @Override
    public AppointmentDetails getAppointmentDetailsWithName(Long appointmentId) throws HmException {
        AppointmentDTO appointmentDTO = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new HmException("APPOINTMENT_NOT_FOUND")).toDTO();
        DoctorDTO doctorDTO = profileClient.getDoctorById(appointmentDTO.getDoctorId());
        if (doctorDTO == null) {
            throw new HmException("DOCTOR_NOT_FOUND");
        }
        PatientDTO patientDTO = profileClient.getPatientById(appointmentDTO.getPatientId());
        if (patientDTO == null) {
            throw new HmException("PATIENT_NOT_FOUND");
        }

        return new AppointmentDetails(appointmentDTO.getId(), appointmentDTO
                .getDoctorId(),doctorDTO.getUsername(),
                doctorDTO.getPhone(),doctorDTO
                .getEmail(), appointmentDTO.getPatientId()
                ,patientDTO.getUsername(),patientDTO.getPhone()
                ,patientDTO.getEmail()
                ,appointmentDTO.getAppointmentTime(),
                appointmentDTO.getStatus(),
                appointmentDTO.getReason(),
                appointmentDTO.getNotes()
        );
    }
}
