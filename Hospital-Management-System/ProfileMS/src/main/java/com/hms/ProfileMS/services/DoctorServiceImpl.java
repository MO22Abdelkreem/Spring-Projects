package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.DoctorDTO;
import com.hms.ProfileMS.entity.Doctor;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Override
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO) throws HmException {
        doctorRepository.findById(doctorDTO.getId()).orElseThrow(()-> new HmException("DOCTOR_NOT_FOUND"));
        return doctorRepository.save(doctorDTO.toEntity()).toDTO();
    }

    @Override
    public Boolean doctorExists(Long id) throws HmException {
        return doctorRepository.existsById(id);
    }

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Long addDoctor(DoctorDTO doctorDTO) throws HmException {
        if (doctorRepository.findByEmail(doctorDTO.getEmail()).isPresent())
            throw new HmException("DOCTOR_ALREADY_EXISTS");

        if (doctorDTO.getLicenseNo() != null && doctorRepository.findByLicenseNo(doctorDTO.getLicenseNo()).isPresent())
            throw new HmException("DOCTOR_ALREADY_EXISTS");

        return doctorRepository.save(doctorDTO.toEntity()).getId();
    }

    @Override
    public DoctorDTO getDoctorById(Long id) throws HmException {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new HmException("DOCTOR_NOT_FOUND"));
        return doctor.toDTO();
    }

    @Override
    public void deleteDoctor(Long id) throws HmException{
        if(!doctorRepository.existsById(id)){
            throw new HmException("Doctor_NOT_Found");
        }
        doctorRepository.deleteById(id);
    }
}
