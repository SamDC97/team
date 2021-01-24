drop table if exists team_entity CASCADE;
create table team_entity (id bigint not null, car_id bigint, driver_id1 bigint, driver_id2 bigint, name varchar(255), primary key (id));

insert into team_entity (id, name, car_id, driver_id1, driver_id2) values
 (1, 'Alfa Romeo Racing', 1, 11, 3),
 (2, 'AlphaTauri', 2, 7, 16),
 (3, 'Ferrari', 3, 18, 5),
 (4, 'Haas', 4, 17, 10),
 (5, 'McLaren', 5, 4, 13),
 (6, 'Mercedes', 6, 1, 20),
 (7, 'Racing Point', 7, 19, 12),
 (8, 'Red Bull', 8, 14, 2),
 (9, 'Renault', 9, 6, 8),
 (10, 'Williams', 10, 9, 15);