package com.example.marsrover.service;

import com.example.marsrover.exception.MarsRoverException;
import com.example.marsrover.model.MarsRoverModel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface IMarsRoverService {
    void praseInputFromFile(String filePath) throws MarsRoverException;
    void processRoverInstructions();
    void displayfinalCoordsHeadeing();
    void displaydottedRepresentaion();
}

