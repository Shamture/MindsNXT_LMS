package com.minds.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minds.lms.model.Course;
import com.minds.lms.model.InstructorCourse;

@Repository
public interface InstructorCourseRepository extends JpaRepository<InstructorCourse, Long> {

	Object findById(int anyInt);

	List<InstructorCourse> findByName(String name);

	List<InstructorCourse> findByCode(String code);
	
	List<InstructorCourse> findByNameAndCodeAndMajorAndDeliveryMethodAndStatus(String name, String code , String major, String deliveryMethod , String status);

	

}
