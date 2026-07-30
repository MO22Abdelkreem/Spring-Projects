package com.hms.User.service;

import com.hms.User.dto.RegisterRequestDTO;
import com.hms.User.dto.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {

    @Autowired
    private WebClient.Builder webClient;

    public Mono<Long> addProfile(RegisterRequestDTO userDTO) {

        if (Roles.DOCTOR.equals(userDTO.getRole())) {
            return webClient.build()
                    .post()
                    .uri("http://localhost:9100/profile/doctor/add")
                    .bodyValue(userDTO)
                    .retrieve()
                    .bodyToMono(Long.class);

        } else if (Roles.PATIENT.equals(userDTO.getRole())) {
            return webClient.build()
                    .post()
                    .uri("http://localhost:9100/profile/patient/add")
                    .bodyValue(userDTO)
                    .retrieve()
                    .bodyToMono(Long.class);
        }

        return Mono.empty();
    }
}
