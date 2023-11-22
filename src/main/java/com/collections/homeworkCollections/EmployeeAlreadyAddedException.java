package com.collections.homeworkCollections;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(){
        super();
    }

    public EmployeeAlreadyAddedException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
