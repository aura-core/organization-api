package com.aura.organizationapi.domain.util.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public static final String MESSAGE = "user not found";

    public UserNotFoundException() {
        super(MESSAGE);
    }

    public UserNotFoundException(UUID id) {
        super(String.format("user '%s' not found", id.toString()));
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
