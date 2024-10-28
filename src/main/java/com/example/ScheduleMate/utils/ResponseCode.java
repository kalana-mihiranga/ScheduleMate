package com.example.ScheduleMate.utils;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200, "successful"),
    INVALID_REQUEST(1000, "Invalid Request"),
    INTERNAL_SERVER_ERROR(1000, "Invalid Request" ),
    NOT_FOUND(1000, "Invalid Request" ),
    BAD_REQUEST(1000, "Invalid Request"  ),
    UNAUTHORIZED(1000, "Invalid Request"  ),
    VALIDATION_ERROR(1000, "Invalid Request" ),
    DUPLICATE(1010, "Duplicate Value" ),
    ROLE_ISSUE(1000, "No Prmission Granted For This Role" ),
    RESOURCE_NOT_FOUND(404, "Resource Not Found");

    private final int code;
    private final String description;

    ResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }


}
