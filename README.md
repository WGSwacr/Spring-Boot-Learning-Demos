# Spring-Boot-Learning-Demos
A Spring Boot project to learn how to write a basic website showing some articles with some simple user functions.

# Requirements
- Java
- Spring Boot
- MySQL

Feel free to work on this repo. Also welcome adding new project folders and discussing exist projects.
Issues and pull requests will be reviewed once per day.

# MySQL tables details
- t_user
CREATE TABLE t_user (
id int primary key auto_increment,
username varchar(255) not null unique,
password varchar(255) not null
) engine=InnoDB default charset=utf8;

- t_article
CREATE TABLE t_article (
id int primary key auto_increment,
author varchar(255),
content varchar(255) not null,
create_time timestamp default current_timestamp,
type varchar(255) not null,
update_time timestamp default current_timestamp on update current_timestamp
) engine=InnoDB default charset=utf8;

Feel free if you have ideas of modifying this database.
