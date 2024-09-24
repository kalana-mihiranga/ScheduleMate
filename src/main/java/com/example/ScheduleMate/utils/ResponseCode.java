package com.example.ScheduleMate.utils;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200, "successful");

    private final int code;
    private final String description;

    ResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }


}
