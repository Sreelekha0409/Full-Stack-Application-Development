package com.employee.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.service.EmployeeService;

public class MainApp {

    public static void main(String[] args) {

        // Load Spring container
        BeanFactory factory =
                new ClassPathXmlApplicationContext("beans.xml");

        // Get EmployeeService bean from Spring container
        EmployeeService service =
                factory.getBean(EmployeeService.class);

        // Create employees
        service.createEmployee(101, "Arun", "IT");
        service.createEmployee(102, "Priya", "HR");

        // Display employees
        service.displayEmployees();
    }
}