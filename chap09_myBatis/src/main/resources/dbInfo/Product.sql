drop table product CASCADE CONSTRAINTS;

create table Product( 
num int primary key ,
name varchar(50) not null ,
price int ,
reg_date date );

create sequence pro_seq start with 1 increment by 1;

select * from product;
insert into Product values(pro_seq.nextval,'HDTV',750000,sysdate);
insert into Product values(pro_seq.nextval,'냉장고',450000,sysdate);
insert into Product values(pro_seq.nextval,'세탁기',350000,sysdate);

commit work;