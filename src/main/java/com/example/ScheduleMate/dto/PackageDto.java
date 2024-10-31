package com.example.ScheduleMate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("name")
    private String name;

    @JsonProperty("duration")
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
