package com.aura.organizationapi.domain.util.exception;

import java.util.UUID;

public class TeamNotFoundException extends RuntimeException {

    public static final String MESSAGE = "team not found";

    public TeamNotFoundException() {
        super(MESSAGE);
    }

    public TeamNotFoundException(UUID id) {
        super(String.format("team '%s' not found", id.toString()));
    }

    public TeamNotFoundException(String message) {
        super(message);
    }

}
