package com.hms.appointment.service;

import com.hms.appointment.dto.AppointmentDTO;
import com.hms.appointment.dto.AppointmentDetails;
import com.hms.appointment.exception.HmException;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    Long scheduleAppointment(AppointmentDTO appointmentDTO) throws HmException;
    void cancelledAppointment(Long appointmentId) throws HmException;
    void rescheduleAppointment(Long appointmentId, LocalDateTime newDateTime) throws HmException;
    void completeAppointment(Long appointmentId) throws HmException;
    AppointmentDTO getAppointmentDetails(Long appointmentId) throws HmException;
    AppointmentDetails getAppointmentDetailsWithName(Long appointmentId) throws HmException;
    List<AppointmentDTO> getAppointmentsByPatientId(Long patientId);
    List<AppointmentDTO> getAppointmentsByDoctorId(Long doctorId);
}
