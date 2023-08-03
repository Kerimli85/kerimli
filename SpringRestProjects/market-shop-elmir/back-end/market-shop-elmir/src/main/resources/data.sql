insert into users
(username, password, enabled)
values
('admin','{noop}admin','1'),
('cashier','{noop}12','1');

insert into authorities
(username, authority)
values
('admin','admin'),
('cashier', 'cashier');

insert into product (name, barcode, price, cost, description, register_date, update_date, quantity) 
values 
('james g', '1234567890', 15, 10, 'james tesviri', NOW(), NOW(), 5), 
('java', '1234567890', 100, 70, 'JAVA tesviri', NOW(), NOW(), 10), 
('CSS', '1234567890', 75, 40, 'CSS tesviri', NOW(), NOW(), 6);