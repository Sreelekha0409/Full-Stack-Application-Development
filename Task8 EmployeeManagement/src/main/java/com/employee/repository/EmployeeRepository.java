package com.employee.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.model.Employee;

@Component
public class EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}