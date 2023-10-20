INSERT INTO tb_gadget (model, piece_price, service_price) VALUES ('Moto G5', 100.50, 200.00);
INSERT INTO tb_gadget (model, piece_price, service_price) VALUES ('iPhone 15', 120.00, 250.00);
INSERT INTO tb_gadget (model, piece_price, service_price) VALUES ('Samsung Galaxy S20 Ultra', 80.30, 180.50);
INSERT INTO tb_gadget (model, piece_price, service_price) VALUES ('Google Pixel 6', 110.70, 220.90);
INSERT INTO tb_gadget (model, piece_price, service_price) VALUES ('OnePlus 9 Pro', 105.80, 210.20);
INSERT INTO tb_gadget (model, piece_price, service_price) VALUES ('Xiaomi Mi 11', 90.60, 190.30);

INSERT INTO tb_client (cpf, name) VALUES ('05022469790', 'Caio Fernando Carvalho');
INSERT INTO tb_client (cpf, name) VALUES ('85196437606', 'Theo Luiz Aragão');
INSERT INTO tb_client (cpf, name) VALUES ('47860021943', 'Vanessa Regina Julia Castro');

INSERT INTO tb_service_item (gadget_id, client_id, inclusion_date, delivered_date, status) VALUES (1, 1, '2023-10-16', '2023-10-18', 4);
INSERT INTO tb_service_item (gadget_id, client_id, inclusion_date, delivered_date, status) VALUES (2, 1, '2023-10-15', '2023-10-19', 3);
INSERT INTO tb_service_item (gadget_id, client_id, inclusion_date, delivered_date, status) VALUES (2, 2, '2023-10-14', '2023-10-17', 2);
INSERT INTO tb_service_item (gadget_id, client_id, inclusion_date, delivered_date, status) VALUES (3, 3, '2023-10-14', '2023-10-17', 1);
INSERT INTO tb_service_item (gadget_id, client_id, inclusion_date, delivered_date, status) VALUES (4, 1, '2023-10-16', '2023-10-18', 4);
INSERT INTO tb_service_item (gadget_id, client_id, inclusion_date, delivered_date, status) VALUES (5, 1, '2023-10-15', '2023-10-19', 3);
INSERT INTO tb_service_item (gadget_id, client_id, inclusion_date, delivered_date, status) VALUES (5, 2, '2023-10-14', '2023-10-17', 2);
INSERT INTO tb_service_item (gadget_id, client_id, inclusion_date, delivered_date, status) VALUES (6, 3, '2023-10-14', '2023-10-17', 1);