-- Assignment 1:
-- EX1:
CREATE DATABASE TrainingManagement;			
USE TrainingManagement;
DROP TABLE IF EXISTS TRAINEE;
-- TAO 1 BẢNG
CREATE TABLE TRAINEE(
		TraineeID 				TINYINT AUTO_INCREMENT PRIMARY KEY,
        Full_Name 				VARCHAR(30),
        Birth_Date 				DATE,
        Gender					ENUM('male,','female','unknown'),
        ET_IQ 					TINYINT(20),
        ET_Gmath				TINYINT(20),
        ET_English				TINYINT(50),
        Training_Class 			VARCHAR(30),
        Evaluation_Notes		VARCHAR(30)
        
);
-- THEM 1 TRUONG
ALTER TABLE TRAINEE ADD  VTI_Account VARCHAR(20) NOT NULL UNIQUE;
		-- EX2:
-- 	ID		 		TINYINT AUTO_INCREMENT PRIMARY KEY
-- 	Name		 	VARCAHR(20)
--	Code 			INT(5)
-- ModifiedDate	DATE
		-- EX3
-- 	ID		 		TINYINT AUTO_INCREMENT PRIMARY KEY
-- 	Name		 	VARCAHR(20)
-- BirthDate		DATE
-- Gender			ENUM('0','1','NULL')
-- IsDeletedFlag	ENUM('0','1')


-- Assignment 3:
-- EX1:ADD 10 RECORD
SELECT *FROM TRAINEE;
INSERT INTO TRAINEE (Full_Name,Birth_Date,Gender,ET_IQ,ET_Gmath,ET_English,Training_Class,Evaluation_Notes,VTI_Account)
VALUES 				('HUNG'	,'1999/07/29','female',	1,		4,		8,			'ABC1',			'not key',		'EJGJR'),
					('tien'	,'2000/07/11','male',	9,		4,		3,			'cc1',			'not key',		'BDWD1'),
                    ('DUNG'	,'1999/07/29','male',	10,		6,		8,			'GC1',			' key',			'CWDWW'),
					('QUANG','2000/07/11','male',	4,		4,		3,			'HH1',			'key',			'DAASD'),
                    ('SANG'	,'1999/07/29','male',	1,		6,		2,			'RRC1',			'not key',		'EQWQ'),
					('VAN'	,'2000/07/11','female',	6,		7,		3,			'TT',			'not key',		'FFEF'),
					('TINH'	,'2000/07/11','male',	8,		6,		8,			'UU',			'not key',		'HFRG'),
                    ('TONG'	,'1999/07/29','female',	1,		4,		8,			'III',			'not key',		'JRTTT'),
                    ('LINH'	,'1999/07/29','female',	10,		7,		10,			'ZZZ',			'key',			'OJJJ'),
					('LAN'	,'2000/07/11','female',	9,		4,		3,			'CCCC',			'not key',		'LT4G');
-- EX2: passed the entry test, group them into different birth months
SELECT *FROM TRAINEE WHERE ET_English>7 GROUP BY Birth_Date;
SELECT (2020-YEAR(Birth_Date)),Full_Name FROM TRAINEE WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name))FROM TRAINEE);
