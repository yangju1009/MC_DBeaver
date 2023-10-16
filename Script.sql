-- 설명/comments 

-- 1.db생성 : ctrl + enter

create database product3

use product3 --  db선택 


-- 2.table생성:항목명 결정

create table member (
	id varchar(100),
	name varchar(100),
	content varchar(100),
	price int(100),
	company varchar(100),
	img varchar(100)
)

-- Data Definition Language(DDL)
-- 여기까지는 데이터를 어떤 것을 저장할지 정의하는 문법 

-- 이 아래부터는 데이터를 어떻게 할지 조작을 하는 문법 
-- Data Manipulation Language(DML)

-- 3.data넣어보고,수정/검색/삭제 
-- varchar == String

insert into member values ('100', 'shoes1', 'fun shoes1', 1000, 'c100', '1.png')

insert into member values ('101', 'shoes2', 'fun shoes2', 2000, 'c200', '2.png')

insert into member values ('102', 'shoes3', 'fun shoes3', 3000, 'c300', '3.png')

insert into member values ('103', 'shoes4', 'fun shoes4', 4000, 'c100', '4.png')

select * from member

update member set tel = '000'

update member set tel = '999' where id = '100'

-- java ==, sql =

-- id가 200인 사람의 이름을 park이라고 수정해보세요.
update member set name = 'park' where id = '200'

-- 조건에서 and, or

delete from member where id = '100'

delete from member where id = '200' and tel = '000'

select id from member

select id, tel, name from member