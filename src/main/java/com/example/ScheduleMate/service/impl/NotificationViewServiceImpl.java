package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.entity.Notification;
import com.example.ScheduleMate.repository.NotificationRepository;
import com.example.ScheduleMate.service.NotificationViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationViewServiceImpl implements NotificationViewService {
    private final NotificationRepository notificationRepository;
    @Override
    public List<Notification> getAlLNotificationsForClient(Long id) {
        return notificationRepository.findByClientId(id).stream()
                .filter(e -> e.getRole().toString().equals("CLIENT")).collect(Collectors.toList());
    }

    @Override
    public List<Notification> getAlLNotificationsForBusiness(Long id) {
        return notificationRepository.findByClientId(id).stream()
                .filter(e -> e.getRole().toString().equals("BUSINESS")).collect(Collectors.toList());
    }
}
