insert into dish (id,name,creation_date,last_modified_date) values (1,'Quiche','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into dish (id,name,creation_date,last_modified_date) values (2,'Rice','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into dish (id,name,creation_date,last_modified_date) values (3,'Potato','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into dish (id,name,creation_date,last_modified_date) values (4,'Tomato','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into dish (id,name,creation_date,last_modified_date) values (5,'Cucumber','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');

insert into ingredient (id,name,creation_date,last_modified_date) values (1,'Tomato','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into ingredient (id,name,creation_date,last_modified_date) values (2,'Paprika (groen)','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into ingredient (id,name,creation_date,last_modified_date) values (3,'Paprika (rood)','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into ingredient (id,name,creation_date,last_modified_date) values (4,'Radiches','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into ingredient (id,name,creation_date,last_modified_date) values (5,'Cucumber','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');

insert into ingredient_unit (id, name,creation_date,last_modified_date) values (1,'pieces','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into ingredient_unit (id, name,creation_date,last_modified_date) values (2,'teaspoons','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into ingredient_unit (id, name,creation_date,last_modified_date) values (3,'gr','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into ingredient_unit (id, name,creation_date,last_modified_date) values (4,'kg','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');
insert into ingredient_unit (id, name,creation_date,last_modified_date) values (5,'ml','1986-11-12T04:32:59.000+02:00','1986-11-13T04:32:59.000+02:00');

insert into menu (id, creation_date, last_modified_date, end_date, start_date, week_nr) values (1, '2015-07-04 12:33:13.019', '2015-07-04 12:33:13.019', '2015-06-21 21:59:59.0', '2015-06-15 00:00:00.0', 25)
insert into menu (id, creation_date, last_modified_date, end_date, start_date, week_nr) values (2, '2015-07-04 12:33:13.019', '2015-07-04 12:33:13.019', '2015-06-28 21:59:59.0', '2015-06-22 00:00:00.0', 26)
insert into menu (id, creation_date, last_modified_date, end_date, start_date, week_nr) values (3, '2015-07-04 12:33:13.019', '2015-07-04 12:33:13.019', '2015-07-05 21:59:59.0', '2015-06-29 00:00:00.0', 27)

insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (1, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 1, 1)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (2, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 2, 1)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (3, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 3, 1)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (4, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 4, 1)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (5, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 5, 1)

insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values ( 6, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 3, 2)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values ( 7, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 4, 2)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values ( 8, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 5, 2)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values ( 9, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 1, 2)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (10, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 2, 2)

insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (11, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 3, 3)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (12, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 4, 3)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (13, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 5, 3)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (14, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 1, 3)
insert into menu_dish (id, creation_date, last_modified_date, dish_id, menu_id) values (15, '2015-07-04 12:33:13.035', '2015-07-04 12:33:13.035', 2, 3)