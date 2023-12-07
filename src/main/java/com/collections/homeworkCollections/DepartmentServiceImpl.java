package com.collections.homeworkCollections;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentServiceImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @Override
    public Employee minSalaryFind(Integer departmentId){
        Optional<Employee> employee = employeeService.getListOfEmployees().values()
                .stream()
                .filter(v -> v.getDepartment() == departmentId)
                .min(Comparator.naturalOrder());

        return employee.orElseThrow();
    }

    @Override
    public Employee maxSalaryFind(Integer departmentId){
        Optional<Employee> employee = employeeService.getListOfEmployees().values()
                .stream()
                .filter(v -> v.getDepartment() == departmentId)
                .max(Comparator.naturalOrder());
        return employee.orElseThrow();
    }

    @Override
    public List<Employee> allEmployeesByDepartmentId(Integer departmentId){
        return employeeService.getListOfEmployees()
                .values()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> allEmployees(){
        return employeeService.getListOfEmployees()
                .values()//.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepartment()))
                .collect(Collectors.toList());
    }
}
