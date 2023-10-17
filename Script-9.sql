insert into member values ('melon', '1234', 'melon', '010');

select * from member -- * : 모든 컬럼

select id from member

select tel, id from member

select tel, name from member where id = 'apple' 

insert into member values ('melon', '1234', 'melon', '010')

select * from member -- * : 모든 컬럼

select id from member

select tel, id from member

select tel, name from member where id = 'apple'

insert into member values ('computer', '1234', 'com', null)

insert into member(id, pw, name) values ('com2', '1111', 'com2')

select * from member

