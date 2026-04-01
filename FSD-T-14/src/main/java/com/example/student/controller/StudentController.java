package com.example.student.controller;

import com.example.student.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "John"));
        list.add(new Student(2, "Alice"));
        return list;
    }
}