package com.collections.homeworkCollections;

import java.util.List;

public interface DepartmentService {
    Employee minSalaryFind(Integer departmentId);
    Employee maxSalaryFind(Integer departmentId);
    List<Employee> allEmployeesByDepartmentId(Integer departmentId);
    List<Employee> allEmployees();
}
