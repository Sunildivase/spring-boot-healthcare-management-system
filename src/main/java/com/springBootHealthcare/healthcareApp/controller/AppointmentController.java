package com.springBootHealthcare.healthcareApp.controller;

import com.springBootHealthcare.healthcareApp.model.Appointment;
import com.springBootHealthcare.healthcareApp.model.Department;
import com.springBootHealthcare.healthcareApp.service.AppointmentService;
import com.springBootHealthcare.healthcareApp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/healthcareManagement")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointment")
    public boolean createAppointment(@RequestBody Appointment appointment) throws SQLException {
        System.out.println("inside the controller: "+appointment);
        return appointmentService.createAppointment();
    }

    @GetMapping("/appointment")
    public List<Appointment> retrieveAllAppointment() throws SQLException {
        return appointmentService.retrieveAllAppointment();
    }

    @GetMapping("/appointment/{appointmentId}")
    public List<Appointment> retrieveById(@PathVariable("appointmentId") int appointmentId) throws SQLException {
        return appointmentService.retrieveById(appointmentId);
    }

    @DeleteMapping("/appointment/{appointmentId}")
    public boolean deleteAppointment(@PathVariable("appointmentId") int appointmentId){
        return appointmentService.deleteAppointment(appointmentId);
    }

    // when we need to update some attributes not all then we use @Patchmapping
//    @PatchMapping
//    public Person updatePerson(@PathVariable ("personId,firstName")int personId,String firstName) {
//        return personService.updatePerson(personId, firstName);
//    }

    // when we need to update all attributes then we use @Putmapping
    @PutMapping("/appointment/{appointmentId}")
    public Appointment updateAppointment ( @PathVariable("appointmentId") int appointmentId, @RequestBody Appointment appointment) throws SQLException {
        return appointmentService.updateAppointment(appointmentId, appointment);
    }
}
