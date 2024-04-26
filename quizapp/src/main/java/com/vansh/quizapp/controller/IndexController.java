package com.vansh.quizapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String welcome() {
        return "welcome"; // Assuming "welcome.html" is your template name
    }
    
}
