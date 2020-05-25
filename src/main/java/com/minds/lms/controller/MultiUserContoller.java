package com.minds.lms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Announcement;
import com.minds.lms.model.AnnouncementUser;
import com.minds.lms.model.QuizQuestions;
import com.minds.lms.model.SystemRole;
import com.minds.lms.repository.AnnouncementRepository;
import com.minds.lms.repository.MultiUserRepository;

@RestController
public class MultiUserContoller {

	@Autowired
	MultiUserRepository multiUserRepository;

	@Autowired
	AnnouncementRepository announcementRepository;

	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewAnnouncementUser/{id}")
	public ResponseEntity<AnnouncementUser> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

		AnnouncementUser multiUser = multiUserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		return ResponseEntity.ok().body(multiUser);
	}

	// Add Announcement User by Sham
	@CrossOrigin
	@PostMapping("/viewAnnouncement/{announcementId}/anncouncementUser")
	public AnnouncementUser create(@PathVariable(value = "announcementId") long announcementId,
			@Valid @RequestBody AnnouncementUser multiUser) throws ResourceNotFoundException {
		return announcementRepository.findById(announcementId).map(course -> {
			multiUser.setAnnouncement(course);
			return multiUserRepository.save(multiUser);
		}).orElseThrow(() -> new ResourceNotFoundException("CourseId " + announcementId + " not found"));
	}

	// Update By Sham
		@CrossOrigin
		@PutMapping("/viewAnnouncement/{id}")
		public Announcement updateMultiUser(@PathVariable(value = "id") Long id, @Valid @RequestBody 
				Announcement AnnouncementRequest) throws ResourceNotFoundException {
			
			Announcement announcement= announcementRepository.findById(id)
			.orElseThrow(() -> (new ResourceNotFoundException("Announcement not found for this id : " + id)));
			
			announcement.setId(AnnouncementRequest.getId());
			announcement.setAnncouncementUser(AnnouncementRequest.getAnncouncementUser());
			announcement.setDescription(AnnouncementRequest.getDescription());
			announcement.setFileName(AnnouncementRequest.getFileName());
			announcement.setSubject(AnnouncementRequest.getSubject());
			announcement.setFileComment(announcement.getFileComment());
			
			Announcement updateannouncement = announcementRepository.save(announcement);

			return (Announcement) ResponseEntity.ok();
			
		}
}
