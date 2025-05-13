package com.sa.spring_tuto_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/newform")
    public String loginForm() {
        return "newForm"; // Maps to form.jsp
    }
}
