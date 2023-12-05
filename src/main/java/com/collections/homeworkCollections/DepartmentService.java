package com.collections.homeworkCollections;

import java.util.ArrayList;

public interface DepartmentService {
    Employee minSalaryFind(Integer departmentId);
    Employee maxSalaryFind(Integer departmentId);
    ArrayList<Employee> allEmployeesByDepartmentId(Integer departmentId);
    ArrayList<Employee> allEmployees();
}
