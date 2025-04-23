package com.sa.spring_tuto_web.controller;

import com.sa.spring_tuto_web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.sa.spring_tuto_web.model.User.users;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping
    public String showForm(@ModelAttribute("user") User user, Model model) {
        List<String> countries = Arrays.asList(
                "United States",
                "Canada",
                "United Kingdom",
                "Australia",
                "India",
                "Germany",
                "France",
                "Morocco"
        );

        // Add countries to the model
        model.addAttribute("countriesList", countries);
        return "form";
    }

    @PostMapping
    public String processForm(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("country") String country,
                              @RequestParam("action") String action, Model model) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);

        if (action.equals("more")) {
            model.addAttribute("users", users);
            model.addAttribute("showDetails", true);
            model.addAttribute("selectedUser", user);
            return "result";
        } else {
            users.add(user);
            model.addAttribute("users", users);
            model.addAttribute("showDetails", false);
            return "result";
        }
    }
}