INSERT INTO category (name) VALUES ('Fruit');
INSERT INTO category (name) VALUES ('Vegetable');
INSERT INTO category (name) VALUES ('Phone');
INSERT INTO category (name) VALUES ('Laptop');
INSERT INTO category (name) VALUES ('TV');

INSERT INTO product (name, price, count, category_id) VALUES ('Apple', 106, 15, 1);
INSERT INTO product (name, price, count, category_id) VALUES ('Banana', 100, 10, 1);
INSERT INTO product (name, price, count, category_id) VALUES ('Potato', 123, 12, 2);
INSERT INTO product (name, price, count, category_id) VALUES ('Samsung', 1062, 100, 3);
INSERT INTO product (name, price, count, category_id) VALUES ('iPhone', 1412, 150, 3);
INSERT INTO product (name, price, count, category_id) VALUES ('Lenovo', 1123, 231, 4);
INSERT INTO product (name, price, count, category_id) VALUES ('Asus', 1213, 131, 4);
INSERT INTO product (name, price, count, category_id) VALUES ('Artel', 532, 43, 5);

INSERT INTO transactions (product_id, count, type) VALUES (1, 5, 'INPUT');
INSERT INTO transactions (product_id, count, type) VALUES (2, 4, 'INPUT');
INSERT INTO transactions (product_id, count, type) VALUES (3, 1, 'OUTPUT');
INSERT INTO transactions (product_id, count, type) VALUES (4, 5, 'INPUT');
INSERT INTO transactions (product_id, count, type) VALUES (5, 2, 'INPUT');
INSERT INTO transactions (product_id, count, type) VALUES (6, 10, 'OUTPUT');