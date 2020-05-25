package com.minds.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MultiDataCont")
public class MultiDataCont {

	@Id
	@GeneratedValue
	private int id;
	private String contName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	@ManyToOne
	private Category category;

	public MultiDataCont(String contName) {
		this.contName = contName;
	

	}

	public MultiDataCont() {

	}

}
