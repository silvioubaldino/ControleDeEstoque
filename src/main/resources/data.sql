insert into inventory (type_inventory) values ('Estoque de bebidas');

insert into drink_type (drink_type) values ('Alcoolica');
insert into drink_type (drink_type) values ('Nao alcoolica');

insert into section (id_inventory, id_drink_type, capacity, busy) values (1, null, 0, 0);
insert into section (id_inventory, id_drink_type, capacity, busy) values (1, null, 0, 0);
insert into section (id_inventory, id_drink_type, capacity, busy) values (1, null, 0, 0);
insert into section (id_inventory, id_drink_type, capacity, busy) values (1, null, 0, 0);
insert into section (id_inventory, id_drink_type, capacity, busy) values (1, null, 0, 0);

insert into drink (id_drink_type, drink_name, drink_volume) values (1, 'Bebida Alcoolica', 1.0);
insert into drink (id_drink_type, drink_name, drink_volume) values (2, 'Bebida Não Alcoolica', 1.0);