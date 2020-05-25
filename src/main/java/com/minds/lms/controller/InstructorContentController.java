package com.minds.lms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Category;
import com.minds.lms.model.Content;
import com.minds.lms.model.DataOrg;
import com.minds.lms.model.InstructorContent;
import com.minds.lms.model.MultiDataCont;
import com.minds.lms.repository.FileRepository;
import com.minds.lms.repository.InstructorFileRepository;
import com.minds.lms.repository.MultiOrgDataRepository;
 
@RestController

public class InstructorContentController {
	
	@Autowired
	InstructorFileRepository fileRepository;
	
	@Autowired
	MultiOrgDataRepository multOrgRepo;
 
    /*
     * MultipartFile Upload
     */
	 @CrossOrigin
    @PostMapping("/addInstructorContent")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file , @ModelAttribute  InstructorContent filemodel) {
		 if(filemodel.getOwnerOrganizations()!= null) {
	            //you are saving all the nested tags manually before saving the activity
	            for(DataOrg t : filemodel.getOwnerOrganizations()) {
	            	multOrgRepo.save(t);
	            }
	        }
		 try {
    		// save file to PostgreSQL
			 InstructorContent filemode = new InstructorContent(
	    			filemodel.getName(), 
	    			filemodel.getDiscription(),
	    			filemodel.getLanguage(),
	    			filemodel.getOwnerOrganizations(),
	    			filemodel.getStatus(),
	    			filemodel.getType(),
	    			filemodel.getStartDate(),
	    			filemodel.getEndDate(),
	    			filemodel.getContactName(),
	    			filemodel.getContactNumber(),
	    			file.getBytes());
	    	
	    	
	    	fileRepository.save(filemode);
	    	//return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	    	
	    	return "File uploaded successfully! -> filename = " + filemodel.getStatus();
		} catch (	Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}    
    }
    
    
    
    @CrossOrigin
    @GetMapping("/viewAllInstructorContent")
    public List<InstructorContent> getAllContentFiles() {
        return fileRepository.findAll();
    }
    
    
    @CrossOrigin
    @GetMapping("/viewInstructorContentById/{id}")
    public ResponseEntity<InstructorContent> getContentFilesById(@PathVariable(value = "id") Long fileId)
        throws ResourceNotFoundException {
    	InstructorContent filemodel = fileRepository.findById(fileId)
          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + fileId));
        return ResponseEntity.ok().body(filemodel);
    }
    
    @CrossOrigin
    @DeleteMapping("/deleteInstructorContent/{id}")
    public Map<String, Boolean> deleteContent(@PathVariable(value = "id") Long fileId)
         throws ResourceNotFoundException {
    	InstructorContent file = fileRepository.findById(fileId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + fileId));
	  fileRepository.delete(file);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Course Content File has deleted Successfully ", Boolean.TRUE);
        return response;
    }
    
   
    @CrossOrigin
    @PutMapping("/upadteInstructorContent/{id}") 
    public ResponseEntity<InstructorContent> updateContentFile(@PathVariable(value = "id") Long fileId, @ModelAttribute InstructorContent fileDetails , @RequestParam("uploadfile") MultipartFile file) throws ResourceNotFoundException, IOException {
    	InstructorContent filemodel = fileRepository.findById(fileId)
        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + fileId));
    	filemodel.setName(fileDetails.getName());
    	filemodel.setDiscription(fileDetails.getDiscription());
    	filemodel.setPic(file.getBytes());
    	filemodel.setContactName(fileDetails.getContactName());
        final InstructorContent updateFiles = fileRepository.save(filemodel);
        return ResponseEntity.ok(updateFiles);
    }
  
    
    @CrossOrigin
    @GetMapping(value = "/searchInstructorContentByAll/{name}/{status}/{type}")
    public List<InstructorContent> findByNameAndStatusAndType(@PathVariable("name") String name, @PathVariable("status") String status,@PathVariable("type") String type ){
	return fileRepository.findByNameAndStatusAndType(name,status,type);
    }
    
    
    @CrossOrigin
    @GetMapping(value = "/searchInstructorContentByName/{name}")
    public List<InstructorContent> findByName(@PathVariable("name") String name){
	return fileRepository.findByName(name);
    }
    
    @CrossOrigin
    @GetMapping(value = "/searchInstructorContentByStatus/{status}")
    public List<InstructorContent> findBySatus(@PathVariable("status") String status){
	return fileRepository.findByStatus(status);
    }
    
	
    
    
}