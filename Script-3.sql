USE book;

CREATE TABLE writer_info (
    id VARCHAR(100),
    name VARCHAR(100),
    publisher VARCHAR(100),
    tel VARCHAR(100)
);

INSERT INTO writer_info (id, name, publisher, tel)
VALUES ('writer1', '벤저민 하디', '상상스퀘어', '010-1234-4567');

INSERT INTO writer_info (id, name, publisher, tel)
VALUES ('writer2', '미야자키 하야오', '다우출판사', '010-2345-6789');

INSERT INTO writer_info (id, name, publisher, tel)
VALUES ('writer3', '김난도, 전미영, 최지혜, 외 9명', '미래의창', '010-3456-7890');

SELECT * FROM writer_info

SELECT * FROM writer_info
WHERE id = 'writer1';

update writer_info set tel = '010-2131-2135' where id = 'writer3'

SELECT * FROM writer_info
WHERE id = 'writer3';

