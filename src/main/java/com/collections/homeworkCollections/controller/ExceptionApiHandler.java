package com.collections.homeworkCollections.controller;

import com.collections.homeworkCollections.domain.ErrorMessage;
import com.collections.homeworkCollections.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(AddEmployeeException.class)
    public ResponseEntity<ErrorMessage> addEmployeeException(AddEmployeeException exception){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<ErrorMessage> notFoundException(EmployeeAlreadyAddedException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> notFoundException(EmployeeNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public ResponseEntity<ErrorMessage> mismatchException(EmployeeStorageIsFullException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(WrongNameException.class)
    public ResponseEntity<ErrorMessage> mismatchException(WrongNameException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

}
