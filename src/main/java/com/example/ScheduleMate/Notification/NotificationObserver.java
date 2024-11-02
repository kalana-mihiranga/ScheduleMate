package com.example.ScheduleMate.Notification;

public interface NotificationObserver {
    void update(String message);

    // Check if observer supports this role
    boolean supportsRole(String role);
}
