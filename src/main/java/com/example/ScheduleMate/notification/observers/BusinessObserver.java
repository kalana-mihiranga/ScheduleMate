package com.example.ScheduleMate.notification.observers;

import com.example.ScheduleMate.notification.Interface.NotificationObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessObserver implements NotificationObserver {
    @Override
    public void update(String message) {


        log.info("\"Business received notification: \"" + message);
    }
}