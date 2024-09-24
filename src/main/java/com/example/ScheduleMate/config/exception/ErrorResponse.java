package com.example.ScheduleMate.config.exception;


import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse {
    private String message;
    private String details;
    private Date timestamp;

    public ErrorResponse(String message,String details){
        this.message=message;
        this.details=details;
        this.timestamp=new Date();
    }

}
