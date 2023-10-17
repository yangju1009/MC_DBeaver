use shop4

select * from bbs b 

select * 
from `member` m , bbs b
where b.writer = m.id 

select *
from `member` m
left outer join bbs b
on (b.writer = m.id)

select *
from `member` m 
right outer join bbs b 
on (b.writer=m.id)

select *
from product p 
right outer join company c 
on (p.company=c.id)

-- UNION(집합)

use company

select *
from emp
where deptno = 10

