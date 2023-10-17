CREATE TABLE DEPT
(
  DEPTNO  int,
  DNAME   VARCHAR(100),
  LOC     VARCHAR(100)
)

CREATE TABLE SALGRADE
(
  GRADE  int,
  LOSAL  int,
  HISAL  int
)

desc salgrade

CREATE TABLE EMP
(
  EMPNO     int,
  ENAME     VARCHAR(100),
  JOB       VARCHAR(100),
  MGR       int,
  HIREDATE  DATE,
  SAL       decimal(7,2),
  COMM      decimal(7,2),
  DEPTNO    int
)

desc emp 

-- 파일이 저장되는 위치를 알고 싶으면 alt + enter

select * from emp -- select 컬러명(열이름), * ==> all columns

select empno from emp

select DEPTNO from EMP

select distinct  DEPTNO from EMP

select deptno from emp
where DEPTNO = 10

-- sql은 대소문자를 구분하지 않음. DEPTNO, deptno, DeptNo
-- 내부적으로 처리할 때 모두 대문자로 변경해서 실행되기 때문.
-- oracle에서는 대문자로 변경해서 실행 --> 버그
-- oracle에서는 모두 대문자로 쓰기 권장

select ENAME as '이름', SAL * 12 as '연봉' from emp

select * from emp e 
order by sal asc -- 작 --> 큰 정렬(오름차순), asc 생략 가능

select * from emp e 
order by SAL desc  -- 큰 --> 작 정렬(내림차순)

select * from emp e 
where  JOB = 'manager' -- '조건'

select * from emp e 
where DEPTNO = 30 -- deptno가 30인 것만 출력

select * from emp e 
where not DEPTNO = 30 -- depno가 30이 아닌것만 출력

select * from emp e 
where DEPTNO = 30 and JOB = 'salesman' -- 조건 모두 만족 and

select * from emp e 
where DEPTNO = 30 or JOB = 'salesman' -- 조건중 하나라도 만족 or

select * from emp e 
where SAL >= 3000 -- sal이 3000이상인 항목들 출력

select * from emp e 
where SAL != 3000 -- sal이 3000이 아닌것들 출력

select distinct job from emp e -- 중복제거하면 종류를 알 수 있음.

select * from emp e 
where JOB = 'clerk' or JOB  = 'salesman' or JOB = 'manager'

select e.EMPNO, d.DEPTNO from EMP e, DEPT d
WHERE JOB in (‘CLERK’, ‘SALESMAN’, ‘MANAGER’)

select * from emp e 
where comm is null 

select * from emp e 
where comm is not null 


