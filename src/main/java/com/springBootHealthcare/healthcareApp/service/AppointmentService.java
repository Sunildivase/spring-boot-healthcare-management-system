package com.springBootHealthcare.healthcareApp.service;

import com.springBootHealthcare.healthcareApp.model.Appointment;
import com.springBootHealthcare.healthcareApp.model.Department;
import com.springBootHealthcare.healthcareApp.repository.AppointmentRepository;
import com.springBootHealthcare.healthcareApp.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    private static final Scanner scanner = new Scanner(System.in);

    void printAppointment(Appointment appointment){
        System.out.println(appointment);
    }

    public boolean createAppointment() throws SQLException {

        System.out.println("please enter appointmentId");
        int appointmentId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter doctorId");
        int doctorId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter hospitalId");
        int hospitalId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter deptId");
        int deptId = Integer.parseInt(scanner.nextLine());

        Appointment appointment = new Appointment(appointmentId,personId,doctorId,hospitalId,deptId);

        System.out.println("appointment created successfully!!!");
        return appointmentRepository.createAppointment(appointment);
    }

    public List<Appointment> retrieveAllAppointment() throws SQLException {

        List<Appointment> appointmentList = new ArrayList<>();

        System.out.println("appointment list: "+appointmentRepository.retrieveAllAppointment());

        return appointmentList;
    }


    public List<Appointment> retrieveById(int deptId) throws SQLException {

        List<Appointment> appointmentList = new ArrayList<>();

        System.out.println("appointment list: "+appointmentRepository.retrieveById(deptId));

        return appointmentList;
    }

    public Appointment updateAppointment(int appointmentId,Appointment appointment) throws SQLException {

        int appointmentToBeUpdated = appointment.getAppointmentId();
        String updatedAppointment = String.valueOf(appointment.getPersonId());

        if (updatedAppointment.isEmpty() && updatedAppointment.isBlank()) {
            System.out.println("appointment updated successfully ");
        } else {
            System.out.println("Failed to update department");
        }
        return appointment;
    }

    public boolean deleteAppointment(int appointmentId){

        boolean deleteAppointment = appointmentRepository.deleteAppointment(appointmentId);
        System.out.println("deleted appointment: "+deleteAppointment);
        return deleteAppointment;

    }
}
