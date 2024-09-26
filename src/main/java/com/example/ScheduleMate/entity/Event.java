package com.example.ScheduleMate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @Column(name = "provider_id")
    private Long providerId;
    @Column(name = "event_title")
    private String eventTitle;
    @Column(name = "description")
    private String description;
    @Column(name = "post_url")
    private String posterUrl;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    private List<TimeSlot> availableTimeSlots;

}
