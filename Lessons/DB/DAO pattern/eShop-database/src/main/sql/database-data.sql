/*
use eshop_database;
-- insert admin user
insert into eshop_database.user (id, created_date, last_login_date, login_name, status)
values (1, now(), null, 'admin', 'ACTIVE');
insert into eshop_database.user (id, created_date, last_login_date, login_name, status)
values (2, now(), null, 'user2', 'DELETED');
insert into eshop_database.user (id, created_date, last_login_date, login_name, status)
values (3, now(), null, 'user3', 'LOCKED');
insert into eshop_database.user (id, created_date, last_login_date, login_name, status)
values (4, now(), null, 'user4', 'LOCKED');
-- add password information
insert into eshop_database.user_data (id, user_id, created_date, status, password)
values (1, 1, now(), 'ACTIVE', 'password') ;
insert into eshop_database.user_data (id, user_id, created_date, status, password)
values (2, 3, now(), 'ACTIVE', 'password123') ;
insert into eshop_database.user_data (id, user_id, created_date, status, password)
values (3, 3, now(), 'UPDATED', 'new_password') ;

-- Data manipulation examples
-- select * from user;
-- select * from user_data limit 0, 2;
-- update user_data set password='admin_password' where user_id=1;
-- select avg(ud.user_id) from user_data ud;
-- select * from user u where u.login_name like 'user_';
-- select * from user u, user_data ud where u.status = ud.status;
-- select * from user u right join user_data ud on u.id=ud.user_id;
*/
