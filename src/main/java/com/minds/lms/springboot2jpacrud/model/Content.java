package com.minds.lms.springboot2jpacrud.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="content_model")

public class Content {
	public Content(String name, String discription, String language, String ownerOrganizations, String type,
			String startDate, String endDate, String contactName, String contactNumber, byte[] pic) {
		super();
		this.name = name;
		this.discription = discription;
		this.language = language;
		OwnerOrganizations = ownerOrganizations;
		this.type = type;
		StartDate = startDate;
		EndDate = endDate;
		ContactName = contactName;
		ContactNumber = contactNumber;
		this.pic = pic;
	}

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
    
    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getOwnerOrganizations() {
		return OwnerOrganizations;
	}

	public void setOwnerOrganizations(String ownerOrganizations) {
		OwnerOrganizations = ownerOrganizations;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getContactName() {
		return ContactName;
	}

	public void setContactName(String contactName) {
		ContactName = contactName;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	@Column(name = "OwnerOrganizations")
   	private String OwnerOrganizations;
    
    @Column(name = "type")
   	private String type;
    
    @Column(name = "StartDate")
   	private String StartDate;
    
    @Column(name = "EndDate")
   	private String EndDate; 
    
    @Column(name = "ContactName")
   	private String ContactName; 
    
    @Column(name = "ContactNumber")
   	private String ContactNumber; 
    
    
    
    
	@Lob
    @Column(name="pic")
    private byte[] pic;
	
	public Content(){}
	
	
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
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
	
	public byte[] getPic(){
		return this.pic;
	}
	
	public void setPic(byte[] pic){
		this.pic = pic;
	}
}