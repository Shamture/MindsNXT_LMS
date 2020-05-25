package com.minds.lms.springboot2jpacrud.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="category_model")

public class Category {


	@Id
	@GeneratedValue
    @Column(name = "id")
	@JsonView(View.FileInfo.class)
    private Long id;
	
    @Column(name = "name")
    @JsonView(View.FileInfo.class)
	private String name;
    
    @Column(name = "discription")
	private String discription;
	
    @Column(name = "language")
	private String language;
    
    
    @Column(name = "StartDate")
   	private String StartDate;
    
    @Column(name = "EndDate")
   	private String EndDate; 

	@Column(name = "Lms")
   	private String Lms;
    
    @Column(name = "searchable")
   	private String searchable ; 
    
    
    
    public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
    
    public String getLms() {
		return Lms;
	}

	public void setLms(String lms) {
		Lms = lms;
	}

	public String getSearchable() {
		return searchable;
	}

	public void setSearchable(String searchable) {
		this.searchable = searchable;
	}

    
        
    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDiscription(){
		return this.discription;
	}
	
	public void setDiscription(String discription){
		this.discription = discription;
	}
	
	
}