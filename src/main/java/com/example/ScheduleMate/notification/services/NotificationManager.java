package com.example.ScheduleMate.notification.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;


public class NotificationManager {
    private static NotificationManager instance;
    private final Map<String, Observer> observers = new HashMap<>();

    private NotificationManager() {}

    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    public void addObserver(Observer observer, String role) {
        observers.put(role, observer);
    }

    public void notifyObservers(String message, String role) {
        if (observers.containsKey(role)) {
            observers.get(role).update(message);
        }
    }
}
