package com.springBootHealthcare.healthcareApp.controller;

import com.springBootHealthcare.healthcareApp.model.Person;
import com.springBootHealthcare.healthcareApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/healthcareManagement")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        System.out.println("inside the controller: "+person);
        return personService.createPerson(person);
    }

    @GetMapping("/person")
    public List<Person> retrieveAllPerson(){
        return personService.retrieveAllPerson();
    }

    @GetMapping("/person/{personId}")
    public Person retrieveById(@PathVariable("personId") int personId){
        return personService.retrieveById(personId);
    }

    @DeleteMapping("/person/{personId}")
    public Person deletePerson(@PathVariable("personId") int personId){
        return personService.deletePerson(personId);
    }

    // when we need to update some attributes not all then we use @Patchmapping
    @PatchMapping
    public Person updatePerson(@PathVariable ("personId,firstName")int personId,String firstName) {
        return personService.updatePerson(personId, firstName);
    }

    // when we need to update all attributes then we use @Putmapping
    //    @PutMapping
    //    public Person updatePerson ( @PathVariable("personId,firstName") int personId, String firstName){
    //      return personService.updatePerson(personId, firstName);
    //    }

}
