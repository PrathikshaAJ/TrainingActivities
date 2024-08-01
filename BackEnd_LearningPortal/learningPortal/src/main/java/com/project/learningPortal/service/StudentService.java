package com.project.learningPortal.service;

import com.project.learningPortal.models.Course;
import com.project.learningPortal.models.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);
    public List<Student> getAllStudent();
    public boolean deleteStudentById(Long id);
    public Student updateStudent(Student student, Long id);
    public Student getStudentByID(Long id);
    public Student login(String email,String password);
    public boolean makeAdmin(Long id);
    public boolean registerCourse(Long sid,Long cid);
}
