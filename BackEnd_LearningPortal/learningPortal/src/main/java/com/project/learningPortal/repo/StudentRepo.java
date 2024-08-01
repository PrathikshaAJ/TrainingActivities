package com.project.learningPortal.repo;

import com.project.learningPortal.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {

    public Student findByEmail(String email);

}
