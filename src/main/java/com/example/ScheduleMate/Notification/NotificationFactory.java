package com.example.ScheduleMate.Notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class NotificationFactory {

    private final EmailNotification emailNotification;
    private final PushNotification pushNotification;
    private final InAppNotification inAppNotification;

    public NotificationTask createNotification(String type, String message, String role, String email) {
        return switch (type.toLowerCase()) {
            case "push" -> pushNotification;
            case "inapp" -> inAppNotification;
            case "email" -> emailNotification;
            default -> throw new IllegalArgumentException("Invalid notification type: " + type);
        };
    }


}
