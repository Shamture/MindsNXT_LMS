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
import com.minds.lms.model.Category;
import com.minds.lms.model.Course;
import com.minds.lms.model.User;
import com.minds.lms.repository.CourseRepository;
import com.minds.lms.repository.UserRepository;

@RestController

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
		@CrossOrigin
	  @GetMapping("/viewAllUsers")
	    public List<User> getAllCourses() {
	        return userRepository.findAll();
	    }
	  
	  @CrossOrigin
	  @GetMapping("/viewUserById/{id}")
	    public ResponseEntity<User> getCourseById(@PathVariable(value = "id") long id)
	        throws ResourceNotFoundException {
		  User user = userRepository.findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
	        return ResponseEntity.ok().body(user);
	    }
	  
	  
	 @CrossOrigin 
	 @PostMapping("/addUser")
	    public User createUser( @RequestBody User user) {
	        return userRepository.save(user);
	        
	    }
	  
	 @CrossOrigin
	  @DeleteMapping("/deleteUser/{id}")
	    public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") Long id)
	         throws ResourceNotFoundException {
		  User user = userRepository.findById(id)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		  userRepository.delete(user);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	  
	
	 @CrossOrigin
	 @PutMapping("/updateUser/{id}") 
	    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long id,
	         @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		 User user = userRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + id));
		 user.setAffiliation(userDetails.getAffiliation());
		 user.setCity(userDetails.getCity());
	
		 user.setCountry(userDetails.getCountry());
		 user.setEndDate(userDetails.getEndDate());
		  user.setFax(userDetails.getFax());
		  user.setFirstName(userDetails.getFirstName());
		  
		  user.setInstitutionalRoles(userDetails.getInstitutionalRoles());
		  user.setLanguage(userDetails.getLanguage());
		  user.setLastName(userDetails.getLastName());
		  user.setMobile(userDetails.getMobile());
		 
		  user.setOrganization(userDetails.getOrganization());
		  user.setPassword(userDetails.getPassword());
		  user.setPassword(userDetails.getPassword());
		;
		  user.setPostalCode(userDetails.getPostalCode());
		  user.setStartDate(userDetails.getStartDate());
		  
		  user.setState(userDetails.getState());
		  user.setStreet(userDetails.getStreet());
		  user.setSystemRoles(userDetails.getSystemRoles());
		  user.setUserName(userDetails.getUserName());
		  user.setVoice(userDetails.getVoice());
		 
		    final User updatedUser = userRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	    }
	  
	 
	 
	 /* @GetMapping(value = "/searchuser/{username}/{systemRoles}/{institutionalRoles}")
	    public List<User> findByUserNameAndSystemRolesAndInstitutionalRoles(@PathVariable("username") String userName,@PathVariable("systemRoles") String systemRoles, @PathVariable("institutionalRoles") String institutionalRoles ){
		return userRepository.findByUserNameAndSystemRolesAndInstitutionalRoles(userName, systemRoles ,institutionalRoles);
	    }*/
	  
	  
	  
	  
	  
}
