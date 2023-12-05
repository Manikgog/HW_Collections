package com.collections.homeworkCollections;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> listOfEmployees;
    private final int maxNumberOfEmployees = 10;

    public EmployeeServiceImpl(){
        listOfEmployees = new HashMap<>();
    }

    private String getKey(String firstName, String lastName){
        return firstName + lastName;
    }

    public HashMap<String, Employee> getListOfEmployees(){
        return new HashMap<>(listOfEmployees);
    }

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

    public Employee removeEmployee(String firstName, String lastName){
        String key = this.getKey(firstName, lastName);
        if(listOfEmployees.get(key) != null){
            return listOfEmployees.remove(key);
        }
        throw new EmployeeNotFoundException("EmployeeNotFound");
    }

    public Employee findEmployee(String firstName, String lastName){
        String key = this.getKey(firstName, lastName);
        if(listOfEmployees.get(key) != null){
            return listOfEmployees.get(key);
        }
        throw new EmployeeNotFoundException("EmployeeNotFound");
    }

    public ArrayList<Employee> showEmployees(){
        ArrayList<Employee> result = new ArrayList<>();
        result.addAll(listOfEmployees.values());
        return result;
    }



}
