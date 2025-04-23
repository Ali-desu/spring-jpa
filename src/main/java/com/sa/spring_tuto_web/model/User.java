package com.sa.spring_tuto_web.model;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String country;
    public static List<User> users = new java.util.ArrayList<>();

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}