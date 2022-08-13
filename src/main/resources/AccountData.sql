INSERT INTO user_table (acc_name, password) VALUES ('test', '123');
INSERT INTO user_table (acc_name, password) VALUES ('test2', '1234');
INSERT INTO user_table (acc_name, password) VALUES ('testupdate', '12345');


INSERT INTO items_table (item_name, price, stock, unique_itemid) values ('test', 12, 2, 123456);
INSERT INTO items_table (item_name, price, stock, unique_itemid) values ('test2', 13, 3, 1234567);
INSERT INTO items_table (item_name, price, stock, unique_itemid) values ('testupdate', 14, 4, 1234568);
INSERT INTO items_table (item_name, price, stock, unique_itemid) values ('testdeleteunique', 14, 4, 12345689);

INSERT INTO order_table(is_processing, order_quantity, order_uniqueid) values (true, 5, 123343241);
INSERT INTO order_table(is_processing, order_quantity, order_uniqueid) values (false, 6, 123343242);
INSERT INTO order_table(is_processing, order_quantity, order_uniqueid) values (true, 7, 123343243);