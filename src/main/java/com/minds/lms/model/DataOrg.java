package com.minds.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MultiDataOrg")
public class DataOrg {
		
	
	public DataOrg(){
		
	} 
	
	public DataOrg(String orgName) {
		super();
		this.setOrgName(orgName);
	}

	@Id
	@GeneratedValue
	private int id;
	private String orgName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@ManyToOne
	private Role role;
	
	
	@ManyToOne
	private InstituteRole instituterole;
	
	
	@ManyToOne
	private Content content;
	
	@ManyToOne
	private Discipline discipline;
	
	@ManyToOne
	private Course course;
	
	
	@ManyToOne
	private User user;
}
