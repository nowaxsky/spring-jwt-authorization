--
-- Table structure for table T_ROLE
--
drop table if exists T_ROLE;
create table T_ROLE (
  ROLE_ID varchar(5) NOT NULL,
  ROLE_NAME varchar(45) DEFAULT NULL,
  PRIMARY KEY (ROLE_ID)
); 

--
-- Table structure for table T_USER
--
drop table if exists T_USER;
create table T_USER (
  USER_ID SERIAL,
  USERNAME varchar(255) DEFAULT NULL,
  PASSWORD varchar(255) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  EMAIL varchar(255) DEFAULT NULL,
  PRIMARY KEY (USER_ID)
); 

--
-- Table structure for table T_USER_ROLE
--

drop table if exists T_USER_ROLE;
create table T_USER_ROLE (
  USER_ID integer NOT NULL,
  ROLE_ID varchar(5) NOT NULL,
  PRIMARY KEY (USER_ID, ROLE_ID),
  CONSTRAINT fk_t_user_role_roleid FOREIGN KEY (ROLE_ID) REFERENCES T_ROLE (ROLE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_t_user_role_userid FOREIGN KEY (USER_ID) REFERENCES T_USER (USER_ID) ON DELETE CASCADE ON UPDATE CASCADE
); 

--
-- Dumping data for table T_ROLE
--
insert into T_ROLE values ('R_STD','學生');

commit;

