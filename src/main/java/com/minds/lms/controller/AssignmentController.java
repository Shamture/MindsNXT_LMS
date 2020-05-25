package com.minds.lms.controller;
import java.util.List;
import java.util.Optional;

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
import com.minds.lms.model.Assignment;
import com.minds.lms.model.Category;
import com.minds.lms.model.Course;
import com.minds.lms.model.DataOrg;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.MultiDataCont;
import com.minds.lms.model.Role;
import com.minds.lms.model.Term;
import com.minds.lms.repository.AssignmentRepository;
import com.minds.lms.repository.InstituteRoleRepository;
import com.minds.lms.repository.MultiInstituteDataRepository;
import com.minds.lms.repository.MultiOrgDataRepository;
import com.minds.lms.repository.RoleRepository;
import com.minds.lms.repository.TermRepository;

@RestController
public class AssignmentController {
	@Autowired
	AssignmentRepository asignmentRepository;
	
	
	@CrossOrigin
	 @GetMapping("/viewAssignments")
	    public List<Assignment> getAllAssignments() {
	        return asignmentRepository.findAll();
	    }
	
	
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewAssignment/{id}")
	public ResponseEntity<Assignment> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{		
		
		Assignment assignment = asignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));		

		return ResponseEntity.ok().body(assignment);
	}
	
	@CrossOrigin
    @PostMapping("/addAssignment")
    public Assignment create(@RequestBody Assignment input) {
           return asignmentRepository.save(input);
    }
	
	@CrossOrigin
	@DeleteMapping("deletAssignment/{id}")
	public String deleteSystemRoles(@PathVariable(value ="id") long id){
		
		asignmentRepository.deleteById(id);
		
		return "Deleted" ;
		
	}
	
	@CrossOrigin
	@PutMapping("updateAssignment/{id}")
	public ResponseEntity<Assignment> updateSystemRoles(@PathVariable (value = "id") long id , @RequestBody Assignment assign) throws ResourceNotFoundException{
		
		Assignment assignment = asignmentRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("User not found for this id : "+id)));
		
		
		assignment.setName(assign.getName());
		assignment.setDescription(assign.getDescription());
		assignment.setSelectAssignments(assign.getSelectAssignments());
		assignment.setMaximumScore(assign.getMaximumScore());
		assignment.setWeightInsideAssignments(assign.getWeightInsideAssignments());
		Assignment updaterole = asignmentRepository.save(assignment);
		
		return ResponseEntity.ok(updaterole);
		
	}
	
	@CrossOrigin
	@GetMapping("searchAssignment/{name}")
	
	public List<Assignment> findByName(@PathVariable(value = "name") String name){
		
		return asignmentRepository.findByName(name);
	
	}	
	
	
	
	
	
	
	
}
