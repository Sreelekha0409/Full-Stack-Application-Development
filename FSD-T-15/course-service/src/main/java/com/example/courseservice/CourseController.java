package com.example.courseservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public String getCourses() {
        return "Course Service Running Successfully";
    }
}