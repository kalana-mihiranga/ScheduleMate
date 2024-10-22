package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.entity.Event;
import com.example.ScheduleMate.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
