package com.example.backend.models;

import com.example.backend.dtos.EmployeeCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class Employee {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String company;
    private boolean admin;

    public Employee(EmployeeCreateDto employeeCreateDto, UUID id) {
        this.name = employeeCreateDto.getName();
        this.surname = employeeCreateDto.getSurname();
        this.email = employeeCreateDto.getEmail();
        this.company = employeeCreateDto.getCompany();
        this.admin = employeeCreateDto.isAdmin();
        this.id = id;
    }
}
