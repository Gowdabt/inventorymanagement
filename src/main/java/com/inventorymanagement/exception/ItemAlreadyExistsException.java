package com.inventorymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Harshith Gowda B T
 * @Date 3/7/2023
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemAlreadyExistsException extends RuntimeException {

    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}

