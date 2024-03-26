package com.aura.organizationapi.app.config.exception.http;

import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends RuntimeException {

    public static final String MESSAGE = HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase();

    public UnprocessableEntityException() {
        super(MESSAGE);
    }

    public UnprocessableEntityException(String message)  {
        super(message);
    }

}