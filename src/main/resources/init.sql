--
-- Table structure for table T_ROLE
--
drop table if exists T_ROLES;
create table T_ROLES (
  ROLE_ID varchar(5) NOT NULL,
  ROLE_NAME varchar(45) NOT NULL,
  PRIMARY KEY (ROLE_ID)
); 

--
-- Table structure for table T_USER
--
drop table if exists T_USERS;
create table T_USERS (
  USER_ID SERIAL,
  USERNAME varchar(255) NOT NULL,
  PASSWORD varchar(255) NOT NULL,
  NAME varchar(255) NOT NULL,
  EMAIL varchar(255) UNIQUE DEFAULT NULL,
  CREATED_AT timestamp DEFAULT NULL,
  UPDATED_AT timestamp DEFAULT NULL,
  PRIMARY KEY (USER_ID)
); 

--
-- Table structure for table T_USER_ROLE
--

drop table if exists T_USER_ROLES;
create table T_USER_ROLES (
  USER_ID integer NOT NULL,
  ROLE_ID varchar(5) NOT NULL,
  PRIMARY KEY (USER_ID, ROLE_ID),
  CONSTRAINT fk_t_user_roles_roleid FOREIGN KEY (ROLE_ID) REFERENCES T_ROLES (ROLE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_t_user_roles_userid FOREIGN KEY (USER_ID) REFERENCES T_USERS (USER_ID) ON DELETE CASCADE ON UPDATE CASCADE
); 

--
-- Table structure for table T_POLLS
--

drop table if exists T_POLLS;
CREATE TABLE T_POLLS (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  QUESTION varchar(140) NOT NULL,
  EXPIRATION_DATE_TIME datetime NOT NULL,
  CREATED_AT datetime DEFAULT NULL,
  UPDATED_AT datetime DEFAULT NULL,
  CREATED_BY bigint(20) DEFAULT NULL,
  UPDATED_BY bigint(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

--
-- Table structure for table T_CHOICES
--

drop table if exists T_CHOICES;
CREATE TABLE T_CHOICES (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  TEXT varchar(40) NOT NULL,
  POLL_ID bigint(20) NOT NULL,
  PRIMARY KEY (ID),
  KEY `fk_choices_poll_id` (POLL_ID),
  CONSTRAINT `fk_choices_poll_id` FOREIGN KEY (POLL_ID) REFERENCES T_POLLS (ID)
);

--
-- Table structure for table T_VOTES
--

drop table if exists T_VOTES;
CREATE TABLE T_VOTES (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  USER_ID bigint(20) NOT NULL,
  POLL_ID bigint(20) NOT NULL,
  CHOICE_ID bigint(20) NOT NULL,
  CREATED_BY datetime DEFAULT NULL,
  UPDATED_BY datetime DEFAULT NULL,
  PRIMARY KEY (ID),
  KEY `fk_votes_user_id` (USER_ID),
  KEY `fk_votes_poll_id` (POLL_ID),
  KEY `fk_votes_choice_id` (CHOICE_ID),
  CONSTRAINT `fk_votes_user_id` FOREIGN KEY (USER_ID) REFERENCES T_USERS (ID),
  CONSTRAINT `fk_votes_poll_id` FOREIGN KEY (POLL_ID) REFERENCES T_POLLS (ID),
  CONSTRAINT `fk_votes_choice_id` FOREIGN KEY (CHOICE_ID) REFERENCES T_CHOICES (ID)
);

--
-- Dumping data for table T_ROLE
--
insert into T_ROLES values ('R_STD','學生');

commit;

