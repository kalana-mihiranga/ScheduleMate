package com.example.ScheduleMate.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "package_services")
public class PackageServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "package_id")
    private Packages packages;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

}
