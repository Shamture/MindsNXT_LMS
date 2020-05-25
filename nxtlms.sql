# Host: localhost  (Version: 5.6.21-log)
# Date: 2020-01-21 16:51:41
# Generator: MySQL-Front 5.3  (Build 4.186)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "announcement"
#

DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` bigint(20) NOT NULL,
  `add_attachment` longblob,
  `description` varchar(255) DEFAULT NULL,
  `file_comment` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "announcement"
#


#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `is_category_searchable` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `lms` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "category"
#


#
# Structure for table "content_model"
#

DROP TABLE IF EXISTS `content_model`;
CREATE TABLE `content_model` (
  `id` bigint(20) NOT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `discription` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pic` longblob,
  `start_date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "content_model"
#

INSERT INTO `content_model` VALUES (1,'sham','9852874587','Java Des',NULL,'English','Java',NULL,NULL,'Active',NULL);

#
# Structure for table "course_model"
#

DROP TABLE IF EXISTS `course_model`;
CREATE TABLE `course_model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accumulate_credit` varchar(255) DEFAULT NULL,
  `allow_use_of_interest_lists` varchar(255) DEFAULT NULL,
  `approval_required` varchar(255) DEFAULT NULL,
  `can_relaunch` varchar(255) DEFAULT NULL,
  `certification_calculation_date` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `course_completion_certificate` varchar(255) DEFAULT NULL,
  `course_display_date` varchar(255) DEFAULT NULL,
  `course_hide_date` varchar(255) DEFAULT NULL,
  `credit` varchar(255) DEFAULT NULL,
  `days_before_std_to_compl` bigint(20) NOT NULL,
  `days_std_to_compl` bigint(20) NOT NULL,
  `delivery_method` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `enrollment_close_date` varchar(255) DEFAULT NULL,
  `enrollment_open_date` varchar(255) DEFAULT NULL,
  `enrollment_restriction` varchar(255) DEFAULT NULL,
  `expire_days` bigint(20) NOT NULL,
  `instructional_languages` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `remind_student` bigint(20) NOT NULL,
  `self_certified_completion` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `targeted_learners` varchar(255) DEFAULT NULL,
  `tuition` bigint(20) NOT NULL,
  `version` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "course_model"
#

INSERT INTO `course_model` VALUES (1,'','','','','','CS100','','','','','',0,0,'classroom','Java Course','','','','',0,'','English','Java','CS100','',0,'','','',0,'');

#
# Structure for table "assignment"
#

DROP TABLE IF EXISTS `assignment`;
CREATE TABLE `assignment` (
  `id` bigint(20) NOT NULL,
  `assignment_description` varchar(255) DEFAULT NULL,
  `assignment_max_score` varchar(255) DEFAULT NULL,
  `assignment_name` varchar(255) DEFAULT NULL,
  `assignment_weight_inside_assess` varchar(255) DEFAULT NULL,
  `course_id` bigint(20) NOT NULL,
  `assessment_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjs7glrr059h1fwd810dltvr65` (`course_id`),
  CONSTRAINT `FKjs7glrr059h1fwd810dltvr65` FOREIGN KEY (`course_id`) REFERENCES `course_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "assignment"
#

INSERT INTO `assignment` VALUES (6,'Java Des','100','Java','100',1,'Networking'),(10,'Python Des','100','Python','100',1,'Networking');

#
# Structure for table "assessment"
#

