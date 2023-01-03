package com.example.backend.models;

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
}
