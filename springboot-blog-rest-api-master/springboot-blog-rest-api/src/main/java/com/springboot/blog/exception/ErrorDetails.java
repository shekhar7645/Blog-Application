package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    private HttpStatus status;

    // Constructor to initialize the error details
    public ErrorDetails(Date timestamp, String message, String details, HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.status = status;
    }

    // Getters for the fields
    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
