package com.collections.homeworkCollections;

import java.util.ArrayList;
import java.util.HashMap;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, float salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    ArrayList<Employee> showEmployees();
    HashMap<String, Employee> getListOfEmployees();

}
