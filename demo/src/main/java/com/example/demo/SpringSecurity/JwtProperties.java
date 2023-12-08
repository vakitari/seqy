package com.example.demo.SpringSecurity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("security.jwt")
public class JwtProperties {
    /*секретный ключ чтобы выпущенный для JWT*/
    private String secretKey;
}
