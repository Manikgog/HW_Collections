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
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String name,
                             @RequestParam(value = "lastName", required = false) String lastName,
                              @RequestParam(value = "departmentId", required = false) Integer department,
                              @RequestParam(value = "salary", required = false) Float salary) {
        checkService.check(name, lastName, department, salary);
        return this.employeeService.addEmployee(name, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName", required = false) String name,
                             @RequestParam(value = "lastName", required = false) String lastName) {
        checkService.checkName(name, lastName);
        return this.employeeService.removeEmployee(name, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(value = "firstName", required = false) String name,
                                 @RequestParam(value = "lastName", required = false) String lastName) {
        checkService.checkName(name, lastName);
        return this.employeeService.findEmployee(name, lastName);
    }

    @GetMapping
    public List<Employee> showEmployees(){
        return employeeService.showEmployees();
    }

}
