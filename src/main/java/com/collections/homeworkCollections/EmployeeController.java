package com.collections.homeworkCollections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CheckService checkService;

    public EmployeeController(EmployeeService employeeService, CheckService checkService){
        this.employeeService = employeeService;
        this.checkService = checkService;

    }

    @GetMapping(path = "/add")
    public Object addEmployee(@RequestParam(value = "firstName", required = false) String name,
                             @RequestParam(value = "lastName", required = false) String lastName,
                              @RequestParam(value = "departmentId", required = false) Integer department,
                              @RequestParam(value = "salary", required = false) Float salary) {
        String resultOfCheck = checkService.check(name, lastName, department, salary);
        if(resultOfCheck == null){
            return this.employeeService.addEmployee(name, lastName, department, salary);
        }
        return resultOfCheck;
    }

    @GetMapping(path = "/remove")
    public Object removeEmployee(@RequestParam(value = "firstName", required = false) String name,
                             @RequestParam(value = "lastName", required = false) String lastName) {
        String resultOfCheck = checkService.checkName(name, lastName);
        if(resultOfCheck == null){
            try {
                return this.employeeService.removeEmployee(name, lastName);
            }catch (EmployeeNotFoundException e){
                System.out.println(e.getMessage());
                return resultOfCheck;
            }
        }
        return resultOfCheck;
    }

    @GetMapping(path = "/find")
    public Object findEmployee(@RequestParam(value = "firstName", required = false) String name,
                                 @RequestParam(value = "lastName", required = false) String lastName) {
        String resultOfCheck = checkService.checkName(name, lastName);
        if(resultOfCheck == null){
            try {
                return this.employeeService.findEmployee(name, lastName);
            }catch (EmployeeNotFoundException e){
                System.out.println(e.getMessage());
                return resultOfCheck;
            }
        }
        return resultOfCheck;
    }

    @GetMapping
    public List<Employee> showEmployees(){
        return employeeService.showEmployees();
    }

}
