package com.minds.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Privilege;
import com.minds.lms.model.Quiz;
import com.minds.lms.model.SubRoles;
import com.minds.lms.repository.PrivilegeRepository;
import com.minds.lms.repository.RoleRepository;
import com.minds.lms.repository.SubRolesRepository;

@RestController
public class PrivilegeController {

	@Autowired
	PrivilegeRepository privilegeRepository;

	@Autowired
	SubRolesRepository subRolesRepository;

	@Autowired
	RoleRepository roleRepository;

	@CrossOrigin
	@GetMapping("/viewAllPrivileges")
	public List<Privilege> getAllPrivileges() {
		return privilegeRepository.findAll();
	}

	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewAllPrivileges/{role_id}/{sub_role_id}")
	public List<Privilege> findByRoleIdAndSubRoleId(@PathVariable(value = "role_id") long roleId,
			@PathVariable(value = "sub_role_id") long subRoleId) throws ResourceNotFoundException {

		return privilegeRepository.findByPrivilegesEntityRoleIdAndPrivilegesEntitySubRoleId(roleId, subRoleId);

	}

	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewAllPrivilegesById/{role_id}/{sub_role_id}/{privilegeId}")
	public List<Privilege> findByRoleIdAndSubRoleId(@PathVariable(value = "role_id") long roleId,
			@PathVariable(value = "sub_role_id") long subRoleId, @PathVariable(value = "privilegeId") long privilegeId)
			throws ResourceNotFoundException {

		return privilegeRepository.findByPrivilegesEntityRoleIdAndPrivilegesEntitySubRoleIdAndPrivilegesEntityPrivilegeId(roleId,
						subRoleId, privilegeId);

	}

	@CrossOrigin(allowedHeaders = "*")
	@PutMapping("/viewAllPrivilegesById/{privilege_id}")
	public Privilege updatePrivilege(@PathVariable(value = "privilege_id") long privilegeId,
			@Valid @RequestBody Privilege privilegeRequest) throws ResourceNotFoundException {
		if (!privilegeRepository.existsById(privilegeId)) {
			throw new ResourceNotFoundException("courseId not found");
		}
		return privilegeRepository.findById(privilegeId).map(privilege -> {
			privilege.setName(privilegeRequest.getName());
			privilege.setDescription(privilegeRequest.getDescription());
			privilege.setStatus(privilegeRequest.getStatus());
			return privilegeRepository.save(privilege);
		}).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
		// return
		// privilegeRepository.findByPrivilegesEntityRoleIdAndPrivilegesEntitySubRoleIdAndPrivilegesEntityPrivilegeId(roleId,subRoleId,privilegeId);

	}
	
/*	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewPrivilegesById/{id}")
	public ResponseEntity<Privilege> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

		Quiz quiz = quizRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		return ResponseEntity.ok().body(quiz);
	}*/
}
