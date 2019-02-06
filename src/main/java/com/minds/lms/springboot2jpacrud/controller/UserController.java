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
import com.minds.lms.springboot2jpacrud.model.Category;
import com.minds.lms.springboot2jpacrud.model.Course;
import com.minds.lms.springboot2jpacrud.model.User;
import com.minds.lms.springboot2jpacrud.repository.CourseRepository;
import com.minds.lms.springboot2jpacrud.repository.UserRepository;

@RestController

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	  @GetMapping("/users")
	    public List<User> getAllCourses() {
	        return userRepository.findAll();
	    }
	  
	  @GetMapping("/user/{id}")
	    public ResponseEntity<User> getCourseById(@PathVariable(value = "id") long id)
	        throws ResourceNotFoundException {
		  User user = userRepository.findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
	        return ResponseEntity.ok().body(user);
	    }
	  
	 @PostMapping("/users")
	    public User createUser(@Valid @RequestBody User user) {
	        return userRepository.save(user);
	    }
	  
	  @DeleteMapping("/user/{id}")
	    public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") Long id)
	         throws ResourceNotFoundException {
		  User user = userRepository.findById(id)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		  userRepository.delete(user);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	  
	
	 @PutMapping("/user/{id}") 
	    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long id,
	         @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		 User user = userRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + id));
		 user.setAffiliation(userDetails.getAffiliation());
		 user.setCity(userDetails.getCity());
		 user.setConfirmPassword(userDetails.getConfirmPassword());
		 user.setCountry(userDetails.getCountry());
		 user.setEndDate(userDetails.getEndDate());
		  user.setFax(userDetails.getFax());
		  user.setFirstname(userDetails.getFirstname());
		  user.setGeneratePassword(userDetails.getGeneratePassword());
		  user.setInstitutionalRoles(userDetails.getInstitutionalRoles());
		  user.setLanguage(userDetails.getLanguage());
		  user.setLastname(userDetails.getLastname());
		  user.setMobile(userDetails.getMobile());
		  user.setNotifyUser(userDetails.getNotifyUser());
		  user.setOrganization(userDetails.getOrganization());
		  user.setPassword(userDetails.getPassword());
		  user.setPasswordReset(userDetails.getPassword());
		  user.setPosition(userDetails.getPosition());
		  user.setPostalCode(userDetails.getPostalCode());
		  user.setStartDate(userDetails.getStartDate());
		  
		  user.setState(userDetails.getState());
		  user.setStreet(userDetails.getStreet());
		  user.setSystemRoles(userDetails.getSystemRoles());
		  user.setUsername(userDetails.getUsername());
		  user.setVoice(userDetails.getVoice());
		 
		    final User updatedUser = userRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	    }
	  
	 
	 
	  @GetMapping(value = "/searchuser/{username}/{systemRoles}/{institutionalRoles}")
	    public List<User> findByNameAndDiscriptionAndSearchable(@PathVariable("username") String username,@PathVariable("systemRoles") String systemRoles, @PathVariable("institutionalRoles") String institutionalRoles ){
		return userRepository.findByUsernameAndSystemRolesAndInstitutionalRoles(username, systemRoles ,institutionalRoles);
	    }
	  
	  
	  
	  
	  
}
