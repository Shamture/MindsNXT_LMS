package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.Announcement;
import com.minds.lms.model.Content;

@Transactional
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, String>{
	 public Optional<Announcement> findById(Long fileId);

	
}