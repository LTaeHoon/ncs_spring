--spring_member.sql 
create table spring_member(
id varchar2(12) not null primary key,
passwd varchar2(12) not null,
name varchar2(10) not null,
reg_date date not null
);
insert into spring_member
values('hong','1234','홍길동',sysdate);

select * from spring_member;

commit work;