package com.example.ScheduleMate.dto;

import com.example.ScheduleMate.entity.BookingStatus;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.entity.Services;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("clientId")
    private Long clientId;

    @JsonProperty("serviceId")
    private Long serviceId;

    @JsonProperty("packageId")
    private Long packageId;

}
