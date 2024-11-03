package com.example.ScheduleMate.dto;

import com.example.ScheduleMate.entity.BookingStatus;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.entity.Services;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    @NotNull(message = "bookingId is required")
    @JsonProperty("bookingId")
    private Long bookingId;


    @JsonProperty("Id")
    private Long Id;

    @JsonProperty("clientNote")
    private String clientNote;

    @JsonProperty("businessNote")
    private String businessNote;

    @JsonProperty("isPaid")
    private Boolean isPaid;

    @JsonProperty("startingTime")
    private LocalTime startingTime;

    @JsonProperty("bookingDate")
    private LocalDate bookingDate;


    @NotNull(message = "clientId is required")
    @JsonProperty("clientId")
    private Long clientId;


    @NotNull(message = "eventId is required")
    @JsonProperty("eventId")
    private Long eventId;

    @NotNull(message = "serviceId is required")
    @JsonProperty("serviceId")
    private Long serviceId;

    @NotNull(message = "slotId is required")
    @JsonProperty("slotId")
    private Long slotId;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("serviceId")
    private Long serviceId;

    @JsonProperty("packageId")
    private Long packageId;


    @JsonProperty("status")
    private String status;

    @JsonProperty("clientType")
    private String clientType;

}
