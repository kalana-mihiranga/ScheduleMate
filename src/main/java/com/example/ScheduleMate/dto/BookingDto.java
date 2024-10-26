package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    @NotNull(message = "bookingId is required")
    @JsonProperty("bookingId")
    private Long bookingId;

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

    @JsonProperty("status")
    private String status; // Using String for simplicity in the DTO

    @JsonProperty("providerNotes")
    private String providerNotes;

    @JsonProperty("bookingTime")
    private LocalDateTime bookingTime;
}
