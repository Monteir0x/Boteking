package com.boteking.boteking.domain.entities.user;

import lombok.Getter;

@Getter
public class User {
    private final Long id;
    private final String name;
    private final String email;
    private final String password;

    public User(Long id, String name, String email, String password) {
        validate(name, email, password);
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private void validate(String name, String email, String password) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("User email cannot be empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("User password cannot be empty");
        }
    }
}
