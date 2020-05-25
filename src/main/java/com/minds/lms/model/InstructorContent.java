package com.minds.lms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Instructor_Content")

public class InstructorContent {
	public InstructorContent(String name, String discription, String language, List<DataOrg> ownerOrganizations,String status, String type,
			String startDate, String endDate, String contactName, String contactNumber, byte[] pic) {
		super();
		this.name = name;
		this.discription = discription;
		this.language = language;
		this.ownerOrganizations = ownerOrganizations;
		this.status = status;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.pic = pic;
	}

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String discription;

	private String language;

	private String type;
	
	private String status;

	private String startDate;

	private String endDate;

	private String contactName;

	private String contactNumber;

	@Lob
	private byte[] pic;
	
		
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="instacontent_id")
	private List<DataOrg> ownerOrganizations;

	public InstructorContent() {
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public List<DataOrg> getOwnerOrganizations() {
		return ownerOrganizations;
	}

	public void setOwnerOrganizations(List<DataOrg> ownerOrganizations) {
		this.ownerOrganizations = ownerOrganizations;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}