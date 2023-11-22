package com.collections.homeworkCollections;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(){
        super();
    }

    public EmployeeStorageIsFullException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
