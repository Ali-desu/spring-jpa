package com.sa.spring_tuto_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String handleHelloRequest(Model model) {
        model.addAttribute("message", "Hello from HelloWorldController , it's working !");
        return "hello";
    }
}