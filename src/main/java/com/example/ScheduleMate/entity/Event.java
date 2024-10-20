package com.example.ScheduleMate.entity;

import com.example.ScheduleMate.meta.BaseEntity;
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
public class Event extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private Client providerId;

    @Column(name = "event_title")
    private String eventTitle;
    @Column(name = "description")
    private String description;
    @Column(name = "post_url")
    private String posterUrl;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    private List<TimeSlot> availableTimeSlots;

}
