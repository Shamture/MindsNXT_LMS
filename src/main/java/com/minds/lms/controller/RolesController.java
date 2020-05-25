package com.minds.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.model.Role;
import com.minds.lms.repository.RoleRepository;

@RestController
public class RolesController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@CrossOrigin
	@GetMapping("/viewAllRoles")
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

}
