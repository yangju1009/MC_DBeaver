-- 주석 

-- shop, shop2, sys

-- db > table > 항목(field, item, property attribute)

-- shop을 선택후, SQL버튼을 클릭한 경우, shop이 선택된 것.

-- create table a ==> shop db에 만들어짐.

-- 다른 db를 사용하고 싶은 경우

-- use shop2

-- create table b ==> shop2 db에 만들어짐.

-- DCL : create, alter, drop

create user 'summer3'@'localhost' identified by '1111'

grant all privileges
on *.*
to 'summer3'@'localhost'

-- apple / 1234 생성 후 디비버에서 재연결

