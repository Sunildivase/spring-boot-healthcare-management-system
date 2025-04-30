package com.springBootHealthcare.healthcareApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class HealthcareApp {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareApp.class, args);
	}

}
