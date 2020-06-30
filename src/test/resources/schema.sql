drop table if exists user;

create table user(
  user_id INT AUTO_INCREMENT  PRIMARY KEY,
  name varchar(60) not null,
  email varchar(60) not null,
  password varchar(60) not null
);