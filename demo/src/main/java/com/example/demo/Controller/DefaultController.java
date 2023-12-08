package com.example.demo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DefaultController {
    @GetMapping("/")
    public String get() {
        return "Hello world";
    }
}
