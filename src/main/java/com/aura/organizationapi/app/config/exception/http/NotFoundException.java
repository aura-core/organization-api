package com.aura.organizationapi.app.config.exception.http;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    public static final String MESSAGE = HttpStatus.NOT_FOUND.getReasonPhrase();

    public NotFoundException() {
        super(MESSAGE);
    }

    public NotFoundException(String message)  {
        super(message);
    }
}

