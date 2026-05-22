package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeClassPagination;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServicePredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    //private EmployeeService employeeService;
    //private EmployeeServicePredicate employeeServicePredicate;
    private EmployeeClassPagination employeeClassPagination;

    /*@GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployee();
    }*/

    //Calling Employee service with Predicates
    /*@GetMapping("/employees")
    public List<Employee> searchEmployees(
            @RequestParam(required = false)
            String department,
            @RequestParam(required=false)
            Double salary
    ){
        return employeeServicePredicate.searchEmployees(department,salary);
    }*/

    @GetMapping("/employees")
    public List<Employee> searchEmployees(
            //Dynamic Filters
            @RequestParam(required = false)
            String department,
            @RequestParam(required = false)
            Double salary,

            //Pagination
            @RequestParam(defaultValue = "0")
            int page,
            @RequestParam(defaultValue = "5")
            int size,

            //Sorting
            @RequestParam(defaultValue = "id")
            String sortBy,
            @RequestParam(defaultValue = "asc")
            String direction
    ){
        return employeeClassPagination.searchEmployees(department,salary,page,size,sortBy,direction);

    }

}
