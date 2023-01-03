package com.example.backend.controllers;

import com.example.backend.dtos.EmployeeCreateDto;
import com.example.backend.models.Employee;
import com.example.backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") UUID id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public String createEmployee(@RequestBody EmployeeCreateDto employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") UUID id) {
        return employeeService.deleteEmployeeById(id);
    }
}
