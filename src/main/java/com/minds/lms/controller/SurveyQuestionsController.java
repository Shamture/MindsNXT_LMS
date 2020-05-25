package com.minds.lms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Quiz;
import com.minds.lms.model.QuizQuestions;
import com.minds.lms.model.SurveyQuestions;
import com.minds.lms.repository.QuizQuestionsRepository;
import com.minds.lms.repository.QuizRepository;
import com.minds.lms.repository.SurveyQuestionsRepository;
import com.minds.lms.repository.SurveyRepository;

@RestController
public class SurveyQuestionsController {

	@Autowired
	SurveyQuestionsRepository surveyQuestionsRepository;

	@Autowired
	SurveyRepository surveyRepository;

	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewSurveyQuestions/{id}")
	public ResponseEntity<SurveyQuestions> findById(@PathVariable(value = "id") long id)
			throws ResourceNotFoundException {

		SurveyQuestions surveyQuestions = surveyQuestionsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		return ResponseEntity.ok().body(surveyQuestions);
	}

	// Add Quiz by Sham
	@CrossOrigin
	@PostMapping("/viewSurvey/{surveyId}/surveyQuestions")
	public SurveyQuestions create(@PathVariable(value = "surveyId") long surveyId,
			@Valid @RequestBody SurveyQuestions surveyQuestions) throws ResourceNotFoundException {
		return surveyRepository.findById(surveyId).map(course -> {
			surveyQuestions.setSurvey(course);
			return surveyQuestionsRepository.save(surveyQuestions);
		}).orElseThrow(() -> new ResourceNotFoundException("CourseId " + surveyId + " not found"));
	}

	// Update By Sham
	@CrossOrigin
	@PutMapping("/viewSurvey/{surveyId}/surveyQuestions/{id}")
	public SurveyQuestions updateQuiz(@PathVariable(value = "surveyId") Long surveyId, @PathVariable(value = "id") Long id,
			@Valid @RequestBody SurveyQuestions surveyQuestionsRequest) throws ResourceNotFoundException {
		if (!surveyRepository.existsById(surveyId)) {
			throw new ResourceNotFoundException("courseId not found");
		}

		return surveyQuestionsRepository.findById(id).map(survey -> {
			survey.setSurveyQuestionTitle(surveyQuestionsRequest.getSurveyQuestionTitle());
			survey.setSurveyQuestionType(surveyQuestionsRequest.getSurveyQuestionType());
			survey.setSurveyQuestionOption(surveyQuestionsRequest.getSurveyQuestionOption());
			survey.setSurveyAnswerOption1(surveyQuestionsRequest.getSurveyAnswerOption1());
			survey.setSurveyAnswerOption2(surveyQuestionsRequest.getSurveyAnswerOption2());
			return surveyQuestionsRepository.save(survey);
		}).orElseThrow(() -> new ResourceNotFoundException("survey id not found"));
	}

	// Delete Added By Sham 13-01-2020
	@CrossOrigin
	@DeleteMapping("/deletSurveyQuestions/{id}")
	public Map<String, Boolean> deleteQuiz(@PathVariable(value = "id") Long Id) throws ResourceNotFoundException {
		SurveyQuestions surveyQuestions = surveyQuestionsRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Survey not found for this id :: " + Id));
		surveyQuestionsRepository.delete(surveyQuestions);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
