-- Users
INSERT INTO users (id, name, email, cpf, password, cnh, phone, role) VALUES (1, 'Admin User', 'admin@example.com', '12345678901', 'admin123', 'AB1234567', '11987654321', 'ADMIN');
INSERT INTO users (id, name, email, cpf, password, cnh, phone, role) VALUES (2, 'John Doe', 'john.doe@example.com', '98765432109', 'john123', 'CD9876543', '11912345678', 'BASIC');
INSERT INTO users (id, name, email, cpf, password, cnh, phone, role) VALUES (3, 'Jane Smith', 'jane.smith@example.com', '45678912345', 'jane123', 'EF4567890', '11923456789', 'BASIC');

-- Cars
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (1, 'Toyota Corolla', 'AUTOMATIC', 4, 5, '11911112222', 150.0);
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (2, 'Honda Civic', 'MANUAL', 4, 5, '11933334444', 140.0);
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (3, 'Ford Ka', 'AUTOMATIC', 4, 5, '11955556666', 100.0);
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (4, 'Chevrolet Onix', 'MANUAL', 4, 5, '11977778888', 120.0);
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (5, 'Renault Sandero', 'AUTOMATIC', 4, 5, '11988889999', 110.0);
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (6, 'Fiat Argo', 'MANUAL', 4, 5, '11999990000', 130.0);
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (7, 'Hyundai HB20', 'AUTOMATIC', 4, 5, '11922223333', 145.0);
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (8, 'Volkswagen Polo', 'MANUAL', 4, 5, '11944445555', 135.0);
INSERT INTO cars (id, name, gear, doors, seats, phone, price) VALUES (9, 'Nissan Versa', 'AUTOMATIC', 4, 5, '11966667777', 125.0);

-- Car Maintenance
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (1, 1, 'ABC1234', 15000, '2024-10-20');
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (2, 2, 'DEF5678', 20000, '2024-10-25');
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (3, 3, 'GHI9012', 10000, '2024-10-18');
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (4, 4, 'JKL3456', 25000, '2024-09-15');
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (5, 5, 'MNO7890', 18000, '2024-10-10');
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (6, 6, 'PQR2345', 22000, '2024-11-01');
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (7, 7, 'STU6789', 27000, '2024-10-05');
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (8, 8, 'VWX0123', 12000, '2024-09-25');
INSERT INTO car_maintenance (id, car_id, plate, km, last_maintenance) VALUES (9, 9, 'YZA4567', 30000, '2024-11-07');

 -- Leases
INSERT INTO leases (id, car_id, user_id, initial_date, final_date) VALUES (1, 1, 2, '2024-11-10', '2024-11-15');
INSERT INTO leases (id, car_id, user_id, initial_date, final_date) VALUES (2, 2, 3, '2024-11-11', '2024-11-16');