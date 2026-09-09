package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.entity.Patient;
import com.hms.ProfileMS.exception.HmException;

import java.util.List;

public interface PatientService {
    public Long addPatient(PatientDTO patientDTO) throws HmException;
    public PatientDTO getPatientById(Long id) throws HmException;
    public void deletePatient(Long id) throws HmException;
    public PatientDTO updatePatient(PatientDTO patientDTO) throws HmException;
    public Boolean patientExists(Long id) throws HmException;
    List<PatientDTO> getAllPatients();
}
