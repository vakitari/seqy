package com.example.demo.SpringSecurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class JwtIssuer {

    private final JwtProperties properties;

    public JwtIssuer(JwtProperties properties) {
        this.properties = properties;
    }

    public String issue(long userId, String email, List<String> roles) {
        return JWT.create() // начало работы с JWT
                .withSubject(String.valueOf(userId)) // создание объекта userId
                .withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS))) // максимальное количество времени которое будет доступен токен
                .withClaim("email", email) // добавление аргумента для почты
                .withClaim("role", roles) // добавление аргумента для роли
                .sign(Algorithm.HMAC256(properties.getSecretKey())); //использование кодировки hmac256
    }
}
