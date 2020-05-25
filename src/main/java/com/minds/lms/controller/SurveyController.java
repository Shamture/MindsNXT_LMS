
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
import com.minds.lms.model.QuizQuestions;
import com.minds.lms.model.Survey;
import com.minds.lms.model.SurveyQuestions;
import com.minds.lms.repository.CourseRepository;
import com.minds.lms.repository.SurveyQuestionsRepository;
import com.minds.lms.repository.SurveyRepository;

@RestController
public class SurveyController {
	@Autowired
	SurveyRepository surveyRepository;

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	SurveyQuestionsRepository surveyQuestionsRepository;

	/*
	 * @CrossOrigin
	 * 
	 * @GetMapping("/viewSurveys") public List<Survey> getAllTerms() { return
	 * surveyRepository.findAll(); }
	 * 
	 * 
	 * 
	 * @CrossOrigin
	 * 
	 * @PostMapping("/addSurvey") public Survey create(@RequestBody Survey
	 * input) { return surveyRepository.save(input); }
	 * 
	 * @CrossOrigin
	 * 
	 * @DeleteMapping("deletSurvey/{id}") public String
	 * deleteSystemRoles(@PathVariable(value ="id") long id){
	 * 
	 * surveyRepository.deleteById(id);
	 * 
	 * return "Deleted" ;
	 * 
	 * }
	 */

	/*
	 * @CrossOrigin
	 * 
	 * @PutMapping("updateSurvey/{id}") public ResponseEntity<Survey>
	 * updateSystemRoles(@PathVariable (value = "id") long id , @RequestBody
	 * Survey roledetails) throws ResourceNotFoundException{
	 * 
	 * Survey role = surveyRepository.findById(id).orElseThrow(()->(new
	 * ResourceNotFoundException("User not found for this id : "+id)));
	 * 
	 * 
	 * role.setTermName(roledetails.getTermName());
	 * role.setTermDescription(roledetails.getTermDescription());
	 * role.setStartDate(roledetails.getStartDate());
	 * role.setLanguage(roledetails.getLanguage());
	 * role.setEndDate(roledetails.getEndDate()); Term updaterole =
	 * surveyRepository.save(role);
	 * 
	 * return ResponseEntity.ok(updaterole);
	 * 
	 * }
	 */

	/*
	 * @CrossOrigin
	 * 
	 * @GetMapping("searchSurvey/{termName}")
	 * 
	 * public List<Term> findByTerms(@PathVariable(value = "termName") String
	 * termName){
	 * 
	 * return surveyRepository.findByTermName(termName);
	 * 
	 * }
	 */

	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewSurvey/{id}")
	public ResponseEntity<Survey> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

		Survey role = surveyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		return ResponseEntity.ok().body(role);
	}

	// Add Quiz by Sham
	@CrossOrigin
	@PostMapping("/viewAllCourses/{courseId}/survey")
	public Survey create(@PathVariable(value = "courseId") long courseId, @Valid @RequestBody Survey survey)
			throws ResourceNotFoundException {
		return courseRepository.findById(courseId).map(course -> {
			survey.setCourse(course);
			return surveyRepository.save(survey);
		}).orElseThrow(() -> new ResourceNotFoundException("CourseId " + courseId + " not found"));
	}

	// Update By Sham
	@CrossOrigin
	@PutMapping("/viewAllCourses/{courseId}/survey/{id}")
	public Survey updateQuiz(@PathVariable(value = "courseId") Long courseId, @PathVariable(value = "id") Long id,
			@Valid @RequestBody Survey surveyRequest) throws ResourceNotFoundException {
		if (!courseRepository.existsById(courseId)) {
			throw new ResourceNotFoundException("courseId not found");
		}

		return surveyRepository.findById(id).map(survey -> {
			survey.setSurveyCode(surveyRequest.getSurveyCode());
			survey.setSurveyTitle(surveyRequest.getSurveyTitle());
			survey.setSurveyDescription(surveyRequest.getSurveyDescription());
			survey.setSurveyStartDate(surveyRequest.getSurveyStartDate());
			survey.setSurveyEndDate(surveyRequest.getSurveyEndDate());
			return surveyRepository.save(survey);
		}).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
	}

	// Delete Added By Sham 13-01-2020
	@CrossOrigin
	@DeleteMapping("/deletSurvey/{id}")
	public Map<String, Boolean> deleteSurvey(@PathVariable(value = "id") Long Id) throws ResourceNotFoundException {
		Survey survey = surveyRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz not found for this id :: " + Id));
		surveyRepository.delete(survey);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@CrossOrigin
	@GetMapping(value = "/viewSurvey/{surveyId}/surveyQuestions")
	public List<SurveyQuestions> findBySurvey(@PathVariable("surveyId") long id) {
		return surveyQuestionsRepository.findBySurveyId(id);
	}

}
