-- spring_goods

create table spring_goods(
code char(5) primary key,
name varchar(30) not null,
price number(6)	not null,
maker varchar(20) not null
);

insert into spring_goods values(10001,'AAAAA',800000,'SM');
insert into spring_goods values(10002,'BBBBB',900000,'LG');
insert into spring_goods values(10003,'CCCCC',700000,'AP');

select * from spring_goods;
select code from spring_goods where code='5';
commit work;