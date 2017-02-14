-- team.sql

create table team(
team_id number(2) primary key,
team_name varchar(20) not null
);

insert into team values(1,'삼성');
insert into team values(2,'LG');
insert into team values(3,'KIA');
insert into team values(4,'두산');
insert into team values(5,'넥센');

select * from TEAM;

commit work;