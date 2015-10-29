
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));


CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
  
  
 
  insert into users values ('hugo','1234',1);
  insert into user_roles  (username, role) values ('hugo','ROLE_USER');
  insert into user_roles  (username, role) values ('hugo','ROLE_ADMIN');
  
select r.user_role_id, u.username,u.password, r.role from users u inner join user_roles  r on u.username=r.username;
select * from user_roles;

update users set password='03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',enabled=1 where username='hugo';
update users set password='$2a$10$x2rbddASJTNUhlgxzdtSuOxR.UMoVOUDsv.75kvkEFRoHiCS7eFQK',enabled=1 where username='hugo';
update user_roles set role='ROLE_USER' where user_role_id=1;
  
  
select username,password,enabled from users where username='hugo';
  
select user_role_id,username,role from user_roles where username='hugo';