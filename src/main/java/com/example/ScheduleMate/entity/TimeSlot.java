package com.example.ScheduleMate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;
    @Column(name="start_time")
    private LocalDateTime startTime;
    @Column(name="end_time")
    private LocalDateTime endTime;
    @Column(name="available_seats")
    private int availableSeats;

    @ManyToOne(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "event_id",referencedColumnName = "id")
    private Event event;

}
