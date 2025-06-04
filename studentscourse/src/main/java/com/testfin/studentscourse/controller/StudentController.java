package com.testfin.studentscourse.controller;

import com.testfin.studentscourse.entity.Course;
import com.testfin.studentscourse.entity.Student;
import com.testfin.studentscourse.repository.CourseRepository;
import com.testfin.studentscourse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Student register(@RequestBody Student student){
        List<Course> selected = courseRepository.findAllById(
                student.getCourses().stream().map(Course :: getCourseId).toList()
        );
        student.setCourses(selected);
        return studentRepository.save(student);
    }
}
