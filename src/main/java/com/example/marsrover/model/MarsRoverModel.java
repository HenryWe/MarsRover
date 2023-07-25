package com.example.marsrover.model;

public class MarsRoverModel {
    private int x;
    private int y;
    private char orientation;
    private String instructions;

    public MarsRoverModel(int x, int y, char orientation, String instructions) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public int getCurrentPositionX() {
        return x;
    }

    public int getCurrentPositionY() {
        return y;
    }

    public char getCurrentPositionOriention() {
        return orientation;
    }

    public String getCurrentPosition() {
        return x + " " + y + " " + orientation;
    }

    public void processInstructions(int plateauX, int plateauY) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    move(plateauX, plateauY);
                    break;
            }
        }
    }

    private void turnLeft() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'N';
                break;
        }
    }

    private void turnRight() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
        }
    }

    private void move(int plateauX, int plateauY) {
        switch (orientation) {
            case 'N':
                if (y < plateauY) y++;
                break;
            case 'E':
                if (x < plateauX) x++;
                break;
            case 'S':
                if (y > 0) y--;
                break;
            case 'W':
                if (x > 0) x--;
                break;
        }
    }
}
