
package com.minds.lms.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.exception.ResourceNotFoundException;
import com.minds.lms.model.Category;
import com.minds.lms.model.Course;
import com.minds.lms.model.DataOrg;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.MultiDataCont;
import com.minds.lms.model.Role;
import com.minds.lms.repository.InstituteRoleRepository;
import com.minds.lms.repository.MultiInstituteDataRepository;
import com.minds.lms.repository.MultiOrgDataRepository;
import com.minds.lms.repository.RoleRepository;





@RestController
public class InstitutionalRoleController {
	@Autowired
	InstituteRoleRepository instituteRepository;
	@Autowired
	MultiInstituteDataRepository  multiInstRepo;
	
	@CrossOrigin
	 @GetMapping("/viewAllInstituteroles")
	    public List<InstituteRole> getAllSystemRoles() {
	        return instituteRepository.findAll();
	    }
	
	
	@CrossOrigin
	@GetMapping("/instituterolesById/{id}")
	public ResponseEntity<InstituteRole> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{		
		
		InstituteRole role = instituteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));		

		return ResponseEntity.ok().body(role);
	}
	
	@CrossOrigin
    @PostMapping("/addInstituteRole")
    public InstituteRole create(@RequestBody InstituteRole input) {
        if(input.getLms() != null) {
            //you are saving all the nested tags manually before saving the activity
            for(DataOrg t : input.getLms()) {
            	multiInstRepo.save(t);
            }
        }
        //now you are saving activity which contains these tags
        return multiInstRepo.save(input);
    }
	
	@CrossOrigin
	@DeleteMapping("deletInstituteroles/{id}")
	public String deleteSystemRoles(@PathVariable(value ="id") long id){
		
		instituteRepository.deleteById(id);
		
		return "Deleted" ;
		
	}
	
	@CrossOrigin
	@PutMapping("updateInstituteroles/{id}")
	public ResponseEntity<InstituteRole> updateSystemRoles(@PathVariable (value = "id") long id , @RequestBody InstituteRole roledetails) throws ResourceNotFoundException{
		
		InstituteRole role = instituteRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("User not found for this id : "+id)));
		
		
		role.setCode(roledetails.getCode());
		role.setLms(roledetails.getLms());
		role.setName(roledetails.getName());
		role.setLanguage(roledetails.getLanguage());
		role.setEffectiveDate(roledetails.getEffectiveDate());
		role.setEndDate(roledetails.getEndDate());
		
		
		InstituteRole updaterole = instituteRepository.save(role);
		
		return ResponseEntity.ok(updaterole);
		
	}
	
	@CrossOrigin
	@GetMapping("searchInstituteroles/{name}/{code}")
	
	public List<InstituteRole> findByNameAndCode(@PathVariable(value = "name") String name ,@PathVariable(value = "code") String code ){
		
		return instituteRepository.findByNameAndCode(name,code);
		

		
	}	
	
	
	
	
	
	
	
}
