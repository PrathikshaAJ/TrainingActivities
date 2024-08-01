package com.project.learningPortal.service;

import com.project.learningPortal.models.Course;
import com.project.learningPortal.models.Student;
import com.project.learningPortal.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public boolean deleteStudentById(Long id) {
        if(studentRepo.findById(id).isPresent())
        {
            studentRepo.deleteById(id);
            return true;
        }
        else {

            return false;
        }
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        if(studentRepo.findById(id).isPresent())
        {
            Student oldstudent=studentRepo.findById(id).get();
            oldstudent.setName(student.getName());
            oldstudent.setCourses(student.getCourses());
            return studentRepo.save(oldstudent);
        }else {
            return null;
        }
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student login(String email, String password) {
        Student found=studentRepo.findByEmail(email);
        if(found!=null)
        {
            if(found.getPassword().equals(password))
            {
                return found;
            }
        }
        return null;
    }

    @Override
    public boolean makeAdmin(Long id) {
        Student found=studentRepo.findById(id).orElse(null);
        if(found!=null)
        {
            found.setRole(true);
            studentRepo.save(found);
            return true;
        }
        return false;
    }

    @Override
    public boolean registerCourse(Long sid, Long cid) {

        Student st = studentRepo.findById(sid).orElse(null);
        if(st != null){
            Course course = new Course();
            course.setId(cid);
            Set<Course> courseSet = st.getCourses();
            courseSet.add(course);
            st.setCourses(courseSet);
            studentRepo.save(st);
            return true;
        }
        return false;
    }
}
