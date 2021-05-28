CREATE DATABASE TemptingMorsels;
USE TemptingMorsels;

CREATE TABLE Desserts (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
dessert_name NVARCHAR(50) NOT NULL,
dessert_description TEXT,
imgPath TEXT NOT NULL,
price double NOT NULL
);

CREATE TABLE Soft_Drinks (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
drink_name NVARCHAR(50) NOT NULL,
drink_description TEXT,
imgPath TEXT NOT NULL,
price double NOT NULL
);

CREATE TABLE Orders (
order_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
customer_id INT UNSIGNED,
dessert_id INT UNSIGNED,
num_of_desserts INT,
drink_id INT UNSIGNED,
num_of_drinks INT,
order_date datetime
);

CREATE TABLE Customer (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname NVARCHAR(80) NOT NULL,
lastname NVARCHAR(100) NOT NULL,
email NVARCHAR(100) NOT NULL,
city NVARCHAR(80) NOT NULL
);

ALTER TABLE Orders ADD CONSTRAINT fk_dessert_id FOREIGN KEY (dessert_id) REFERENCES Desserts(id);
ALTER TABLE Orders ADD CONSTRAINT fk_drink_id FOREIGN KEY (drink_id) REFERENCES Soft_Drinks(id);
ALTER TABLE Orders ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES Customer(id);
