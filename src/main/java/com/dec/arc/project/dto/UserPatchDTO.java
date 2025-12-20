package com.dec.arc.project.dto;

import jakarta.validation.constraints.Email;

public class UserPatchDTO {

    private String username;

    @Email
    private String email;

    // getters & setters

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
