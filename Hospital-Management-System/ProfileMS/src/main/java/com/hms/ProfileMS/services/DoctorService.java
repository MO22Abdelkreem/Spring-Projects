package com.hms.ProfileMS.services;

import com.hms.ProfileMS.dto.DoctorDTO;
import com.hms.ProfileMS.entity.Doctor;
import com.hms.ProfileMS.exception.HmException;

public interface DoctorService {
    public void addDoctor(DoctorDTO doctorDTO)throws HmException;
    public DoctorDTO getDoctorById(Long id)throws HmException;
}
