package com.example.ScheduleMate.notification.Factory;

import com.example.ScheduleMate.notification.Interface.Notification;

public class InAppNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("In-App Notification Sent: " + message);
    }
}