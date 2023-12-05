package com.collections.homeworkCollections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public String findEmployeeWithMinSalaryByDepartment(@RequestParam(value = "departmentId", required = false) Integer departmentId){

        try {
            return departmentService.minSalaryFind(departmentId).toString();
        }catch (ListOfEmployeesIsEmptyException e){
            return e.toString();
        }
    }

    @GetMapping(path = "/max-salary")
    public String findEmployeeWithMaxSalaryByDepartment(@RequestParam(value = "departmentId", required = false) Integer departmentId){
        try {
            return departmentService.maxSalaryFind(departmentId).toString();
        }catch (ListOfEmployeesIsEmptyException e){
            return e.toString();
        }
    }

    @GetMapping(path = "/all", params = "departmentId")
    public String printAllEmployeesByDepartmentId(@RequestParam(defaultValue = "departmentId", required = false) Integer departmentId){
        try {
            return departmentService.allEmployeesByDepartmentId(departmentId).toString();
        }catch (ListOfEmployeesIsEmptyException e){
            return e.toString();
        }
    }

    @GetMapping(path = "/all")
    public String printAllEmployeesByDepartmentId(){
        try {
            return departmentService.allEmployees().toString();
        }catch (ListOfEmployeesIsEmptyException e){
            return e.toString();
        }
    }

}
