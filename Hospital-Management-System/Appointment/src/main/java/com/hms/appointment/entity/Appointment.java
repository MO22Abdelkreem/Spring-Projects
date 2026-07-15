package com.hms.appointment.entity;

import com.hms.appointment.dto.AppointmentDTO;
import com.hms.appointment.dto.Status;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    
    private Long doctorId;
    
    private LocalDateTime appointmentTime;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    private String reason;
    
    private String notes;

    public Appointment() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }


    public AppointmentDTO toDTO() {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(this.id);
        dto.setPatientId(this.patientId);
        dto.setDoctorId(this.doctorId);
        dto.setAppointmentTime(this.appointmentTime);
        dto.setStatus(this.status);
        dto.setReason(this.reason);
        dto.setNotes(this.notes);
        return dto;
    }
}
