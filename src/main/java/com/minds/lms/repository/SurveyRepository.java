package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.Category;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.Quiz;
import com.minds.lms.model.SystemRole;
import com.minds.lms.model.Survey;
import com.minds.lms.model.Term;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
	

	public List<Survey> findBySurveyCode(String surveyCode);

	
	public Survey save(Survey input);


	public List<Survey> findByCourseId(long id);
	
	public Optional<Survey> findById(long id);


	
}
