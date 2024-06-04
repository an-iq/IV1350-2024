package com.example.POS_System.exceptions;

/**
 * Thrown when a database access error occurs.
 */
public class DatabaseFailureException extends RuntimeException {
    public DatabaseFailureException(String message) {
        super(message);
    }
}