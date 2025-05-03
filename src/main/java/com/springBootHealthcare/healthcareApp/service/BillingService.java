package com.springBootHealthcare.healthcareApp.service;

import com.springBootHealthcare.healthcareApp.model.Billing;
import com.springBootHealthcare.healthcareApp.model.Prescription;
import com.springBootHealthcare.healthcareApp.repository.BillingRepository;
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
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    private static final Scanner scanner = new Scanner(System.in);

    void printBilling(Billing billing){
        System.out.println(billing);
    }

    public boolean createBilling() throws SQLException {

        System.out.println("please enter billId");
        int billId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter bill");
        Double bill = Double.valueOf(scanner.nextLine());

        System.out.println("please enter totalBill");
        Double totalBill = Double.valueOf(scanner.nextLine());

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        Billing billing = new Billing(billId,bill,totalBill,personId);

        System.out.println("billing created successfully!!!");
        return billingRepository.createBilling(billing);
    }

    public List<Billing> retrieveAllBilling() throws SQLException {

        List<Billing> billingList = new ArrayList<>();

        System.out.println("billing list: "+billingRepository.retrieveAllBilling());

        return billingList;
    }


    public List<Billing> retrieveById(int billId) throws SQLException {

        List<Billing> billingList = new ArrayList<>();

        System.out.println("billing list: "+billingRepository.retrieveById(billId));

        return billingList;
    }

    public Billing updateBilling(int billId,Billing billing) throws SQLException {

        int billingToBeUpdated = billing.getBillId();
        String updatedBilling = String.valueOf(billing.getTotalBill());

        if (updatedBilling.isEmpty() && updatedBilling.isBlank()) {
            System.out.println("billing updated successfully ");
        } else {
            System.out.println("Failed to update billing");
        }
        return billing;
    }

    public boolean deleteBilling(int billId){

        boolean deleteBill = billingRepository.deleteBilling(billId);
        System.out.println("deleted billing: "+deleteBill);
        return deleteBill;

    }
}
