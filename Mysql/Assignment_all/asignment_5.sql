-- Q1
USE qlybaithi;
CREATE VIEW DS AS
SELECT		a.*,d.DepartmentName
FROM 		`account` a
JOIN		department d
ON 			a.DepartmentID = d.DepartmentID
WHERE		d.DepartmentName = 'SALE';
SELECT 		* FROM DS;
DROP VIEW DS;

-- Q2
CREATE VIEW AC AS
SELECT a.*, COUNT(ga.AccountID) AS DEM FROM `account` a
JOIN			groupaccount ga
ON				a.AccountID= ga.AccountID
GROUP BY 		ga.AccountID
HAVING			DEM = (SELECT MAX(MAXS.DEM) 
FROM			(SELECT AccountID, COUNT(ga.AccountID) AS DEM
FROM			groupaccount ga
GROUP BY 		ga.AccountID) AS MAXS);
SELECT * FROM AC;
-- Q3
CREATE VIEW XOA AS
SELECT *FROM 	`question`
WHERE		 	LENGTH(Content) >300;
DELETE  FROM XOA WHERE LENGTH(Content) >300;

-- Q4
CREATE VIEW D4 AS
SELECT		d.*,COUNT(a.DepartmentID) AS DEM
FROM 		`account` a
JOIN		department d
ON 			a.DepartmentID = d.DepartmentID
GROUP BY	a.DepartmentID
ORDER BY	DEM DESC
LIMIT 1;
SELECT 		* FROM D4;
DROP VIEW D4;

-- Q5
CREATE VIEW Q5 AS
SELECT 		Q.*, A.FullName
FROM 		Question Q 
RIGHT JOIN 		`Account` A ON Q.CreatorID = A.AccountID
WHERE		SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen';
SELECT * FROM Q5;