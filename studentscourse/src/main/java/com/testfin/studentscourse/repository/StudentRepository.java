package com.testfin.studentscourse.repository;

import com.testfin.studentscourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
