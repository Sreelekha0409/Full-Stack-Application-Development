package com.jtmdh.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.jtmdh.studentmanagement.entity.Student;
import com.jtmdh.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // CREATE / UPDATE
    public void saveStudent(Student student) {
        repo.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // FILTER BY DEPARTMENT
    public List<Student> getStudentsByDepartment(String dept) {
        return repo.findByDepartment(dept);
    }

    // FILTER BY AGE
    public List<Student> getStudentsByAge(int age) {
        return repo.findByAgeGreaterThan(age);
    }

    // PAGINATION + SORTING
    public Page<Student> getStudentsWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("name"));
        return repo.findAll(pageable);
    }

    // DELETE
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    // GET BY ID
    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }
}