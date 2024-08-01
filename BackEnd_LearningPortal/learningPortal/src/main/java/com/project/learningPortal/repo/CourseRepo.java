package com.project.learningPortal.repo;

import com.project.learningPortal.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {

}
