
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
import com.minds.lms.model.Discipline;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.MultiDataCont;
import com.minds.lms.model.Role;
import com.minds.lms.repository.DisciplineDataRepository;
import com.minds.lms.repository.InstituteRoleRepository;
import com.minds.lms.repository.MultiInstituteDataRepository;
import com.minds.lms.repository.MultiOrgDataRepository;
import com.minds.lms.repository.RoleRepository;

@RestController
public class DisciplineController {
	@Autowired
	DisciplineDataRepository disciplineRepository;
	@Autowired
	MultiInstituteDataRepository  multiInstRepo;
	
	@CrossOrigin
	 @GetMapping("/viewDiscipline")
	    public List<Discipline> getAllSystemRoles() {
	        return disciplineRepository.findAll();
	    }
	
	
	@CrossOrigin
	@GetMapping("/viewDiscipline/{id}")
	public ResponseEntity<Discipline> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{		
		
		Discipline role = disciplineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));		

		return ResponseEntity.ok().body(role);
	}
	
	@CrossOrigin
    @PostMapping("/addDiscipline")
    public Discipline create(@RequestBody Discipline input) {
        if(input.getOwnerOrganization() != null) {
            //you are saving all the nested tags manually before saving the activity
            for(DataOrg t : input.getOwnerOrganization()) {
            	multiInstRepo.save(t);
            }
        }
        //now you are saving activity which contains these tags
        return disciplineRepository.save(input);
    }
	
	@CrossOrigin
	@DeleteMapping("deleteDiscipline/{id}")
	public String deleteSystemRoles(@PathVariable(value ="id") long id){
		
		disciplineRepository.deleteById(id);
		
		return "Deleted" ;
		
	}
	
	@CrossOrigin
	@PutMapping("upadateDiscipline/{id}")
	public ResponseEntity<Discipline> updateSystemRoles(@PathVariable (value = "id") long id , @RequestBody Discipline roledetails) throws ResourceNotFoundException{
		
		Discipline role = disciplineRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("User not found for this id : "+id)));
		
		
		role.setCode(roledetails.getCode());
		role.setOwnerOrganization(roledetails.getOwnerOrganization());
		role.setName(roledetails.getName());
		role.setLanguage(roledetails.getLanguage());
		role.setDescription(roledetails.getDescription());
		role.setOrdinal(roledetails.getOrdinal());
		role.setStatus(roledetails.getStatus());
			
		
		
		Discipline updaterole = disciplineRepository.save(role);
		
		return ResponseEntity.ok(updaterole);
		
	}
	
	@CrossOrigin
	@GetMapping("searchDiscipline/{name}/{status}")
	
	public List<Discipline> findByNameAndStatus(@PathVariable(value = "name") String name ,@PathVariable(value = "status") String status){
		
		return disciplineRepository.findByNameAndStatus(name,status);

	}	
	
	@CrossOrigin
	@GetMapping("searchDisciplinebyName/{name}")
	
	public List<Discipline> findByName(@PathVariable(value = "name") String name){
		
		return disciplineRepository.findByName(name);

	}	

}
