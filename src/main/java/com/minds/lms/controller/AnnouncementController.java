package com.minds.lms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Announcement;
import com.minds.lms.repository.AnnouncementRepository;
 
@RestController

public class AnnouncementController {
	
	@Autowired
	AnnouncementRepository announcementRepository;
	
	 
    /*
     * MultipartFile Upload
     */
	 @CrossOrigin
    @PostMapping("/addAnnouncement")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file , @ModelAttribute  Announcement announcementmodel) {
		/* if(filemodel.getOwnerOrganizations()!= null) {
	            //you are saving all the nested tags manually before saving the activity
	            for(DataOrg t : filemodel.getOwnerOrganizations()) {
	            	multOrgRepo.save(t);
	            }
	        }*/
		 try {
    		// save file to PostgreSQL
	    	Announcement announcement = new Announcement(
	    			announcementmodel.getUser(), 
	    			announcementmodel.getDescription(),
	    			announcementmodel.getSubject(),
	    			announcementmodel.getFileComment(),
	    			file.getBytes());
	    	
	    	
	    	announcementRepository.save(announcement);
	    	//return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	    	
	    	return "File uploaded successfully! ->";
		} catch (	Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}    
    }
    
    
    
    @CrossOrigin
    @GetMapping("/viewAllAnnouncement")
    public List<Announcement> getAllAnnouncementFiles() {
        return announcementRepository.findAll();
    }
    
    
    @CrossOrigin
    @GetMapping("/viewAnnouncementById/{id}")
    public ResponseEntity<Announcement> getAnnouncementFilesById(@PathVariable(value = "id") Long fileId)
        throws ResourceNotFoundException {
    	Announcement announcementmodel = announcementRepository.findById(fileId)
          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + fileId));
        return ResponseEntity.ok().body(announcementmodel);
    }
    
    @CrossOrigin
    @DeleteMapping("/deleteAnnouncement/{id}")
    public Map<String, Boolean> deleteAnnouncement(@PathVariable(value = "id") Long fileId)
         throws ResourceNotFoundException {
    	Announcement file = announcementRepository.findById(fileId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + fileId));
	  announcementRepository.delete(file);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Course Announcement File has deleted Successfully ", Boolean.TRUE);
        return response;
    }
    
   
    @CrossOrigin
    @PutMapping("/upadteAnnouncement/{id}") 
    public ResponseEntity<Announcement> updateAnnouncementFile(@PathVariable(value = "id") Long fileId, @ModelAttribute Announcement announcementDetails , @RequestParam("uploadfile") MultipartFile file) throws ResourceNotFoundException, IOException {
    	Announcement filemodel = announcementRepository.findById(fileId)
        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + fileId));
    	filemodel.setUser(announcementDetails.getUser());
    	filemodel.setSubject(announcementDetails.getSubject());
    	filemodel.setDescription(announcementDetails.getDescription());
    	filemodel.setFileComment(announcementDetails.getFileComment());
    	filemodel.setAddAttachment(file.getBytes());
        final Announcement updateFiles = announcementRepository.save(filemodel);
        return ResponseEntity.ok(updateFiles);
    }
  
    
  /*  @CrossOrigin
    @GetMapping(value = "/searchAnnouncement/{name}/{status}/{type}")
    public List<Announcement> findByNameAndStatusAndType(@PathVariable("name") String name, @PathVariable("status") String status,@PathVariable("type") String type ){
	return announcementRepository.findByNameAndStatusAndType(name,status,type);
    }
    
    
    @CrossOrigin
    @GetMapping(value = "/searchAnnouncementByUser/{user}")
    public List<Announcement> findByName(@PathVariable("name") String user){
	return announcementRepository.findByUser(user);
    }
    
    @CrossOrigin
    @GetMapping(value = "/searchAnnouncement/{status}")
    public List<Announcement> findBySatus(@PathVariable("status") String status){
	return announcementRepository.findByStatus(status);
    }
    */
	
    
    
}