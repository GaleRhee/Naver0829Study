create table bit701.test(
	num smallint primary key,
    name varchar(20) primary key,
    age smallint default 10,
    birthday date
    ); 
    -- Error : Multiple primary key defined
   
   
   create table bit701.test(
	num smallint,
    name varchar(20),
    age smallint default 10,
    birthday date,
    constraint test_pk_numname primary key(num,name)
    );
    
    insert into bit701.test values (1,'lee',10,now());
	insert into bit701.test values (2,'lee',10,now());
	insert into bit701.test values (1,'kim',10,now());
	insert into bit701.test values (1,'lee',10,now());
    
    