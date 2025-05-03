package com.springBootHealthcare.healthcareApp.controller;

import com.springBootHealthcare.healthcareApp.model.Appointment;
import com.springBootHealthcare.healthcareApp.model.Prescription;
import com.springBootHealthcare.healthcareApp.service.AppointmentService;
import com.springBootHealthcare.healthcareApp.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/healthcareManagement")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/prescription")
    public boolean createPrescription(@RequestBody Prescription prescription) throws SQLException {
        System.out.println("inside the controller: "+prescription);
        return prescriptionService.createPrescription();
    }

    @GetMapping("/prescription")
    public List<Prescription> retrieveAllPrescription() throws SQLException {
        return prescriptionService.retrieveAllPrescription();
    }

    @GetMapping("/prescription/{prescriptionId}")
    public List<Prescription> retrieveById(@PathVariable("prescriptionId") int prescriptionId) throws SQLException {
        return prescriptionService.retrieveById(prescriptionId);
    }

    @DeleteMapping("/prescription/{prescriptionId}")
    public boolean deletePrescription(@PathVariable("prescriptionId") int prescriptionId){
        return prescriptionService.deletePrescription(prescriptionId);
    }

    // when we need to update some attributes not all then we use @Patchmapping
//    @PatchMapping
//    public Person updatePerson(@PathVariable ("personId,firstName")int personId,String firstName) {
//        return personService.updatePerson(personId, firstName);
//    }

    // when we need to update all attributes then we use @Putmapping
    @PutMapping("/prescription/{prescriptionId}")
    public Prescription updatePrescription ( @PathVariable("prescriptionId") int prescriptionId, @RequestBody Prescription prescription) throws SQLException {
        return prescriptionService.updatePrescription(prescriptionId, prescription);
    }
}
