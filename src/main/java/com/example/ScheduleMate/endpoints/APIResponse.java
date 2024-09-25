package com.example.ScheduleMate.endpoints;

import com.example.ScheduleMate.utils.ResponseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> {
    @JsonProperty("timestamp")
    private Date timestamp;
    @JsonProperty("status")
    private int status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("body")
    private T body;

    public APIResponse(@NonNull ResponseCode header) {
        this.timestamp = new Date();
        this.status = header.getCode();
        this.message = header.getDescription();
    }

    public APIResponse(@NonNull ResponseCode header, T body) {
        this(header);
        this.body = body;
    }

}
