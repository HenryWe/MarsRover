package com.example.marsrover.model;

public class MarsRoverMapModel {
    private int plateauX;
    private int plateauY;
    private char[][] map;

    public MarsRoverMapModel(int plateauX, int plateauY) {
        this.plateauX = plateauX;
        this.plateauY = plateauY;
        this.map = new char[plateauY + 1][plateauX + 1]; // Add 1 to include coordinates from 0 to plateauX/Y
        initializeMap();
    }

    private void initializeMap() {
        for (int y = 0; y <= plateauY; y++) {
            for (int x = 0; x <= plateauX; x++) {
                map[y][x] = '.';
            }
        }
    }

    public void markRoverPosition(int x, int y) {
        if (x >= 0 && x <= plateauX && y >= 0 && y <= plateauY) {
            map[plateauY - y][x] = 'R'; // Reverse the y-axis to match the coordinate system
        }
    }

    public void printMap() {
        for (int y = plateauY; y >= 0; y--) {
            for (int x = 0; x <= plateauX; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
    }
}

