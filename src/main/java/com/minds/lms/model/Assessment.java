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
@Table(name = "ASSESSMENT")
public class Assessment {

	@Id
	@GeneratedValue
	private long id;

	private String assessmentName;
	private String assessmentTotalWeight;
	private String assessmentDescription;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getAssessmentTotalWeight() {
		return assessmentTotalWeight;
	}

	public void setAssessmentTotalWeight(String assessmentTotalWeight) {
		this.assessmentTotalWeight = assessmentTotalWeight;
	}

	public String getAssessmentDescription() {
		return assessmentDescription;
	}

	public void setAssessmentDescription(String assessmentDescription) {
		this.assessmentDescription = assessmentDescription;
	}

	@JsonIgnore
	public Course getCourse() {
		return course;
	}

	@JsonIgnore
	public void setCourse(Course course) {
		this.course = course;
	}

}
