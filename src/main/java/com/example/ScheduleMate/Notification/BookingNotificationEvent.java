package com.example.ScheduleMate.Notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor

public class BookingNotificationEvent {
    private final String notificationType;
    private final String message;
    private final String role;
    private final String email;


}
