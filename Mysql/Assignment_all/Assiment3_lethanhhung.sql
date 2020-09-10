DROP DATABASE IF EXISTS QLYBaithi;
CREATE DATABASE QLYBaithi;
USE QLYBaithi;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    PositionName VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS  `Account`;
CREATE TABLE `Account`(
	AccountID TINYINT  AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) NOT NULL UNIQUE KEY,
    Username VARCHAR(50) NOT NULL,
    FullName VARCHAR(50) NOT NULL,
    DepartmentID TINYINT NOT NULL,
    PositionID TINYINT NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID) ON DELETE CASCADE,
    FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID) ON DELETE CASCADE
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
    JoinDate DATETIME DEFAULT NOW(),
   PRIMARY KEY(GroupID,AccountID),
   FOREIGN KEY (GroupID) REFERENCES `Group` (GroupID),
   FOREIGN KEY (AccountID) REFERENCES `Account` (AccountID)
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
	FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID) ON DELETE CASCADE 
);

DROP  TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
	ExamID INT,
    QuestionID TINYINT NOT NULL,
	FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

INSERT INTO Department (DepartmentName) VALUES ('developer'),('Demo'),('SALE'),('ASSIGNMENT'),
('DELEVER'),('BILL'),('PAY');
INSERT INTO `Position` (PositionName) VALUES ('manager'),
('employee'),('profesor'),('Leader'),('Custommer'),('Asignment');
INSERT INTO `Group` (GroupName,CreatorID,CreateDate) VALUES
('T_LEADER',1,'1999/1/1'),('T_EMPLOYEE',2,'2020/11/11'),('T_CUSTOMER',6,'2021/6/6'),('T_PROFESOR',5,'2022/4/5');
INSERT INTO `Account` (Email,Username,FullName,DepartmentID,PositionID,CreateDate)
VALUES ('A.COM','HUNG','LEHUNG',1,3,'2010/12/20'),('B.COM','TUNG','NGUETUNG',3,1,'2010/11/11'),
('C.COM','ALL','AN',2,4,'2021/1/12'),('D.COM','DEL','DEN',2,3,'1999/10/11'),
('E.COM','QUA','QUAN',1,3,'2020/11/11'),('F.COM','TOA','TOAN',3,3,'2021/11/1'),
('G.COM','GUN','GUNG',2,2,'2001/1/1');
INSERT INTO GroupAccount (GroupID,AccountID) VALUES (4,4),
(2,1),(1,2),(1,3),(2,3),
(2,2),(1,4),(4,2),(3,3);
SELECT *FROM GroupAccount;
INSERT INTO TypeQuestion (TypeName) VALUES ('Multiple-Choice'),
('Essay');
INSERT INTO CategoryQuestion (CategoryName) VALUES ('JAVA'),('.NET'),('SQL'),('POSTMAN'),('RUBY');
INSERT INTO Question (Content,CategoryID,TypeID,CreatorID,CreateDate) 
VALUES ('ABCD',1,2,3,'2020/2/2'),('BCD',2,2,2,'2021/12/12'),('DDC',2,2,3,'2021/4/2'),
('AMC',1,1,1,'2017/2/21'),('ANC',3,2,3,'2010/2/27'),
('AEC',3,2,3,'2019/2/22'),('AMC',4,1,3,'2030/2/26'),('QQC',2,2,3,'2022/3/2'),
('AZC',4,2,1,'2018/2/23'),('AHC',1,1,3,'2010/2/25');
select *from Question;
INSERT INTO Answer (Content,QuestionID,isCorrect) VALUES
 ('L0IF',4,'DUNG'),('BBC',1,'SAI'),('LAA',2,'DUNG'),('WWW',1,'SAI'),
 ('ACC',2,'SAI'),('JSS',2,'SAI'),('USS',1,'SAI'),('EEE',2,'DUNG'),
 ('ACC',2,'SAI'),('LLR',1,'DUNG');
 select *from Answer;
 INSERT INTO Exam (`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) VALUES 
  (11125,'WAN',1,60,1,'2019/2/23'),
 (10,'TI',3,100,1,'2019/2/23'),
 (111,'ZAN',4,10,1,'2010/2/23'), (11131,'MAN',1,50,1,'2019/2/23'),
 (1123,'ZIM',1,101,1,'2011/2/23');
 INSERT INTO ExamQuestion (ExamID,QuestionID) VALUES (1,1),(2,1),
 (3,3),(4,1),(5,5),(2,4),(4,1),(1,3),(3,1),(1,5);
 SELECT *FROM ExamQuestion;

-- Q2 lấy ra tất cả các phòng ban
SELECT DepartmentName FROM Department;
-- Q3 lấy ra id của phòng ban sale
SELECT DepartmentID FROM Department WHERE DepartmentName = 'SALE';
-- Q4 LẤY RA ACC có full name dài nhất sx giảm
SELECT * FROM 	`Account` 
WHERE          	LENGTH(FullName) = (SELECT MAX(LENGTH(FullName)) 
FROM 			`Account`)  
ORDER BY 		FullName DESC;
-- Q5 LẤY RA ACC có full name dài nhất thuộc phòng ban id=3
SELECT * FROM 	`Account`
WHERE			LENGTH(FullName) = 
(SELECT 		MAX(LENGTH(FullName))
FROM 			`Account`)
AND 			DepartmentID =3;
-- Q6 Lất ra gr đã tham gia trước ngày 20/12/2019
SELECT 		GroupName 
FROM 		`Group`
WHERE		CreateDate < '2019/12/20';
-- Q7 lay ra id cua question >=4 cau trloi
SELECT 		QuestionID
FROM		Answer
GROUP BY 	QuestionID
HAVING		QuestionID>=4;
-- Q8 lay ma de thi cos time>=60p va <20/12/2019
SELECT 		`Code`
FROM		Exam
WHERE		Duration>=60 
AND			CreateDate < '2019/12/20';
-- Q9 5 gr tao gan day
SELECT 		*
FROM		`Group`
ORDER BY CreateDate DESC
LIMIT 5;
-- Q10 dem so nv thuoc department co id=2
SELECT 		COUNT(AccountID) AS DEM
FROM		`Account`
WHERE		DepartmentID =2;
-- Q11 LAY RA TT NV CO TEN BD LA D VA ket thuc la o
SELECT 		*
FROM		`Account`
WHERE		FullName
LIKE 'D%o';
-- q12 xoa cac ban ghi truoc ngay 20/12/2019
DELETE 
FROM		Exam
WHERE 		CreateDate < '2019/12/20';
-- Q13 Xoa acc bd bang hai chu nguyn hai
DELETE 
FROM		`Account`
WHERE		(SUBSTRING_INDEX(FullName,' ',2))= 'Nguyễn Hải';
-- q14 update acc id=5 thanh ten 'Nguyễn bá Lộc' và email thành 'loc.nguyenba@vti.com.vn
UPDATE		`Account`
SET			FullName = N'Nguyễn bá Lộc'  , Email = 'loc.nguyenba@vti.com.vn'
WHERE		AccountID =5;
-- Q15 update acc id=5 thuoc gr id=4
UPDATE		GroupAccount
SET			AccountID =5
WHERE		GroupID =4;







 

 
