package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.DoctorDTO;
import com.hms.ProfileMS.entity.Doctor;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Long addDoctor(DoctorDTO doctorDTO) throws HmException {
        if (doctorRepository.findByEmail(doctorDTO.getEmail()) != null)
            throw new HmException("DOCTOR_ALREADY_EXISTS");

        if (doctorRepository.findByLicenseNo(doctorDTO.getLicenseNo()) != null)
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
