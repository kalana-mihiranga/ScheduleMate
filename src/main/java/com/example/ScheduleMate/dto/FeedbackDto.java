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

    @JsonProperty("businessId")
    private Long businessId;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("comment")
    private String comment;

}
