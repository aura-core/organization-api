package com.aura.organizationapi.domain.util.exception;

import java.util.UUID;

public class DepartmentNotFoundException extends RuntimeException {

    public static final String MESSAGE = "department not found";

    public DepartmentNotFoundException() {
        super(MESSAGE);
    }

    public DepartmentNotFoundException(UUID id) {
        super(String.format("department '%s' not found", id.toString()));
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

}
