package com.hms.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDetails {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private String patientName;
    private String doctorName;
    private String patientEmail;
    private String patientPhone;
    private String doctorEmail;
    private String doctorPhone;
    private LocalDateTime appointmentTime;
    private Status status;
    private String reason;
    private String notes;

    public AppointmentDetails(Long id, Long doctorId, String doctorName, String doctorPhone,
                              String doctorEmail, Long patientId, String patientName, String patientPhone,
                              String patientEmail, LocalDateTime appointmentTime, Status status,
                              String reason, String notes) {
        this.id = id;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.patientEmail = patientEmail;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
    }
}
