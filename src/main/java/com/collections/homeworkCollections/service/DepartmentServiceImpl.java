package com.collections.homeworkCollections.service;

import com.collections.homeworkCollections.domain.Employee;
import com.collections.homeworkCollections.exception.EmployeeNotFoundException;
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
        return employee.orElseThrow(() -> new EmployeeNotFoundException("Department Not Found"));
    }

    @Override
    public Employee maxSalaryFind(Integer departmentId){
        Optional<Employee> employee = employeeService.getListOfEmployees().values()
                .stream()
                .filter(v -> v.getDepartment() == departmentId)
                .max(Comparator.naturalOrder());
        return employee.orElseThrow(() -> new EmployeeNotFoundException("Department Not Found"));
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
    public Map<Integer, List<Employee>> allEmployees(){
        List<Employee> employeesList = employeeService.getListOfEmployees()
                .values()
                .stream()
                .collect(Collectors.toList());
        return employeesList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
