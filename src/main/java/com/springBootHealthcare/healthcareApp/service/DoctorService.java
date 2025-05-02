package com.springBootHealthcare.healthcareApp.service;

import com.springBootHealthcare.healthcareApp.model.Doctor;
import com.springBootHealthcare.healthcareApp.model.Person;
import com.springBootHealthcare.healthcareApp.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    private static final Scanner scanner = new Scanner(System.in);

    void printDoctor(Doctor doctor){
        System.out.println(doctor);
    }

    public boolean createDoctor() throws SQLException {

        System.out.println("please enter doctorId");
        int doctorId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter firstName");
        String firstName = scanner.nextLine();

        System.out.println("please enter lastName");
        String lastName = scanner.nextLine();

        System.out.println("please enter age");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter gender");
        String gender = scanner.nextLine();

        System.out.println("please enter contactNo");
        String contactNo = scanner.nextLine();

        System.out.println("please enter speciality");
        String speciality = scanner.nextLine();

        System.out.println("please enter experience");
        int experience = Integer.parseInt(scanner.nextLine());

        Doctor doctor = new Doctor(doctorId,firstName,lastName,age,gender,contactNo,speciality,experience);


        System.out.println("doctor created successfully!!!");
        return doctorRepository.createDoctor(doctor);
    }

    public List<Doctor> retrieveAllDoctor() throws SQLException {

        List<Doctor> doctorList = new ArrayList<>();

        System.out.println("doctor list: "+doctorRepository.retrieveALlDoctor());

        return doctorList;
    }


    public List<Doctor> retrieveById(int doctorId) throws SQLException {

        List<Doctor> doctorList = new ArrayList<>();

        System.out.println("doctor list: "+doctorRepository.retrieveById(doctorId));

        return doctorList;
    }

    public boolean updateDoctor(int doctorId,String firstName) throws SQLException {

        boolean doctorUpdated = doctorRepository.updateDoctor(doctorId, firstName);

        if (doctorUpdated) {
            System.out.println("doctor updated successfully ");
        } else {
            System.out.println("Failed to update doctor");
        }
        return doctorUpdated;
    }

    public boolean deleteDoctor(int doctorId){

        boolean deletedDoctor = doctorRepository.deleteDoctor(doctorId);
        System.out.println("deleted doctor: "+deletedDoctor);
        return deletedDoctor;

    }
}
