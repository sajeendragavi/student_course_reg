package com.testfin.studentscourse.controller;

import com.testfin.studentscourse.entity.Course;
import com.testfin.studentscourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id,@RequestBody Course c){
        Course existing = courseRepository.findById(id).orElseThrow();
        existing.setDivisions(c.getDivisions());
        return courseRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        courseRepository.deleteById(id);
    }

    
}
