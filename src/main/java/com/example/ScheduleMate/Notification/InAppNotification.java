package com.example.ScheduleMate.Notification;

import com.example.ScheduleMate.entity.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InAppNotification implements NotificationTask{
    @Override
    public void send( String type,String message, String role, String email) {
        log.info("Inapp Notification Sent: " + message);
    }
}
