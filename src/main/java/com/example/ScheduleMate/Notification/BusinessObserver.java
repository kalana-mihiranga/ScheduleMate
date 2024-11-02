package com.example.ScheduleMate.Notification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessObserver implements NotificationObserver{
    private final String supportedRole = "BUSINESS"; // Define the role this observer supports

    @Override
    public void update(String message) {
        log.info("Business received notification: " + message);
        // Additional logic for processing the message can be added here
    }

    @Override
    public boolean supportsRole(String role) {
        return supportedRole.equals(role);
    }
}
