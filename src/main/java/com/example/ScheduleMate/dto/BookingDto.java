package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    @JsonProperty("bookingId")
    private Long bookingId;

    @JsonProperty("clientId")
    private Long clientId;

    @JsonProperty("eventId")
    private Long eventId;

    @JsonProperty("serviceId")
    private Long serviceId;

    @JsonProperty("slotId")
    private Long slotId;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("status")
    private String status;

    @JsonProperty("providerNotes")
    private String providerNotes;

    @JsonProperty("bookingTime")
    private LocalDateTime bookingTime;

}
