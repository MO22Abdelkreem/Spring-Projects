package com.hms.gateway.filter;

import io.jsonwebtoken.Jwts;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class TokenFilter extends AbstractGatewayFilterFactory<TokenFilter.Config> {

    private static final String SECRET = "hospital-management-system-secret-key";

    public TokenFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath();

            if ("/user/login".equals(path) || "/user/register".equals(path)) {
                return chain.filter(exchange);
            }

            HttpHeaders headers = exchange.getRequest().getHeaders();
            String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

            if (authorizationHeader == null) {
                throw new RuntimeException("Authorization header is missing");
            }

            if (!authorizationHeader.startsWith("Bearer ")) {
                throw new RuntimeException("Authorization header is invalid");
            }

            String token = authorizationHeader.substring(7);

            try {
                Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();

                ServerHttpRequest request = exchange.getRequest()
                        .mutate()
                        .header("X-Secret-Key", "SECRET")
                        .build();

                return chain.filter(exchange.mutate().request(request).build());
            } catch (Exception exception) {
                throw new RuntimeException("Token is invalid");
            }
        };
    }

    public static class Config {
    }
}
