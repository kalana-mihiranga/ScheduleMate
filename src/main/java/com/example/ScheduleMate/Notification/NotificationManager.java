package com.example.ScheduleMate.Notification;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotificationManager {

    private static NotificationManager instance;
    private final List<NotificationObserver> observers;

    private NotificationManager() {
        observers = new ArrayList<>();
    }

    // Singleton pattern: Ensures only one instance of NotificationManager
    public static NotificationManager getInstance() {
        if (instance == null) {
            synchronized (NotificationManager.class) {
                if (instance == null) {
                    instance = new NotificationManager();
                }
            }
        }
        return instance;
    }

    // Adds an observer to the list
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    // Removes an observer from the list
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    // Notifies all observers with a message, based on the recipient role
// Method to notify all observers who support the role
    public void notifyObservers(String message, String role) {
        for (NotificationObserver observer : observers) {
            if (observer.supportsRole(role)) {
                observer.update(message); // Notify if the observer supports the role
            }
        }
    }
}
