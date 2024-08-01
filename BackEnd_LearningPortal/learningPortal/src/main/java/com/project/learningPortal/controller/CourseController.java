package com.project.learningPortal.controller;

import com.project.learningPortal.models.Course;
import com.project.learningPortal.models.Student;
import com.project.learningPortal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }

    @PostMapping
    public ResponseEntity<Object> createCourse(@RequestBody Course course)
    {
        Course newCourse=courseService.createCourse(course);
        return new ResponseEntity<>("course added",HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable long id)
    {
        if(courseService.deleteCourseById(id))
            return new ResponseEntity<>("course deleted",HttpStatus.OK);
        return new ResponseEntity<>("course not found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable long id,@RequestBody Course course)
    {
        Course updated=courseService.updateCourse(course,id);
        if(updated==null)
        {
            return new ResponseEntity<>("no course found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Course getCourseById(@PathVariable long id)
    {
        return courseService.getCourseByID(id);
    }

}
