package com.hms.ProfileMS.repository;

import com.hms.ProfileMS.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
