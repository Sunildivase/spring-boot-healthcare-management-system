package com.springBootHealthcare.healthcareApp.service;

import com.springBootHealthcare.healthcareApp.model.Person;
import com.springBootHealthcare.healthcareApp.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private static final Scanner scanner = new Scanner(System.in);

    void printPerson(Person person){
        System.out.println(person);
    }

    public boolean createPerson() throws SQLException {

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter type");
        String type = scanner.nextLine();

        System.out.println("please enter firstName");
        String firstName = scanner.nextLine();

        System.out.println("please enter lastName");
        String lastName = scanner.nextLine();

        System.out.println("please enter age");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter gender");
        String gender = scanner.nextLine();

        System.out.println("please enter contactNo");
        String contactNo = scanner.nextLine();

        System.out.println("please enter alternateMobile");
        String  alternateMobile = scanner.nextLine();

        System.out.println("please enter address");
        String address = scanner.nextLine();

        Person person = new Person();

        person.setPersonId(personId);
        person.setType(type);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        person.setGender(gender);
        person.setContactNo(contactNo);
        person.setAlternateMobile(alternateMobile);
        person.setAddress(address);

        System.out.println("person created successfully!!!");
        return personRepository.createPerson(person);
    }

    public List<Person> retrieveAllPerson() throws SQLException {

        List<Person> personList = new ArrayList<>();

        System.out.println("person list: "+personRepository.retrieveAllPerson());

        return personList;
    }


    public List<Person> retrieveById(int personId) throws SQLException {

        List<Person> personList = new ArrayList<>();

        System.out.println("person list: "+personRepository.retrieveById(personId));

        return personList;
    }

    public Person updatePerson(int personId,Person person) throws SQLException {

        int personToBeUpdated = person.getPersonId();
        String updatedPerson = person.getFirstName();

        if (updatedPerson.isBlank() && updatedPerson.isEmpty()) {
            System.out.println("person updated successfully ");
        } else {
            System.out.println("Failed to update person");
        }
       return person;
    }

    public boolean deletePerson(int personId){

        boolean deletedPerson = personRepository.deletePerson(personId);
        System.out.println("deleted person: "+deletedPerson);
        return deletedPerson;

    }
}
