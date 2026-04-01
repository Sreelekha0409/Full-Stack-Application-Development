package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee.entity.Employee;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}