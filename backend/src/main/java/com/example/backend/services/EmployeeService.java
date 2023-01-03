package com.example.backend.services;

import com.example.backend.dtos.EmployeeCreateDto;
import com.example.backend.models.Employee;
import com.example.backend.mybatis.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepository.getEmployeeById(id);
    }

    public boolean checkIfEmployeeWithSuchEmailExists(String email) {
        return employeeRepository.getEmployeeByEmail(email) != null;
    }

    public boolean checkIfEmployeeWithSuchIdExists(UUID id) {
        return employeeRepository.getEmployeeById(id) != null;
    }

    public String createEmployee(EmployeeCreateDto employeeCreateDto) {
        if (checkIfEmployeeWithSuchEmailExists(employeeCreateDto.getEmail())) {
            return "Employee with such email already exists";
        }

        employeeRepository.createEmployee(new Employee(employeeCreateDto, UUID.randomUUID()));
        return "Employee created successfully";
    }

    public String deleteEmployeeById(UUID id) {
        if (!checkIfEmployeeWithSuchIdExists(id)) {
            return "Employee with such id does not exist";
        }

        employeeRepository.deleteEmployeeById(id);
        return "Employee deleted successfully";
    }
}
