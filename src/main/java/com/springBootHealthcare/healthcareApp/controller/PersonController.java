package com.springBootHealthcare.healthcareApp.controller;

import com.springBootHealthcare.healthcareApp.model.Person;
import com.springBootHealthcare.healthcareApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/healthcareManagement")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public boolean createPerson(@RequestBody Person person) throws SQLException {
        System.out.println("inside the controller: "+person);
        return personService.createPerson();
    }

    @GetMapping("/person")
    public List<Person> retrieveAllPerson() throws SQLException {
        return personService.retrieveAllPerson();
    }

    @GetMapping("/person/{personId}")
    public List<Person> retrieveById(@PathVariable("personId") int personId) throws SQLException {
        return personService.retrieveById(personId);
    }

    @DeleteMapping("/person/{personId}")
    public boolean deletePerson(@PathVariable("personId") int personId){
        return personService.deletePerson(personId);
    }

    // when we need to update some attributes not all then we use @Patchmapping
//    @PatchMapping
//    public Person updatePerson(@PathVariable ("personId,firstName")int personId,String firstName) {
//        return personService.updatePerson(personId, firstName);
//    }

    // when we need to update all attributes then we use @Putmapping
        @PutMapping("/person/{personId}")
        public boolean updatePerson ( @PathVariable("personId,firstName") int personId, String firstName) throws SQLException {
          return personService.updatePerson(personId, firstName);
        }

}
