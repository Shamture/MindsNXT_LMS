package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	

	public List<Role> findByRoleName(String rolename);
	
}
