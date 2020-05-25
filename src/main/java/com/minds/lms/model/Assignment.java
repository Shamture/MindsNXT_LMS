package com.minds.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASSIGNMENT")
public class Assignment {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String description;
	private String maximumScore;
	private String selectAssignments;
	private String weightInsideAssignments;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMaximumScore() {
		return maximumScore;
	}
	public void setMaximumScore(String maximumScore) {
		this.maximumScore = maximumScore;
	}
	public String getSelectAssignments() {
		return selectAssignments;
	}
	public void setSelectAssignments(String selectAssignments) {
		this.selectAssignments = selectAssignments;
	}
	public String getWeightInsideAssignments() {
		return weightInsideAssignments;
	}
	public void setWeightInsideAssignments(String weightInsideAssignments) {
		this.weightInsideAssignments = weightInsideAssignments;
	}
	
}
