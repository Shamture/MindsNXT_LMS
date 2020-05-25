package com.minds.lms.springboot2jpacrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.minds.lms.springboot2jpacrud.model.Content;
import com.minds.lms.springboot2jpacrud.repository.FileRepository;




 
@RestController
@Repository
public class SearchContentController {
	
	@Autowired
	FileRepository fileRepository;

	
	
	 @GetMapping(value = "/searchfiles/{name}/{type}")
	    public List<Content> findByNameAndType(@PathVariable("name") String name,@PathVariable("type") String type){
		return fileRepository.findByNameAndType(name, type);
	    }

	 /*
	  * 
	  * Search Files By Either Name Or FileType 
	  * 
	  * @GetMapping(value = "/searchfiles/{name}/{filetype}/")
	    public List<Content> findByNameOrType(@PathVariable("name") String name,@PathVariable("name") String filetype){
		return fileRepository.findByNameOrType(name, filetype);
	    }*/
 
	 @GetMapping(value = "/searchfiles/{name}")
	    public List<Content> findByName(@PathVariable("name") String name){
	   	return fileRepository.findByName(name);
	    }
	 
}