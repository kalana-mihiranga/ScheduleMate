package com.example.ScheduleMate.notification.services;

import com.example.ScheduleMate.notification.Factory.NotificationFactory;
import com.example.ScheduleMate.notification.Interface.Notification;

public class NotificationService {
    public void sendNotification(String type, String message, String role) {
        NotificationManager manager = NotificationManager.getInstance();
        manager.notifyObservers(message, role);

        Notification notification = NotificationFactory.createNotification(type);
        notification.send(message);
    }
}