package com.example.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Employee {
    private int uuid;
    private String name;
    private String surname;
    private String email;
    private String company;
}
