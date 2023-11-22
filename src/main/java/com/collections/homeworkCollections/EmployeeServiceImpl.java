package com.collections.homeworkCollections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private ArrayList<Employee> listOfEmployees;
    private final int maxNumberOfEmployees = 10;

    public EmployeeServiceImpl(){
        listOfEmployees = new ArrayList<>();
    }

    public Employee addEmployee(String firstName, String lastName){
        if(listOfEmployees.size() < maxNumberOfEmployees) {
            Employee employee = new Employee(firstName, lastName);
            Employee employee1 = getEmployee(employee);
            boolean b = employee.equals(employee1);
            if(b){
                throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
            }
            listOfEmployees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException("ArrayIsFull");
    }

    public Employee removeEmployee(String firstName, String lastName){
        Employee employee = findEmployee(firstName, lastName);
        listOfEmployees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        Employee employee1 = getEmployee(employee);
        if(employee1 != null){
            return employee1;
        }
        throw new EmployeeNotFoundException("EmployeeNotFound");
    }

    public ArrayList<Employee> showEmployees(){
        return new ArrayList<>(listOfEmployees);
    }


    private Employee getEmployee(Employee employee){
        for (Employee emp :
                listOfEmployees) {
            if(emp.equals(employee)){
                return emp;
            }
        }
        return null;
    }

}
