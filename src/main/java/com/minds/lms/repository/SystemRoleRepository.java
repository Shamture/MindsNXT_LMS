package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.SystemRole;

public interface SystemRoleRepository extends JpaRepository<SystemRole, Long> {
	

	public List<SystemRole> findByRoleName(String rolename);
	
}
