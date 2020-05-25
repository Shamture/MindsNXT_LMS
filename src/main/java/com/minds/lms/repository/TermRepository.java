package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.Category;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.Role;
import com.minds.lms.model.Term;

public interface TermRepository extends JpaRepository<Term, Long> {
	

	public List<Term> findByTermName(String termName);

	
	public Term save(Term input);


	public Optional<Term> findById(long id);


	public void deleteById(int id);
	
}
