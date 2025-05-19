package com.springBootHealthcare.healthcareApp.Exception;

public class EmailIdNotFoundException extends RuntimeException {
    public EmailIdNotFoundException(String message) {
        super(message);
    }
}
