package com.hms.appointment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import jakarta.servlet.http.HttpServletRequest;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder()
                .filter(forwardAuthorizationHeader())
                .filter(logRequest());
    }

    private ExchangeFilterFunction forwardAuthorizationHeader() {
        return (request, next) -> {
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            if (attributes instanceof ServletRequestAttributes) {
                HttpServletRequest servletRequest = ((ServletRequestAttributes) attributes).getRequest();
                String authHeader = servletRequest.getHeader("Authorization");
                if (authHeader != null) {
                    ClientRequest filteredRequest = ClientRequest.from(request)
                            .header("Authorization", authHeader)
                            .build();
                    return next.exchange(filteredRequest);
                }
            }
            return next.exchange(request);
        };
    }

    private ExchangeFilterFunction logRequest(){
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            System.out.println("Request: " + clientRequest.method() + " " + clientRequest.url());
            return Mono.just(clientRequest);
        });
    }
}
