package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository repository;

    public String getSimpleGreeting() {
        return "Hello, World!";
    }

    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        }
        return "Hello, World!";
    }

    public Greeting saveGreeting(String message) {
        return repository.save(new Greeting(null, message));
    }

    public Optional<Greeting> findGreetingById(Long id) {
        return repository.findById(id);
    }

    // ✅ UC6: Fetch All Greetings from Database
    public List<Greeting> findAllGreetings() {
        return repository.findAll();
    }
}