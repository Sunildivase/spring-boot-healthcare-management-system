package com.springBootHealthcare.healthcareApp.controller;

import com.springBootHealthcare.healthcareApp.model.Department;
import com.springBootHealthcare.healthcareApp.model.Hospital;
import com.springBootHealthcare.healthcareApp.service.DepartmentService;
import com.springBootHealthcare.healthcareApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/healthcareManagement")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public boolean createDepartment(@RequestBody Department department) throws SQLException {
        System.out.println("inside the controller: "+department);
        return departmentService.createDepartment();
    }

    @GetMapping("/department")
    public List<Department> retrieveAllDepartment() throws SQLException {
        return departmentService.retrieveAllDepartment();
    }

    @GetMapping("/department/{deptId}")
    public List<Department> retrieveById(@PathVariable("deptId") int deptId) throws SQLException {
        return departmentService.retrieveById(deptId);
    }

    @DeleteMapping("/department/{deptId}")
    public boolean deleteDepartment(@PathVariable("deptId") int deptId){
        return departmentService.deleteDepartment(deptId);
    }

    // when we need to update some attributes not all then we use @Patchmapping
//    @PatchMapping
//    public Person updatePerson(@PathVariable ("personId,firstName")int personId,String firstName) {
//        return personService.updatePerson(personId, firstName);
//    }

    // when we need to update all attributes then we use @Putmapping
    @PutMapping("/department/{deptId}")
    public Department updateDepartment ( @PathVariable("deptId") int deptId, @RequestBody Department department) throws SQLException {
        return departmentService.updateDepartment(deptId, department);
    }

}
