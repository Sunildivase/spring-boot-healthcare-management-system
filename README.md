# spring-boot-healthcare-management-system
spring boot project

## Introduction
🚀 Project Overview The spring-boot-healthcare-management-system is a Java-based web application built using Servlet and JSP technologies. It simulates real-world operations such as user registration, patient booking, doctor management, appointment booking, and appointment booking functionalities. This project serves as a hands-on approach to understanding full-stack Java development while applying core concepts like JDBC, MVC, and OOP design principles.

## Features
Key Features 👤 customer, 👨🏻‍⚕️ Doctor,🏥 hospital Registration & 📅appointment.

Register and manage both customer and doctor accounts seamlessly.

📅 appointment booking

Book appointment by selecting 👤 customer,👨🏻‍⚕️ Doctor & 🏥 hospital automatically.

🗃️ CRUD Operations

Perform Create, Read, Update, and Delete operations on all modules.

📈 Admin Dashboard

Customer, Doctor, Hospital,Department,Apointment,Billing,Prescription activity.

## Technologies Used
🛠️ Stack

Java – Core language for backend logic

JSP/Servlet (Jakarta EE) – For handling web requests and building the user interface

JDBC – For database operations

MySQL – Relational database to store system data

HTML/CSS – Frontend structure and styling

JavaScript – Basic client-side interactivity

Apache Tomcat – Servlet container

Maven – Build and dependency management

Git – Version control

## Getting Started
💡 Installation and Setup

## Prerequisites
Java JDK 21

Apache Tomcat 10

MYSQL 8

Maven 3.8

IDE (IntelliJ)

Git (optional)

## Setup MySQL Database
CREATE DATABASE healthcareDatat; USE healthcaredata;

## Configure Your MySQL Connection
jdbc.url=jdbc:mysql://localhost:3306/cab_management jdbc.username=root jdbc.password=your_password jdbc.driver=com.mysql.cj.jdbc.Driver

Compile and Run the Application
locate Main.java in your IDE.

Run the file to launch the application.

Build the project mvn clean install Deploy to Tomcat Server Place the .war file in the webapps folder and start the server.

## Usage
Customer Registration & Login

Book a Appointment

Assign Doctor & Hospital Details

Make a bill

Admin Access to Monitor Activities

## Contributing
Contributions are welcome! Open an issue or submit a pull request. For major changes, please open a discussion first.

## Functionality
Customer

Doctor

Hospital

Department

Appointment

Prescription

Billing

# Package Structure
* com.healthcareApp Contains the main application logic (healthcareApp.java)
* * com.healthcareApp.controller: includes all the controller classes:
  * PersonController.java
  * DoctoController.java
  * HospitalController.java
  * DepartmentController.java
  * AppointmentController.java
  * PrescriptionController.java
  * BillingController.java
* com.helathcareApp.model: includes all the model classes:
  * Person.java
  * Doctor.java
  * Hospital.java
  * Department.java
  * Appointment.java
  * Prescription.java
  * Billing.java
* com.healthcareApp.service: includes all the service classes and interfaces:
   * PersonService.java
   * DoctorService.java
   * HospitalService.java
   * DepartmentService.java
   * AppointmentService.java
   * PrescriptionService.java
   * BillingService.java
   * ConnectionService.java
     
 # Class Diagram
```mermaid
---
title: healthcare management system
---
classDiagram

 note " This is generally appointment booking for health services"

 class Person
 Person : +int personId
 Person : +String firstname
 Person : +String lastName
 Person : +int age
 Person : +String gender
 Person : +Long contactNo
 Person : +Long alternateMobile
 Person : +String address

class Person{
 +createPerson()
 +displayPerson()
}

 

Doctor: +int doctorId
Doctor: +String firstName
Doctor: +String lastName
Doctor: +int age
Doctor: +String gender
Doctor: +String contactNo
Doctor: +String speciality
Doctor: +int experience

class Doctor{
 +createDoctor()
 +displayDoctor()
}


Hospital: +int hospitalId
Hospital: +String hospitalName
Hospital: +String address
Hospital: +Long contactNo
Hospital: +String emailId

class Hospital{
+createHospital()
+displayHospital()
}

Department: +int deptId
Department: +String deptName
Department: +doctorId
Department: +hosptitalId

class Department{
+createDepartment()
+displayDepartment()
}

Hospital <-- Department : Association
Doctor  <-- Department  : Assocciation

Appointment: +int appointmentId
Appointment: +int personId
Appointment: +int doctorId
Appointment: +int hospitalId
Appointment: +int deptId

class Appointment{
+createAppointment()
+displayAppointment()

}


Appointment --> Person : Association
Appointment --> Doctor : Association
Appointment --> Hospital : Association
Appointment --> Department : Association

Prescription : +int prescriptionId
Prescription : +String prescriptionDetails
Prescription : +int personId

class Prescription{
+createPrescription()
+displayPrescription()
}

Prescription --> Person : Association

Billing : +int billId
Billing : +int bill
Billing : +int totalBill
Billing : +int personId

class Billing{
+createBilling()
+displayBilling()
}

Billing --> Person : Association

```




