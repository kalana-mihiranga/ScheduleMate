package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("clientId")
    private Long clientId;

    @JsonProperty("serviceId")
    private Long serviceId;

    @JsonProperty("bookingId")
    private Long bookingId;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("comments")
    private String comments;

}