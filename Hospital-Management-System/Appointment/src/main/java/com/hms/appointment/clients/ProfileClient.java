package com.hms.appointment.clients;

import com.hms.appointment.dto.DoctorDTO;
import com.hms.appointment.dto.PatientDTO;
import com.hms.appointment.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ProfileMS", url = "${profile.service.url:}", configuration = FeignClientConfig.class)
public interface ProfileClient {

    @GetMapping("/profile/doctor/exists/{id}")
    Boolean doctorExists(@PathVariable("id") Long id);

    @GetMapping("/profile/patient/exists/{id}")
    Boolean patientExists(@PathVariable("id") Long id);

    @GetMapping("/profile/patient/get/{id}")
    PatientDTO getPatientById(@PathVariable("id") Long id);

    @GetMapping("/profile/doctor/get/{id}")
    DoctorDTO getDoctorById(@PathVariable("id") Long id);

    @GetMapping("/profile/doctor/email/{email}")
    Long getDoctorByEmail(@PathVariable("email") String email);

    @PostMapping("/profile/patient/batch")
    List<PatientDTO> getPatientsByIds(@RequestBody List<Long> patientIds);
}
