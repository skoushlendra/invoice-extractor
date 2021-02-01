package com.example.pdftext.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api-tester")
public class APITester {
    @GetMapping("/status")
    public String getStatus() {
        return "App is running";
    }
}
