package com.hms.appointment.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @JsonAlias({"aadharNo", "addharNo"})
    private String addharNo;
    private BloodGroup bloodGroup;
    private String allergies;
    private String chronicDisease;

    public void setId(Long id) {
        this.id = id;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setAddharNo(String addharNo) {
        this.addharNo = addharNo;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAddharNo() {
        return addharNo;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }
}
