package com.example.ScheduleMate.entity;


import com.example.ScheduleMate.meta.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "event_id")
    private Long eventId;
    @Column(name = "slot_id")
    private Long slotId;
    @Column(name = "notes")
    private String notes;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @Column(name = "provider_notes")
    private String providerNotes;
    @Column(name = "booking_time")
    private LocalDateTime bookingTime;
}

