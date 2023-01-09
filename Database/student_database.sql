CREATE DATABASE student_database;
USE student_database;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE users_list
(
    UID varchar(7),
    Password varchar(20),
    post Int,
    PRIMARY KEY(UID)
);

CREATE TABLE Student_Details
(
    Name varchar(200),
    URN varchar(7),
    Branch varchar(3),
    PRIMARY KEY(URN)
);

CREATE TABLE Mess_Details
(
    URN varchar(7),
    No_of_days int,
    Dues int,
    FOREIGN KEY(URN) REFERENCES Student_Details(URN)
);

CREATE TABLE Books_Details
(
    Book_ID varchar(10),
    Book_Name varchar(200),
    Author varchar(200),
    Count int,
    PRIMARY KEY(Book_ID)
);

CREATE TABLE Book_Issue_List
(
    Book_ID varchar(10),
    URN varchar(7),
    Date_of_Issue DATE,
    Date_of_Return DATE,
    Dues Int,
    FOREIGN KEY(Book_ID) REFERENCES Books_Details(Book_ID),
    FOREIGN KEY(URN) REFERENCES Student_Details(URN)
);

CREATE TABLE Sports_Equipment_Details
(
    Equipment_ID varchar(10),
    Equipment_Name varchar(200),
    Count int,
    PRIMARY KEY(Equipment_ID)
);

CREATE TABLE Equipment_Issue_List
(
    Equipment_ID varchar(10),
    URN varchar(7),
    Date_of_Issue DATE,
    Date_of_Return DATE,
    Dues Int,
    FOREIGN KEY(Equipment_ID) REFERENCES Sports_Equipment_Details(Equipment_ID),
    FOREIGN KEY(URN) REFERENCES Student_Details(URN)
);

show tables;