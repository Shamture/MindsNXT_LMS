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
import com.minds.lms.repository.CourseRepository;
import com.minds.lms.repository.QuizQuestionsRepository;
import com.minds.lms.repository.QuizRepository;

@RestController
@CrossOrigin
public class QuizController {

	@Autowired
	QuizRepository quizRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	QuizQuestionsRepository quizQuestionsRepository;

	/*
	 * @PostMapping("/addQuiz") public Quiz addQuize(@RequestBody Quiz input){
	 * return quizRepository.save(input); }
	 * 
	 * @GetMapping("/viewAllQuiz") public List<Quiz> getAllQuize(){ return
	 * quizRepository.findAll(); }
	 * 
	 * @DeleteMapping("deleteQuizById/{id}") public String
	 * deleteQuiz(@PathVariable(value = "id") long id){
	 * 
	 * 
	 * quizRepository.deleteById(id); return "QuiZ Deleted For the Id :" +id;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @GetMapping("/viewQuizById/{id}") public Quiz
	 * getQuize(@PathVariable(value = "id") long id) throws
	 * ResourceNotFoundException{
	 * 
	 * return quizRepository.findById(id).orElseThrow(()->(new
	 * ResourceNotFoundException("Quize Is Not Found For this Id : " +id)));
	 * 
	 * }
	 * 
	 * @GetMapping("/viewQuiZByCourseCode/{courseCode}") public Quiz
	 * getQuizByCourseCode(@PathVariable(value = "courseCode") String courseCode
	 * ){
	 * 
	 * return quizRepository.findByCourseCode(courseCode); }
	 */

	// View in Quiz Id by Sham D: 13-01-2020
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewQuiz/{id}")
	public ResponseEntity<Quiz> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

		Quiz quiz = quizRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		return ResponseEntity.ok().body(quiz);
	}

	// Add Quiz by Sham
	@CrossOrigin
	@PostMapping("/viewAllCourses/{courseId}/quiz")
	public Quiz create(@PathVariable(value = "courseId") long courseId, @Valid @RequestBody Quiz quiz)
			throws ResourceNotFoundException {
		return courseRepository.findById(courseId).map(course -> {
			quiz.setCourse(course);
			return quizRepository.save(quiz);
		}).orElseThrow(() -> new ResourceNotFoundException("CourseId " + courseId + " not found"));
	}

	// Update By Sham
	@CrossOrigin
	@PutMapping("/viewAllCourses/{courseId}/quiz/{id}")
	public Quiz updateQuiz(@PathVariable(value = "courseId") Long courseId, @PathVariable(value = "id") Long id,
			@Valid @RequestBody Quiz quizRequest) throws ResourceNotFoundException {
		if (!courseRepository.existsById(courseId)) {
			throw new ResourceNotFoundException("courseId not found");
		}

		return quizRepository.findById(id).map(quiz -> {
			quiz.setQuizName(quizRequest.getQuizName());
			quiz.setQuizDescription(quizRequest.getQuizDescription());
			quiz.setQuizStartDate(quizRequest.getQuizStartDate());
			quiz.setQuizEndDate(quizRequest.getQuizEndDate());
			quiz.setQuestions(quizRequest.getQuestions());
			return quizRepository.save(quiz);
		}).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
	}

	// Delete Added By Sham 13-01-2020
	@CrossOrigin
	@DeleteMapping("/deletQuiz/{id}")
	public Map<String, Boolean> deleteQuiz(@PathVariable(value = "id") Long Id) throws ResourceNotFoundException {
		Quiz quiz = quizRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz not found for this id :: " + Id));
		quizRepository.delete(quiz);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	// View QuizQuestions by QuizId
	@CrossOrigin
	@GetMapping(value = "/viewQuiz/{quizId}/quizQuestions")
	public List<QuizQuestions> findByQuiz(@PathVariable("quizId") long id) {
		return quizQuestionsRepository.findByQuizId(id);
	}

	@PutMapping("updateQuizById/{id}")
	public Quiz updateQuiz(@PathVariable(value = "id") long id, @RequestBody Quiz update)
			throws ResourceNotFoundException {

		Quiz quiz = quizRepository.findById(id)
				.orElseThrow(() -> (new ResourceNotFoundException(" User Not Found for this Id :" + id)));

		quiz.setQuizName(update.getQuizName());
		quiz.setQuestions(update.getQuestions());
		quiz.setQuizDescription(update.getQuizDescription());
		quiz.setQuizStartDate(update.getQuizStartDate());
		quiz.setQuizEndDate(update.getQuizEndDate());

		return quizRepository.save(quiz);

	}

}
