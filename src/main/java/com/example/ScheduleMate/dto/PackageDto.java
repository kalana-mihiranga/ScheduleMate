package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PackageDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("maximumCount")
    private String maximumCount;
    @JsonProperty("price")
    private BigDecimal price;

}
