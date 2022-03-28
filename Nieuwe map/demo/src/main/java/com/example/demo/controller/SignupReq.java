package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.*;

public class SignupReq {
    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    //private List<String> role;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    public List<String> getRole() {
        return this.role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
     */
}