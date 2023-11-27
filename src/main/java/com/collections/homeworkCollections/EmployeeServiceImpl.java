package com.collections.homeworkCollections;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<List<String>, Employee> listOfEmployees;
    private final int maxNumberOfEmployees = 10;

    public EmployeeServiceImpl(){
        listOfEmployees = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName){
        List<String> key = new ArrayList<>(List.of(firstName, lastName));
        if(listOfEmployees.size() < maxNumberOfEmployees) {
            if(listOfEmployees.containsKey(key)){
                throw new EmployeeAlreadyAddedException("Employee is already exist");
            }
            Employee employee = new Employee(firstName, lastName);
            listOfEmployees.put(key, employee);
            return listOfEmployees.get(key);
        }
        throw new EmployeeStorageIsFullException("ArrayIsFull");
    }

    public Employee removeEmployee(String firstName, String lastName){
        Employee employee = findEmployee(firstName, lastName);
        listOfEmployees.remove(new ArrayList<>(List.of(employee.getFirstName(), employee.getLastName())));
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName){
        List<String> key = new ArrayList<>(List.of(firstName, lastName));
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
