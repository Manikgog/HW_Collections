package com.collections.homeworkCollections;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, float salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> showEmployees();
    Map<String, Employee> getListOfEmployees();

}
