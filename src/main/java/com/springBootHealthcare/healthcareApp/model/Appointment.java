package com.springBootHealthcare.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {
    private int appointmentId;
    private int personId;
    private int doctorId;
    private int hospitalId;
    private int deptId;
}
