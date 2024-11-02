package com.example.ScheduleMate.Notification;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationEventListener {

    private final NotificationService notificationService;
    @EventListener
    public void handleBookingNotificationEvent(BookingNotificationEvent event) {
        notificationService.sendNotification(event.getNotificationType(), event.getMessage(), event.getRole(),event.getEmail());
    }
}
