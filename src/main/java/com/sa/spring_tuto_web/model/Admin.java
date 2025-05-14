package com.sa.spring_tuto_web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @OneToOne
    @JoinColumn(name = "account_username", referencedColumnName = "username")
    private Account account;

    public Admin() {
    }

    public Admin(Long id, String name, String email, Account account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.account = account;
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
}