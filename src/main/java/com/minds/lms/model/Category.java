package com.minds.lms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

@Entity
@Table(name = "CATEGORY")

public class Category {
	
	public Category(String name, String description, String language, String lms,
			String startDate, String endDate, String isCategorySearchable, String status, List<MultiDataCont> content) {
		super();
		this.name = name;
		this.description = description;
		this.language = language;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lms =lms;
		this.isCategorySearchable = isCategorySearchable;
		this.status = status;
		this.content = content;
	}
	
	

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String  description;

	private String language;

	private String startDate;

	private String endDate;

	private String lms;

	private String isCategorySearchable;
		
	private String status;
		
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	private List<MultiDataCont> content;
	
	public List<MultiDataCont> getContent() {
		return content;
	}

	public void setContent(List<MultiDataCont> content) {
		this.content = content;
	}



	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLms() {
		return lms;
	}

	public void setLms(String lms) {
		this.lms = lms;
	}



	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	 public Category() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsCategorySearchable() {
		return isCategorySearchable;
	}

	public void setIsCategorySearchable(String isCategorySearchable) {
		this.isCategorySearchable = isCategorySearchable;
	}

	
	
}