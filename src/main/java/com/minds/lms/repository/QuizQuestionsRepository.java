package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.QuizQuestions;

public interface QuizQuestionsRepository extends JpaRepository<QuizQuestions, Long> {

	public Optional<QuizQuestions> findById(long id);

	public List<QuizQuestions> findByQuizId(long id);

}
