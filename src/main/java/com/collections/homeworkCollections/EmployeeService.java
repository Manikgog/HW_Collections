package com.collections.homeworkCollections;

import java.util.ArrayList;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    ArrayList<Employee> showEmployees();
}
