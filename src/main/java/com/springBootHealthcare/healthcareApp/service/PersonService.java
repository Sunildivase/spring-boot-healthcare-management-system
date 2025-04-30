package com.springBootHealthcare.healthcareApp.service;

import com.springBootHealthcare.healthcareApp.model.Person;
import com.springBootHealthcare.healthcareApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person){

        return person;
    }

    public void retrieveAllPerson(){

    }

    public void retrieveById(int personId){

    }

    public void updatePerson(int personId,String firstName){

    }

    public void deletePerson(int personId){

    }
}
