package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public void createEmployee(int id, String name, String dept) {
        Employee emp = new Employee(id, name, dept);
        repository.addEmployee(emp);
    }

    public void displayEmployees() {
        for (Employee emp : repository.getAllEmployees()) {
            System.out.println(emp.getId() + " "
                    + emp.getName() + " "
                    + emp.getDepartment());
        }
    }
}