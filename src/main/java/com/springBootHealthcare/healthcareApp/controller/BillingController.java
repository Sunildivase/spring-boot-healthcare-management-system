package com.springBootHealthcare.healthcareApp.controller;

import com.springBootHealthcare.healthcareApp.model.Billing;
import com.springBootHealthcare.healthcareApp.model.Prescription;
import com.springBootHealthcare.healthcareApp.service.BillingService;
import com.springBootHealthcare.healthcareApp.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/healthcareManagement")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/billing")
    public boolean createBilling(@RequestBody Billing billing) throws SQLException {
        System.out.println("inside the controller: "+billing);
        return billingService.createBilling();
    }

    @GetMapping("/billing")
    public List<Billing> retrieveAllBilling() throws SQLException {
        return billingService.retrieveAllBilling();
    }

    @GetMapping("/billing/{billId}")
    public List<Billing> retrieveById(@PathVariable("billId") int billId) throws SQLException {
        return billingService.retrieveById(billId);
    }

    @DeleteMapping("/billing/{billId}")
    public boolean deleteBilling(@PathVariable("billId") int billId){
        return billingService.deleteBilling(billId);
    }

    // when we need to update some attributes not all then we use @Patchmapping
//    @PatchMapping
//    public Person updatePerson(@PathVariable ("personId,firstName")int personId,String firstName) {
//        return personService.updatePerson(personId, firstName);
//    }

    // when we need to update all attributes then we use @Putmapping
    @PutMapping("/billing/{billId}")
    public Billing updateBilling ( @PathVariable("billId") int billId, @RequestBody Billing billing) throws SQLException {
        return billingService.updateBilling(billId, billing);
    }
}
