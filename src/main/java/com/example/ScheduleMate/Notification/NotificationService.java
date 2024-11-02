package com.example.ScheduleMate.Notification;

import com.example.ScheduleMate.entity.Notification;
import com.example.ScheduleMate.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationFactory notificationFactory;

    public void sendNotification(String type, String message, String role, String email) {
        // Notify observers
        NotificationManager manager = NotificationManager.getInstance();
        manager.notifyObservers(message, role);

        // Send notification via selected channel
        NotificationTask notification = notificationFactory.createNotification(type,message,role,email);
        notification.send( type, message,  role,  email);

        // Save to database
        Notification notificationEntity = new Notification();
        notificationEntity.setMessage(message);
        notificationEntity.setRole(role);
        notificationEntity.setNotificationType(type);
        notificationRepository.save(notificationEntity);

    }


}
