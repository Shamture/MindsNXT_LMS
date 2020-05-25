
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
import com.minds.lms.model.Category;
import com.minds.lms.model.Course;
import com.minds.lms.model.DataOrg;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.MultiDataCont;
import com.minds.lms.model.Role;
import com.minds.lms.model.Term;
import com.minds.lms.repository.InstituteRoleRepository;
import com.minds.lms.repository.MultiInstituteDataRepository;
import com.minds.lms.repository.MultiOrgDataRepository;
import com.minds.lms.repository.RoleRepository;
import com.minds.lms.repository.TermRepository;

@RestController
public class TermController {
	@Autowired
	TermRepository termRepository;
	
	
	@CrossOrigin
	 @GetMapping("/viewTerms")
	    public List<Term> getAllTerms() {
	        return termRepository.findAll();
	    }
	
	
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewTerm/{id}")
	public ResponseEntity<Term> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{		
		
		Term role = termRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));		

		return ResponseEntity.ok().body(role);
	}
	
	@CrossOrigin
    @PostMapping("/addTerms")
    public Term create(@RequestBody Term input) {
           return termRepository.save(input);
    }
	
	@CrossOrigin
	@DeleteMapping("deletTerm/{id}")
	public String deleteSystemRoles(@PathVariable(value ="id") long id){
		
		termRepository.deleteById(id);
		
		return "Deleted" ;
		
	}
	
	@CrossOrigin
	@PutMapping("updateTerm/{id}")
	public ResponseEntity<Term> updateSystemRoles(@PathVariable (value = "id") long id , @RequestBody Term roledetails) throws ResourceNotFoundException{
		
		Term role = termRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("User not found for this id : "+id)));
		
		
		role.setTermName(roledetails.getTermName());
		role.setTermDescription(roledetails.getTermDescription());
		role.setStartDate(roledetails.getStartDate());
		role.setLanguage(roledetails.getLanguage());
		role.setEndDate(roledetails.getEndDate());
		Term updaterole = termRepository.save(role);
		
		return ResponseEntity.ok(updaterole);
		
	}
	
	@CrossOrigin
	@GetMapping("searchTerm/{termName}")
	
	public List<Term> findByTerms(@PathVariable(value = "termName") String termName){
		
		return termRepository.findByTermName(termName);
	
	}	
	
	
	
	
	
	
	
}
