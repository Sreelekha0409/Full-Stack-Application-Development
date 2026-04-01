package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee updateEmployee(Long id, Employee emp) {
        Employee existing = getEmployeeById(id);

        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setSalary(emp.getSalary());
        existing.setDepartment(emp.getDepartment());

        return repository.save(existing);
    }

    public void deleteEmployee(Long id) {
        Employee emp = getEmployeeById(id);
        repository.delete(emp);
    }
}