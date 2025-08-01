package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogAPIException.class)
    public ResponseEntity<ErrorDetails> handleBlogAPIException(BlogAPIException ex) {
        // Create an ErrorDetails object with status code, message, and timestamp
        ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                ex.getMessage(),
                "uri=" + ex.getStackTrace()[0].toString(), // You can adjust this as needed
                ex.getStatus()
        );

        // Return the error details with the correct status code
        return new ResponseEntity<>(errorDetails, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGeneralException(Exception ex) {
        // Create ErrorDetails for general exceptions with status 500
        ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                "An error occurred: " + ex.getMessage(),
                "uri=" + ex.getStackTrace()[0].toString(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



