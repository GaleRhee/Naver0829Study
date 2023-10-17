
create table myshop(
	num smallint auto_increment primary key,
    sangpum varchar(30),
    price int,
    photo varchar(5),
    color varchar(20),
    writeday datetime
)

create table simpleboard(
	num smallint auto_increment primary key,
    writer varchar(20),
    subject varchar(1000),
    content varchar(1000),
    photo varchar(30),
    readcunt smallint default 0,
    writeday datetime
)