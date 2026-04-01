package com.example.employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Salary cannot be null")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double salary;

    @NotBlank(message = "Department is mandatory")
    private String department;

    // Getters & Setters
}