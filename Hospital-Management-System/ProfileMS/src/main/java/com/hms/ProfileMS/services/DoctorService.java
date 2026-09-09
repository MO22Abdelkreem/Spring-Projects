package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.DoctorDTO;
import com.hms.ProfileMS.entity.Doctor;
import com.hms.ProfileMS.exception.HmException;

import java.util.List;

public interface DoctorService {
    public Long addDoctor(DoctorDTO doctorDTO) throws HmException;
    public DoctorDTO getDoctorById(Long id) throws HmException;
    void deleteDoctor(Long id) throws HmException;
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO) throws HmException;
    public Boolean doctorExists(Long id) throws HmException;
    List<DoctorDTO> getAllDoctors();
    List<DoctorDTO> getDoctorsByDepartment(String department);
    List<DoctorDTO> getDoctorsBySpecialization(String specialization);
}
