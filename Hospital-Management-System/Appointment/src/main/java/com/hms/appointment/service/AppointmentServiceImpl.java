package com.hms.appointment.service;

import com.hms.appointment.clients.ProfileClient;
import com.hms.appointment.dto.*;
import com.hms.appointment.entity.Appointment;
import com.hms.appointment.exception.HmException;
import com.hms.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ProfileClient profileClient;

    @Override
    public Long scheduleAppointment(AppointmentDTO appointmentDTO)throws HmException {
        if(appointmentDTO.getAppointmentTime() == null || appointmentDTO.getAppointmentTime().isBefore(LocalDateTime.now())){
            throw new HmException("INVALID_APPOINTMENT_TIME");
        }
        Boolean doctorExists = profileClient.doctorExists(appointmentDTO.getDoctorId());
        if(doctorExists == null || !doctorExists){
            throw new HmException("DOCTOR_NOT_FOUND");
        }
        Boolean patientExists = profileClient.patientExists(appointmentDTO.getPatientId());
        if(patientExists == null || !patientExists){
            throw new HmException("PATIENT_NOT_FOUND");
        }
        if(appointmentRepository.existsByDoctorIdAndAppointmentTimeAndStatus(
                appointmentDTO.getDoctorId(), appointmentDTO.getAppointmentTime(), Status.SCHEDULED)){
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
