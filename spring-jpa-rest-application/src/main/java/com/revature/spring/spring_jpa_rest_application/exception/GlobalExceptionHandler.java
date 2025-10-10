package com.revature.spring.spring_jpa_rest_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Annotation to handle exceptions globally across all controllers
public class GlobalExceptionHandler {

    // Handle ResourceNotFoundException and return a 404 Not Found response
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Handle generic exceptions and return a 500 Internal Server Error response
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return new ResponseEntity<>("An error occurred:" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
