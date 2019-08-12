DROP DATABASE IF EXISTS Railway_ticket_booking_system;

CREATE DATABASE  Railway_ticket_booking_system;

USE Railway_ticket_booking_system;

CREATE TABLE roles (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
role_name VARCHAR(30)
); 

INSERT INTO roles 
(role_name)
VALUES
('Main administrator'),
('Administrator'),
('Passenger');

CREATE TABLE users (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
email VARCHAR(40) UNIQUE NOT NULL,
`password` VARCHAR(20) NOT NULL,
phone VARCHAR(13) UNIQUE NOT NULL,
role_id INT NOT NULL,
FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO users 
(`name`, surname, email, `password`, phone, role_id)
VALUES
('Alexey', 'Bavika', 'bavikaalexey@gmail.com', '123', '+380636587296', 1),
('Admin', 'Adminovich', 'admin@gmail.com', '123', '+380842716500', 2),
('Vadim', 'Tyschenko', 'vadik@gmail.com', '234', '+380863196837', 3),
('Matvey', 'Gorskiy', 'matgorskiy@gmail.com', '1241', '+380987126592', 3),
('Andrey', 'Bogdan', 'andrb@mail.ru', 'b2f', '+380821948500', 2),
('Egor', 'Sinchukov', 'sinchuk@bigmir.ua', 'sss23', '+380872617593', 2),
('Danylo', 'Pavlenko', 'danyloPavl@gmail.com', 'cab2', '+380921658239', 3),
('Alfred', 'Torokhtiy', 'alfredtoroh@yandex.ru', 'sfsf', '+380981554728', 3),
('Alexander', 'Pushnya', 'pushnya@mail.ru', 'push', '+380127684936', 3),
('Ivan', 'Vasilenko', 'ivas@gmail.com', 'ivasik', '+380652889003', 3);


CREATE TABLE routes (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
departure_station VARCHAR(30) NOT NULL,
departure_time DATETIME NOT NULL,
destination_station VARCHAR(30) NOT NULL,
destination_time DATETIME NOT NULL
);

INSERT INTO routes
(departure_station, departure_time, destination_station, destination_time)
VALUES
('Kyiv', '2019-07-27 21:30:30', 'Lviv', '2019-07-28 05:07:00'),
('Kyiv', '2019-07-27 19:22:20', 'Moscow', '2019-07-28 21:00:00'),
('Kharkiv', '2019-08-20 20:00:00', 'Los-Angeles', '2019-08-22 05:00:00'),
('Moscow', '2019-08-23 20:00:00', 'Kyiv', '2019-08-24 20:00:00'),
('Kyiv', '2019-08-24 21:00:00', 'Paris', '2019-08-25 20:00:00'),
('Tokyo', '2019-08-24 22:00:00', 'Saint-Peterburg', '2019-08-26 05:37:00'),
('Saint-Peterburg', '2019-08-26 07:00:00', 'Tokyo', '2019-08-27 21:39:30'),
('Kyiv', '2019-08-25 22:30:00', 'Lviv', '2019-08-26 07:35:00');

CREATE TABLE trains (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
route INT NOT NULL,
berth_num INT NOT NULL,
coupe_num INT NOT NULL,
deluxe_num INT NOT NULL
);

ALTER TABLE trains CHANGE route route_id INT;
ALTER TABLE trains ADD CONSTRAINT fk_route_id FOREIGN KEY (route_id) REFERENCES routes(id);

INSERT INTO trains
(route_id, berth_num, coupe_num, deluxe_num)
VALUES
(1, 20, 10, 5),
(1, 0, 0, 30),
(2, 15, 20, 5),
(5, 5, 5, 5),
(5, 0, 0, 15),
(3, 30, 15, 10),
(4, 10, 10, 10),
(6, 7, 20, 7),
(7, 40, 20, 0);

CREATE TABLE prices (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
route_id INT NOT NULL,
berth_price INT NOT NULL,
coupe_price INT NOT NULL,
deluxe_price INT NOT NULL,
FOREIGN KEY (route_id) REFERENCES routes(id)
);

INSERT INTO prices 
(route_id, berth_price, coupe_price, deluxe_price)
VALUES
(1, 20, 100, 200),
(2, 130, 400, 800),
(3, 600, 1200, 2400),
(4, 50, 150, 300),
(5, 20, 50, 100),
(6, 70, 120, 180),
(7, 7, 15, 20),
(8, 19, 46, 79);


CREATE TABLE orders (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
passenger_id INT NOT NULL,
train_id INT NOT NULL,
place_type ENUM('berth', 'coupe', 'deluxe'),
price INT NOT NULL
);

ALTER TABLE orders ADD CONSTRAINT fk_passenger_id FOREIGN KEY (passenger_id) REFERENCES users(id) 
ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE orders ADD CONSTRAINT fk_train_id FOREIGN KEY (train_id) REFERENCES trains(id)
ON UPDATE CASCADE ON DELETE CASCADE;

CREATE TABLE change_role_requests (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
user_id INT NOT NULL,
text VARCHAR(1000),
FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO change_role_requests
(user_id, text)
VALUES
(5, 'I have admin exp > than 10 years'),
(7, 'Please make me admin!');