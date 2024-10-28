package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("discountRate")
    private BigDecimal discountRate;

    @JsonProperty("duration")
    private Long duration;

    @JsonProperty("description")
    private String description;

    @JsonProperty("conditions")
    private String conditions;

    @JsonProperty("serviceFrom")
    private LocalTime serviceFrom;

    @JsonProperty("serviceTo")
    private LocalTime serviceTo;

    @JsonProperty("availability")
    private List<DayOfWeek> availability;

    @JsonProperty("imageUrl")
    private String imageUrl;

}
