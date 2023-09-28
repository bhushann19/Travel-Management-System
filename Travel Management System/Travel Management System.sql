CREATE DATABASE travelmanagementsystem;

SHOW DATABASES;

USE travelmanagementsystem;

CREATE TABLE account(username varchar(20), name varchar(20), password varchar(20), security varchar(100), answer varchar(50));

SHOW TABLES;

SELECT * FROM ACCOUNT;

CREATE TABLE customer(username varchar(20), id varchar(30), number varchar(30), name varchar(30), gender varchar(20), country varchar(30),
 address varchar(50), phone varchar(30), email varchar(30));
 
SELECT * FROM CUSTOMER; 

CREATE TABLE bookpackage(username varchar(20), package varchar(30), person varchar(20), id varchar(30), number varchar(30), phone varchar(30), price varchar(30));

select * from bookpackage;

CREATE TABLE hotel(name varchar(30), costperperson varchar(30), acroom varchar(10), foodinluded varchar(10));

INSERT INTO hotel VALUES('Radisson Blue Hotel', '3400', '1000', '1700');
INSERT INTO hotel VALUES('River View Hotel', '2400', '1600', '1000');
INSERT INTO hotel VALUES('The taj Hotel', '4800', '1290', '2900');
INSERT INTO hotel VALUES('The Ashoka Hotel', '3000', '1000', '1200');

SELECT * FROM hotel;

CREATE TABLE bookhotel(username varchar(30), name varchar(30), persons varchar(20), days varchar(20), ac varchar(10), food varchar(10), id varchar(30), number varchar(30), phone varchar(30), price varchar(30));

SELECT * FROM bookhotel;