package com.example.demo.Controller;

import com.example.demo.Model.LoginRequest;
import com.example.demo.Model.LoginResponse;
import com.example.demo.SpringSecurity.JwtIssuer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    private final JwtIssuer jwtIssuer;

    public AuthController(JwtIssuer jwtIssuer) {
        this.jwtIssuer = jwtIssuer;
    }

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        var token = jwtIssuer.issue(1L, request.getEmail(), List.of("USER"));
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
