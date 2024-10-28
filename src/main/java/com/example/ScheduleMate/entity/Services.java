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

    @Column(name = "discount_rate")
    private Integer discountRate;

    @Column(name = "description")
    private String description;

    @Column(name = "conditions")
    private String conditions;

    @Column(name = "service_from")
    private LocalTime serviceFrom;

    @Column(name = "service_to")
    private LocalTime serviceTo;

    @ElementCollection
    @CollectionTable(name = "service_days", joinColumns = @JoinColumn(name = "service_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "available_day")
    private List<DayOfWeek> availability;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "service_package", joinColumns = @JoinColumn(name = "service_id"), inverseJoinColumns = @JoinColumn(name = "package_id"))
    private List<Packages> packages;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> booking;

    @Column(name = "image_url")
    private String imageUrl;

}
