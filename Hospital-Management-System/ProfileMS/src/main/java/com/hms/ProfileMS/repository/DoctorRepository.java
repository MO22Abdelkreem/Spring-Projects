package com.hms.ProfileMS.repository;

import com.hms.ProfileMS.entity.Doctor;
import com.hms.ProfileMS.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {


    Optional<Patient> findByEmail(String email);
    Optional<Patient> findByLicenseNo(String licenseNo);
}

