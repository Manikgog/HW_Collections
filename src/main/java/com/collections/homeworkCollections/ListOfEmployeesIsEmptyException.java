package com.collections.homeworkCollections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ListOfEmployeesIsEmptyException extends RuntimeException{
    public ListOfEmployeesIsEmptyException(){
        super();
    }

    public ListOfEmployeesIsEmptyException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
