-- username: webphp, password: password, this is user to connect to db
DROP DATABASE IF EXISTS finaldb;

CREATE DATABASE finaldb;

USE finaldb;

CREATE TABLE auth
(
	userID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username varchar(60),
	password varchar(60),
	firstName varchar(60),
	lastName varchar(60),
	email varchar(60),
	phone varchar(60)
);

-- insert 3 records
INSERT INTO auth (username, password, firstName, lastName, email, phone)
VALUES ('andrewP123', 'password1', 'Andrew', 'Proton', 'andrew.proton@gmail.com', '(123)456-7890');
INSERT INTO auth (username, password, firstName, lastName, email, phone)
VALUES('bobE123', 'password2', 'Bob', 'Electron', 'bob.electron@gmail.com', '(321)654-0987');
INSERT INTO auth (username, password, firstName, lastName, email, phone)
VALUES('carlN123', 'password3', 'Carl', 'Neutron', 'carl.neutron@gmail.com', '(321)321-4214');
