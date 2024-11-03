package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotDTO {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "startTime is required")
    @FutureOrPresent(message = "startTime cannot be in the past")
    @JsonProperty("startTime")
    private LocalDateTime startTime;

    @NotNull(message = "endTime is required")
    @FutureOrPresent(message = "endTime cannot be in the past")
    @JsonProperty("endTime")
    private LocalDateTime endTime;

    @JsonProperty("availableSeats")
    private int availableSeats;

}
