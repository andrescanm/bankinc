-- Insertar datos de prueba para Customer
INSERT INTO customer (first_name, middle_name, last_name, second_last_name) VALUES ('John', 'Alexander', 'Doe', null);
INSERT INTO customer (first_name, middle_name, last_name, second_last_name) VALUES ('Jane', null, 'Smith', null);
INSERT INTO customer (first_name, middle_name, last_name, second_last_name) VALUES ('Robert', 'James', 'Johnson', 'Williams');
INSERT INTO customer (first_name, middle_name, last_name, second_last_name) VALUES ('Michael', null, 'Brown', null);
INSERT INTO customer (first_name, middle_name, last_name, second_last_name) VALUES ('Emily', null, 'Davis', null);

-- Insertar datos de prueba para Card
INSERT INTO card (card_number, card_holder, expiration_date, active, balance, blocked, card_type, customer_id)
VALUES ('1111222233334444', 'JOHN DOE', '2025-06-30', true, 1000.00, false, 'CREDIT', 1);

INSERT INTO card (card_number, card_holder, expiration_date, active, balance, blocked, card_type, customer_id)
VALUES ('2222333344445555', 'JOHN DOE', '2024-12-31', true, 500.00, false, 'DEBIT', 1);

INSERT INTO card (card_number, card_holder, expiration_date, active, balance, blocked, card_type, customer_id)
VALUES ('3333444455556666', 'JANE SMITH', '2023-09-30', true, 2000.00, false, 'CREDIT', 2);

INSERT INTO card (card_number, card_holder, expiration_date, active, balance, blocked, card_type, customer_id)
VALUES ('4444555566667777', 'ROBERT JOHNSON', '2026-03-31', true, 1500.00, false, 'DEBIT', 3);

INSERT INTO card (card_number, card_holder, expiration_date, active, balance, blocked, card_type, customer_id)
VALUES ('5555666677778888', 'MICHAEL BROWN', '2024-11-30', true, 300.00, false, 'CREDIT', 4);

INSERT INTO card (card_number, card_holder, expiration_date, active, balance, blocked, card_type, customer_id)
VALUES ('6666777788889999', 'EMILY DAVIS', '2025-07-31', true, 700.00, false, 'DEBIT', 5);
