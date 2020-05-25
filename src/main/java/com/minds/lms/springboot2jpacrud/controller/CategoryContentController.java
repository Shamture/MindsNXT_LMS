package com.minds.lms.springboot2jpacrud.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.minds.lms.springboot2jpacrud.model.Category;
import com.minds.lms.springboot2jpacrud.model.Content;
import com.minds.lms.springboot2jpacrud.repository.CategoryRepository;
import com.minds.lms.springboot2jpacrud.repository.FileRepository;




 
@RestController
@Repository
public class CategoryContentController {
	
	@Autowired
	CategoryRepository categoryRepository;

	
	@PostMapping("/addcategory")
public Category addCategoryContent(@RequestBody Category category){
	
		category.getName();
		category.getDiscription();
		category.getLanguage();
		category.getLms();
		category.getStartDate();
		category.getEndDate();
		category.getSearchable();
		category.getLms();
		
	Category saveCategory =  categoryRepository.save(category);
		
		
	return saveCategory;
		
		
		
	}
	
	
	 @GetMapping("/allcategory")
	    public List<Category> getAllContentFiles() {
	        return categoryRepository.findAll();
	    }
	
	    @GetMapping("/category/{id}")
	    public ResponseEntity<Category> getContentFilesById(@PathVariable(value = "id") Long categoryId)
	        throws ResourceNotFoundException {
	    	Category catmodel = categoryRepository.findById(categoryId)
	          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + categoryId));
	        return ResponseEntity.ok().body(catmodel);
	    }
	    
	    @DeleteMapping("/category/{id}")
	    public Map<String, Boolean> deleteContent(@PathVariable(value = "id") Long categoryId)
	         throws ResourceNotFoundException {
	    	Category category = categoryRepository.findById(categoryId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + categoryId));
	    	categoryRepository.delete(category);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("Course Content File has deleted Successfully ", Boolean.TRUE);
	        return response;
	    }
	
	    @PutMapping("/category/{id}") 
	    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId, @RequestBody Category catDetails ) throws ResourceNotFoundException, IOException {
	    	Category category = categoryRepository.findById(categoryId)
	        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + categoryId));
	    	category.setName(catDetails.getName());
	    	category.setDiscription(catDetails.getDiscription());
	    	category.setLanguage(catDetails.getLanguage());;
	    	category.setLms(catDetails.getLms());
	    	category.setStartDate(catDetails.getStartDate());
	    	category.setEndDate(catDetails.getEndDate());
	    	category.setSearchable(catDetails.getSearchable());
	       final  Category updateCategory = categoryRepository.save(category);
			return  ResponseEntity.ok(updateCategory);
	      
	    }
	    
	    
	    @GetMapping(value = "/searchcategory/{name}/{discription}/{searchable}")
	    public List<Category> findByNameAndDiscriptionAndSearchable(@PathVariable("name") String name,@PathVariable("discription") String discription, @PathVariable("searchable") String searchable ){
		return categoryRepository.findByNameAndDiscriptionAndSearchable(name, discription ,searchable);
	    }

		
	 
}