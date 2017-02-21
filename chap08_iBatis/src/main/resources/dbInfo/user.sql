-- user.sql

create table user1(
user_id varchar(20) primary key,
user_pwd varchar(20) not null,
user_name varchar(20) not null
);

insert into user1 values('hong','1234','홍길동');
insert into user1 values('yoo','4567','유관순');

select * from user1;
commit work;
