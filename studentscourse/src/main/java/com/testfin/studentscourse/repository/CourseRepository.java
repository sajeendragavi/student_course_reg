package com.testfin.studentscourse.repository;

import com.testfin.studentscourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
