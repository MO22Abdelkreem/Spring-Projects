package com.hms.ProfileMS.repository;

import com.hms.ProfileMS.entity.Doctor;
import com.hms.ProfileMS.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Optional<Doctor> findByEmail(String email);
    Optional<Doctor> findByLicenseNo(String licenseNo);
    List<Doctor> findAll();
    List<Doctor> findByDepartmentIgnoreCase(String department);
    List<Doctor> findBySpecializationIgnoreCase(String specialization);
}

