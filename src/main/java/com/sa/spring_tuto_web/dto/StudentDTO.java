package com.sa.spring_tuto_web.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class StudentDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min=3 , max = 30)
    private String name = "ss";

    @NotBlank(message = "Email is required")
    @Size(min=2 , max = 30)
    @Email
    private String email;

    @NotBlank(message = "Major is required")
    private String major;

    private double mark;


    public StudentDTO() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", mark=" + mark +
                '}';
    }

}