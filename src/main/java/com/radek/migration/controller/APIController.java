package com.radek.migration.controller;

import com.radek.migration.entity.User;
import com.radek.migration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class APIController {

    private UserService userService;

    @Autowired
    public APIController(UserService userService) {
        this.userService = userService;
    }

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


    @PostMapping("/register")
    public User register(@RequestBody @Valid User user) {
        return userService.register(user);
    }


    @GetMapping("/activate")
    public String activate (@RequestParam("token") String activationToken) {
        User user = userService.findUserbyActivationHash(activationToken);

        if (user.isEnabled()) {
            return "Konto aktywowano wcześniej";
        } else {
            user.setEnabled(true);
            userService.save(user);

            return "Konto aktywowano";
        }

    }
}
