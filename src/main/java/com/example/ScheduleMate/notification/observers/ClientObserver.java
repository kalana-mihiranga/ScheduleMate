package com.example.ScheduleMate.notification.observers;

import com.example.ScheduleMate.notification.Interface.NotificationObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;

@Slf4j
public class ClientObserver implements NotificationObserver {
    @Override
    public void update(String message) {

        log.info("\"Client received notification: \"" + message);
    }
}