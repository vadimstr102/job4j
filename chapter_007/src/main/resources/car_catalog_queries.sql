--1. Вывести список всех машин и все привязанные к ним детали.

select c.name, c_b.name, e.name, t.name from car as c
inner join car_body as c_b on car_body_id = c_b.id
inner join engine as e on engine_id = e.id
inner join transmission as t on transmission_id = t.id;

--2. Вывести отдельно детали, которые не используются в машине - кузова, двигатели, коробки передач.
--Кузова:

select c_b.name from car_body as c_b
left outer join car as c on c.car_body_id = c_b.id
where c.id is null;

--Двигатели:

select e.name from engine as e
left outer join car as c on c.engine_id = e.id
where c.id is null;

--Коробки передач:

select t.name from transmission as t
left outer join car as c on c.transmission_id = t.id
where c.id is null;