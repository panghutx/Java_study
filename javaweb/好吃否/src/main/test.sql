create database if not exists delicious

use delicious;

drop table if exists discuss;
create table discuss (
    discussId int primary key auto_increment,
    score int,
    title varchar(1024),
    content mediumtext,
    postTime datetime
);
