package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByClientId(Long clientId);


    @Query("SELECT b FROM Booking b WHERE b.startingTime = :startingTime")
    List<Booking> findByStartingTime(@Param("startingTime") LocalTime startingTime);
}
