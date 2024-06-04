package com.example.POS_System.exceptions;

/**
 * Thrown when an item with a specified identifier is not found in the inventory.
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        super(message);
    }
}

