package com.minds.lms.springboot2jpacrud.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "user_model")

public class User {
	
	private long   id;
	
	
	
	
	@javax.validation.constraints.Email(message = "Email Format")
    private String username;
	
    private String firstname;
	
	private String lastname;
	private String language;
    private String organization;
    
    private String position;
    //@Size(min = 8)
    @Pattern(regexp = "[a-zA-Z0-9_.@]*")
	private String password;
  
	private String confirmPassword;
   
	private String generatePassword;
   
	private String passwordReset;
	private String notifyUser;
	private String startDate;
	private String endDate;
	private String voice;
	
	@Positive
	private long mobile ;
	private String fax;
	private String affiliation ;
	private String   street;
	
	
	private String   city;
	private String   country;
	private String   state;
	
	@Positive 
	private long postalCode;
	private String institutionalRoles;
	private String systemRoles;
	
	
	@javax.validation.constraints.Email(message = "")
	public String getInstitutionalRoles() {
		return institutionalRoles;
	}
	public void setInstitutionalRoles(String institutionalRoles) {
		this.institutionalRoles = institutionalRoles;
	}
	public String getSystemRoles() {
		return systemRoles;
	}
	public void setSystemRoles(String systemRoles) {
		this.systemRoles = systemRoles;
	}
	
		 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getGeneratePassword() {
		return generatePassword;
	}
	public void setGeneratePassword(String generatePassword) {
		this.generatePassword = generatePassword;
	}
	public String getPasswordReset() {
		return passwordReset;
	}
	public void setPasswordReset(String passwordReset) {
		this.passwordReset = passwordReset;
	}
	public String getNotifyUser() {
		return notifyUser;
	}
	public void setNotifyUser(String notifyUser) {
		this.notifyUser = notifyUser;
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
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}
		
	
		
		
}
