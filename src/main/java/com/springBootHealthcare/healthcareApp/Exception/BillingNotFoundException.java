package com.springBootHealthcare.healthcareApp.Exception;

public class BillingNotFoundException extends RuntimeException {
    public BillingNotFoundException(String message) {
        super(message);
    }
}
