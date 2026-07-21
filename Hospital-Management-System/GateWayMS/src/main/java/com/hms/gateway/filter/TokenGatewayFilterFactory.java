package com.hms.gateway.filter;

import io.jsonwebtoken.Jwts;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class TokenGatewayFilterFactory
        extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {


    private static final String SECRET =
            "hospital-management-user-service-jwt-secret-key-256";


    public TokenGatewayFilterFactory() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {


            String path = exchange.getRequest()
                    .getURI()
                    .getPath();

            if (isPublicEndpoint(path)) {
                return chain.filter(exchangeWithSecretHeader(exchange));
            }
            String authorizationHeader =
                    exchange.getRequest()
                            .getHeaders()
                            .getFirst(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader == null ||
                    !authorizationHeader.startsWith("Bearer ")) {
                return unauthorized(
                        exchange,
                        "Authorization token is missing"
                );
            }
            String token = authorizationHeader.substring(7);
            try {
                Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token);

                return chain.filter(exchangeWithSecretHeader(exchange));
            } catch (Exception e) {
                return unauthorized(
                        exchange,
                        "Invalid token"
                );
            }
        };
    }
    private boolean isPublicEndpoint(String path) {

        return path.equals("/api/users/login")
                ||
                path.equals("/api/users/register");

    }

    private org.springframework.web.server.ServerWebExchange exchangeWithSecretHeader(
            org.springframework.web.server.ServerWebExchange exchange
    ) {
        ServerHttpRequest request =
                exchange.getRequest()
                        .mutate()
                        .header(
                                "X-Secret-Key",
                                "SECRET"
                        )
                        .build();

        return exchange.mutate()
                .request(request)
                .build();
    }

    private Mono<Void> unauthorized(
            org.springframework.web.server.ServerWebExchange exchange,
            String message
    ){


        exchange.getResponse()
                .setStatusCode(HttpStatus.UNAUTHORIZED);


        return exchange.getResponse()
                .setComplete();

    }
    public static class Config {

    }

}
