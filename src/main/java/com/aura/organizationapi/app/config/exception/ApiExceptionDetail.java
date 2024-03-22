package com.aura.organizationapi.app.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record ApiExceptionDetail(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        Set<String> details) {

    private static final String MESSAGE_FAIL_TO_VALIDATE_FIELDS = "Problemas ao validar os campos";

    public ApiExceptionDetail(HttpStatus status, String message, Set<String> details) {
        this(LocalDateTime.now(), status.value(), status.getReasonPhrase(), message, details);
    }

    public ApiExceptionDetail(HttpStatus status, String message) {
        this(status, message, null);
    }

    public ApiExceptionDetail(HttpStatus httpStatus, Exception exception) {
        this(httpStatus, exception.getMessage(), null);
    }

    public ApiExceptionDetail(BindingResult bindingResult) {
        this(HttpStatus.BAD_REQUEST, MESSAGE_FAIL_TO_VALIDATE_FIELDS, toDetails(bindingResult));
    }

    private static Set<String> toDetails(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(FieldError.class::cast)
                .map(detail -> detail.getField() + ": " + detail.getDefaultMessage())
                .collect(Collectors.toSet());
    }

}
