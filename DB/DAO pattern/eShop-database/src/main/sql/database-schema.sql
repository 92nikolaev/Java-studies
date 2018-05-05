/*
-- Create database
create database if not exists eshop_database;
-- Create user table
use eshop_database;
create table if not exists eshop_database.user (
    id int(11) not null primary key,
    login_name varchar(200) not null,
    created_date datetime not null,
    last_login_date datetime null,
    status varchar(100) null
);
-- Create user password
create table if not exists eshop_database.user_data (
    id int(11) not null primary key,
    user_id int(11), foreign key (user_id) references user(id),
    created_date datetime not null,
    status varchar(100) null,
    password varchar(250) not null,
    first_name varchar(250) null,
    second_name varchar(250) null,
    email varchar(1024) null
);

*/

