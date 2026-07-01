package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.entity.Patient;
import com.hms.ProfileMS.exception.HmException;

public interface PatientService {
    public Long addPatient(PatientDTO patientDTO)throws HmException;
    public Patient getPatientById(Long id)throws HmException;
    public void deletePatient(Long id)throws HmException;

}
