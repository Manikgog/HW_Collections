package com.collections.homeworkCollections;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(){
        super();
    }

    public EmployeeNotFoundException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
