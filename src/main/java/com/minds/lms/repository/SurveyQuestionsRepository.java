package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.SurveyQuestions;

public interface SurveyQuestionsRepository extends JpaRepository<SurveyQuestions, Long> {

	public Optional<SurveyQuestions> findById(long id);

	public List<SurveyQuestions> findBySurveyId(long id);

}
