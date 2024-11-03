package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Feedback findByBusiness(Client client);

}
