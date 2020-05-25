package com.minds.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minds.lms.model.Course;
import com.minds.lms.model.DataOrg;
import com.minds.lms.model.MultiDataCont;

@Repository
public interface MultiOrgDataRepository extends JpaRepository<DataOrg, Long> {



}
