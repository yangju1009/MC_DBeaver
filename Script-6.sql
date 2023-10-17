-- 데이터베이스 생성

create database `college`

-- 사용할 데이터베이스 지정

use college

-- 데이터베이스 테이블 확인

show tables

-- 테이블 생성

create table `Student` (
  `id` varchar(100) default null,
  `name` varchar(100) default null,
  `tel` varchar(100) default null,
  `deptid` varchar(100) default null,
  `professorid` varchar(100) default null
) engine = InnoDB default CHARSET = utf8mb4 collate = utf8mb4_0900_ai_ci;

create table `dept` (
  `deptno` int(100) default null,
  `dname` varchar(100) default null,
  `lco` varchar(100) default null,
)engine = InnoDB default CHARSET = utf8mb4 collate = utf8mb4_0900_ai_ci;

create table college.Emp (
	EmpNo INT null,
	EName varchar(100) null,
	jpb varchar(100) null,
	mgr varchar(100) null,
	hiredate DATE null,
	sal INT null,
	comm INT null,
	deptno INT null
)
engine = InnoDB
default CHARSET = utf8mb4
collate = utf8mb4_0900_ai_ci;

create table college.professor (
	id varchar(100) null,
	name varchar(100) null,
	tel varchar(100) null,
	deptid INT null,
	addr varchar(100) null,
	roomno varchar(100) null
)engine = InnoDB
default CHARSET = utf8mb4
collate = utf8mb4_0900_ai_ci;

-- dept 테이블 키 지정

ALTER TABLE college.dept ADD CONSTRAINT dept_pk PRIMARY KEY (deptno);

-- student table 키 지정

ALTER TABLE college.student ADD CONSTRAINT student_pk PRIMARY KEY (id);

ALTER TABLE college.student ADD CONSTRAINT student_FK FOREIGN KEY (deptid) REFERENCES college.dept(deptno);

-- professor table 키 지정

ALTER TABLE college.professor ADD CONSTRAINT professor_pk PRIMARY KEY (id);

ALTER TABLE college.professor ADD CONSTRAINT professor_FK FOREIGN KEY (deptid) REFERENCES college.dept(deptno);

-- emp table 키 지정

ALTER TABLE college.emp ADD CONSTRAINT emp_pk PRIMARY KEY (EmpNo);

ALTER TABLE college.emp ADD CONSTRAINT emp_FK FOREIGN KEY (deptno) REFERENCES college.dept(deptno);



