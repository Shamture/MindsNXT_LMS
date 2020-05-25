package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.Category;
import com.minds.lms.model.InstructorCategory;


@Transactional
@Repository
public interface InstructorCategoryRepository extends JpaRepository<InstructorCategory,String>{
	
	public List<InstructorCategory> findByNameAndIsCategorySearchableAndStatus(String name,String isCategorySearchable,String status);
	Optional<InstructorCategory> findById(Long categoryId);
	
	List<InstructorCategory> findAll();
	public List<InstructorCategory> findByName(String name);

	
		
	

}
