package com.sa.spring_tuto_web.dto;

import java.util.List;

public class TeacherDTO {
    private Long id;
    private String name;
    private String email;
    private String accountUsername;
    private List<Long> moduleIds;

    // Constructors
    public TeacherDTO() {
    }

    public TeacherDTO(Long id, String name, String email, String accountUsername, List<Long> moduleIds) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountUsername = accountUsername;
        this.moduleIds = moduleIds;
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

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public List<Long> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Long> moduleIds) {
        this.moduleIds = moduleIds;
    }
}