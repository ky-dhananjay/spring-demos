drop table if exists `roles`;
drop table if exists `members`;

create table `members`(
    user_id varchar(50) not null,
    pw char(68) not null,
    active tinyint not null,
    primary key (user_id)
) engine=InnoDB default charset=latin1;

insert into members values
('john','{noop}test123',1),
('jane','{noop}test123',1),
('jack','{noop}test123',1);

create table roles(
user_id varchar(50) not null,
role varchar(50) not null,
unique key authorities5_idx_1 (user_id,role),
constraint authorities5_ibfk_1 foreign key(user_id) references members(user_id)
)engine=InnoDB default charset=latin1;

insert into roles values
('john','ROLE_EMPLOYEE'),
('jack','ROLE_EMPLOYEE'),
('jack','ROLE_MANAGER'),
('jane','ROLE_EMPLOYEE'),
('jane','ROLE_MANAGER'),
('jane','ROLE_ADMIN');

