package com.example.ScheduleMate.Notification;

public interface NotificationTask {
    void send(String type,String message, String role, String email);
}
