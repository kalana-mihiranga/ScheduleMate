package com.example.ScheduleMate.entity;
import com.example.ScheduleMate.meta.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_note")
    private String clientNote;

    @Column(name = "business_note")
    private String businessNote;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @Column(name = "starting_time")
    private LocalTime startingTime;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "status")
    private BookingStatus status;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn (name = "client_id",referencedColumnName = "id")
    private Client client;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id",referencedColumnName = "id")
    private Services services;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id",referencedColumnName = "id")
    private Packages packages;

}

