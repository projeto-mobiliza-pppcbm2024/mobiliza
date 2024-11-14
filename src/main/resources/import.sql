-- Users
INSERT INTO users (id, name, email, cpf, password, cnh, phone, role) VALUES
(1, 'Admin User', 'admin@example.com', '12345678901', 'admin123', 'AB1234567', '11987654321', 'ADMIN'),
(2, 'John Doe', 'john.doe@example.com', '98765432109', 'john123', 'CD9876543', '11912345678', 'BASIC'),
(3, 'Jane Smith', 'jane.smith@example.com', '45678912345', 'jane123', 'EF4567890', '11923456789', 'BASIC');

-- Cars
INSERT INTO cars (id, name, plate, gear, doors, seats, phone, price) VALUES
(1, 'Toyota Corolla', 'ABC1234', 'AUTOMATIC', 4, 5, '11911112222', 150.0),
(2, 'Honda Civic', 'DEF5678', 'MANUAL', 4, 5, '11933334444', 140.0),
(3, 'Ford Ka', 'GHI9012', 'AUTOMATIC', 4, 5, '11955556666', 100.0),
(4, 'Chevrolet Onix', 'JKL3456', 'MANUAL', 4, 5, '11977778888', 120.0),
(5, 'Renault Sandero', 'MNO7890', 'AUTOMATIC', 4, 5, '11988889999', 110.0),
(6, 'Fiat Argo', 'PQR2345', 'MANUAL', 4, 5, '11999990000', 130.0),
(7, 'Hyundai HB20', 'STU6789', 'AUTOMATIC', 4, 5, '11922223333', 145.0),
(8, 'Volkswagen Polo', 'VWX0123', 'MANUAL', 4, 5, '11944445555', 135.0),
(9, 'Nissan Versa', 'YZA4567', 'AUTOMATIC', 4, 5, '11966667777', 125.0);

-- Leases
INSERT INTO leases (id, car_id, user_id, initialDate, finalDate) VALUES
(1, 1, 2, '2024-11-10', '2024-11-15'),
(2, 2, 3, '2024-11-11', '2024-11-16');

-- Car Maintenances
INSERT INTO car_maintenance (id, car_id, km, lastMaintenance) VALUES
(1, 1, 15000, '2024-10-20'),
(2, 2, 20000, '2024-10-25'),
(3, 3, 10000, '2024-10-18'),
(4, 4, 25000, '2024-09-15'),
(5, 5, 18000, '2024-10-10'),
(6, 6, 22000, '2024-11-01'),
(7, 7, 27000, '2024-10-05'),
(8, 8, 12000, '2024-09-25'),
(9, 9, 30000, '2024-11-07');