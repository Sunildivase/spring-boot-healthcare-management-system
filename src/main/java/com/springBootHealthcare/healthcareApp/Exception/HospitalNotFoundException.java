package com.springBootHealthcare.healthcareApp.Exception;

public class HospitalNotFoundException extends RuntimeException {
    public HospitalNotFoundException(String message) {
        super(message);
    }
}
