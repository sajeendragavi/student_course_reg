package com.testfin.studentscourse.controller;

import com.testfin.studentscourse.entity.Course;
import com.testfin.studentscourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    
}
