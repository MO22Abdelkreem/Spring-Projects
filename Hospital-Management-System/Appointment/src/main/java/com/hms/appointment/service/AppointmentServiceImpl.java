package com.hms.appointment.service;

import com.hms.appointment.dto.*;
import com.hms.appointment.entity.Appointment;
import com.hms.appointment.exception.HmException;
import com.hms.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ApiService apiService;

    @Override
    public Long scheduleAppointment(AppointmentDTO appointmentDTO)throws HmException {
        Boolean doctorExists = apiService.doctorExists(appointmentDTO.getDoctorId()).block();
        if(doctorExists == null || !doctorExists){
            throw new HmException("DOCTOR_NOT_FOUND");
        }
        Boolean patientExists = apiService.patientExists(appointmentDTO.getPatientId()).block();
        if(patientExists == null || !patientExists){
            throw new HmException("PATIENT_NOT_FOUND");
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
    public void rescheduleAppointment(Long appointmentId, String newDateTime) {

    }

    @Override
    public void completeAppointment(Long appointmentId) {

    }

    @Override
    public AppointmentDTO getAppointmentDetails(Long appointmentId)throws HmException {
        return appointmentRepository.findById(appointmentId).orElseThrow(()->new HmException("APPOINTMENT_NOT_FOUND")).toDTO();

    }

    @Override
    public AppointmentDetails getAppointmentDetailsWithName(Long appointmentId) throws HmException {
        AppointmentDTO appointmentDTO = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new HmException("APPOINTMENT_NOT_FOUND")).toDTO();
        DoctorDTO doctorDTO = apiService.getDoctorById(appointmentDTO.getDoctorId()).block();
        PatientDTO patientDTO = apiService.getPatientById(appointmentDTO.getPatientId()).block();

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
