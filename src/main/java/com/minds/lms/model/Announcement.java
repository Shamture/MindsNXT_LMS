package com.minds.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ANNOUNCEMENT")
public class Announcement {

	@Id
	@GeneratedValue
	private long id;
	
	private String subject;
	private String user;
	private String description;
	@Lob
	private byte[] addAttachment;
	private String fileComment;
	
	public Announcement(String user, String description, String subject, String fileComment, byte[] addAttachment) {
		super();
		this.user = user;
		this.description = description;
		this.subject = subject;
		this.fileComment = fileComment;
		this.addAttachment = addAttachment;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFileComment() {
		return fileComment;
	}
	public void setFileComment(String fileComment) {
		this.fileComment = fileComment;
	}
	public byte[] getAddAttachment() {
		return addAttachment;
	}
	public void setAddAttachment(byte[] addAttachment) {
		this.addAttachment = addAttachment;
	}
}
