package com.project.learningPortal.controller;

import com.project.learningPortal.models.Student;
import com.project.learningPortal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student)
    {
        Student newStudent=studentService.addStudent(student);
        return new ResponseEntity<>("student added",HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id)
    {
        if(studentService.deleteStudentById(id))
            return new ResponseEntity<>("user deleted",HttpStatus.OK);
        return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable long id,@RequestBody Student student)
    {
        Student updated=studentService.updateStudent(student,id);
        if(updated==null)
        {
            return new ResponseEntity<>("no user found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable long id)
    {
        return studentService.getStudentByID(id);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Student student)
    {
        Student found=studentService.login(student.getEmail(),student.getPassword());
        if(found!=null)
        {
            return new ResponseEntity<>("logged in",HttpStatus.OK);
        }
        return new ResponseEntity<>("invalid credentials",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/makeadmin/{id}")
    public boolean makeAdmin(@PathVariable Long id) {
        return studentService.makeAdmin(id);
    }

    @PostMapping("{sid}/addCourse/{cid}")
    public Boolean registerCourse(@PathVariable Long sid,@PathVariable Long cid){
        return studentService.registerCourse(sid,cid);
    }
}

