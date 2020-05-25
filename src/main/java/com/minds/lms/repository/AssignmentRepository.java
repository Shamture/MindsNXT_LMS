package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.Assignment;
import com.minds.lms.model.Role;
import com.minds.lms.model.Term;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
	

	public List<Assignment> findByName(String name);

	
	public Assignment save(Assignment input);


	public Optional<Assignment> findById(long id);


	public void deleteById(int id);
	
}
