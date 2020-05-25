package com.minds.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.StudentAssignment;

public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, Long>{

	List<StudentAssignment> findByAssignmentId(long id);
	StudentAssignment findByAssignmentIdAndUserName(long id, String name);

}
