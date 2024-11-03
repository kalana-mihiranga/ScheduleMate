package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByClientId(Long id);
}
