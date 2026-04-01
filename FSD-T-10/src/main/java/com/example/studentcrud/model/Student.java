package com.example.studentcrud.model;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="department")
    private String department;

    public Student(){}

    public Student(String name, String department){
        this.name = name;
        this.department = department;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getDepartment(){ return department; }

    public void setName(String name){ this.name = name; }
    public void setDepartment(String department){ this.department = department; }
}