package com.aura.organizationapi.domain.util.exception;

import java.util.UUID;

public class UnitNotFoundException extends RuntimeException {

    public static final String MESSAGE = "unit not found";

    public UnitNotFoundException() {
        super(MESSAGE);
    }

    public UnitNotFoundException(UUID id) {
        super(String.format("unit '%s' not found", id.toString()));
    }

    public UnitNotFoundException(String message) {
        super(message);
    }

}
