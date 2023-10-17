-- company.product3 definition

use company

CREATE TABLE `product3` (
  `id` int DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * from product3

select * from product3
order by price desc 

select name, content, price from product3
order by price 

select distinct company from product3 p 

-- 각 신발을 5개씩 주문했을 때 가격을 price5라고 항목명을 지정하여 출력

SELECT price * 5 AS price5 FROM product3;

select name, company from product3 p 
where price = 5000

select name, price, company from product3 p 
where 6000 >= price and 3000 <= price 

select company, name from product3 p 
where not company = 'c100'

select price, name from product3 p 
where company = 'c100' or company ='c200'

-- 제품명에 4로 끝나는 제품의 전체 정보 검색 

select * from product3 p 
where name like '%4'

select * from product3 p 
where content like '%food%'

-- 가격이 5000원인 제품의 content 품절로 수정

update product3 p 
set content ='품절' where price = 5000

select * from product3 p 

update product3 
set img = 'o.png', price = 10000 where id = '100' or id ='102'

select * from product3 p 

delete from product3 
where company = 'c100'

select * from product3 p 

delete  from product3 -- data 삭제

drop table product3 -- table삭제 (스키마+데이터)

select * from product3 p 

-- 주요 함수(문자함수)
-- selcet의 결과는 항상 테이블(항목명+값)

select concat(empno, ename) as 붙인글자
from emp e 

select replace(ename, 'E', 'AAA')
from emp e 

select now()

select now(), 
year(now()) as 년, 
month(now()) as 월,
HOUR (now()) as 시, 
MINUTE(now()) as 분

select * from emp

select sal + comm from emp e 

select sal, comm, sal+comm from emp e 

-- Null을 이용해서 연산을 하면 연산결과가 이상하게 나올 수 있다.
-- null을  0으로 미리 변경해라.

update emp
set comm = 0
where comm is null 

select * from emp e 

select concat(ename, job)
from emp e

update emp 
set ename = '' 
where ename is null 

-- ename의 글자수 검색

select length(ename) from emp e 

select length(ename) from emp e 
where JOB = 'manager'

select ename, job from emp e 
where COMM is null 

select HIREDATE from emp e 
where COMM is not null 

-- ename의 2번째 글자부터 끝까지 검색

select substr(ename, 2) from emp e  

select substr(JOB, 1, 3) from emp e

select replace(ename, 'k', 'p') from emp e 

select concat(empno, '번은 ', ename, '입니다') from emp e 

select concat(ename,'의 입사 날짜는 ', month(HIREDATE), '월 ',dayname(HIREDATE) ,' 입니다') from emp e  

select JOB,
	case
	when 'manager' then 'level1'
	when 'salesman' then 'level2'
	else 'level3'
	end as level_result
	from emp e 
	
select count(sal), sum(SAL), avg(SAL), min(SAL), max(SAL)  
from emp e 
where JOB = 'salesman'

select job, count(sal), sum(SAL), avg(SAL), min(SAL), max(SAL)  
from emp e 
group by JOB 

-- 집계/그룹함수 정리문제

select count(ENAME)
from emp e 

select count(ename)
from emp e 
where DEPTNO = 20 or MGR <= 7700

select min(sal)
from emp e 
where DEPTNO = 10 or DEPTNO = 20

select min(sal), max(sal), sum(sal)
from emp e 

select DEPTNO, avg(sal)
from emp e 
group by DEPTNO 

select deptno, sum(sal)
from emp e 
group by DEPTNO 
having avg(sal) >= 2000
order by DEPTNO desc 

select count(deptno), avg(sal)
from emp e 
where JOB = 'manager'

select count(deptno)
from emp e
where  ENAME like '%s%'

select count(deptno) as 직원수
from emp e 
where SAL >= 3000 and comm is not null 
order by SAL desc 

-- select의 결과는 무조건 테이블(항목명+결과값)

-- join: 2개이상의 테이블을 합해서 검색함.
-- join: 하나이상의 동일한 값의 범위를 가지는 컬럼을 양쪽 테이블에 있어야함
-- emp: deptno, dept: deptno

-- select * : 2개의 테이블에 이쓴ㄴ 모든 컬럼이 검색

select *
from dept d, emp e 
where d.DEPTNO =e.EMPNO 

select e.empno, e.ename, e2.ename, e2.sal
from emp e, emp e2 
where e.MGR =e2.MGR 

-- 직원번호, 직원이름, 관리자이름, 관리월급

select e.empno, e.ename
from emp e , emp e2 
where e.MGR = e2.EMPNO 

select * from  emp e 



  









