package com.springBootHealthcare.healthcareApp.model;

public record Appointment(int appointmentId,int personId,int doctorId,int hospitalId,int deptId) {
}
