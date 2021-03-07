drop table if exists kotlinserver2.User;
create table if not exists kotlinserver2.User (id int auto_increment,name varchar(100),pass varchar(100),role varchar(100),Primary key(id));