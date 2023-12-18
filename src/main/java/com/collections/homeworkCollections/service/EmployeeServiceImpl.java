package com.collections.homeworkCollections.service;

import com.collections.homeworkCollections.*;
import com.collections.homeworkCollections.domain.Employee;
import com.collections.homeworkCollections.exception.EmployeeAlreadyAddedException;
import com.collections.homeworkCollections.exception.EmployeeNotFoundException;
import com.collections.homeworkCollections.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> listOfEmployees;
    private final int maxNumberOfEmployees = 20;

    public EmployeeServiceImpl(){
        listOfEmployees = new HashMap<>(HomeworkCollectionsApplication.listOfEmployees);
    }

    private String getKey(String firstName, String lastName){
        return firstName + lastName;
    }

    @Override
    public Map<String, Employee> getListOfEmployees(){
        return new HashMap<>(listOfEmployees);
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, float salary){
        String key = this.getKey(firstName, lastName);
        if(listOfEmployees.size() < maxNumberOfEmployees) {
            if(listOfEmployees.containsKey(key)){
                throw new EmployeeAlreadyAddedException("Employee is already exist");
            }

            Employee employee = new Employee(firstName, lastName, departmentId, salary);
            listOfEmployees.put(key, employee);
            return listOfEmployees.get(key);
        }
        throw new EmployeeStorageIsFullException("ArrayIsFull");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName){
        String key = this.getKey(firstName, lastName);
        if(listOfEmployees.get(key) != null){
            return listOfEmployees.remove(key);
        }
        throw new EmployeeNotFoundException("Employee Not Found");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName){
        String key = this.getKey(firstName, lastName);
        if(listOfEmployees.get(key) != null){
            return listOfEmployees.get(key);
        }
        throw new EmployeeNotFoundException("Employee Not Found");
    }

    @Override
    public List<Employee> showEmployees(){
        ArrayList<Employee> result = new ArrayList<>();
        result.addAll(listOfEmployees.values());
        return result;
    }

}
