package com.springBootHealthcare.healthcareApp.service;

import com.springBootHealthcare.healthcareApp.model.Appointment;
import com.springBootHealthcare.healthcareApp.model.Prescription;
import com.springBootHealthcare.healthcareApp.repository.AppointmentRepository;
import com.springBootHealthcare.healthcareApp.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    private static final Scanner scanner = new Scanner(System.in);

    void printPrescription(Prescription prescription){
        System.out.println(prescription);
    }

    public boolean createPrescription() throws SQLException {

        System.out.println("please enter prescriptionId");
        int prescriptionId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter prescriptionDetails");
        String prescriptionDetails = scanner.nextLine();

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        Prescription prescription = new Prescription(prescriptionId,prescriptionDetails,personId);

        System.out.println("prescription created successfully!!!");
        return prescriptionRepository.createPrescription(prescription);
    }

    public List<Prescription> retrieveAllPrescription() throws SQLException {

        List<Prescription> prescriptionList = new ArrayList<>();

        System.out.println("prescription list: "+prescriptionRepository.retrieveAllPrescription());

        return prescriptionList;
    }


    public List<Prescription> retrieveById(int prescriptionId) throws SQLException {

        List<Prescription> prescriptionList = new ArrayList<>();

        System.out.println("prescription list: "+prescriptionRepository.retrieveById(prescriptionId));

        return prescriptionList;
    }

    public Prescription updatePrescription(int prescriptionId,Prescription prescription) throws SQLException {

        int prescriptionToBeUpdated = prescription.getPrescriptionId();
        String updatedPrescription =prescription.getPrescriptionDetails();

        if (updatedPrescription.isEmpty() && updatedPrescription.isBlank()) {
            System.out.println("prescription updated successfully ");
        } else {
            System.out.println("Failed to update prescription");
        }
        return prescription;
    }

    public boolean deletePrescription(int prescriptionId){

        boolean deletePrescription = prescriptionRepository.deletePrescription(prescriptionId);
        System.out.println("deleted prescription: "+deletePrescription);
        return deletePrescription;

    }
}
