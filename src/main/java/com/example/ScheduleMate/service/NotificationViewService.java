package com.example.ScheduleMate.service;

import com.example.ScheduleMate.entity.Notification;

import java.util.List;

public interface NotificationViewService {

    List<Notification> getAlLNotificationsForClient(Long id);
    List<Notification> getAlLNotificationsForBusiness(Long id);

}
