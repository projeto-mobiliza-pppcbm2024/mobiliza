-- Users
-- User 1 - admin123
-- User 2 - john123
-- User 3 - jane123
INSERT INTO users (id, name, email, cpf, password, cnh, phone, role) VALUES (1, 'Admin User', 'admin@example.com', '12345678901', '$2a$10$.PbtOxDAJedSZxv3uWXlS.qk2bMA.BRf0B6j2L9VTYyhiDimYfbYS', 'AB1234567', '11987654321', 'ADMIN');
INSERT INTO users (id, name, email, cpf, password, cnh, phone, role) VALUES (2, 'John Doe', 'john.doe@example.com', '98765432109', '$2a$10$REpWLarqlVSt4H.Rtg9PSe9aDjGUZTx79Pu2IvOs7YGCxCQ1E64py', 'CD9876543', '11912345678', 'BASIC');
INSERT INTO users (id, name, email, cpf, password, cnh, phone, role) VALUES (3, 'Jane Smith', 'jane.smith@example.com', '45678912345', '$2a$10$vUNp5jsyH/7yPzzMb4twhOAXVM3NyseId8Lq084O52utgHh6o1f9i', 'EF4567890', '11923456789', 'BASIC');

-- Cars
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (1, 'Toyota Corolla', 'Sedan confiável e confortável, perfeito para longas viagens em família.', 'AUTOMATIC', 4, 5, '11911112222', 150.0, false);
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (2, 'Honda Civic', 'Elegância e desempenho se encontram neste sedan com visual esportivo.', 'MANUAL', 4, 5, '11933334444', 140.0, false);
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (3, 'Ford Ka', 'Compacto, econômico e fácil de estacionar, ideal para o dia a dia na cidade.', 'AUTOMATIC', 4, 5, '11955556666', 100.0, false);
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (4, 'Chevrolet Onix', 'Moderno e eficiente, com ótimo consumo de combustível e tecnologia embarcada.', 'MANUAL', 4, 5, '11977778888', 120.0, false);
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (5, 'Renault Sandero', 'Espaçoso e robusto, perfeito para aventuras tanto na cidade quanto na estrada.', 'AUTOMATIC', 4, 5, '11988889999', 110.0, false);
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (6, 'Fiat Argo', 'Versatilidade e design em um hatch que impressiona por onde passa.', 'MANUAL', 4, 5, '11999990000', 130.0, false);
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (7, 'Hyundai HB20', 'Design sofisticado e tecnologia de ponta, perfeito para o motorista moderno.', 'AUTOMATIC', 4, 5, '11922223333', 145.0, false);
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (8, 'Volkswagen Polo', 'Performance esportiva com conforto de um hatch premium.', 'MANUAL', 4, 5, '11944445555', 135.0, false);
INSERT INTO cars (id, name, description, gear, doors, seats, phone, price, rented) VALUES (9, 'Nissan Versa', 'Sedan espaçoso e econômico, ideal para viagens longas com a família.', 'AUTOMATIC', 4, 5, '11966667777', 125.0, false);

-- Car Maintenance
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (1, 1, 'ABC1234', '2024-10-20');
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (3, 3, 'GHI9012', '2024-10-18');
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (2, 2, 'DEF5678', '2024-10-25');
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (4, 4, 'JKL3456', '2024-09-15');
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (5, 5, 'MNO7890', '2024-10-10');
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (6, 6, 'PQR2345', '2024-11-01');
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (7, 7, 'STU6789', '2024-10-05');
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (8, 8, 'VWX0123', '2024-09-25');
INSERT INTO car_maintenance (id, car_id, plate, last_maintenance) VALUES (9, 9, 'YZA4567', '2024-11-07');

-- Leases
INSERT INTO leases (id, car_id, user_id, initial_date, final_date) VALUES (1, 1, 2, '2024-11-10', '2024-11-15');
INSERT INTO leases (id, car_id, user_id, initial_date, final_date) VALUES (2, 2, 3, '2024-11-11', '2024-11-16');

-- Payments
INSERT INTO payment (id, lease_id, installments, instalment_amount, payment_date, payment_method) VALUES (1, 1, 1, 750.00, '2024-11-12', 'CREDIT_CARD');
INSERT INTO payment (id, lease_id, installments, instalment_amount, payment_date, payment_method) VALUES (2, 1, 1, 750.00, '2024-11-13', 'PIX');
INSERT INTO payment (id, lease_id, installments, instalment_amount, payment_date, payment_method) VALUES (3, 2, 1, 700.00, '2024-11-14', 'DEBIT_CARD');
INSERT INTO payment (id, lease_id, installments, instalment_amount, payment_date, payment_method) VALUES (4, 2, 1, 700.00, '2024-11-15', 'PIX');

-- Sequences
ALTER SEQUENCE users_id_seq RESTART WITH 4;
ALTER SEQUENCE cars_id_seq RESTART WITH 10;
ALTER SEQUENCE car_maintenance_id_seq RESTART WITH 10;
ALTER SEQUENCE leases_id_seq RESTART WITH 3;
ALTER SEQUENCE payment_id_seq RESTART WITH 5;