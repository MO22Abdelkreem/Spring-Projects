package com.hms.ProfileMS.dto;

import com.hms.ProfileMS.entity.BloodGroup;
import com.hms.ProfileMS.entity.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String username;

    @NotBlank(message = "email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    private LocalDate dob;
    private String phone;
    private String address;
    private String addharNo;
    private BloodGroup bloodGroup;

    public Patient toEntity() {
        return new Patient(
                this.id,
                this.username,
                this.email,
                this.dob,
                this.phone,
                this.address,
                this.addharNo,
                this.bloodGroup
        );
    }
}
