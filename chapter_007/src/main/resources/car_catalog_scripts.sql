create table transmission (
	id serial primary key,
	name varchar(200)
);

create table car_body (
	id serial primary key,
	name varchar(200)
);

create table engine (
	id serial primary key,
	name varchar(200)
);

insert into transmission (name) values ('four_speed');

insert into transmission (name) values ('five_speed');

insert into transmission (name) values ('six_speed');

insert into car_body (name) values ('sedan');

insert into car_body (name) values ('minivan');

insert into car_body (name) values ('suv');

insert into car_body (name) values ('coupe');

insert into engine (name) values ('v4');

insert into engine (name) values ('v6');

insert into engine (name) values ('v8');

insert into engine (name) values ('v12');

create table car (
	id serial primary key,
	name varchar(200),
	car_body_id int references car_body(id) not null,
	engine_id int references engine(id) not null,
	transmission_id int references transmission(id) not null
);

insert into car (name, car_body_id, engine_id, transmission_id) values ('ferrari', 4, 4, 3);

insert into car (name, car_body_id, engine_id, transmission_id) values ('jaguar', 1, 3, 3);

insert into car (name, car_body_id, engine_id, transmission_id) values ('jeep', 3, 2, 2);