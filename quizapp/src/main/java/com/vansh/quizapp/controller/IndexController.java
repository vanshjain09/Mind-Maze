package com.vansh.quizapp.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan(basePackages = {"/quizapp/src/main/java/com/vansh/quizapp/controller/IndexController.java"})
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // Assuming "index.html" is your template name
    }
    @PostMapping("/role")
    public String role(@RequestParam("role") String role) {
        System.out.println(role); // Changed to println for better visibility
        return role;
    }
}
