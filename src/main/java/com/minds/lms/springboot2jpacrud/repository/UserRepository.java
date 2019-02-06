package com.minds.lms.springboot2jpacrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.springboot2jpacrud.model.Category;
import com.minds.lms.springboot2jpacrud.model.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	List<User> findByUsernameAndSystemRolesAndInstitutionalRoles(String username, String systemRole, String institutionalRoles);
	
	
		
	

}
