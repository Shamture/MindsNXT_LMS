package com.minds.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quiz")

public class Quiz {
	
	@Id
	@GeneratedValue
	private int id;
	private String quizName;
	private String quizDescription;
	private String quizStartDate;
	private String quizEndDate;
	private String courseCode;
	/*private String createBy;
	private String createDate;
	private String modifiedBy;
	private String modifiedDate;
	private String deletedBy;
	private String deletedDate;*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public String getQuizDescription() {
		return quizDescription;
	}
	public void setQuizDescription(String quizDescription) {
		this.quizDescription = quizDescription;
	}
	public String getQuizStartDate() {
		return quizStartDate;
	}
	public void setQuizStartDate(String quizStartDate) {
		this.quizStartDate = quizStartDate;
	}
	public String getQuizEndDate() {
		return quizEndDate;
	}
	public void setQuizEndDate(String quizEndDate) {
		this.quizEndDate = quizEndDate;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	/*public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	public String getDeletedDate() {
		return deletedDate;
	}
	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}*/
	 
}
