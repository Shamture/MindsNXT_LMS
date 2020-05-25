package com.minds.lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.minds.lms.model.InstructorCategory;
import com.minds.lms.model.MultiDataCont;
import com.minds.lms.repository.CategoryRepository;
import com.minds.lms.repository.FileRepository;
import com.minds.lms.repository.InstructorCategoryRepository;
import com.minds.lms.repository.MultiDataRepository;


@RestController
@Repository
public class InstructorCategoryController {
	
	@Autowired
	InstructorCategoryRepository categoryRepository;
	
	
	@Autowired
	MultiDataRepository multidataRepository;
	
	

	/*@CrossOrigin
	@PostMapping("/addcategory")
public Category addCategoryContent(@RequestBody Category category ){
		 return categoryRepository.save(category);
	}
	*/
	
	 @CrossOrigin
	 @GetMapping("/viewAllInstructorCategory")
	 
	    public List<InstructorCategory> getAllContentFiles(@ModelAttribute InstructorCategory category ) {
		 
		/* if(category.getContent() != null) {
	            //you are saving all the nested tags manually before saving the activity
	            for(MultiDataCont t : category.getContent()) {
	                tagRepository.findAll();
	            }
	        }*/
	        return  categoryRepository.findAll();
	    }
	
	 @CrossOrigin
	    @GetMapping("/viewInstructorCategoryById/{id}")
	    public ResponseEntity<InstructorCategory> getContentFilesById(@PathVariable(value = "id") Long categoryId)
	        throws ResourceNotFoundException {
		 InstructorCategory catmodel = categoryRepository.findById(categoryId)
	          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + categoryId));
	        return ResponseEntity.ok().body(catmodel);
	    }
	    
	 @CrossOrigin
	    @DeleteMapping("/deleteInstructorCategory/{id}")
	    public Map<String, Boolean> deleteContent(@PathVariable(value = "id") Long categoryId)
	         throws ResourceNotFoundException {
		 InstructorCategory category = categoryRepository.findById(categoryId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + categoryId));
	    	categoryRepository.delete(category);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("Course Content File has deleted Successfully", Boolean.TRUE);
	        return response;
	    }
		    
	    @CrossOrigin
	    @PutMapping("/updateInstructorCategory/{id}") 
	    public ResponseEntity<InstructorCategory> updateCategory(@PathVariable(value = "id") Long categoryId, @RequestBody Category catDetails ) throws ResourceNotFoundException, IOException {
	    	InstructorCategory category = categoryRepository.findById(categoryId)
	        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + categoryId));
	    	category.setName(catDetails.getName());
	    	category.setDescription(catDetails.getDescription());
	    	category.setLanguage(catDetails.getLanguage());;
	    	category.setLms(catDetails.getLms());
	    	category.setStartDate(catDetails.getStartDate());
	    	category.setEndDate(catDetails.getEndDate());
	    	category.setIsCategorySearchable(catDetails.getIsCategorySearchable());
	    	category.setContent(catDetails.getContent());
	       final  InstructorCategory updateCategory = categoryRepository.save(category);
			return  ResponseEntity.ok(updateCategory);
	      	    }
	    
	    @CrossOrigin
	    @GetMapping(value = "/searchInstructorCategory/{name}/{isCategorySearchable}/{status}")
	    public List<InstructorCategory> findByNameAndIsCategorySearchableAndStatus(@PathVariable("name") String name, @PathVariable("isCategorySearchable") String isCategorySearchable,@PathVariable("status") String status ){
		return categoryRepository.findByNameAndIsCategorySearchableAndStatus(name,isCategorySearchable,status);
	    }
	    
	    @CrossOrigin
	    @PostMapping("/addInstructorCategory")
	    public InstructorCategory create(@Valid @RequestBody InstructorCategory input) {
	        if(input.getContent() != null) {
	            //you are saving all the nested tags manually before saving the activity
	            for(MultiDataCont t : input.getContent()) {
	            	multidataRepository.save(t);
	            }
	        }
	        //now you are saving activity which contains these tags
	        return categoryRepository.save(input);
	    }
	    
	    @CrossOrigin
	    @GetMapping(value = "/searchInstructorCategory/{name}")
	    public List<InstructorCategory> findByName(@PathVariable("name") String name){
		return categoryRepository.findByName(name);
	    }
	 }