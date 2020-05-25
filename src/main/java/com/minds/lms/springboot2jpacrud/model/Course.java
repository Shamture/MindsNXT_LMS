package com.minds.lms.springboot2jpacrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "coursedetails")

public class Course {
	
	    private long   id;
	    private String Organizations;
	    private String Code;
		private String Name;
		private long   Tuition;
	    private String Description;
	    private String Duration;
		private String TargetedLearners;
		private String DeliveryMethod;
		private String ApprovalRequired;
		private String CourseCompletionCertificate;
		private String Language;
		private String Notes;
		private String CourseDisplayDate;
		private String EnrollmentOpenDate;
		private String EnrollmentCloseDate ;
		private String CourseHideDate;
		private String CertificationCalculationDate;
		private long   DaysStdToCompl;
		private long   DaysBeforeStdToCompl;
		private long   ExpireDays;
		private long   RemindStudent;
		private String EnrollmentRestriction;
		private String AccumulateCredit;
		private String Credit;
		private String InstructionalLanguages;
		private String Version;
		private String AllowUseOfInterestLists;
		
		

		 @Id
		 @GeneratedValue(strategy = GenerationType.AUTO)
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getOrganizations() {
			return Organizations;
		}
		public void setOrganizations(String organizations) {
			Organizations = organizations;
		}
		public String getCode() {
			return Code;
		}
		public void setCode(String code) {
			Code = code;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public long getTuition() {
			return Tuition;
		}
		public void setTuition(long tuition) {
			Tuition = tuition;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getDuration() {
			return Duration;
		}
		public void setDuration(String duration) {
			Duration = duration;
		}
		public String getTargetedLearners() {
			return TargetedLearners;
		}
		public void setTargetedLearners(String targetedLearners) {
			TargetedLearners = targetedLearners;
		}
		public String getDeliveryMethod() {
			return DeliveryMethod;
		}
		public void setDeliveryMethod(String deliveryMethod) {
			DeliveryMethod = deliveryMethod;
		}
		public String getApprovalRequired() {
			return ApprovalRequired;
		}
		public void setApprovalRequired(String approvalRequired) {
			ApprovalRequired = approvalRequired;
		}
		public String getCourseCompletionCertificate() {
			return CourseCompletionCertificate;
		}
		public void setCourseCompletionCertificate(String courseCompletionCertificate) {
			CourseCompletionCertificate = courseCompletionCertificate;
		}
		public String getLanguage() {
			return Language;
		}
		public void setLanguage(String language) {
			Language = language;
		}
		public String getNotes() {
			return Notes;
		}
		public void setNotes(String notes) {
			Notes = notes;
		}
		public String getCourseDisplayDate() {
			return CourseDisplayDate;
		}
		public void setCourseDisplayDate(String courseDisplayDate) {
			CourseDisplayDate = courseDisplayDate;
		}
		public String getEnrollmentOpenDate() {
			return EnrollmentOpenDate;
		}
		public void setEnrollmentOpenDate(String enrollmentOpenDate) {
			EnrollmentOpenDate = enrollmentOpenDate;
		}
		public String getEnrollmentCloseDate() {
			return EnrollmentCloseDate;
		}
		public void setEnrollmentCloseDate(String enrollmentCloseDate) {
			EnrollmentCloseDate = enrollmentCloseDate;
		}
		public String getCourseHideDate() {
			return CourseHideDate;
		}
		public void setCourseHideDate(String courseHideDate) {
			CourseHideDate = courseHideDate;
		}
		public String getCertificationCalculationDate() {
			return CertificationCalculationDate;
		}
		public void setCertificationCalculationDate(String certificationCalculationDate) {
			CertificationCalculationDate = certificationCalculationDate;
		}
		public long getDaysStdToCompl() {
			return DaysStdToCompl;
		}
		public void setDaysStdToCompl(long daysStdToCompl) {
			DaysStdToCompl = daysStdToCompl;
		}
		public long getDaysBeforeStdToCompl() {
			return DaysBeforeStdToCompl;
		}
		public void setDaysBeforeStdToCompl(long daysBeforeStdToCompl) {
			DaysBeforeStdToCompl = daysBeforeStdToCompl;
		}
		public long getExpireDays() {
			return ExpireDays;
		}
		public void setExpireDays(long expireDays) {
			ExpireDays = expireDays;
		}
		public long getRemindStudent() {
			return RemindStudent;
		}
		public void setRemindStudent(long remindStudent) {
			RemindStudent = remindStudent;
		}
		public String getEnrollmentRestriction() {
			return EnrollmentRestriction;
		}
		public void setEnrollmentRestriction(String enrollmentRestriction) {
			EnrollmentRestriction = enrollmentRestriction;
		}
		public String getAccumulateCredit() {
			return AccumulateCredit;
		}
		public void setAccumulateCredit(String accumulateCredit) {
			AccumulateCredit = accumulateCredit;
		}
		public String getCredit() {
			return Credit;
		}
		public void setCredit(String credit) {
			Credit = credit;
		}
		public String getInstructionalLanguages() {
			return InstructionalLanguages;
		}
		public void setInstructionalLanguages(String instructionalLanguages) {
			InstructionalLanguages = instructionalLanguages;
		}
		public String getVersion() {
			return Version;
		}
		public void setVersion(String version) {
			Version = version;
		}
		public String getAllowUseOfInterestLists() {
			return AllowUseOfInterestLists;
		}
		public void setAllowUseOfInterestLists(String allowUseOfInterestLists) {
			AllowUseOfInterestLists = allowUseOfInterestLists;
		}
		
		
		
		
	    
		
		
}
