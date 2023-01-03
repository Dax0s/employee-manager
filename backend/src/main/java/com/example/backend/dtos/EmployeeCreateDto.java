package com.example.backend.dtos;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeCreateDto {
    private String name;
    private String surname;
    private String email;
    private String company;
}
