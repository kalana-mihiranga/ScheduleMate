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

@Table(name = "feedback")
public class Feedback extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "business_id")
    private Client business;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment")
    private String comment;

}
