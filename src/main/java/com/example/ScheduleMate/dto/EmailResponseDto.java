package com.example.ScheduleMate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailResponseDto {

    @JsonProperty("status")
    private boolean status;
    @JsonProperty("message")
    private String message;

}
