package com.hms.appointment.service;

import com.hms.appointment.dto.AppointmentDTO;
import com.hms.appointment.dto.Status;
import com.hms.appointment.entity.Appointment;
import com.hms.appointment.exception.HmException;
import com.hms.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Long scheduleAppointment(AppointmentDTO appointmentDTO) {
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
}
