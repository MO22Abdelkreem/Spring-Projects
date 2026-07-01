package com.hms.ProfileMS.api;

import com.hms.ProfileMS.dto.DoctorDTO;
import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.entity.Doctor;
import com.hms.ProfileMS.entity.Patient;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.services.DoctorService;
import com.hms.ProfileMS.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/profile/doctor")
@Validated
public class DoctorAPI {

    private final DoctorService doctorService;

    public DoctorAPI(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping({"/add", "/create"})
    public ResponseEntity<String> addPatient(@Valid @RequestBody DoctorDTO doctorDTO) throws HmException {
        doctorService.addDoctor(doctorDTO);
        return new ResponseEntity<>("Patient added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DoctorDTO> getPatientById(@PathVariable Long id) throws HmException {
        return new ResponseEntity<>(doctorService.getDoctorById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) throws HmException {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>("Doctor deleted successfully", HttpStatus.OK);
    }
}
