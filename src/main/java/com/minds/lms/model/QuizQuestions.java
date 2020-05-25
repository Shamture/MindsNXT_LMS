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
@Table(name = "QuizQuestions")
public class QuizQuestions {

	@Id
	@GeneratedValue
	private long id;
	private String quizQuestion;
	private String quizAnswer1;
	private String quizAnswer2;
	private String quizAnswer3;
	private String quizAnswer4;
	private String correctAnswers;
	private int answerScores;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id", nullable = false)
	private Quiz quiz;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuizQuestion() {
		return quizQuestion;
	}

	public void setQuizQuestion(String quizQuestion) {
		this.quizQuestion = quizQuestion;
	}

	public String getQuizAnswer1() {
		return quizAnswer1;
	}

	public void setQuizAnswer1(String quizAnswer1) {
		this.quizAnswer1 = quizAnswer1;
	}

	public String getQuizAnswer2() {
		return quizAnswer2;
	}

	public void setQuizAnswer2(String quizAnswer2) {
		this.quizAnswer2 = quizAnswer2;
	}

	public String getQuizAnswer3() {
		return quizAnswer3;
	}

	public void setQuizAnswer3(String quizAnswer3) {
		this.quizAnswer3 = quizAnswer3;
	}

	public String getQuizAnswer4() {
		return quizAnswer4;
	}

	public void setQuizAnswer4(String quizAnswer4) {
		this.quizAnswer4 = quizAnswer4;
	}

	public String getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(String correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getAnswerScores() {
		return answerScores;
	}

	public void setAnswerScores(int answerScores) {
		this.answerScores = answerScores;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}
