create table T_USER (
  USER_ID varchar(20) unique not null,
  PASSWORD varchar(60) not null,
  primary key(USER_ID)
);

create table T_USER_DETAIL (
  USER_ID varchar(20) unique not null,
  USERNAME varchar(30) not null,
  primary key(USER_ID)
);

insert into T_USER values ('admin', '$2a$11$wiX/CTMhDF97/KMh1J5Zmemx2id51gflBgci/s9TLFCwS2arN1x8e');
insert into T_USER_DETAIL values ('admin', 'chuck');
