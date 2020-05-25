package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.Content;
import com.minds.lms.model.InstructorContent;

@Transactional
@Repository
public interface InstructorFileRepository extends JpaRepository<InstructorContent, String>{
	 public List<InstructorContent> findByNameAndStatusAndType(String name, String status, String Type);
	 public List<InstructorContent> findByName(String name);
	 public List<InstructorContent> findByNameOrType(String name, String filetype );
	 public Optional<InstructorContent> findById(Long fileId);
	public List<InstructorContent> findByStatus(String status);

	
}