DROP TABLE IF EXISTS `assessment`;
CREATE TABLE `assessment` (
  `id` bigint(20) NOT NULL,
  `assessment_description` varchar(255) DEFAULT NULL,
  `assessment_name` varchar(255) DEFAULT NULL,
  `assessment_total_weight` varchar(255) DEFAULT NULL,
  `course_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6d0htmt4r7ak9rmk525cm2scu` (`course_id`),
  CONSTRAINT `FK6d0htmt4r7ak9rmk525cm2scu` FOREIGN KEY (`course_id`) REFERENCES `course_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "assessment"
#

INSERT INTO `assessment` VALUES (5,'Networking Details','Networking','50',1),(17,'Java Details','Java','100',1),(18,'Python Des','Python','100',1);

#
# Structure for table "admin_quiz"
#

DROP TABLE IF EXISTS `admin_quiz`;
CREATE TABLE `admin_quiz` (
  `id` bigint(20) NOT NULL,
  `questions` bigint(20) NOT NULL,
  `quiz_description` varchar(255) DEFAULT NULL,
  `quiz_end_date` varchar(255) DEFAULT NULL,
  `quiz_name` varchar(255) DEFAULT NULL,
  `quiz_start_date` varchar(255) DEFAULT NULL,
  `course_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9xse2xaann4t9uorup2r47cq2` (`course_id`),
  CONSTRAINT `FK9xse2xaann4t9uorup2r47cq2` FOREIGN KEY (`course_id`) REFERENCES `course_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "admin_quiz"
#

INSERT INTO `admin_quiz` VALUES (11,1,'Java Des','2020-01-27T09:00','Java','2020-01-20T09:00',1),(12,1,'Python Des','2020-01-27T10:00','Python','2020-01-20T10:00',1);

#
# Structure for table "demo"
#

DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "demo"
#


#
# Structure for table "discipline"
#

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE `discipline` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ordinal` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "discipline"
#

INSERT INTO `discipline` VALUES (8,'MLMS','Java Des','English','Java','0','Active');

#
# Structure for table "hibernate_sequence"
#

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "hibernate_sequence"
#

INSERT INTO `hibernate_sequence` VALUES (19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19),(19);

#
# Structure for table "institute_role"
#

DROP TABLE IF EXISTS `institute_role`;
CREATE TABLE `institute_role` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `effective_date` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "institute_role"
#


#
# Structure for table "instructor_category"
#

DROP TABLE IF EXISTS `instructor_category`;
CREATE TABLE `instructor_category` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `is_category_searchable` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `lms` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "instructor_category"
#


#
# Structure for table "instructor_content"
#

DROP TABLE IF EXISTS `instructor_content`;
CREATE TABLE `instructor_content` (
  `id` bigint(20) NOT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `discription` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pic` longblob,
  `start_date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "instructor_content"
#


#
# Structure for table "instructor_course"
#

DROP TABLE IF EXISTS `instructor_course`;
CREATE TABLE `instructor_course` (
  `id` bigint(20) NOT NULL,
  `accumulate_credit` varchar(255) DEFAULT NULL,
  `allow_use_of_interest_lists` varchar(255) DEFAULT NULL,
  `approval_required` varchar(255) DEFAULT NULL,
  `can_relaunch` varchar(255) DEFAULT NULL,
  `certification_calculation_date` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `course_completion_certificate` varchar(255) DEFAULT NULL,
  `course_display_date` varchar(255) DEFAULT NULL,
  `course_hide_date` varchar(255) DEFAULT NULL,
  `credit` varchar(255) DEFAULT NULL,
  `days_before_std_to_compl` bigint(20) NOT NULL,
  `days_std_to_compl` bigint(20) NOT NULL,
  `delivery_method` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `enrollment_close_date` varchar(255) DEFAULT NULL,
  `enrollment_open_date` varchar(255) DEFAULT NULL,
  `enrollment_restriction` varchar(255) DEFAULT NULL,
  `expire_days` bigint(20) NOT NULL,
  `instructional_languages` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `remind_student` bigint(20) NOT NULL,
  `resource_content` varchar(255) DEFAULT NULL,
  `self_certified_completion` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `targeted_learners` varchar(255) DEFAULT NULL,
  `tuition` bigint(20) NOT NULL,
  `version` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "instructor_course"
#


#
# Structure for table "multi_data_cont"
#

DROP TABLE IF EXISTS `multi_data_cont`;
CREATE TABLE `multi_data_cont` (
  `id` int(11) NOT NULL,
  `cont_name` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `instacategory_id` bigint(20) DEFAULT NULL,
  `instacontent_id` bigint(20) DEFAULT NULL,
  `content_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlknuoo5ajdhalc2fp4v1v2lew` (`category_id`),
  KEY `FK6be6884rtq2p4mu3d0a5c05pa` (`instacategory_id`),
  KEY `FKsr8bgtao6x3gcj4pjicdukv38` (`instacontent_id`),
  KEY `FK22vp9mls5dskuft9o3j2313ju` (`content_id`),
  CONSTRAINT `FK22vp9mls5dskuft9o3j2313ju` FOREIGN KEY (`content_id`) REFERENCES `course_model` (`id`),
  CONSTRAINT `FK6be6884rtq2p4mu3d0a5c05pa` FOREIGN KEY (`instacategory_id`) REFERENCES `instructor_category` (`id`),
  CONSTRAINT `FKlknuoo5ajdhalc2fp4v1v2lew` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKsr8bgtao6x3gcj4pjicdukv38` FOREIGN KEY (`instacontent_id`) REFERENCES `instructor_course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "multi_data_cont"
#

INSERT INTO `multi_data_cont` VALUES (2,'Java',NULL,NULL,NULL,1);

#
# Structure for table "organization"
#

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `org_code` varchar(255) DEFAULT NULL,
  `org_name` varchar(255) DEFAULT NULL,
  `postal_code` bigint(20) NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "organization"
#

INSERT INTO `organization` VALUES (1,'GUBARGA','india','2020-12-31','English','MLMS','MindsLMS',585101,'2020-01-01','Karnataka','GULBARGA','Bussiness Unit');

#
# Structure for table "privileges"
#

DROP TABLE IF EXISTS `privileges`;
CREATE TABLE `privileges` (
  `privilege_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `sub_role_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`privilege_id`,`role_id`,`sub_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "privileges"
#

INSERT INTO `privileges` VALUES (1,1,1,'Course Management','Add Course','Active'),(2,1,1,'Course Management','View Course','Active'),(3,1,1,'Course Management','Edit Course','Active'),(4,1,1,'Course Management','View Course Details','Active'),(5,1,2,'Content Management','Add Content','Active'),(6,1,2,'Content Management','View Content','Active'),(7,1,2,'Content Management','Edit Content','Active'),(8,1,2,'Content Management','View Content Details','Active');

#
# Structure for table "quiz_questions"
#

DROP TABLE IF EXISTS `quiz_questions`;
CREATE TABLE `quiz_questions` (
  `id` bigint(20) NOT NULL,
  `answer_scores` int(11) NOT NULL,
  `correct_answers` varchar(255) DEFAULT NULL,
  `quiz_answer1` varchar(255) DEFAULT NULL,
  `quiz_answer2` varchar(255) DEFAULT NULL,
  `quiz_answer3` varchar(255) DEFAULT NULL,
  `quiz_answer4` varchar(255) DEFAULT NULL,
  `quiz_question` varchar(255) DEFAULT NULL,
  `quiz_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKslfii7mnyk55vppx528dq4xq9` (`quiz_id`),
  CONSTRAINT `FKslfii7mnyk55vppx528dq4xq9` FOREIGN KEY (`quiz_id`) REFERENCES `admin_quiz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "quiz_questions"
#

INSERT INTO `quiz_questions` VALUES (13,10,'Yes','Yes','No','None of the above','others','Java is Platform Independent',11),(14,10,'Yes','Yes','No','None of the above','others','python is platform independent',12);

#
# Structure for table "roles"
#

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "roles"
#

INSERT INTO `roles` VALUES (1,'Administrator','admin','Active'),(2,'Course Instructor','Instructor','Active'),(3,'Users','student','Active');

#
# Structure for table "sub_roles"
#

DROP TABLE IF EXISTS `sub_roles`;
CREATE TABLE `sub_roles` (
  `role_id` bigint(20) NOT NULL,
  `sub_role_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`,`sub_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sub_roles"
#

INSERT INTO `sub_roles` VALUES (1,1,'Course Management','Course','Active'),(1,2,'Content Management','Content','Active'),(1,3,'Course Support','Course Support','Active'),(1,4,'Catalog Management','Catalog','Active'),(1,5,'Institutional Roles','Institutional Roles','Active'),(1,6,'System Roles','System Roles','Active'),(1,7,'User Management ','Users','Active'),(1,8,'Organizational Management','Oraganization','Active'),(1,9,'Assignment','Assignment','Active'),(1,10,'Assessment','Assessment','Active'),(1,11,'Quiz','Quiz','Active'),(1,12,'Announcement','Announcement','Active'),(1,13,'Surveys','Survey','Active'),(1,14,'Enrollemnts','Enrollment','Active'),(2,1,'Course Management','Course','Active'),(2,2,'Content Management','Content','Active'),(2,3,'Course Support','Course Support','Active'),(2,4,'Catalog Management','Catalog','Active'),(2,5,'Quiz','Quiz','Active'),(2,6,'Assignment','Assignment','Active'),(2,7,'Announcement','Announcemenr','Active'),(2,8,'Survey','Survey','Active'),(2,9,'Assessment ','Assessment','Active'),(2,10,'Enrollment','Enrollment','Active');

#
# Structure for table "survey"
#

DROP TABLE IF EXISTS `survey`;
CREATE TABLE `survey` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `survey_code` varchar(255) DEFAULT NULL,
  `survey_description` varchar(255) DEFAULT NULL,
  `survey_end_date` varchar(255) DEFAULT NULL,
  `survey_start_date` varchar(255) DEFAULT NULL,
  `survey_title` varchar(255) DEFAULT NULL,
  `course_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30dr2efncofcwe3ba3ia6vhtx` (`course_id`),
  CONSTRAINT `FK30dr2efncofcwe3ba3ia6vhtx` FOREIGN KEY (`course_id`) REFERENCES `course_model` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "survey"
#

INSERT INTO `survey` VALUES (1,'s01','survey Description','2020-01-27','2020-01-20','Survey1',1),(2,'s02','survey2 Description','2020-01-28','2020-01-21','Survey2',1);

#
# Structure for table "survey_questions"
#

DROP TABLE IF EXISTS `survey_questions`;
CREATE TABLE `survey_questions` (
  `id` bigint(20) NOT NULL,
  `survey_answer_option1` varchar(255) DEFAULT NULL,
  `survey_answer_option2` varchar(255) DEFAULT NULL,
  `survey_question_option` varchar(255) DEFAULT NULL,
  `survey_question_title` varchar(255) DEFAULT NULL,
  `survey_question_type` varchar(255) DEFAULT NULL,
  `survey_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6d3brrwy6141fd7375ux6udnx` (`survey_id`),
  CONSTRAINT `FK6d3brrwy6141fd7375ux6udnx` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "survey_questions"
#

INSERT INTO `survey_questions` VALUES (15,'Yes','No','2','SurveyQ1','Yes/No',1),(16,'','','0','SurveyQ1','Open(Text Box)',1);

#
# Structure for table "system_role"
#

DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` bigint(20) NOT NULL,
  `effective_date` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "system_role"
#


#
# Structure for table "term"
#

DROP TABLE IF EXISTS `term`;
CREATE TABLE `term` (
  `id` bigint(20) NOT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `term_description` varchar(255) DEFAULT NULL,
  `term_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "term"
#

INSERT INTO `term` VALUES (9,'2020-12-31',NULL,'2020-01-01','One Year','1Year');

#
# Structure for table "user_model"
#

DROP TABLE IF EXISTS `user_model`;
CREATE TABLE `user_model` (
  `id` bigint(20) NOT NULL,
  `affiliation` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `institutional_roles` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `postal_code` bigint(20) NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `system_roles` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `voice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user_model"
#


#
# Structure for table "multi_data_org"
#

DROP TABLE IF EXISTS `multi_data_org`;
CREATE TABLE `multi_data_org` (
  `id` int(11) NOT NULL,
  `org_name` varchar(255) DEFAULT NULL,
  `content_id` bigint(20) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `discipline_id` bigint(20) DEFAULT NULL,
  `instacontent_id` bigint(20) DEFAULT NULL,
  `instacourse_id` bigint(20) DEFAULT NULL,
  `instituterole_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcmwc1p6q0g3jxlsgjdmpkawvn` (`content_id`),
  KEY `FKgxmf1vs077ujlcm2abhjlgfh5` (`course_id`),
  KEY `FKsaruu9sm5thx4tlh4132xffgu` (`discipline_id`),
  KEY `FK302jlr43xc5412pwku2fymva9` (`instacontent_id`),
  KEY `FKlvucuxs3jicwwqafdmpjwocki` (`instacourse_id`),
  KEY `FKp7ejhl42fehdd8ocy85nxumsv` (`instituterole_id`),
  KEY `FKqen2te07wn7xdc6i86hxqmjfn` (`role_id`),
  KEY `FKoc70y42xw18dk15ae7ykomugw` (`user_id`),
  CONSTRAINT `FK302jlr43xc5412pwku2fymva9` FOREIGN KEY (`instacontent_id`) REFERENCES `instructor_content` (`id`),
  CONSTRAINT `FKcmwc1p6q0g3jxlsgjdmpkawvn` FOREIGN KEY (`content_id`) REFERENCES `content_model` (`id`),
  CONSTRAINT `FKgxmf1vs077ujlcm2abhjlgfh5` FOREIGN KEY (`course_id`) REFERENCES `course_model` (`id`),
  CONSTRAINT `FKlvucuxs3jicwwqafdmpjwocki` FOREIGN KEY (`instacourse_id`) REFERENCES `instructor_course` (`id`),
  CONSTRAINT `FKoc70y42xw18dk15ae7ykomugw` FOREIGN KEY (`user_id`) REFERENCES `user_model` (`id`),
  CONSTRAINT `FKp7ejhl42fehdd8ocy85nxumsv` FOREIGN KEY (`instituterole_id`) REFERENCES `institute_role` (`id`),
  CONSTRAINT `FKqen2te07wn7xdc6i86hxqmjfn` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`id`),
  CONSTRAINT `FKsaruu9sm5thx4tlh4132xffgu` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "multi_data_org"
#

INSERT INTO `multi_data_org` VALUES (3,'MindsLMS',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(7,'MindsLMS',NULL,NULL,8,NULL,NULL,NULL,NULL,NULL);
