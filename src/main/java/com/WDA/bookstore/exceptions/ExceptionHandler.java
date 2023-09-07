package com.WDA.bookstore.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handleEntityExistsException(EntityExistsException exception){
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList( exception.getMessage() )
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> errors.add( fieldError.getDefaultMessage() ) );

        return buildResponseEntity( HttpStatus.BAD_REQUEST, "Verifique se colocou todos os dados corretamente", errors );
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();

        return buildResponseEntity( HttpStatus.BAD_REQUEST, "Malformed JSON body and/or field error", Collections.singletonList( exception.getLocalizedMessage() ) );
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message, List<String> errors){
        ApiError apiError = ApiError.builder()
                .code( httpStatus.value() )
                .status( httpStatus.getReasonPhrase() )
                .message( message )
                .errors( errors )
                .build();
        return ResponseEntity.status( httpStatus ).body( apiError );
    }
}