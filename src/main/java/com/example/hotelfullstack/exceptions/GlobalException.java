package com.example.hotelfullstack.exceptions;

import com.example.hotelfullstack.models.ErrorObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    public Date getTimestamp() {
        return new Date();
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleResourceNotFoundException (ResourceNotFoundException ex) {
        ErrorObject eObject = new ErrorObject(
                HttpStatus.NO_CONTENT.value(),
                ex.getMessage(),
                getTimestamp()
        );
        return new ResponseEntity<>(eObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleNoDataFoundException (NoDataFoundException ex) {
        ErrorObject eObject = new ErrorObject(
                HttpStatus.NO_CONTENT.value(),
                ex.getMessage(),
                getTimestamp()
        );
        return new ResponseEntity<>(eObject, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handIllegalArgument (IllegalArgumentException ex) {
        ErrorObject eObject = new ErrorObject(
                HttpStatus.NO_CONTENT.value(),
                ex.getMessage(),
                getTimestamp()
        );
        return new ResponseEntity<>(eObject, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        ErrorObject errorDto = new ErrorObject(HttpStatus.BAD_REQUEST.value(),
                "Validation failed" +  errorMessages, getTimestamp());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorObject> handleMethodNotAllowedException(HttpRequestMethodNotSupportedException ex) {
        ErrorObject eObject = new ErrorObject(
                HttpStatus.NO_CONTENT.value(),
                "Method Not Allowed. Supported methods are " + ex.getSupportedHttpMethods(),
                getTimestamp()
        );
        return new ResponseEntity<>(eObject, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorObject> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorObject eObject = new ErrorObject(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request: Required request body is missing",
                getTimestamp()
        );
        return new ResponseEntity<>(eObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorObject errorObject = new ErrorObject(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid argument: " + ex.getName(),
                getTimestamp()
        );
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
