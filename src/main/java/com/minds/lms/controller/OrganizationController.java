package com.minds.lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.minds.lms.model.DataOrg;
import com.minds.lms.model.MultiDataCont;
import com.minds.lms.model.Organization;
import com.minds.lms.model.Term;
import com.minds.lms.repository.CategoryRepository;
import com.minds.lms.repository.FileRepository;
import com.minds.lms.repository.MultiDataRepository;
import com.minds.lms.repository.MultiOrgDataRepository;
import com.minds.lms.repository.OrganizationRepository;


@RestController
@Repository
public class OrganizationController {
	
	@Autowired
	OrganizationRepository orgRepository;
	
	
	@Autowired
	MultiOrgDataRepository multidataorgRepository;
	
	

	/*@CrossOrigin
	@PostMapping("/addcategory")
public Category addCategoryContent(@RequestBody Category category ){
		 return categoryRepository.save(category);
	}
	*/
	
	 @CrossOrigin
	 @GetMapping("/viewAllOrganization")
	 
	    public List<Organization> getAllContentFiles(@ModelAttribute Organization orgN ) {
		 
		/* if(category.getContent() != null) {
	            //you are saving all the nested tags manually before saving the activity
	            for(MultiDataCont t : category.getContent()) {
	                tagRepository.findAll();
	            }
	        }*/
	        return  orgRepository.findAll();
	    }
	
	 @CrossOrigin
	    @GetMapping("/viewOrganizationById/{id}")
	    public ResponseEntity<Organization> getContentFilesById(@PathVariable(value = "id") long orgId)throws ResourceNotFoundException {
		 Organization orgmodel = orgRepository.findById(orgId).orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + orgId));
	        return ResponseEntity.ok().body(orgmodel);
	    }
	    
	 @CrossOrigin
	    @DeleteMapping("/deleteOrganization/{id}")
	    public Map<String, Boolean> deleteContent(@PathVariable(value = "id") long orgId)
	         throws ResourceNotFoundException {
		 Organization org = orgRepository.findById(orgId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + orgId));
		 orgRepository.delete(org);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("Course Content File has deleted Successfully ", Boolean.TRUE);
	        return response;
	    }
		    
	    @CrossOrigin
	    @PutMapping("/updateOrganization/{id}") 
	    public ResponseEntity<Organization> updateCategory(@PathVariable(value = "id") long orgId, @RequestBody Organization org ) throws ResourceNotFoundException, IOException {
	    	Organization orgDet = orgRepository.findById(orgId)
	        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + orgId));
	    	
	    	orgDet.setOrgName(org.getOrgName());
	    	orgDet.setCity(org.getCity());
	    	orgDet.setCountry(org.getCountry());
	    	orgDet.setLanguage(org.getLanguage());;
	    	orgDet.setOrgCode(org.getOrgCode());
	    	orgDet.setState(org.getState());
	    	orgDet.setEndDate(org.getEndDate());
	    	orgDet.setStreet(org.getStreet());
	    	orgDet.setType(org.getType());
	    	orgDet.setPostalCode(org.getPostalCode());
	    	
	    
	    	
	       final  Organization updateOrganization = orgRepository.save(orgDet);
			return  ResponseEntity.ok(updateOrganization);
	      
	    }
	    
	    @CrossOrigin
	    @GetMapping(value = "/searchOrganization/{orgName}/{orgCode}/{type}")
	    public List<Organization> findByOrgNameAndOrgCodeAndType(@PathVariable("orgName") String orgname,@PathVariable("orgCode") String orgcode, @PathVariable("type") String type ){
		return orgRepository.findByOrgNameAndOrgCodeAndType(orgname, orgcode ,type);
	    }

	    @CrossOrigin
	    @GetMapping(value = "/searchOrganizationByName/{orgName}")
	    public List<Organization> findByOrgName(@PathVariable("orgName") String orgname){
		return orgRepository.findByOrgName(orgname);
	    }
	    
	    @CrossOrigin
	    @GetMapping(value = "/searchOrganizationByCode/{orgCode}")
	    public List<Organization> findByOrgCode(@PathVariable("orgCode") String orgCode){
		return orgRepository.findByorgCode(orgCode);
	    }
	    
	    
	    @CrossOrigin
	    @GetMapping(value = "/searchOrganizationByType/{type}")
	    public List<Organization> findByType(@PathVariable("type") String type){
		return orgRepository.findByType(type);
	    }
	    
	    @CrossOrigin
	    @PostMapping("/addOrganization")
	    public Organization create(@RequestBody Organization input) {
	           return orgRepository.save(input);
	    }
	    
		
	 
}