package com.example.marsrover.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

class MarsRoverServiceTest {

    private IMarsRoverService marsRoverService = new MarsRoverService();

    @Test
    public void testProcessRovers() throws FileNotFoundException {

        String inputFilePath = "input.txt";
        String expectedOutput = "1 3 N\n5 1 E\n";

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Process the rovers
        marsRoverService.praseInputFromFile(inputFilePath);
        marsRoverService.processRoverInstructions();
        marsRoverService.displayfinalCoordsHeadeing();

        // Restore System.out
        System.setOut(System.out);

        // Get the captured output
        String actualOutput = outputStream.toString().replaceAll("\\r","");

        // Compare the expected and actual output
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}