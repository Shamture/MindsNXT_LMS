package com.minds.lms.springboot2jpacrud.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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

import com.minds.lms.springboot2jpacrud.exception.ResourceNotFoundException;

import com.minds.lms.springboot2jpacrud.model.Content;
import com.minds.lms.springboot2jpacrud.repository.FileRepository;
 
@RestController

public class ContentController {
	
	@Autowired
	FileRepository fileRepository;
 
    /*
     * MultipartFile Upload
     */
    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file , @ModelAttribute  Content filemodel ) {
    	try {
    		// save file to PostgreSQL
	    	Content filemode = new Content(
	    			filemodel.getName(), 
	    			filemodel.getDiscription(),
	    			filemodel.getLanguage(),
	    			filemodel.getOwnerOrganizations(),
	    			filemodel.getType(),
	    			filemodel.getStartDate(),
	    			filemodel.getEndDate(),
	    			filemodel.getContactName(),
	    			filemodel.getContactNumber(),
	    			file.getBytes());
	    	
	    	
	    	fileRepository.save(filemode);
	    	return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (	Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}    
    }
    
    
    
    
    
    @GetMapping("/allfiles")
    public List<Content> getAllContentFiles() {
        return fileRepository.findAll();
    }
    
    
    
    @GetMapping("/files/{id}")
    public ResponseEntity<Content> getContentFilesById(@PathVariable(value = "id") Long fileId)
        throws ResourceNotFoundException {
    	Content filemodel = fileRepository.findById(fileId)
          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + fileId));
        return ResponseEntity.ok().body(filemodel);
    }
    
    @DeleteMapping("/files/{id}")
    public Map<String, Boolean> deleteContent(@PathVariable(value = "id") Long fileId)
         throws ResourceNotFoundException {
    	Content file = fileRepository.findById(fileId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + fileId));
	  fileRepository.delete(file);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Course Content File has deleted Successfully ", Boolean.TRUE);
        return response;
    }
    
    
    
    
    
    
    
    
    @PutMapping("/files/{id}") 
    public ResponseEntity<Content> updateContentFile(@PathVariable(value = "id") Long fileId, @ModelAttribute Content fileDetails , @RequestParam("uploadfile") MultipartFile file) throws ResourceNotFoundException, IOException {
    	Content filemodel = fileRepository.findById(fileId)
        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + fileId));
    	filemodel.setName(fileDetails.getName());
    	filemodel.setDiscription(fileDetails.getDiscription());
    	filemodel.setPic(file.getBytes());
    	filemodel.setContactName(fileDetails.getContactName());
        final Content updateFiles = fileRepository.save(filemodel);
        return ResponseEntity.ok(updateFiles);
    }
  
    
    
    
    
    
    
    
    
    
}