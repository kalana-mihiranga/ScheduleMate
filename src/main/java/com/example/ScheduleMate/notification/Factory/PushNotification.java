package com.example.ScheduleMate.notification.Factory;

import com.example.ScheduleMate.notification.Interface.Notification;

public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Push Notification Sent: " + message);
    }
}