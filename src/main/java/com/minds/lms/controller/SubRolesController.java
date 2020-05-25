package com.minds.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.SubRoles;
import com.minds.lms.repository.SubRolesRepository;

@RestController
public class SubRolesController {

	@Autowired
	SubRolesRepository subRolesRepository;

	@CrossOrigin
	@GetMapping("/viewAllSubRoles")
	public List<SubRoles> getAllSubRoles() {
		return subRolesRepository.findAll();
	}

	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewAllSubRoles/{id}")
	public List<SubRoles> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

		return subRolesRepository.findByRoleEntityRoleId(id);
				
	}

}
