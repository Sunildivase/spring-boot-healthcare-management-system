package com.springBootHealthcare.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hospital {
    private int hospitalId;
    private String hospitalName;
    private String address;
    private String emailId;
    private String contactNo;
}
