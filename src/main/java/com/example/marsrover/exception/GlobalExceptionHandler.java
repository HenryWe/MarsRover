package com.example.marsrover.exception;

public class GlobalExceptionHandler {

    public static void handleException(Exception ex) {

        System.err.println(

                String .format("\nAn error occurred: %s\n", ex.getMessage())
        );
    }
}
