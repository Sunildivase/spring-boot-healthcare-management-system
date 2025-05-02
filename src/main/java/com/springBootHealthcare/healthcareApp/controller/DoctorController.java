package com.springBootHealthcare.healthcareApp.controller;

import com.springBootHealthcare.healthcareApp.model.Doctor;
import com.springBootHealthcare.healthcareApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/healthcareManagement")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor")
    public boolean createDoctor(@RequestBody Doctor doctor) throws SQLException {
        System.out.println("inside the controller: "+doctor);
        return doctorService.createDoctor();
    }

    @GetMapping("/doctor")
    public List<Doctor> retrieveAllDoctor() throws SQLException {
        return doctorService.retrieveAllDoctor();
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Doctor> retrieveById(@PathVariable("doctorId") int doctorId) throws SQLException {
        return doctorService.retrieveById(doctorId);
    }

    @DeleteMapping("/doctor/{doctorId}")
    public boolean deleteDoctor(@PathVariable("doctorId") int doctorId){
        return doctorService.deleteDoctor(doctorId);
    }

    // when we need to update some attributes not all then we use @Patchmapping
//    @PatchMapping
//    public Person updatePerson(@PathVariable ("personId,firstName")int personId,String firstName) {
//        return personService.updatePerson(personId, firstName);
//    }

    // when we need to update all attributes then we use @Putmapping
    @PutMapping("/doctor/{doctorId}")
    public boolean updateDoctor ( @PathVariable("doctorId,firstName") int doctorId, String firstName) throws SQLException {
        return doctorService.updateDoctor(doctorId, firstName);
    }

}
