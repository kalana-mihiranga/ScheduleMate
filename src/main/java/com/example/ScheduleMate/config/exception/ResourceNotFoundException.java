package com.example.ScheduleMate.config.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
