package com.example.ScheduleMate.notification.events.listners;

import com.example.ScheduleMate.notification.events.BookingNotificationEvent;
import com.example.ScheduleMate.notification.services.NotificationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListener {

    private final NotificationService notificationService;

    public NotificationEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @EventListener
    public void handleBookingNotificationEvent(BookingNotificationEvent event) {
        notificationService.sendNotification(event.getNotificationType(), event.getMessage(), event.getRole());
    }
}
