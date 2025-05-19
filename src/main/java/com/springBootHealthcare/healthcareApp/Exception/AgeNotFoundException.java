package com.springBootHealthcare.healthcareApp.Exception;

public class AgeNotFoundException extends RuntimeException {
    public AgeNotFoundException(String message) {
        super(message);
    }
}
