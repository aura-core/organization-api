package com.aura.organizationapi.app.config.exception.http;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends RuntimeException {

    public static final String MESSAGE = HttpStatus.UNAUTHORIZED.getReasonPhrase();

    public UnauthorizedException() {
        super(MESSAGE);
    }

    public UnauthorizedException(String message)  {
        super(message);
    }
}
