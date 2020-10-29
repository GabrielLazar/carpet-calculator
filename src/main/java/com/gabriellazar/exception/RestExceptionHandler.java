package com.gabriellazar.exception;

import com.gabriellazar.models.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidDataException.class)
    protected ResponseEntity<ApiError> handleDataNotFound(InvalidDataException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
