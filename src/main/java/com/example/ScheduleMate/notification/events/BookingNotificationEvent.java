package com.example.ScheduleMate.notification.events;

import org.springframework.context.ApplicationEvent;

public class BookingNotificationEvent extends ApplicationEvent {
    private final String role;
    private final String message;
    private final String notificationType;

    public BookingNotificationEvent(Object source, String role, String message, String notificationType) {
        super(source);
        this.role = role;
        this.message = message;
        this.notificationType = notificationType;
    }

    public String getRole() { return role; }
    public String getMessage() { return message; }
    public String getNotificationType() { return notificationType; }
}
