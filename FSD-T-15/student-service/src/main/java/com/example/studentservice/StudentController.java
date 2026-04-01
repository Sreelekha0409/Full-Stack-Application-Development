package com.example.studentservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/students")
    public String getStudents() {
        return "Student Service Running Successfully";
    }
}