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

-- 전체 테이블을 보여라
select * from `member` m 

-- id가 100인 사람의 name, content를 보여주세요.
select name, content  from member where id = '100'

select price from member where id = '102'

update member set price = 5000 where name = 'shoes1'

update member set company = 'c555' where name = 'shoes2'

update
	member set
	name = 'fun',
	price = 9999
where
id = '103'

delete from member where id ='101'

delete
from
	`member`
where
price = 3000
or img = '4.png'

DELETE FROM member 

select * from `member` m 
