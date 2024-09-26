package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
}


