package com.minds.lms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SurveyQuestions")
public class SurveyQuestions {

	@Id
	@GeneratedValue
	private long id;
	private String surveyQuestionTitle;
	private String surveyQuestionType;
	private String surveyQuestionOption;
	private String surveyAnswerOption1;
	private String surveyAnswerOption2;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "survey_id", nullable = false)
	private Survey survey;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurveyQuestionTitle() {
		return surveyQuestionTitle;
	}

	public void setSurveyQuestionTitle(String surveyQuestionTitle) {
		this.surveyQuestionTitle = surveyQuestionTitle;
	}

	public String getSurveyQuestionType() {
		return surveyQuestionType;
	}

	public void setSurveyQuestionType(String surveyQuestionType) {
		this.surveyQuestionType = surveyQuestionType;
	}

	public String getSurveyQuestionOption() {
		return surveyQuestionOption;
	}

	public void setSurveyQuestionOption(String surveyQuestionOption) {
		this.surveyQuestionOption = surveyQuestionOption;
	}

	public String getSurveyAnswerOption1() {
		return surveyAnswerOption1;
	}

	public void setSurveyAnswerOption1(String surveyAnswerOption1) {
		this.surveyAnswerOption1 = surveyAnswerOption1;
	}

	public String getSurveyAnswerOption2() {
		return surveyAnswerOption2;
	}

	public void setSurveyAnswerOption2(String surveyAnswerOption2) {
		this.surveyAnswerOption2 = surveyAnswerOption2;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
}
