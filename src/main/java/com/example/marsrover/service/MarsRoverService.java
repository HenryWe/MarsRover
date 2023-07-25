package com.example.marsrover.service;

import com.example.marsrover.exception.MarsRoverException;
import com.example.marsrover.model.MarsRoverMapModel;
import com.example.marsrover.model.MarsRoverModel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class MarsRoverService implements IMarsRoverService {
    private int plateauX;   //  upper right position
    private int plateauY;   //  upper right position
    private List<MarsRoverModel> rovers;

    public MarsRoverService() {
        rovers = new ArrayList<>();
    }

    public void praseInputFromFile(String filePath) throws MarsRoverException {

        try {
            // Load the file from the resources folder
            ClassPathResource resource = new ClassPathResource(filePath);
            InputStream inputStream = resource.getInputStream();

            // Use Scanner to read the file line by line
            try (Scanner scanner = new Scanner(inputStream)) {

                // Read the upper-right coordinates of the plateau - 1st line of input file
                String plateauCoordinates = scanner.nextLine();
                String[] plateauCoordinatesArray = plateauCoordinates.split(" ");
                plateauX = Integer.parseInt(plateauCoordinatesArray[0]);
                plateauY = Integer.parseInt(plateauCoordinatesArray[1]);

                // Read rover positions and instructions - split over two lines
                while (scanner.hasNextLine()) {
                    String position = scanner.nextLine();               // position
                    String instructions = scanner.nextLine();           // instructions

                    String[] positionArray = position.split(" ");
                    int roverX = Integer.parseInt(positionArray[0]);    // x
                    int roverY = Integer.parseInt(positionArray[1]);    // y
                    char roverOrientation = positionArray[2].charAt(0); // cardinal direction

                    // parse object with property values to be processed later
                    rovers.add(new MarsRoverModel(roverX, roverY, roverOrientation, instructions));
                }
            } // The try-with-resources block will automatically close the Scanner
        } catch (IOException e) {

            throw new MarsRoverException("Error processing rovers: " + e.getMessage());
        }
    }

    public void processRoverInstructions() {

        // Each rover will be finished sequentially, which means that the second rover won't s
        // tart to move until the first one has finished moving
        for (MarsRoverModel rover : rovers) {

            rover.processInstructions(plateauX, plateauY);  // passes upper cardinal values
        }
    }

    public void displayfinalCoordsHeadeing() {

        for (MarsRoverModel rover : rovers) {

            System.out.println(rover.getCurrentPosition()); // output final co-ordinate and heading
        }
    }

    public void displaydottedRepresentaion() {

        MarsRoverMapModel marsRoverMap = new MarsRoverMapModel(plateauX, plateauY);

        for (MarsRoverModel rover : rovers) {
            marsRoverMap.markRoverPosition(
                    rover.getCurrentPositionX(), rover.getCurrentPositionY()
            );
        }

        marsRoverMap.printMap();
    }
}

