package com.aura.organizationapi.app.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@SuppressWarnings("unused")
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiExceptionDetail handleException(Exception e) {
        log.error(formatLog(e));
        return new ApiExceptionDetail(INTERNAL_SERVER_ERROR, "Unexpected server error.");
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseBody
    public ApiExceptionDetail handleMissingServletRequestPartException(MissingServletRequestPartException e) {
        log.warn(formatLog(e));
        return new ApiExceptionDetail(BAD_REQUEST, e);
    }

    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ApiExceptionDetail handleAccessDeniedException(AccessDeniedException e) {
        log.warn(formatLog(e));
        return new ApiExceptionDetail(FORBIDDEN, e);
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ApiExceptionDetail handleIOException(IOException e) {
        log.error(formatLog(e));
        return new ApiExceptionDetail(INTERNAL_SERVER_ERROR, e);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ApiExceptionDetail handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn(formatLog(e));
        return new ApiExceptionDetail(BAD_REQUEST, e);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiExceptionDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn(formatLog(e));
        return new ApiExceptionDetail(e.getBindingResult());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ApiExceptionDetail handleBindException(BindException e) {
        log.warn(formatLog(e));
        return new ApiExceptionDetail(e.getBindingResult());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(PropertyReferenceException.class)
    @ResponseBody
    public ApiExceptionDetail handlePropertyReferenceException(PropertyReferenceException e) {
        log.warn(formatLog(e));
        return new ApiExceptionDetail(BAD_REQUEST, e);
    }

    private static String formatLog(Exception e) {
        return String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage());
    }

}
