package com.hms.ProfileMS.api;

import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) throws HmException {
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) throws HmException {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('PATIENT', 'ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patientDTO) throws HmException{
        return  new ResponseEntity<>(patientService.updatePatient(patientDTO),HttpStatus.OK);
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> patientExists(@PathVariable Long id)throws HmException{
        return new ResponseEntity<>(patientService.patientExists(id),HttpStatus.OK);
    }
}
