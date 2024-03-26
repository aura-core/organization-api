package com.aura.organizationapi.app.config.exception.http;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {

    public static final String MESSAGE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public BadRequestException() {
        super(MESSAGE);
    }

    public BadRequestException(String message)  {
        super(message);
    }
}
