package com.inventorymanagement.exception;

/**
 * @author Harshith Gowda B T
 * @Date 3/7/2023
 */
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String message) {
        super(message);
    }
}

