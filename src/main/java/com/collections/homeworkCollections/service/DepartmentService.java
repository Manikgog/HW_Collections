package com.collections.homeworkCollections.service;

import com.collections.homeworkCollections.domain.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee minSalaryFind(Integer departmentId);
    Employee maxSalaryFind(Integer departmentId);
    List<Employee> allEmployeesByDepartmentId(Integer departmentId);
    Map<Integer, List<Employee>> allEmployees();
}
