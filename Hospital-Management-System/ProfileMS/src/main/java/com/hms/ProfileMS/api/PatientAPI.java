package com.hms.ProfileMS.api;

import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.entity.Patient;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Long> addPatient(@Valid @RequestBody PatientDTO patientDTO) throws HmException {
        Long id = patientService.addPatient(patientDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
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
    @PutMapping("/update")
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patientDTO) throws HmException{
        return  new ResponseEntity<>(patientService.updatePatient(patientDTO),HttpStatus.OK);
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> patientExists(@PathVariable Long id)throws HmException{
        return new ResponseEntity<>(patientService.patientExists(id),HttpStatus.OK);
    }
}
