DROP DATABASE IF EXISTS QLY_Baithi;
CREATE DATABASE QLY_Baithi;
USE QLY_Baithi;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(50)
);
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    PositionName VARCHAR(50)
);

DROP TABLE IF EXISTS  `Account`;
CREATE TABLE `Account`(
	AccountID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50),
    Username VARCHAR(50),
    FullName VARCHAR(50),
    DepartmentID TINYINT NOT NULL,
    PositionID TINYINT NOT NULL,
    CreateDate DATE,
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID)
);
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    GroupName VARCHAR (20),
    CreatorID INT,
    CreateDate DATE
);
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID TINYINT ,
    AccountID TINYINT,
    JoinDate DATE,
   PRIMARY KEY(GroupID,AccountID)
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
	TypeID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Essay','Multiple-Choice')
);
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
	CategoryID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    CategoryName ENUM('JAVA','.NET','SQL','POSTMAN','RUBY')
);
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
	QuestionID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(30), 
    CategoryID TINYINT NOT NULL,
    TypeID TINYINT NOT NULL,
    CreatorID INT,
    CreateDate DATE,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
	FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID)
);
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
	AnswerID TINYINT AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(20),
    QuestionID TINYINT NOT NULL,
    isCorrect ENUM('DUNG','SAI'),
	FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)

);
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    `Code` INT,
    Title VARCHAR(30),
    CategoryID TINYINT NOT NULL,
    Duration INT,
    CreatorID INT,
    CreateDate DATE,
	FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID)
);

DROP  TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
	ExamID INT,
    QuestionID TINYINT NOT NULL,
	FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);