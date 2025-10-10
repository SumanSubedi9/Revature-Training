package com.revature.spring.spring_jpa_rest_application.exception;

// Custom exception class to handle resource not found scenarios
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
