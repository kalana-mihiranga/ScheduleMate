package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services, Long> {
    Services findByName(String name);
}
