package com.minds.lms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "course_model")

public class Course {
	
	    
	    
	    /*public Course(String organizations, String code, String name, long tuition, String description, String duration,
				String targetedLearners, String deliveryMethod, boolean approvalRequired,
				String courseCompletionCertificate, String language, String notes, String courseDisplayDate,
				String enrollmentOpenDate, String enrollmentCloseDate, String courseHideDate,
				String certificationCalculationDate, long daysStdToCompl, long daysBeforeStdToCompl, long expireDays,
				long remindStudent, String enrollmentRestriction, String accumulateCredit, String credit,
				String instructionalLanguages, String version, String allowUseOfInterestLists) {
			super();
			Organizations = organizations;
			Code = code;
			Name = name;
			Tuition = tuition;
			Description = description;
			Duration = duration;
			TargetedLearners = targetedLearners;
			DeliveryMethod = deliveryMethod;
			ApprovalRequired = approvalRequired;
			courseCompletionCertificate = courseCompletionCertificate;
			Language = language;
			Notes = notes;
			CourseDisplayDate = courseDisplayDate;
			EnrollmentOpenDate = enrollmentOpenDate;
			EnrollmentCloseDate = enrollmentCloseDate;
			CourseHideDate = courseHideDate;
			CertificationCalculationDate = certificationCalculationDate;
			DaysStdToCompl = daysStdToCompl;
			DaysBeforeStdToCompl = daysBeforeStdToCompl;
			ExpireDays = expireDays;
			RemindStudent = remindStudent;
			EnrollmentRestriction = enrollmentRestriction;
			AccumulateCredit = accumulateCredit;
			Credit = credit;
			InstructionalLanguages = instructionalLanguages;
			Version = version;
			AllowUseOfInterestLists = allowUseOfInterestLists;
		}*/
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
		private long   id;
	 
	 
	 
	    @OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="course_id")
		private List<DataOrg> organizations;
	 
	    
	    
	    
	    @OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="content_id")
		private List<MultiDataCont> content;
	    
	    
	    private String code;
		private String name;
		private long   tuition;
	    private String description;
	    private String duration;
		private String targetedLearners;
		private String deliveryMethod;
		private String approvalRequired;
		private String courseCompletionCertificate;
		private String status;
		private String language;
		private String notes;
		private String courseDisplayDate;
		private String enrollmentOpenDate;
		private String enrollmentCloseDate ;
		private String courseHideDate;
		private String certificationCalculationDate;
		private long   daysStdToCompl;
		private long   daysBeforeStdToCompl;
		private long   expireDays;
		private long   remindStudent;
		private String enrollmentRestriction;
		private String accumulateCredit;
		private String credit;
		private String instructionalLanguages;
		private String version;
		private String allowUseOfInterestLists;
		private String canRelaunch;
		private String contentType;
		private String resourceContent;
		private String selfCertifiedCompletion;
		private String major;
		
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public List<DataOrg> getOrganizations() {
			return organizations;
		}
		public void setOrganizations(List<DataOrg> organizations) {
			this.organizations = organizations;
		}
		public List<MultiDataCont> getContent() {
			return content;
		}
		public void setContent(List<MultiDataCont> content) {
			this.content = content;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getTuition() {
			return tuition;
		}
		public void setTuition(long tuition) {
			this.tuition = tuition;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public String getTargetedLearners() {
			return targetedLearners;
		}
		public void setTargetedLearners(String targetedLearners) {
			this.targetedLearners = targetedLearners;
		}
		public String getDeliveryMethod() {
			return deliveryMethod;
		}
		public void setDeliveryMethod(String deliveryMethod) {
			this.deliveryMethod = deliveryMethod;
		}
		public String getApprovalRequired() {
			return approvalRequired;
		}
		public void setApprovalRequired(String approvalRequired) {
			this.approvalRequired = approvalRequired;
		}
		public String getCourseCompletionCertificate() {
			return courseCompletionCertificate;
		}
		public void setCourseCompletionCertificate(String courseCompletionCertificate) {
			this.courseCompletionCertificate = courseCompletionCertificate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public String getCourseDisplayDate() {
			return courseDisplayDate;
		}
		public void setCourseDisplayDate(String courseDisplayDate) {
			this.courseDisplayDate = courseDisplayDate;
		}
		public String getEnrollmentOpenDate() {
			return enrollmentOpenDate;
		}
		public void setEnrollmentOpenDate(String enrollmentOpenDate) {
			this.enrollmentOpenDate = enrollmentOpenDate;
		}
		public String getEnrollmentCloseDate() {
			return enrollmentCloseDate;
		}
		public void setEnrollmentCloseDate(String enrollmentCloseDate) {
			this.enrollmentCloseDate = enrollmentCloseDate;
		}
		public String getCourseHideDate() {
			return courseHideDate;
		}
		public void setCourseHideDate(String courseHideDate) {
			this.courseHideDate = courseHideDate;
		}
		public String getCertificationCalculationDate() {
			return certificationCalculationDate;
		}
		public void setCertificationCalculationDate(String certificationCalculationDate) {
			this.certificationCalculationDate = certificationCalculationDate;
		}
		public long getDaysStdToCompl() {
			return daysStdToCompl;
		}
		public void setDaysStdToCompl(long daysStdToCompl) {
			this.daysStdToCompl = daysStdToCompl;
		}
		public long getDaysBeforeStdToCompl() {
			return daysBeforeStdToCompl;
		}
		public void setDaysBeforeStdToCompl(long daysBeforeStdToCompl) {
			this.daysBeforeStdToCompl = daysBeforeStdToCompl;
		}
		public long getExpireDays() {
			return expireDays;
		}
		public void setExpireDays(long expireDays) {
			this.expireDays = expireDays;
		}
		public long getRemindStudent() {
			return remindStudent;
		}
		public void setRemindStudent(long remindStudent) {
			this.remindStudent = remindStudent;
		}
		public String getEnrollmentRestriction() {
			return enrollmentRestriction;
		}
		public void setEnrollmentRestriction(String enrollmentRestriction) {
			this.enrollmentRestriction = enrollmentRestriction;
		}
		public String getAccumulateCredit() {
			return accumulateCredit;
		}
		public void setAccumulateCredit(String accumulateCredit) {
			this.accumulateCredit = accumulateCredit;
		}
		public String getCredit() {
			return credit;
		}
		public void setCredit(String credit) {
			this.credit = credit;
		}
		public String getInstructionalLanguages() {
			return instructionalLanguages;
		}
		public void setInstructionalLanguages(String instructionalLanguages) {
			this.instructionalLanguages = instructionalLanguages;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
		public String getAllowUseOfInterestLists() {
			return allowUseOfInterestLists;
		}
		public void setAllowUseOfInterestLists(String allowUseOfInterestLists) {
			this.allowUseOfInterestLists = allowUseOfInterestLists;
		}
		public String getCanRelaunch() {
			return canRelaunch;
		}
		public void setCanRelaunch(String canRelaunch) {
			this.canRelaunch = canRelaunch;
		}
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		public String getResourceContent() {
			return resourceContent;
		}
		public void setResourceContent(String resourceContent) {
			this.resourceContent = resourceContent;
		}
		public String getSelfCertifiedCompletion() {
			return selfCertifiedCompletion;
		}
		public void setSelfCertifiedCompletion(String selfCertifiedCompletion) {
			this.selfCertifiedCompletion = selfCertifiedCompletion;
		}
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		
		 
		
		
		
		
	    
		
		
}
