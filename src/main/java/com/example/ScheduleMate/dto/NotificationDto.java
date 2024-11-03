package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NotificationDto {

    @JsonProperty("role")
    private String role;

    @JsonProperty("message")
    private String message;

    @JsonProperty("notificationType")
    private String notificationType;

    @JsonProperty("clientName")
    private String clientName;
    @JsonProperty("activeStatus")
    private Boolean activeStatus;


}
