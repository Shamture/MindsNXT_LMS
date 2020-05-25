package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.Category;
import com.minds.lms.model.Organization;

import java.lang.String;



@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long>{
	
	

	
	
	List<Organization> findAll();

	Optional<Organization> findById(Long orgId);
	
	List<Organization> findByOrgNameAndOrgCodeAndType(String orgname,String orgcode,String type);

	List<Organization> findByOrgName(String orgname);

	List<Organization> findByorgCode(String orgCode);

	List<Organization> findByType(String type);

	
		
	

}
