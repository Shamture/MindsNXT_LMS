package com.minds.lms.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	//List<User> findByUserNameAndSystemRolesAndInstitutionalRoles(String userName, String systemRole, String institutionalRoles);
	
	
		
	

}
