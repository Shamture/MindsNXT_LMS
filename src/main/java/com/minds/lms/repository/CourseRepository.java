package com.minds.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minds.lms.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	Object findById(int anyInt);

	List<Course> findByName(String name);

	List<Course> findByCode(String code);
	
	List<Course> findByNameAndCodeAndMajorAndDeliveryMethodAndStatus(String name, String code , String major, String deliveryMethod , String status);

	

}
