package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.Category;


@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category,String>{
	
	public List<Category> findByNameAndIsCategorySearchableAndStatus(String name,String isCategorySearchable,String status);
	Optional<Category> findById(Long categoryId);
	
	List<Category> findAll();
	public List<Category> findByName(String name);

	
		
	

}
