package com.example.ScheduleMate.notification.Factory;


import com.example.ScheduleMate.notification.Interface.Notification;

public class NotificationFactory {
    public static Notification createNotification(String type) {
        return switch (type.toLowerCase()) {
            case "push" -> new PushNotification();
            case "inapp" -> new InAppNotification();
            default -> throw new IllegalArgumentException("Invalid notification type: " + type);
        };
    }
}
