--数据库的设计

create database if not exists blogSystem;

use blogSystem;

--创建博客表
create table blog(
    blogID int primary key auto_increment,
    title varchar(1024),
    content mediumtext,
    postTime datetime,
    userId int

);

--创建用户表
create table user(
    userId int primary key auto_increment,
    username varchar(128) unique,
    password varchar(128)
);