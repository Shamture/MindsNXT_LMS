package com.minds.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.Privilege;

@Transactional
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long>{
	List<Privilege> findByPrivilegesEntityRoleIdAndPrivilegesEntitySubRoleId(long roleId, long subRoleId);
	
	List<Privilege> findByPrivilegesEntityRoleIdAndPrivilegesEntitySubRoleIdAndPrivilegesEntityPrivilegeId(long roleId, long subRoleId, long privilegeId);

}
