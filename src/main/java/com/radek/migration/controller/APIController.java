package com.radek.migration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "public";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "admin";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "user, admin";
    }
}
