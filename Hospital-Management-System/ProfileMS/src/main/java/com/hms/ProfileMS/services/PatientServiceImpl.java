package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.entity.Patient;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Long addPatient(PatientDTO patientDTO) throws HmException {
       if(patientRepository.findByEmail(patientDTO.getEmail()).isPresent())throw
            new HmException("PATIENT_ALREADY_EXISTS");
       if(patientRepository.findByAadharNo(patientDTO.getAddharNo()).isPresent())throw
            new HmException("PATIENT_ALREADY_EXISTS");
       return patientRepository.save(patientDTO.toEntity()).getId();
    }

    @Override
    public Patient getPatientById(Long id) throws HmException {
        return patientRepository.findById(id)
                .orElseThrow(() -> new HmException("PATIENT_NOT_FOUND"));
    }

    @Override
    public void deletePatient(Long id) throws HmException {
        if (!patientRepository.existsById(id)) {
            throw new HmException("PATIENT_NOT_FOUND");
        }
        patientRepository.deleteById(id);
    }
}
