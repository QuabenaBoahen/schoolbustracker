create schema bus_tracking_db;

create table student(id VARCHAR(255) PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255), other_names VARCHAR(255),
student_class VARCHAR(255), dob VARCHAR(255));

create table parent(id VARCHAR(255) PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255));

