package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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


    @NotBlank(message = " name is required")

    @JsonProperty("businessId")
    private Long businessId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("discountRate")
    private Integer discountRate;

    @NotBlank(message = " description is required")
    @JsonProperty("description")
    private String description;

    @JsonProperty("conditions")
    private String conditions;

    @NotNull(message = "serviceFrom is required")
    @FutureOrPresent(message = "serviceFrom cannot be in the past")
    @JsonProperty("serviceFrom")
    private LocalTime serviceFrom;

    @NotNull(message = "serviceTo is required")
    @FutureOrPresent(message = "serviceTo cannot be in the past")
    @JsonProperty("serviceTo")
    private LocalTime serviceTo;

    @JsonProperty("availability")
    private List<DayOfWeek> availability;

    @JsonProperty("packageList")
    private List<ServicePackageDto> packageList;

    @JsonProperty("imageUrl")
    private String imageUrl;

}
