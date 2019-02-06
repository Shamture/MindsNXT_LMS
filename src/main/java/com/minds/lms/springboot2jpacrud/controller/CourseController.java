package com.minds.lms.springboot2jpacrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.springboot2jpacrud.exception.ResourceNotFoundException;
import com.minds.lms.springboot2jpacrud.model.Course;
import com.minds.lms.springboot2jpacrud.repository.CourseRepository;

@RestController

public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	  @GetMapping("/courses")
	    public List<Course> getAllCourses() {
	        return courseRepository.findAll();
	    }
	  
	  @GetMapping("/course/{id}")
	    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Long courseId)
	        throws ResourceNotFoundException {
		  Course course = courseRepository.findById(courseId)
	          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));
	        return ResponseEntity.ok().body(course);
	    }
	  
	  @PostMapping("/courses")
	    public Course createEmployee(@Valid @RequestBody Course course) {
	        return courseRepository.save(course);
	    }
	  
	  @DeleteMapping("/course/{id}")
	    public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") Long courseId)
	         throws ResourceNotFoundException {
		  Course employee = courseRepository.findById(courseId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + courseId));
		  courseRepository.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	  
	  
	 @PutMapping("/courses/{id}") 
	    public ResponseEntity<Course> updateEmployee(@PathVariable(value = "id") Long courseId,
	         @Valid @RequestBody Course courseDetails) throws ResourceNotFoundException {
		  Course course = courseRepository.findById(courseId)
	        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));
		  course.setName(courseDetails.getName());
		  course.setAccumulateCredit(courseDetails.getAccumulateCredit());
		  course.setAllowUseOfInterestLists(courseDetails.getAllowUseOfInterestLists());
		  course.setApprovalRequired(courseDetails.getApprovalRequired());
		  course.setCertificationCalculationDate(courseDetails.getCertificationCalculationDate());
		  course.setCode(courseDetails.getCode());
		  course.setCourseCompletionCertificate(courseDetails.getCourseCompletionCertificate());
		  course.setCourseDisplayDate(courseDetails.getCourseDisplayDate());
		  course.setCourseHideDate(courseDetails.getCourseHideDate());
		  course.setCredit(courseDetails.getCredit());
		  course.setDaysBeforeStdToCompl(courseDetails.getDaysBeforeStdToCompl());
		  course.setDaysStdToCompl(courseDetails.getDaysStdToCompl());
		  course.setDeliveryMethod(courseDetails.getDeliveryMethod());
		  course.setDescription(courseDetails.getDescription());
		  course.setDuration(courseDetails.getDuration());
		  course.setEnrollmentCloseDate(courseDetails.getEnrollmentCloseDate());
		  course.setEnrollmentOpenDate(courseDetails.getEnrollmentOpenDate());
		  course.setEnrollmentRestriction(courseDetails.getEnrollmentCloseDate());
		  course.setInstructionalLanguages(courseDetails.getInstructionalLanguages());
		  course.setLanguage(courseDetails.getLanguage());
		  course.setNotes(courseDetails.getNotes());
		  course.setOrganizations(courseDetails.getOrganizations());
		  course.setRemindStudent(courseDetails.getRemindStudent());
		  course.setTargetedLearners(courseDetails.getTargetedLearners());
		  course.setTuition(courseDetails.getTuition());
		  course.setVersion(courseDetails.getVersion());
		  
		    final Course updatedCourse = courseRepository.save(course);
	        return ResponseEntity.ok(updatedCourse);
	    }
	  

}
