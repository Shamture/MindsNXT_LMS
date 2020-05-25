package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.minds.lms.model.SubRoles;

@Transactional
@Repository
public interface SubRolesRepository extends JpaRepository<SubRoles, Long>{

	List<SubRoles> findByRoleEntityRoleId(long id);

}
