package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("providerId")
    private Long providerId; // Store providerId as Long for simplicity

    @JsonProperty("eventTitle")
    private String eventTitle;

    @JsonProperty("description")
    private String description;

    @JsonProperty("posterUrl")
    private String posterUrl;

    @JsonProperty("availableTimeSlots")
    private List<TimeSlotDTO> availableTimeSlots;
}
