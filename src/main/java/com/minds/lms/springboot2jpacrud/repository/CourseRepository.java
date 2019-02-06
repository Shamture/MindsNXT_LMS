package com.minds.lms.springboot2jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minds.lms.springboot2jpacrud.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
