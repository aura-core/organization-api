package com.aura.organizationapi.domain.util.exception;

import java.util.UUID;

public class SectorNotFoundException extends RuntimeException {

    public static final String MESSAGE = "sector not found";

    public SectorNotFoundException() {
        super(MESSAGE);
    }

    public SectorNotFoundException(UUID id) {
        super(String.format("sector '%s' not found", id.toString()));
    }

    public SectorNotFoundException(String message) {
        super(message);
    }

}
