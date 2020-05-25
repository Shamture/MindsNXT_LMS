package com.minds.lms.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Assessment;
import com.minds.lms.model.Assignment;
import com.minds.lms.repository.AssessmentRepository;
import com.minds.lms.repository.CourseRepository;

@RestController
public class AssessmentController {

	@Autowired
	AssessmentRepository assessmentRepository;

	@Autowired
	CourseRepository courseRepository;

	// View in Assignment Id by Sham D: 10-01-2020
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewAssessment/{id}")
	public ResponseEntity<Assessment> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

		Assessment assessment = assessmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		return ResponseEntity.ok().body(assessment);
	}

	// Add Asignment by Sham
	@CrossOrigin
	@PostMapping("/viewAllCourses/{courseId}/assessments")
	public Assessment create(@PathVariable(value = "courseId") long courseId, @Valid @RequestBody Assessment assessment)
			throws ResourceNotFoundException {
		return courseRepository.findById(courseId).map(course -> {
			assessment.setCourse(course);
			return assessmentRepository.save(assessment);
		}).orElseThrow(() -> new ResourceNotFoundException("CourseId " + courseId + " not found"));
	}

	// Update By Sham
	@CrossOrigin
	@PutMapping("/viewAllCourses/{courseId}/assessments/{id}")
	public Assessment updateAssessment(@PathVariable(value = "courseId") Long courseId,
			@PathVariable(value = "id") Long id, @Valid @RequestBody Assessment assessnmentRequest)
			throws ResourceNotFoundException {
		if (!courseRepository.existsById(courseId)) {
			throw new ResourceNotFoundException("instructorId not found");
		}

		return assessmentRepository.findById(id).map(assign -> {
			assign.setAssessmentName(assessnmentRequest.getAssessmentName());
			assign.setAssessmentDescription(assessnmentRequest.getAssessmentDescription());
			assign.setAssessmentTotalWeight(assessnmentRequest.getAssessmentTotalWeight());
			return assessmentRepository.save(assign);
		}).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
	}

	// Delete Added By Sham 10-01-2020
	@CrossOrigin
	@DeleteMapping("/deletAssessment/{id}")
	public Map<String, Boolean> deleteAssessmentt(@PathVariable(value = "id") Long Id)
			throws ResourceNotFoundException {
		Assessment assessment = assessmentRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));
		assessmentRepository.delete(assessment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	// get Assessment Object by Assessment Name and Course Id
	 	@CrossOrigin
		@GetMapping("/viewAllCourses/{courseId}/assessments/{assessment_name}")
		public ResponseEntity<Assessment> getAsssemmentbyAssignment(@RequestBody @PathVariable(value = "courseId") long courseId, @PathVariable(value = "assessment_name") String assessmentName) throws ResourceNotFoundException {
	 		Assessment assessment = assessmentRepository.findByCourseIdAndAssessmentName(courseId, assessmentName);
				return ResponseEntity.ok().body(assessment);
		}

}
