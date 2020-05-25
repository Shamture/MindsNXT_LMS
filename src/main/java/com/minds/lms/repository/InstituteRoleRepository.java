package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.Category;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.Role;

public interface InstituteRoleRepository extends JpaRepository<InstituteRole, Long> {
	

	

	

	public List<InstituteRole> findByNameAndCode(String name, String code);
	
}
