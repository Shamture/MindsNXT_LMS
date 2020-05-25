package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.Assessment;
import com.minds.lms.model.Assignment;

@Transactional
@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, String>{
	 
	public Optional<Assessment> findById(Long fileId);

	public List<Assessment> findByCourseId(long id);

	public Assessment findByCourseIdAndAssessmentName(long courseId, String assessmentName);

	
}