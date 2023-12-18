package com.collections.homeworkCollections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AddEmployeeException extends RuntimeException {
    public AddEmployeeException(){
        super();
    }

    public AddEmployeeException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}