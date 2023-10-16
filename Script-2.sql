CREATE DATABASE book;

USE book;

CREATE TABLE book_info (
    id VARCHAR(100),
    title VARCHAR(100),
    genre VARCHAR(100),
    price INT
);

INSERT INTO book_info (id, title, genre, price)
VALUES ('book1', '퓨처 셀프', '자기계발', 17820);

INSERT INTO book_info (id, title, genre, price)
VALUES ('book2', '책으로 가는 문', '독서에세이', 15120);

INSERT INTO book_info (id, title, genre, price)
VALUES ('book3', '트렌드 코리아2024', '트렌드/미래전망 일반', 17100);

SELECT * FROM book_info

SELECT * FROM book_info
WHERE id = 'book1';

update book_info set genre = '경영전략/혁신' where id = 'book3'

SELECT * FROM book_info
WHERE id = 'book3';

delete from book_info  where id ='book3'


SELECT * FROM book_info
WHERE id = 'book3';