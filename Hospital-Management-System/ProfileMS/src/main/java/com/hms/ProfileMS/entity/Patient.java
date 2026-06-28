package com.hms.ProfileMS.entity;

import com.hms.ProfileMS.dto.PatientDTO;
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
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

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
    private String addharNo;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    public PatientDTO toDTO() {
        return new PatientDTO(
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
