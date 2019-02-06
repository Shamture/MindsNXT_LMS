package com.minds.lms.springboot2jpacrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.springboot2jpacrud.model.Content;

@Transactional
@Repository
public interface FileRepository extends JpaRepository<Content, String>{
	 public List<Content> findByNameAndType(String name, String type);
	 public List<Content> findByName(String name);
	 public List<Content> findByNameOrType(String name, String filetype );
	 public Optional<Content> findById(Long fileId);

	
}