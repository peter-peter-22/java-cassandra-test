package com.example.cassandra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping()
    public String home(){
        return "Hello from springboot";
    }
}
