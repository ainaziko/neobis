CREATE DATABASE CakeShop;
USE CakeShop;

CREATE TABLE Desserts (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
dessert_name NVARCHAR(50) NOT NULL,
dessert_description TEXT NOT NULL,
imgPath text,
price double 
); 

CREATE TABLE SoftDrinks (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
drink_name NVARCHAR(50) NOT NULL,
drink_description TEXT NOT NULL,
imgPath text,
price double 
);

CREATE TABLE Orders (
order_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
dessert_id INT UNSIGNED,
FOREIGN KEY(dessert_id) REFERENCES Desserts (id),
dessert_duplicates int,
drink_id INT UNSIGNED,
FOREIGN KEY(drink_id) REFERENCES SoftDrinks(id),
drink_duplicates int,
date_ date
);

CREATE TABLE Customers (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname NVARCHAR(100) NOT NULL,
lastname NVARCHAR(100) NOT NULL,
email NVARCHAR(100) NOT NULL,
city NVARCHAR(50) NOT NULL,
oreder_id int UNSIGNED,
FOREIGN KEY(oreder_id) REFERENCES Orders (order_id)
);