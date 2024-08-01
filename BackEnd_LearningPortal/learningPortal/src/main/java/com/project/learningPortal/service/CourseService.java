package com.project.learningPortal.service;

import com.project.learningPortal.models.Course;
import com.project.learningPortal.models.Student;

import java.util.List;

public interface CourseService {
    public Course createCourse(Course course);
    public List<Course> getAllCourses();
    public boolean deleteCourseById(Long id);
    public Course updateCourse(Course course, Long id);
    public Course getCourseByID(Long id);
}
