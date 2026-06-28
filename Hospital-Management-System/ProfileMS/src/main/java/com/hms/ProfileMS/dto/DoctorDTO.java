package com.hms.ProfileMS.dto;

import com.hms.ProfileMS.entity.BloodGroup;
import com.hms.ProfileMS.entity.Doctor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String username;

    @NotBlank(message = "email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    private LocalDate dob;
    private String phone;
    private String address;
    private String licenseNo;
    private BloodGroup bloodGroup;
    private Integer totalExp;
    private String department;
    private String specialization;

    public Doctor toEntity() {
        return new Doctor(
                this.id,
                this.username,
                this.email,
                this.dob,
                this.phone,
                this.address,
                this.licenseNo,
                this.bloodGroup,
                this.totalExp,
                this.department,
                this.specialization
        );
    }
}
