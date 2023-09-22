package com.WDA.bookstore.exceptions;

import com.WDA.bookstore.exceptions.book.AmountIsZero;
import com.WDA.bookstore.exceptions.book.BookCantBeDeletedException;
import com.WDA.bookstore.exceptions.book.LaunchYearItsNotValidException;
import com.WDA.bookstore.exceptions.publisher.PublisherAlreadyRelatedException;
import com.WDA.bookstore.exceptions.publisher.PublisherCantBeDeletedException;
import com.WDA.bookstore.exceptions.publisher.PublisherNameAlreadyExistsException;
import com.WDA.bookstore.exceptions.rent.RentCantBeDeletedException;
import com.WDA.bookstore.exceptions.user.UserCantBeDeletedException;
import com.WDA.bookstore.exceptions.user.UserEmailAlreadyExistsException;
import com.WDA.bookstore.exceptions.user.UserNameAlreadyExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(AmountIsZero.class)
    public ResponseEntity<Object> handleAmountIsZeroException(AmountIsZero exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BookCantBeDeletedException.class)
    public ResponseEntity<Object> handleBookCantBeDeletedException(BookCantBeDeletedException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(LaunchYearItsNotValidException.class)
    public ResponseEntity<Object> handleLaunchYearItsNotValidException(LaunchYearItsNotValidException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PublisherAlreadyRelatedException.class)
    public ResponseEntity<Object> handlePublisherAlreadyRelatedException(PublisherAlreadyRelatedException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PublisherCantBeDeletedException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(PublisherCantBeDeletedException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PublisherNameAlreadyExistsException.class)
    public ResponseEntity<Object> handlePublisherNameAlreadyExistsException(PublisherNameAlreadyExistsException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RentCantBeDeletedException.class)
    public ResponseEntity<Object> handleRentCantBeDeletedException(RentCantBeDeletedException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserCantBeDeletedException.class)
    public ResponseEntity<Object> handleUserCantBeDeletedException(UserCantBeDeletedException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserEmailAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserEmailAlreadyExistsException(UserEmailAlreadyExistsException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNameAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserNameAlreadyExistsException(UserNameAlreadyExistsException exception) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage())
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> errors.add(fieldError.getDefaultMessage()));

        return buildResponseEntity(HttpStatus.BAD_REQUEST, "Verifique se colocou todos os dados corretamente.", errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return buildResponseEntity(HttpStatus.BAD_REQUEST, "Verifique se colocou todos os dados corretamente.", Collections.singletonList(exception.getLocalizedMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message, List<String> errors) {
        ApiError apiError = ApiError.builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(message)
                .errors(errors)
                .build();
        return ResponseEntity.status(httpStatus).body(apiError);
    }


}
