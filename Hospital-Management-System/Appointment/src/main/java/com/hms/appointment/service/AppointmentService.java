package com.hms.appointment.service;

import com.hms.appointment.dto.AppointmentDTO;
import com.hms.appointment.exception.HmException;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

public interface AppointmentService {
    Long scheduleAppointment(AppointmentDTO appointmentDTO);
    void cancelledAppointment(Long appointmentId) throws HmException;
    void rescheduleAppointment(Long appointmentId, String newDateTime);
    void completeAppointment(Long appointmentId);
    AppointmentDTO getAppointmentDetails(Long appointmentId)throws HmException;
}
