package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.PatientDTO;
import com.hms.ProfileMS.entity.Patient;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;
    private final FileStorageService fileStorageService;

    public PatientServiceImpl(PatientRepository patientRepository, FileStorageService fileStorageService) {
        this.patientRepository = patientRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long addPatient(PatientDTO patientDTO) throws HmException {
        if (patientRepository.findByEmail(patientDTO.getEmail()).isPresent())
            throw new HmException("PATIENT_ALREADY_EXISTS");
        if (patientDTO.getAddharNo() != null && patientRepository.findByAadharNo(patientDTO.getAddharNo()).isPresent())
            throw new HmException("PATIENT_ALREADY_EXISTS");
        return patientRepository.save(patientDTO.toEntity()).getId();
    }

    @Override
    public PatientDTO getPatientById(Long id) throws HmException {
        return patientRepository.findById(id)
                .orElseThrow(() -> new HmException("PATIENT_NOT_FOUND")).toDTO();
    }

    @Override
    public void deletePatient(Long id) throws HmException {
        if (!patientRepository.existsById(id)) {
            throw new HmException("PATIENT_NOT_FOUND");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO) throws HmException {
        patientRepository.findById(patientDTO.getId()).orElseThrow(()-> new HmException("PATIENT_NOT_FOUND"));
        return patientRepository.save(patientDTO.toEntity()).toDTO();
    }

    @Override
    public Boolean patientExists(Long id) throws HmException {
        return patientRepository.existsById(id);
    }

    @Override
    public java.util.List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(Patient::toDTO).toList();
    }

    @Override
    public PatientDTO updatePatientImage(Long patientId, MultipartFile file) {

        Patient patient = patientRepository.findById(patientId).
                orElseThrow(()-> new RuntimeException("Patient not Found with id:" + patientId));
        String imageUrl = fileStorageService.saveFile(file);

        patient.setImageUrl(imageUrl);
        Patient updatedPatient = patientRepository.save(patient);
        return updatedPatient.toDTO();

    }
}
