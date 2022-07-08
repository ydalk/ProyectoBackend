package com.example.ProyectoClinic;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoClinicApplication {

	public static void main(String[] args) {


		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(ProyectoClinicApplication.class, args);
	}

}
