package com.example.ScheduleMate.Notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor

public class BookingNotificationEvent {
    private  Long clientId;
    private  String notificationType;
    private  String message;
    private  String role;
    private  String email;


}
