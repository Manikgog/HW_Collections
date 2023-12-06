package com.collections.homeworkCollections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Object findEmployeeWithMinSalaryByDepartment(@RequestParam(value = "departmentId") Integer departmentId){
        try {
            return departmentService.minSalaryFind(departmentId);
        }catch (RuntimeException e){
            return e.getMessage();
        }
    }

    @GetMapping(path = "/max-salary")
    public Object findEmployeeWithMaxSalaryByDepartment(@RequestParam(value = "departmentId") Integer departmentId){
        try {
            return departmentService.maxSalaryFind(departmentId);
        }catch (RuntimeException e){
            return e.getMessage();
        }
    }

    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> printAllEmployeesByDepartmentId(@RequestParam(defaultValue = "departmentId") Integer departmentId){
        return departmentService.allEmployeesByDepartmentId(departmentId);
    }

    @GetMapping(path = "/all")
    public List<Employee> printAllEmployeesByDepartmentId(){
        return departmentService.allEmployees();
    }

}
