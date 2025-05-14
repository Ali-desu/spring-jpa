package com.sa.spring_tuto_web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @OneToOne
    @JoinColumn(name = "account_username", referencedColumnName = "username")
    private Account account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<Module> modules = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(Long id, String name, String email, Account account, List<Module> modules) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.account = account;
        this.modules = modules;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                ", modules=" + modules +
                '}';
    }
}