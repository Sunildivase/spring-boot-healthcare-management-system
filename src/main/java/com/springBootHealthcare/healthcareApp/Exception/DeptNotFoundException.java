package com.springBootHealthcare.healthcareApp.Exception;

public class DeptNotFoundException extends RuntimeException {
    public DeptNotFoundException(String message) {
        super(message);
    }
}
