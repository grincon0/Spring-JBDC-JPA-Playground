create table person 
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key (id)
);

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10001, 'George', 'Atlanta', sysdate());

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10021, 'Wake', 'Atlanta', sysdate());

INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10031, 'Ocean', 'Atlanta', sysdate());

