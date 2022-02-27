package com.example.lab2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingsController {

    @GetMapping
    public String getGreetings() {
        return "welcome";
    }
}
