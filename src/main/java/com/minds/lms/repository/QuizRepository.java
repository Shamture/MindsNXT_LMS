package com.minds.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.model.Category;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.Quiz;
import com.minds.lms.model.Role;
import com.minds.lms.model.Term;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	

	public List<Quiz> findByQuizName(String quizName);

	
	public Quiz save(Quiz input);


	public Optional<Quiz> findById(long id);


	public void deleteById(int id);
	
}
