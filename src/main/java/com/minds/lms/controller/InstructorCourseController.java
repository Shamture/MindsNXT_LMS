package com.minds.lms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Content;
import com.minds.lms.model.Course;
import com.minds.lms.model.InstructorCourse;
import com.minds.lms.repository.CourseRepository;
import com.minds.lms.repository.InstructorCourseRepository;

@RestController

public class InstructorCourseController {
	
	@Autowired
	private InstructorCourseRepository courseRepository;
	
	  
	  @CrossOrigin
	  @GetMapping("/viewAllInstructorCourses")
	    public List<InstructorCourse> getAllCourses() {
	        return courseRepository.findAll();
	    }
	  
	  @CrossOrigin
	  @GetMapping("/viewInstructorCourseById/{id}")
	    public ResponseEntity<InstructorCourse> getCourseById(@PathVariable(value = "id") Long courseId)
	        throws ResourceNotFoundException {
		  InstructorCourse course = courseRepository.findById(courseId)
	          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));
	        return ResponseEntity.ok().body(course);
	    }
	  
	  
	  @CrossOrigin
	  @PostMapping("/addInstructorCourse")
	    public InstructorCourse createInstructorCourse(@Valid @RequestBody InstructorCourse course) {
	        return courseRepository.save(course);
	    }
	  
	  @CrossOrigin
	  @DeleteMapping("/deleteInstructorCourse/{id}")
	    public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") Long courseId)
	         throws ResourceNotFoundException {
		  InstructorCourse employee = courseRepository.findById(courseId)
	       .orElseThrow(() -> new ResourceNotFoundException("Instructor Course not found for this id :: " + courseId));
		  courseRepository.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	  
	 @CrossOrigin
 	 @PutMapping("/upadteInstructorCourse/{id}") 
	    public ResponseEntity<InstructorCourse> updateEmployee(@PathVariable(value = "id") Long courseId,
	         @Valid @RequestBody InstructorCourse courseDetails) throws ResourceNotFoundException {
		 InstructorCourse course = courseRepository.findById(courseId)
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
		  course.setMajor(courseDetails.getMajor());
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
		  course.setStatus(courseDetails.getStatus());
		  
		    final InstructorCourse updatedCourse = courseRepository.save(course);
	        return ResponseEntity.ok(updatedCourse);
	    }
	  
	   @CrossOrigin
	    @GetMapping(value = "/searchInstructorCourseByName/{name}")
	    public List<InstructorCourse> findByName(@PathVariable("name") String name){
		return courseRepository.findByName(name);
	    }
	    
	    @CrossOrigin
	    @GetMapping(value = "/searchInstructorCourseByCode/{code}")
	    public List<InstructorCourse> findByCode(@PathVariable("code") String code){
		return courseRepository.findByCode(code);
	    }
	    
	    @CrossOrigin
	    @GetMapping(value = "/searchInstructorCourseByNameCodeMajorDlmStatus/{name}/{code}/{major}/{deliveryMethod}/{status}")
	    public List<InstructorCourse> findByNameAndCodeAndMajorAndDeliveryMethodAndStatus(@PathVariable("name") String name,@PathVariable("code") String code,@PathVariable("major") String major,@PathVariable("deliveryMethod") String deliveryMethod,@PathVariable("status") String status){
		return courseRepository.findByCode(code);
	    }

}
