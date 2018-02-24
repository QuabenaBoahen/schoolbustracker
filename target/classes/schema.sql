create schema bus_tracking_db;

create table student(id VARCHAR(255) PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255), other_names VARCHAR(255),
student_class VARCHAR(255), dob VARCHAR(255), parent_id VARCHAR(255));

create table parent(id VARCHAR(255) PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255));

create table role(id VARCHAR(255) PRIMARY KEY, name VARCHAR(255));

create table user(id VARCHAR(255) PRIMARY KEY, is_account_non_expired boolean, is_account_non_locked boolean, 
	is_credentials_non_expired boolean, is_enabled boolean, is_verified boolean, password VARCHAR(255), 
	user_id VARCHAR(255), role_id VARCHAR(255), username VARCHAR(255));

