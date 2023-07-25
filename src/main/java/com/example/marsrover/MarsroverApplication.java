package com.example.marsrover;

import com.example.marsrover.exception.GlobalExceptionHandler;
import com.example.marsrover.exception.MarsRoverException;
import com.example.marsrover.service.IMarsRoverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarsroverApplication {

	@Autowired
	IMarsRoverService marsRoverService;
	public static void main(String[] args) {
		SpringApplication.run(MarsroverApplication.class, args);
	}

	// Define the CommandLineRunner bean
	@Bean
	public CommandLineRunner myCommandLineRunner() {

		try {
			marsRoverService.praseInputFromFile("input.txt");

			marsRoverService.processRoverInstructions();	//	instructions read / stored into marsrovermodel

			System.out.println("\nExpected output for Mars Rover according to input file\n");
			marsRoverService.displayfinalCoordsHeadeing();	// out mars rover final co-ordinates and cardinal

			System.out.println("\nDotted notation of Mars Rover on ractangular plateu\n");
			marsRoverService.displaydottedRepresentaion();	// Bonus feature

			System.out.println("\nOutput completed for Mars Rover according to input file\n");


		} catch (MarsRoverException e) {

			GlobalExceptionHandler.handleException(e);	// Global Exception handler
		}

		return args -> {
			System.out.println("\nMars Rover Application completed");
		};
	}
}
