package com.example.ScheduleMate.dto;

public class LoginResponse {
    private String token;
    private long expiresIn;

    // Add the setters for both fields
    public LoginResponse setToken(String token) {
        this.token = token;
        return this;  // Return 'this' to allow method chaining
    }

    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;  // Return 'this' to allow method chaining
    }

    // Getters (Optional, depending on your usage)
    public String getToken() {
        return token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }
}
