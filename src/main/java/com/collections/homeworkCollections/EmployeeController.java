package com.collections.homeworkCollections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(){
        employeeService = new EmployeeServiceImpl();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam(value = "firstName", required = false) String name,
                             @RequestParam(value = "lastName", required = false) String lastName) {
        String resultOfCheck = checkNameAndLastName(name, lastName);
        if(resultOfCheck == null){
            try {
                Employee employee = this.employeeService.addEmployee(name, lastName);
                return employee.toString();
            }catch (EmployeeAlreadyAddedException e){
                return e.toString();
            }

        }
        return resultOfCheck;
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam(value = "firstName", required = false) String name,
                             @RequestParam(value = "lastName", required = false) String lastName) {
        String resultOfCheck = checkNameAndLastName(name, lastName);
        if(resultOfCheck == null){
            try {
                Employee employee = this.employeeService.removeEmployee(name, lastName);
                return employee.toString();
            }catch (EmployeeNotFoundException e){
                return e.toString();
            }
        }
        return resultOfCheck;
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam(value = "firstName", required = false) String name,
                                 @RequestParam(value = "lastName", required = false) String lastName) {
        String resultOfCheck = checkNameAndLastName(name, lastName);
        if(resultOfCheck == null){
            try {
                Employee employee = this.employeeService.findEmployee(name, lastName);
                return employee.toString();
            }catch (EmployeeNotFoundException e){
                return e.toString();
            }
        }
        return resultOfCheck;
    }

    @GetMapping
    public ArrayList<Employee> showEmployees(){
        return employeeService.showEmployees();
    }

    public String checkNameAndLastName(String name, String lastName){
        if(name == null && lastName == null){
            return "Ошибка: необходимо ввести имя и отчество.";
        }else if(name == null){
            return "Ошибка: необходимо ввести имя.";
        }else if(lastName == null){
            return "Ошибка: необходимо ввести фамилию.";
        }
        return null;
    }
}
