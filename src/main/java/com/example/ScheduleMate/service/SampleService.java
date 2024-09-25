package com.example.ScheduleMate.service;

import com.example.ScheduleMate.config.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SampleService {
    public String findSample(String id) {
        // Simulate resource not found scenario for ID "0"
        if ("0".equals(id)) {
            throw new ResourceNotFoundException("Resource not found for ID: " + id);
        }
        // Return the sample resource if ID is valid
        return "Sample resource with ID: " + id;
    }
}