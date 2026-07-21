package com.hms.appointment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    private String patientEmail;
    private String patientPhone;
    private String doctorEmail;
    private String doctorPhone;
    private LocalDateTime appointmentTime;
    private Status status;
    private String reason;
    private String notes;

    public AppointmentDetails(Long id, Long doctorId, @NotBlank(message = "Name is mandatory") String username, String phone,
                              @NotBlank(message = "email is mandatory") @Email(message = "Email should be valid") String email, Long patientId,
                              String username1, String phone1, String email1, LocalDateTime appointmentTime, Status status,
                              String reason, String notes) {
    }
}
