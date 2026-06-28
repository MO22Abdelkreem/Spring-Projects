package com.hms.ProfileMS.entity;

import com.hms.ProfileMS.dto.DoctorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(unique = true)
    private String email;

    private LocalDate dob;
    private String phone;
    private String address;

    @Column(unique = true)
    private String licenseNo;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    private Integer totalExp;
    private String department;
    private String specialization;

    public DoctorDTO toDTO() {
        return new DoctorDTO(
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
