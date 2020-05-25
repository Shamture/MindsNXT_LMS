package com.minds.lms.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRIVILEGES")
public class Privilege {
	@EmbeddedId
	PrivilegesEntity privilegesEntity;
	
	private String name;
	private String description;
	private String status;
	
	public PrivilegesEntity getPrivilegesEntity() {
		return privilegesEntity;
	}
	public void setPrivilegesEntity(PrivilegesEntity privilegesEntity) {
		this.privilegesEntity = privilegesEntity;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
