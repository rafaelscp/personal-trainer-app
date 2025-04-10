package com.example.personal_trainer_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    public String Hello() {
        return "Hello, this is the login controller!";
    }

}
