insert into student(id, first_name, last_name, other_names, student_class, dob, parent_id) 
values('1', 'Brakoh', 'Rose', '', 'J.H.S 3', '12/12/1995', '1');

insert into parent(id, first_name, last_name) values('1', 'Donkoh', 'Akuah');

insert into parent(id, first_name, last_name) values('2', 'Admin', 'Admin');

insert into role(id, name) values('1', 'ROLE_STUDENT');

insert into role(id, name) values('2', 'ROLE_PARENT');

insert into role(id, name) values('3', 'ROLE_ADMIN');

insert into user(id, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, 
is_verified, password, user_id, role_id, username) values('1', true, true, true, true, true, 'rose123', '1', '2', 'rose');

insert into user(id, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, 
is_verified, password, user_id, role_id, username) values('2', true, true, true, true, true, 'admin123', '2', '3', 'admin');