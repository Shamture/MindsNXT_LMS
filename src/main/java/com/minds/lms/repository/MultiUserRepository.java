package com.minds.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.AnnouncementUser;

@Transactional
@Repository
public interface MultiUserRepository extends JpaRepository <AnnouncementUser, Long>{

	AnnouncementUser findByAnnouncementId(long id);

}
