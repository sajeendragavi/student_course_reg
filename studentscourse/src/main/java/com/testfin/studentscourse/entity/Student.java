package com.testfin.studentscourse.entity;

import jakarta.persistence.ManyToMany;

import java.util.List;

public class Student {
    private String studentId;
    private String name;

    @ManyToMany
    private List<Course> courses;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
