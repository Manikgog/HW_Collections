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

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam(value = "firstName", required = false) String name,
                             @RequestParam(value = "lastName", required = false) String lastName,
                              @RequestParam(value = "departmentId", required = false) String department,
                              @RequestParam(value = "salary", required = false) String salary) {
        String resultOfCheck = check(name, lastName, department, salary);
        float salaryInFloat = 0f;
        int departmentInInt = 0;
        if(resultOfCheck == null){
            try {
                try {
                    salaryInFloat = Float.parseFloat(salary);
                }catch (NumberFormatException e){
                    return e.toString();
                }
                try{
                    departmentInInt = Integer.parseInt(department);
                }catch (NumberFormatException e){
                    return e.toString();
                }
                Employee employee = this.employeeService.addEmployee(name, lastName, departmentInInt, salaryInFloat);
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
        String resultOfCheck = checkName(name, lastName);
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
        String resultOfCheck = checkName(name, lastName);
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


    private String check(String name, String lastName, String department, String salary){
        if(name == null || lastName == null || department == null || salary == null) {
            String result = "Ошибка: ";
            if (name == null) {
                result += "\nнеобходимо ввести имя";
            }
            if (lastName == null) {
                result += "\nнеобходимо ввести фамилию.";
            }
            if (department == null) {
                result += "\nнеобходимо ввести название отдела.";
            }
            if (salary == null) {
                result += "\nнеобходимо ввести значение зарплаты.";
            }
            return result;
        }
        return null;
    }

    private String checkName(String name, String lastName){
        if(name == null || lastName == null) {
            String result = "Ошибка: ";
            if (name == null) {
                result += "\nнеобходимо ввести имя";
            }
            if (lastName == null) {
                result += "\nнеобходимо ввести фамилию.";
            }
            return result;
        }
        return null;
    }

}
