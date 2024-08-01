package com.project.learningPortal.service;

import com.project.learningPortal.models.Course;
import com.project.learningPortal.models.Student;
import com.project.learningPortal.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepo repo;

    @Override
    public Course createCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    @Override
    public boolean deleteCourseById(Long id) {
        if(repo.findById(id).isPresent())
        {
            repo.deleteById(id);
            return true;
        }
        else {

            return false;
        }
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        if(repo.findById(id).isPresent())
        {
            Course oldcourse=repo.findById(id).get();
            oldcourse.setTitle(course.getTitle());
            oldcourse.setStudents(course.getStudents());
            return repo.save(oldcourse);
        }else {
            return null;
        }
    }

    @Override
    public Course getCourseByID(Long id) {
        return repo.findById(id).orElse(null);
    }


}
