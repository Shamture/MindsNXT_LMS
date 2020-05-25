package com.minds.lms.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "StudentAssignment")
public class StudentAssignment {

	@JsonIgnore
	@EmbeddedId
	private StudentAssignmentPK id = new StudentAssignmentPK();
	
	private String userName;
	private String fileName;
	private String fileType;
	private String status;
	private long maxScore;
	private long obtainedScore;
	private String feedback;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("assignment_id")
	@JoinColumn(name = "assignment_id", referencedColumnName = "id")
	private Assignment assignment;

	@JsonIgnore
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public StudentAssignmentPK getId() {
		return id;
	}

	public void setId(StudentAssignmentPK id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(long maxScore) {
		this.maxScore = maxScore;
	}

	public long getObtainedScore() {
		return obtainedScore;
	}

	public void setObtainedScore(long obtainedScore) {
		this.obtainedScore = obtainedScore;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
