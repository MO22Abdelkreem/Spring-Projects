package com.hms.ProfileMS.api;

import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.entity.Patient;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/profile/patient")
@Validated
public class PatientAPI {

    private final PatientService patientService;

    public PatientAPI(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping({"/add", "/create"})
    public ResponseEntity<String> addPatient(@Valid @RequestBody PatientDTO patientDTO) throws HmException {
        patientService.addPatient(patientDTO);
        return new ResponseEntity<>("Patient added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws HmException {
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) throws HmException {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
    }
}
