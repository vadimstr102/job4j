create database job4j_junior;

create table roles (
	id serial primary key,
	name varchar(2000)
);

create table rules (
	id serial primary key,
	name varchar(2000)
);

create table roles_rules (
	id serial primary key,
	roles_id int references roles(id),
	rules_id int references rules(id)
);

create table users (
	id serial primary key,
	name varchar(2000),
	roles_id int references roles(id)
);

create table category (
	id serial primary key,
	name varchar(2000)
);

create table state (
	id serial primary key,
	name varchar(2000)
);

create table items (
	id serial primary key,
	create_date timestamp,
	users_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table attaches (
	id serial primary key,
	name varchar(2000),
	items_id int references items(id)
);

create table comments (
	id serial primary key,
	name varchar(2000),
	items_id int references items(id)
);

insert into roles(name) values('admin');

insert into rules(name) values('control');

insert into roles_rules(roles_id, rules_id) values(1, 1);

insert into users(name, roles_id) values('Vadim', 1);

insert into category(name) values('Create Database');

insert into state(name) values('Open');

insert into items(create_date, users_id, category_id, state_id) values('2020-05-07 22:50:00', 1, 1, 1);

insert into attaches(name, items_id) values('test.txt', 1);

insert into comments(name, items_id) values('Hello, PostgreSQL!', 1);
