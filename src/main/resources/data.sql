insert into inventory (type_inventory) values ('Estoque de bebidas');

insert into drink_type (drink_type) values ('Alcoolica');
insert into drink_type (drink_type) values ('Nao alcoolica');

insert into Section (inventory, drink_type, capacity, busy) values (SELECT * FROM inventory, 1, 400, 100);
insert into Section (inventory, drink_type, capacity, busy) values (SELECT * FROM inventory, 1, 400, 100);
insert into Section (inventory, drink_type, capacity, busy) values (SELECT * FROM inventory, 1, 400, 100);
insert into Section (inventory, drink_type, capacity, busy) values (SELECT * FROM inventory, 1, 400, 100);
insert into Section (inventory, drink_type, capacity, busy) values (SELECT * FROM inventory, 1, 400, 100);

insert into Drink (drink_type, drink_name, drink_volume) values (1, 'Vodka', 1);
insert into Drink (drink_type, drink_name, drink_volume) values (1, 'Rum', 1);
insert into Drink (drink_type, drink_name, drink_volume) values (2, 'Toddynho', 0.2);
insert into Drink (drink_type, drink_name, drink_volume) values (2, 'Suco de laranja', 0.8);

insert into drink_moviment (id_drink, id_section, moviment_type, volume_mov, date_mov, responsible) values (1, 1, 'ADD', 10, '27/03/2020', 'neto');
insert into drink_moviment (id_drink, id_section, moviment_type, volume_mov, date_mov, responsible) values (1, 2, 'ADD', 10, '27/03/2020', 'neto');
insert into drink_moviment (id_drink, id_section, moviment_type, volume_mov, date_mov, responsible) values (2, 1, 'ADD', 10, '27/03/2020', 'neto');
insert into drink_moviment (id_drink, id_section, moviment_type, volume_mov, date_mov, responsible) values (3, 3, 'ADD', 10, '27/03/2020', 'neto');