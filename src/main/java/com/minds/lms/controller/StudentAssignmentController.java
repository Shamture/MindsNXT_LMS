package com.minds.lms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Assignment;
import com.minds.lms.model.Quiz;
import com.minds.lms.model.QuizQuestions;
import com.minds.lms.model.StudentAssignment;
import com.minds.lms.model.StudentAssignmentPK;
import com.minds.lms.model.User;
import com.minds.lms.repository.AssignmentRepository;
import com.minds.lms.repository.StudentAssignmentRepository;
import com.minds.lms.repository.UserRepository;

@RestController
public class StudentAssignmentController {
	
	@Autowired
	StudentAssignmentRepository studentAssignmentRepository;
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@JsonIgnore
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewAssignment/{assignmentId}/studentAssignment")
		public List<StudentAssignment> findByAssifnmentId(@PathVariable("assignmentId") long id) {
			return studentAssignmentRepository.findByAssignmentId(id);
		}
	
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewAssignment/{assignmentId}/studentAssignment/{userName}")
		public StudentAssignment findByAssifnmentId(@PathVariable("assignmentId") long id,@PathVariable("userName") String userName) {
			return studentAssignmentRepository.findByAssignmentIdAndUserName(id, userName);
		}
	
	@CrossOrigin(allowedHeaders = "*")
	@PostMapping("/addAssignment/{assignment_id}/studentAssignment/")
	public StudentAssignment addAssignment(@PathVariable(value = "assignment_id") long assignmentId, @Valid @RequestBody StudentAssignment studentAssignment, @RequestBody StudentAssignmentPK  studentAssignmentPK) throws ResourceNotFoundException{
		
		/*long user_id= studentAssignmentPK.getUser_id();
		long assign_id = studentAssignmentPK.getAssignment_id();
		
		Optional<User> user = userRepository.findById(user_id);
		Optional<Assignment> assignment = assignmentRepository.findById(assign_id);
		*/
		return assignmentRepository.findById(assignmentId).map(assignment ->{
			studentAssignment.setAssignment(assignment);
			return studentAssignmentRepository.save(studentAssignment);
		}).orElseThrow(() -> new ResourceNotFoundException("assignment_id id not found"));
		}
	
}
