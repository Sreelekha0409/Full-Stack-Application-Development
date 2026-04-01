package com.example.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}