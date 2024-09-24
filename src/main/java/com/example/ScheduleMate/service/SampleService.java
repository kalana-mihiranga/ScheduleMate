package com.example.ScheduleMate.service;

import com.example.ScheduleMate.config.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public String findSample(String id) {
        if ("0".equals(id)) {
            throw new ResourceNotFoundException("Resource not found for ID: " + id);
        }
        return "Sample resource with ID: " + id;
    }
    }
