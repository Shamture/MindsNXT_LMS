package com.minds.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.model.AnnouncementUser;

@Transactional
@Repository
public interface AnnouncementUserRepository extends JpaRepository<AnnouncementUser, Long> {

}
