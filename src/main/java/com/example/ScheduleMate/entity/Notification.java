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

@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "message")
    private String message;

    @Column(name = "notificationType")
    private String notificationType;

    @Column(name = "activeStatus")
    private Boolean activeStatus=true; // Default value set to true



}
