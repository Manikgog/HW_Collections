package com.collections.homeworkCollections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongNameException extends RuntimeException {
    public WrongNameException(){
        super();
    }

    public WrongNameException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}