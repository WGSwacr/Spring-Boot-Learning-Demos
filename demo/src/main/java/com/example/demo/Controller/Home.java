package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Home {
    
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}