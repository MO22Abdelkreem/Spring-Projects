package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.DoctorDTO;
import com.hms.ProfileMS.entity.Doctor;
import com.hms.ProfileMS.exception.HmException;
import com.hms.ProfileMS.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final FileStorageService fileStorageService;

    public DoctorServiceImpl(DoctorRepository doctorRepository, FileStorageService fileStorageService) {
        this.doctorRepository = doctorRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public DoctorDTO updateDoctorImage(Long doctorId, MultipartFile file) {
        // فحص وجود الطبيب
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));

        // حفظ الصورة وأخذ المسار النسبي
        String imageUrl = fileStorageService.saveFile(file);

        // تحديث الحقل وحفظه في profiledb
        doctor.setImageUrl(imageUrl);
        Doctor updatedDoctor = doctorRepository.save(doctor);

        return updatedDoctor.toDTO();
    }

    @Override
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO) throws HmException {
        doctorRepository.findById(doctorDTO.getId()).orElseThrow(()-> new HmException("DOCTOR_NOT_FOUND"));
        return doctorRepository.save(doctorDTO.toEntity()).toDTO();
    }

    @Override
    public Boolean doctorExists(Long id) throws HmException {
        return doctorRepository.existsById(id);
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

    @Override
    public java.util.List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream().map(Doctor::toDTO).toList();
    }

    @Override
    public java.util.List<DoctorDTO> getDoctorsByDepartment(String department) {
        return doctorRepository.findByDepartmentIgnoreCase(department).stream().map(Doctor::toDTO).toList();
    }

    @Override
    public java.util.List<DoctorDTO> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecializationIgnoreCase(specialization).stream().map(Doctor::toDTO).toList();
    }
}
