package com.collections.homeworkCollections;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeService employeeService;
    public DepartmentServiceImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    public Employee minSalaryFind(Integer departmentId){
        HashMap<String, Employee> listOfEmployees = employeeService.getListOfEmployees();
        if(listOfEmployees.size() == 0){
            throw new ListOfEmployeesIsEmptyException("Список работников пуст.");
        }
        float min = Float.MAX_VALUE;
        Optional<Employee> employee = listOfEmployees.entrySet()
                .stream()
                .map((entry) -> {return entry.getValue();})
                .filter((emp) -> {return emp.getDepartment() == departmentId;})
                .min(Comparator.naturalOrder());
        return employee.get();
    }

    public Employee maxSalaryFind(Integer departmentId){
        HashMap<String, Employee> listOfEmployees = employeeService.getListOfEmployees();
        if(listOfEmployees.size() == 0){
            throw new ListOfEmployeesIsEmptyException("Список работников пуст.");
        }
        float min = Float.MAX_VALUE;
        Optional<Employee> employee = listOfEmployees.entrySet()
                .stream()
                .map((entry) -> {return entry.getValue();})
                .filter((emp) -> {return emp.getDepartment() == departmentId;})
                .max(Comparator.naturalOrder());
        return employee.get();
    }

    public ArrayList<Employee> allEmployeesByDepartmentId(Integer departmentId){
        HashMap<String, Employee> listOfEmployees = employeeService.getListOfEmployees();
        if(listOfEmployees.size() == 0){
            throw new ListOfEmployeesIsEmptyException("Список работников пуст.");
        }
        List<Employee> employees = listOfEmployees
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .filter(emp -> emp.getDepartment() == departmentId)
                .collect(Collectors.toList());
        return (ArrayList<Employee>) employees;
    }

    public ArrayList<Employee> allEmployees(){
        HashMap<String, Employee> listOfEmployees = employeeService.getListOfEmployees();
        if(listOfEmployees.size() == 0){
            throw new ListOfEmployeesIsEmptyException("Список работников пуст.");
        }
        List<Employee> employees = listOfEmployees
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .sorted(Comparator.comparingInt(o -> {Employee emp = (Employee)o; return emp.getDepartment();}))
                .collect(Collectors.toList());
        return (ArrayList<Employee>) employees;
    }
}
