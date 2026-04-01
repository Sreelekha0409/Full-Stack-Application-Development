package com.jtmdh.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.jtmdh.studentmanagement.entity.Student;
import com.jtmdh.studentmanagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // ADD STUDENT
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        service.saveStudent(student);
        return student;
    }

    // GET ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // FILTER BY DEPARTMENT
    @GetMapping("/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept) {
        return service.getStudentsByDepartment(dept);
    }

    // FILTER BY AGE
    @GetMapping("/age/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return service.getStudentsByAge(age);
    }

    // PAGINATION
    @GetMapping("/page/{pageNo}")
    public Page<Student> getPaginated(@PathVariable int pageNo) {
        return service.getStudentsWithPagination(pageNo, 5);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Deleted Successfully";
    }
}