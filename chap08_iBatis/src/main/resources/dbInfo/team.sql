drop table team purge;

create table team(
team_id number(2) primary key
,team_name varchar(50) not null
);
insert into team values(1,'삼성');
insert into team values(2,'LG');
insert into team values(3,'넥센');
insert into team values(4,'두산');
insert into team values(5,'롯데');
insert into team values(6,'KIA');
insert into team values(7,'SK');
insert into team values(8,'NC');
insert into team values(9,'환화');
insert into team values(10,'KT');

select * from team;

commit work;