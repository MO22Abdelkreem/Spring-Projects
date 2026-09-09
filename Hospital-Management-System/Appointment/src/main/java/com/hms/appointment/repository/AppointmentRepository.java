package com.hms.appointment.repository;

import com.hms.appointment.dto.Status;
import com.hms.appointment.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
    boolean existsByDoctorIdAndAppointmentTimeAndStatus(Long doctorId, LocalDateTime appointmentTime, Status status);
}
