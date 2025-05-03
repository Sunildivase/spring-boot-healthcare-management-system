package com.springBootHealthcare.healthcareApp.service;

import com.springBootHealthcare.healthcareApp.model.Department;
import com.springBootHealthcare.healthcareApp.model.Hospital;
import com.springBootHealthcare.healthcareApp.repository.DepartmentRepository;
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
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Scanner scanner = new Scanner(System.in);

    void printDepartment(Department department){
        System.out.println(department);
    }

    public boolean createDepartment() throws SQLException {

        System.out.println("please enter deptId");
        int deptId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter deptName");
        String deptName = scanner.nextLine();

        System.out.println("please enter hospitalId");
        int hospitalId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter doctorId");
        int doctorId = Integer.parseInt(scanner.nextLine());

        Department department = new Department(deptId,deptName,hospitalId,doctorId);

        System.out.println("department created successfully!!!");
        return departmentRepository.createDepartment(department);
    }

    public List<Department> retrieveAllDepartment() throws SQLException {

        List<Department> departmentList = new ArrayList<>();

        System.out.println("department list: "+departmentRepository.retrieveAllDepartment());

        return departmentList;
    }


    public List<Department> retrieveById(int deptId) throws SQLException {

        List<Department> departmentList = new ArrayList<>();

        System.out.println("department list: "+departmentRepository.retrieveById(deptId));

        return departmentList;
    }

    public Department updateDepartment(int deptId,Department department) throws SQLException {

        int departmentToBeUpdated = department.getDeptId();
        String updatedDepartment = department.getDeptName();

        if (updatedDepartment.isBlank() && updatedDepartment.isEmpty()) {
            System.out.println("department updated successfully ");
        } else {
            System.out.println("Failed to update department");
        }
        return department;
    }

    public boolean deleteDepartment(int deptId){

        boolean deletedDept = departmentRepository.deleteDepartment(deptId);
        System.out.println("deleted hospital: "+deletedDept);
        return deletedDept;

    }
}
