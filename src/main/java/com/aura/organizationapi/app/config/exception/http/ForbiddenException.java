package com.aura.organizationapi.app.config.exception.http;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends RuntimeException {

    public static final String MESSAGE = HttpStatus.FORBIDDEN.getReasonPhrase();

    public ForbiddenException() {
        super(MESSAGE);
    }

    public ForbiddenException(String message)  {
        super(message);
    }
}
