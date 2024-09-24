package com.example.ScheduleMate.config.exception;

import com.example.ScheduleMate.utils.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        logger.error("An unexpected error occurred: ", ex);
        ErrorResponse errorResponse = new ErrorResponse("An Unexpected Error Occurred", request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

        logger.error("Resource not found: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    }

