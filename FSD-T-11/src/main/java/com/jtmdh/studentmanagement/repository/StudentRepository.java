package com.jtmdh.studentmanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jtmdh.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDepartment(String department);

    List<Student> findByAgeGreaterThan(int age);
}