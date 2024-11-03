package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDto {

    @JsonProperty("id")
    private Long id;


    @NotBlank(message = "Package Name is required")

    @JsonProperty("name")
    private String name;

    @JsonProperty("duration")

    private String duration;


    @JsonProperty("maximumCount")
    private String maximumCount;

    @NotNull(message = "price is required")
    @DecimalMin(value = "0.0")

    private Integer duration;

    @JsonProperty("maximumCount")
    private Integer maximumCount;


    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("businessId")
    private Long businessId;

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("createdTime")
    private Date createdTime;

}
