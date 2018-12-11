DROP DATABASE IF EXISTS books;

CREATE DATABASE books;

USE books;

CREATE TABLE Authors
(
   AuthorID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   FirstName varchar(60),
   LastName varchar(60)
);

INSERT INTO Authors (FirstName,LastName) VALUES ('Paul','Deitel');
INSERT INTO Authors (FirstName,LastName) VALUES ('Harvey','Deitel');
INSERT INTO Authors (FirstName,LastName) VALUES ('Abbey','Deitel');
INSERT INTO Authors (FirstName,LastName) VALUES ('Michael','Morgano');
INSERT INTO Authors (FirstName,LastName) VALUES ('Eric','Kern');
-----
CREATE TABLE Titles
(
   ISBN varchar(60) NOT NULL PRIMARY KEY ,
   Title varchar(60),
   EditionNumber int,
   Copyright varchar(60)
);
INSERT INTO Titles (ISBN,Title,EditionNumber,Copyright) VALUES ('0132152134','Visual Basic 2010 How to Program',5,'2011');
INSERT INTO Titles (ISBN,Title,EditionNumber,Copyright) VALUES ('0132151421','Visual C# 2010 How to Program',4,'2011');
INSERT INTO Titles (ISBN,Title,EditionNumber,Copyright) VALUES ('0132575663','Java How to Program',9,'2012');
INSERT INTO Titles (ISBN,Title,EditionNumber,Copyright) VALUES ('0132662361','C++ How to Program',8,'2012');
INSERT INTO Titles (ISBN,Title,EditionNumber,Copyright) VALUES ('0132404168','C How to Program',6,'2010');
INSERT INTO Titles (ISBN,Title,EditionNumber,Copyright) VALUES ('013705842X','iPhone for Programmers: An App-
Driven Approach',1,'2010');
INSERT INTO Titles (ISBN,Title,EditionNumber,Copyright) VALUES ('0132121360','Android for Programmers: An App-
Driven Approach',1,'2012');

----
CREATE TABLE AuthorISBN
(
   AuthorID int NOT NULL,
   ISBN varchar(60) NOT NULL,
   PRIMARY KEY (AuthorID,ISBN),

   FOREIGN KEY  fk_AuthorID(AuthorID)
   REFERENCES Authors(AuthorID)
   ON UPDATE CASCADE
   ON DELETE RESTRICT,

   FOREIGN KEY  fk_ISBN(ISBN)
   REFERENCES Titles(ISBN)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
);
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (1,'0132152134');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (2,'0132152134');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (1,'0132151421');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (2,'0132151421');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (1,'0132575663');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (1,'013705842X');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (2,'013705842X');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (3,'013705842X');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (4,'013705842X');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (5,'013705842X');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (2,'0132575663');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (1,'0132662361');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (2,'0132662361');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (1,'0132404168');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (2,'0132404168');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (1,'0132121360');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (2,'0132121360');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (3,'0132121360');
INSERT INTO AuthorISBN (AuthorID,ISBN) VALUES (4,'0132121360');
