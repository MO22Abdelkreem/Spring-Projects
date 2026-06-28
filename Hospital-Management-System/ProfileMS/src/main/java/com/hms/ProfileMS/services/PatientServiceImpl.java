package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.entity.Patient;
import com.hms.ProfileMS.exception.HmException;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    @Override
    public void addPatient(PatientDTO patientDTO) throws HmException {

    }

    @Override
    public Patient getPatientById(Long id) throws HmException {
        return null;
    }
}
