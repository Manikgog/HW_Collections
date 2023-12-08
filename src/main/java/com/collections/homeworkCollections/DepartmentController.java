package com.collections.homeworkCollections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartment(@RequestParam(value = "departmentId") Integer departmentId){
        return departmentService.minSalaryFind(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartment(@RequestParam(value = "departmentId") Integer departmentId){
        return departmentService.maxSalaryFind(departmentId);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> printAllEmployeesByDepartmentId(@RequestParam(defaultValue = "departmentId") Integer departmentId){
        return departmentService.allEmployeesByDepartmentId(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> printAllEmployeesByDepartmentId(){
        return departmentService.allEmployees();
    }

}
