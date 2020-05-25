package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.Content;

@Transactional
@Repository
public interface ContentRepository extends JpaRepository<Content, String> {
	 public List<Content> findByNameAndStatusAndType(String name, String status, String Type);
	 public List<Content> findByName(String name);
	 public List<Content> findByNameOrType(String name, String filetype );
	 public Optional<Content> findById(long Id);
	public List<Content> findByStatus(String status);

}
