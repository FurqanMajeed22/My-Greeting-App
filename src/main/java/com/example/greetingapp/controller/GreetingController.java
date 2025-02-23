package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/hello")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }

    @GetMapping("/personalized")
    public String getPersonalizedGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // ✅ UC4: Save a Greeting
    @PostMapping
    public Greeting saveGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
    }
}