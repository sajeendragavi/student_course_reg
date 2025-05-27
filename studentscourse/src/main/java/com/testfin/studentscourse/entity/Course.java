package com.testfin.studentscourse.entity;

public class Course {
    private Long courseId;
    private String courseName;
    private String divisions;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDivisions() {
        return divisions;
    }

    public void setDivisions(String divisions) {
        this.divisions = divisions;
    }

}
