package com.springBootHealthcare.healthcareApp.controller;

import com.springBootHealthcare.healthcareApp.model.Doctor;
import com.springBootHealthcare.healthcareApp.model.Hospital;
import com.springBootHealthcare.healthcareApp.service.DoctorService;
import com.springBootHealthcare.healthcareApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/healthcareManagement")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/hospital")
    public boolean createHospital(@RequestBody Hospital hospital) throws SQLException {
        System.out.println("inside the controller: "+hospital);
        return hospitalService.createHospital();
    }

    @GetMapping("/hospital")
    public List<Hospital> retrieveAllHospital() throws SQLException {
        return hospitalService.retrieveAllHospital();
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<Hospital> retrieveById(@PathVariable("hospitalId") int hospitalId) throws SQLException {
        return hospitalService.retrieveById(hospitalId);
    }

    @DeleteMapping("/hospital/{hospitalId}")
    public boolean deleteHospital(@PathVariable("hospitalId") int hospitalId){
        return hospitalService.deleteHospital(hospitalId);
    }

    // when we need to update some attributes not all then we use @Patchmapping
//    @PatchMapping
//    public Person updatePerson(@PathVariable ("personId,firstName")int personId,String firstName) {
//        return personService.updatePerson(personId, firstName);
//    }

    // when we need to update all attributes then we use @Putmapping
    @PutMapping("/hospital/{hospitalId}")
    public Hospital updateHospital ( @PathVariable("hospitalId") int hospitalId, @RequestBody Hospital hospital) throws SQLException {
        return hospitalService.updateHospital(hospitalId, hospital);
    }

}
