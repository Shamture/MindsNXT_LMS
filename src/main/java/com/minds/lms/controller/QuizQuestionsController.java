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
import com.minds.lms.repository.QuizQuestionsRepository;
import com.minds.lms.repository.QuizRepository;

@RestController
public class QuizQuestionsController {

	@Autowired
	QuizQuestionsRepository quizQuestionsRepository;

	@Autowired
	QuizRepository quizRepository;

	/*
	 * @PostMapping("/addQuestions") public String createQuestions(@RequestBody
	 * QuizQuestions input){ quizQuestionsRepository.save(input);
	 * 
	 * 
	 * 
	 * return "Question Succefully Created"; }
	 * 
	 * @GetMapping("/viewAllQuestions") public List<QuizQuestions>
	 * getAllQuestions(){ return quizQuestionsRepository.findAll(); }
	 * 
	 * @GetMapping("/viewQuestionsById/{id}") public QuizQuestions
	 * getQuestionById(@PathVariable(value = "id") int quizId) throws
	 * ResourceNotFoundException{ return
	 * quizQuestionsRepository.findById(quizId).orElseThrow(()-> (new
	 * ResourceNotFoundException("Question Not Found For This Id : "+quizId)));
	 * }
	 * 
	 * @DeleteMapping("/deleQuestionById/{id}") public String
	 * deleteQuestion(@PathVariable(value= "id") int quizId){
	 * 
	 * quizQuestionsRepository.deleteById(quizId); return
	 * "Question is Deleted For This Id :" +quizId;
	 * 
	 * }
	 */

	/*
	 * @PutMapping("/updateQuestions/{id}") public QuizQuestions
	 * editQuesyinsById(@PathVariable(value = "id") int quizId,@RequestBody
	 * QuizQuestions update) throws ResourceNotFoundException{
	 * 
	 * 
	 * QuizQuestions quiz =
	 * questionrepository.findById(quizId).orElseThrow(()->(new
	 * ResourceNotFoundException("Question Is Not Fpund For This id :"+quizId)))
	 * ;
	 * 
	 * quiz.setQuizQuestion(update.getQuizQuestion());
	 * quiz.setCorrectAnswers(update.getCorrectAnswers());
	 * quiz.setQuizAnswer1(update.getQuizAnswer1());
	 * quiz.setQuizAnswe2(update.getQuizAnswe2());
	 * quiz.setQuizAnswer3(update.getQuizAnswer3());
	 * quiz.setQuizAnswer4(update.getQuizAnswer4());
	 * quiz.setAnswerScores(update.getAnswerScores());
	 * 
	 * 
	 * System.out.println("GET method By ID"+quiz.getQuizQuestion());
	 * 
	 * System.out.println("GET method By ID"+update.getQuizQuestion());
	 * 
	 * 
	 * 
	 * return questionrepository.save(quiz);
	 * 
	 * 
	 * 
	 * }
	 */

	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewQuizQuestions/{id}")
	public ResponseEntity<QuizQuestions> findById(@PathVariable(value = "id") long id)
			throws ResourceNotFoundException {

		QuizQuestions quizQuestions = quizQuestionsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		return ResponseEntity.ok().body(quizQuestions);
	}

	// Add Quiz by Sham
	@CrossOrigin
	@PostMapping("/viewQuiz/{quizId}/quizQuestions")
	public QuizQuestions create(@PathVariable(value = "quizId") long quizId,
			@Valid @RequestBody QuizQuestions quizQuestions) throws ResourceNotFoundException {
		return quizRepository.findById(quizId).map(course -> {
			quizQuestions.setQuiz(course);
			return quizQuestionsRepository.save(quizQuestions);
		}).orElseThrow(() -> new ResourceNotFoundException("CourseId " + quizId + " not found"));
	}

	// Update By Sham
	@CrossOrigin
	@PutMapping("/viewQuiz/{quizId}/quizQuestions/{id}")
	public QuizQuestions updateQuiz(@PathVariable(value = "quizId") Long quizId, @PathVariable(value = "id") Long id,
			@Valid @RequestBody QuizQuestions quizQuestionsRequest) throws ResourceNotFoundException {
		if (!quizRepository.existsById(quizId)) {
			throw new ResourceNotFoundException("courseId not found");
		}

		return quizQuestionsRepository.findById(id).map(quiz -> {
			quiz.setQuizQuestion(quizQuestionsRequest.getQuizQuestion());
			quiz.setQuizAnswer1(quizQuestionsRequest.getQuizAnswer1());
			quiz.setQuizAnswer2(quizQuestionsRequest.getQuizAnswer2());
			quiz.setQuizAnswer3(quizQuestionsRequest.getQuizAnswer3());
			quiz.setQuizAnswer4(quizQuestionsRequest.getQuizAnswer4());
			quiz.setAnswerScores(quizQuestionsRequest.getAnswerScores());
			quiz.setCorrectAnswers(quizQuestionsRequest.getCorrectAnswers());
			return quizQuestionsRepository.save(quiz);
		}).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
	}

	// Delete Added By Sham 13-01-2020
	@CrossOrigin
	@DeleteMapping("/deletQuizQuestions/{id}")
	public Map<String, Boolean> deleteQuiz(@PathVariable(value = "id") Long Id) throws ResourceNotFoundException {
		QuizQuestions quizQuestions = quizQuestionsRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz not found for this id :: " + Id));
		quizQuestionsRepository.delete(quizQuestions);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
