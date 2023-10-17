use shop

create table productorder (
	id varchar(100) primary key,
	title varchar(100) unique,
	price int(100),
	buydate date,
	addr varchar(100) default 'home' not null
)

insert into productorder(id,buydate,addr) values ('100', now(), 'office')

insert into productorder(id,title,buydate) values ('200', 'hat', now())

insert into productorder(id,title,buydate) values ('300', 'mouse', now())

select *from productorder p 



