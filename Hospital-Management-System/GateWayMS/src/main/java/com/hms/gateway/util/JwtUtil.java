package com.hms.gateway.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;

@Service
public class JwtUtil {

    private static final String HMAC_SHA256 = "HmacSHA256";
    private static final String JWT_ALGORITHM = "HS256";

    private final ObjectMapper objectMapper;
    private final String jwtSecret;

    public JwtUtil(ObjectMapper objectMapper, @Value("${jwt.secret}") String jwtSecret) {
        this.objectMapper = objectMapper;
        this.jwtSecret = jwtSecret;
    }

    public JwtUser validateAndExtract(String token) {
        String[] parts = token.split("\\.", -1);
        if (parts.length != 3 || parts[0].isBlank() || parts[1].isBlank() || parts[2].isBlank()) {
            throw new IllegalArgumentException("Malformed JWT token");
        }

        Map<String, Object> header = decodeJson(parts[0]);
        if (!JWT_ALGORITHM.equals(header.get("alg"))) {
            throw new IllegalArgumentException("Unsupported JWT algorithm");
        }

        verifySignature(parts);

        Map<String, Object> claims = decodeJson(parts[1]);
        validateExpiration(claims);

        String id = firstPresentClaim(claims, "id", "userId", "sub");
        String email = firstPresentClaim(claims, "email");
        String role = firstPresentClaim(claims, "role");

        if (id == null || email == null || role == null) {
            throw new IllegalArgumentException("Required JWT claims are missing");
        }

        return new JwtUser(id, email, role);
    }

    private void verifySignature(String[] parts) {
        try {
            String signedContent = parts[0] + "." + parts[1];
            Mac mac = Mac.getInstance(HMAC_SHA256);
            mac.init(new SecretKeySpec(jwtSecret.getBytes(StandardCharsets.UTF_8), HMAC_SHA256));

            byte[] expectedSignature = mac.doFinal(signedContent.getBytes(StandardCharsets.UTF_8));
            byte[] actualSignature = Base64.getUrlDecoder().decode(parts[2]);

            if (!MessageDigest.isEqual(expectedSignature, actualSignature)) {
                throw new IllegalArgumentException("Invalid JWT signature");
            }
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new IllegalArgumentException("JWT signature validation failed", ex);
        }
    }

    private Map<String, Object> decodeJson(String base64UrlValue) {
        try {
            byte[] decoded = Base64.getUrlDecoder().decode(base64UrlValue);
            return objectMapper.readValue(decoded, new TypeReference<>() {
            });
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid JWT JSON payload", ex);
        }
    }

    private void validateExpiration(Map<String, Object> claims) {
        Object expiration = claims.get("exp");
        if (!(expiration instanceof Number exp)) {
            throw new IllegalArgumentException("JWT expiration is missing");
        }

        long expiresAt = exp.longValue();
        long now = Instant.now().getEpochSecond();
        if (expiresAt <= now) {
            throw new IllegalArgumentException("JWT token is expired");
        }
    }

    private String firstPresentClaim(Map<String, Object> claims, String... names) {
        for (String name : names) {
            Object value = claims.get(name);
            if (value != null && !value.toString().isBlank()) {
                return value.toString();
            }
        }
        return null;
    }

    public record JwtUser(String id, String email, String role) {
    }
}
