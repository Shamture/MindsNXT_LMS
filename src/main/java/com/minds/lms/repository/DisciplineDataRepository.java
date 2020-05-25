package com.minds.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minds.lms.model.Course;
import com.minds.lms.model.DataOrg;
import com.minds.lms.model.Discipline;
import com.minds.lms.model.InstituteRole;
import com.minds.lms.model.MultiDataCont;

@Repository
public interface DisciplineDataRepository extends JpaRepository<Discipline, Long> {

	Discipline save(Discipline input);

	

	List<Discipline> findByNameAndStatus(String name, String status);



	List<Discipline> findByName(String name);

	



}
