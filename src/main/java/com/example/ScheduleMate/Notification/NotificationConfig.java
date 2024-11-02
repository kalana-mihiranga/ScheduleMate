package com.example.ScheduleMate.Notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Bean
    public NotificationManager notificationManager() {
        NotificationManager manager = NotificationManager.getInstance();
        // Register your observers here
        manager.addObserver(new BusinessObserver());
        // Add other observers as needed
        return manager;
    }
}
