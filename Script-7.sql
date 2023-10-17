use college

create table depart2 (
	id varchar(100),
	name varchar(100),
	instructor varchar(100)
)

select*from depart2

desc depart2 -- 스키마가 보고 싶으면 describe

create table student2 (
	id varchar(100) primary key,
	name varchar(100),
	tel varchar(100),
	dept_id varchar(100)
)

desc student2

ALTER TABLE student2
ADD CONSTRAINT student2_FK
FOREIGN KEY (dept_id) REFERENCES depart2(id);

drop table depart2 


