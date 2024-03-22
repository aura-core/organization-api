package com.aura.organizationapi.domain.util.exception;

import java.util.UUID;

public class JobPositionNotFoundException extends RuntimeException {

    public static final String MESSAGE = "possition not found";

    public JobPositionNotFoundException() {
        super(MESSAGE);
    }

    public JobPositionNotFoundException(UUID id) {
        super(String.format("possition '%s' not found", id.toString()));
    }

    public JobPositionNotFoundException(String message) {
        super(message);
    }

}
