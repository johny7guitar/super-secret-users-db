package org.johny7guitar.supersecretusersdb.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdviceHelper extends ResponseEntityExceptionHandler{

    private static final String MESSAGE_PROPERTY = "message";

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request){

        return handleExceptionInternal(
                ex,
                Collections.singletonMap(MESSAGE_PROPERTY, "Item not found"),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        return handleExceptionInternal(
                ex,
                ex.getBindingResult().getAllErrors().stream()
                        .collect(Collectors.toMap(
                                er -> (((FieldError)er).getField()),
                                er -> Optional.ofNullable(er.getDefaultMessage()).orElse(""))
                        ),
                headers,
                HttpStatus.BAD_REQUEST,
                request
        );
    }
}
