package com.example.mileage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mileage"})
public class MileageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MileageApplication.class, args);
	}

}
