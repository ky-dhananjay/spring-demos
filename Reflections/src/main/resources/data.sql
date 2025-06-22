--create table person
--(
--    id integer not null,
--    name varchar(200) not null,
--    location varchar(20),
--    birth_date timestamp,
--    primary key(id)
--);

INSERT INTO person
(id, name, location, birth_date)
VALUES
(10001, 'dhananjay', 'Noida', CURRENT_TIMESTAMP());
INSERT INTO person
(id, name, location, birth_date)
VALUES
(10002, 'dj', 'Hyderabad', NOW());
INSERT INTO person
(id, name, location, birth_date)
VALUES
(10003, 'bunti', 'Ghazipur', NOW());
INSERT INTO person
(id, name, location, birth_date)
VALUES
(10004, 'dky', 'Varanasi', NOW());

insert into course(id, name)
values
(10001, 'JPA Datasource');
insert into course(id, name)
values
(10002, 'JPA Datasource');
insert into course(id, name)
values
(10003, 'JPA Datasource');