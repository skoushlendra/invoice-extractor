package com.example.pdftext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api-tester")
public class APITester {
    @GetMapping("/status")
    public String getStatus() {
        return "App is running";
    }
}
