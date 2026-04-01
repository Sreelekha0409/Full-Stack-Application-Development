package com.example.student.service;

import com.example.student.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "John"));
        students.add(new Student(2, "Alice"));
    }

    public List<Student> getStudents() {
        return students;
    }
}