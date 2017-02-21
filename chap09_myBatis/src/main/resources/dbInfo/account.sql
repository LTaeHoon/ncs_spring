--account.sql

create table account(
id varchar(20) primary key,
pwd varchar(30) not null,
name varchar(20) not null
);

insert into account values('hongkg','1234','홍길동');
insert into account values('leess','1234','이순신');
insert into account values('kimhs','1234','김희선');

select * from account;

commit work;
