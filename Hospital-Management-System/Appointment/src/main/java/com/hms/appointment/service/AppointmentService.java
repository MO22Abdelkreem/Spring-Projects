package com.hms.appointment.service;

import com.hms.appointment.dto.AppointmentDTO;
import com.hms.appointment.dto.AppointmentDetails;
import com.hms.appointment.exception.HmException;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

public interface AppointmentService {
    Long scheduleAppointment(AppointmentDTO appointmentDTO) throws HmException;
    void cancelledAppointment(Long appointmentId) throws HmException;
    void rescheduleAppointment(Long appointmentId, String newDateTime);
    void completeAppointment(Long appointmentId);
    AppointmentDTO getAppointmentDetails(Long appointmentId)throws HmException;

    AppointmentDetails getAppointmentDetailsWithName(Long appointmentId)throws HmException;
}
