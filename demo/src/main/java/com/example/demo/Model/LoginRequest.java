package com.example.demo.Model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {
    private String password;
    private String email;
}
