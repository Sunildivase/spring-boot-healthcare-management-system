package com.springBootHealthcare.healthcareApp.service;


import com.springBootHealthcare.healthcareApp.model.Hospital;
import com.springBootHealthcare.healthcareApp.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    private static final Scanner scanner = new Scanner(System.in);

    void printHospital(Hospital hospital){
        System.out.println(hospital);
    }

    public boolean createHospital() throws SQLException {

        System.out.println("please enter hospitalId");
        int hospitalId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter hospitalName");
        String hospitalName = scanner.nextLine();

        System.out.println("please enter address");
        String address = scanner.nextLine();

        System.out.println("please enter emailId");
        String emailId = scanner.nextLine();

        System.out.println("please enter contactNo");
        String contactNo = scanner.nextLine();

        Hospital hospital = new Hospital(hospitalId,hospitalName,address,emailId,contactNo);

        System.out.println("hospital created successfully!!!");
        return hospitalRepository.createHospital(hospital);
    }

    public List<Hospital> retrieveAllHospital() throws SQLException {

        List<Hospital> hospitalList = new ArrayList<>();

        System.out.println("hospital list: "+hospitalRepository.retrieveAllHospital());

        return hospitalList;
    }


    public List<Hospital> retrieveById(int hospitalId) throws SQLException {

        List<Hospital> hospitalList = new ArrayList<>();

        System.out.println("hospital list: "+hospitalRepository.retrieveById(hospitalId));

        return hospitalList;
    }

    public Hospital updateHospital(int hospitalId,Hospital hospital) throws SQLException {

        int hospitalToBeUpdated = hospital.getHospitalId();
        String updatedHospital = hospital.getHospitalName();

        if (updatedHospital.isBlank() && updatedHospital.isEmpty()) {
            System.out.println("hospital updated successfully ");
        } else {
            System.out.println("Failed to update hospital");
        }
        return hospital;
    }

    public boolean deleteHospital(int hospitalId){

        boolean deletedHospital = hospitalRepository.deleteHospital(hospitalId);
        System.out.println("deleted hospital: "+deletedHospital);
        return deletedHospital;

    }
}
