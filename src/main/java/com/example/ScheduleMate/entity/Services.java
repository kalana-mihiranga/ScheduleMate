package com.example.ScheduleMate.entity;


import com.example.ScheduleMate.meta.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "services")
public class Services extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "discount_rate")
    private BigDecimal discountRate;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "description")
    private String description;

    @Column(name = "conditions")
    private String conditions;

    @Column(name = "service_from")
    private LocalTime serviceFrom;

    @Column(name = "service_to")
    private LocalTime serviceTo;

    @ElementCollection
    @CollectionTable(name = "package_availability", joinColumns = @JoinColumn(name = "package_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "available_day")
    private List<DayOfWeek> availability;

    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<PackageServices> packageServices;

    @Column(name = "image_url")
    private String imageUrl;















}
