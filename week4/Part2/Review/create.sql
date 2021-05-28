create database AutoShop;

\c AutoShop;

create table Cars(
    ID integer primary key,
    mark varchar(40) not null,
    type varchar(40) not null,
    color varchar(20) not null ,
    engineVolume real not null ,
    transferType varchar(20) not null ,
    price double precision not null
);

create table Customers(
    ID serial primary key,
    firstName varchar(40) not null ,
    lastName varchar(40) not null ,
    phoneNumber varchar(20) not null ,
    email varchar(20) not null ,
    address varchar(20) not null
);

create table Orders(
    orderID serial primary key,
    customersID integer references Customers(ID),
    carsID integer references Cars(ID),
    nameOrder varchar(20) not null,	
    createdDate date not null
);





