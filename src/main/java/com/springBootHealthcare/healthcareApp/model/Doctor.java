package com.springBootHealthcare.healthcareApp.model;

public record Doctor(int doctorId,String firstName,String lastName,int age,String gender,String contactNo,String speciality,int experience) {
}
