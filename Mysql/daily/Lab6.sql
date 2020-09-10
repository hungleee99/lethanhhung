
-- 1 CTE  được bắt đầu bằng WITH Name_cte AS ()
WITH CTE_Test AS (
		SELECT 			AccountID, COUNT(ga.AccountID) AS DEM
		FROM			groupaccount ga
		GROUP BY 		ga.AccountID
				 ),
	CTE_Test_2 AS (
		SELECT 			AccountID, COUNT(ga.AccountID) AS DEM
		FROM			groupaccount ga
		GROUP BY 		ga.AccountID
				 )
SELECT 	AccountID,DEM
FROM 	CTE_Test
WHERE	DEM = (SELECT MAX(DEM) FROM
				CTE_Test);

USE classicmodels;
-- Store Routine
CREATE TABLE `customers_SS` (
  `customerNumber` int(11) NOT NULL,
  `customerName` varchar(50) NOT NULL,
  `contactLastName` varchar(50) NOT NULL,
  `contactFirstName` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `addressLine1` varchar(50) NOT NULL,
  `addressLine2` varchar(50) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) DEFAULT NULL,
  `postalCode` varchar(15) DEFAULT NULL,
  `country` varchar(50) NOT NULL,
  `salesRepEmployeeNumber` int(11) DEFAULT NULL,
  `creditLimit` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`customerNumber`),
  KEY `salesRepEmployeeNumber` (`salesRepEmployeeNumber`),
  CONSTRAINT `customers_ss1` FOREIGN KEY (`salesRepEmployeeNumber`) REFERENCES `employees` (`employeeNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `customers_SS` 
SELECT *FROM customers;
-- CÁCH DÙNG BIẾN IN
DELIMITER $$
CREATE PROCEDURE UPDATE_phone_by_CustomerNumber	(IN IN_CustomerNumber INT,IN IN_phone VARCHAR(50))
BEGIN
UPDATE customers_SS
SET phone = IN_phone
WHERE CustomerNumber = IN_CustomerNumber;
END $$
DELIMITER ;
-- Sử dụng
CALL UPDATE_phone_by_CustomerNumber(103,'123456789');
-- XÓA 
DROP PROCEDURE UPDATE_phone_by_CustomerNumber;
-- KIỂM TRA
SELECT *FROM customers_SS;
--  Cách dùng biến OUT
-- gán city thành OUT_city
DELIMITER $$
CREATE PROCEDURE UPDATE_phone_by_CustomerNumber	(IN IN_CustomerNumber INT,IN IN_phone VARCHAR(50),OUT OUT_city VARCHAR(50))
BEGIN
UPDATE customers_SS
SET phone = IN_phone
WHERE CustomerNumber = IN_CustomerNumber;

SELECT city INTO OUT_city
FROM customers_SS
WHERE CustomerNumber = IN_CustomerNumber;
END $$
DELIMITER ;
SET @city ='';
CALL UPDATE_phone_by_CustomerNumber(103,'123456789',@city);
SELECT @city;
CALL UPDATE_phone_by_CustomerNumber(112,'987654321',@city);
SELECT @city;

-- FUNCTION
DELIMITER $$
CREATE FUNCTION CITY_NHIU_khach_hang_nhat () RETURNS VARCHAR(50)
READS SQL DATA
DETERMINISTIC
BEGIN
-- khai báo biến hứng dữ liệu 
DECLARE ncity VARCHAR(50);
SELECT city INTO ncity
FROM
(SELECT city ,CustomerNumber,COUNT(CustomerNumber) AS DEM
FROM customers
GROUP BY city 
ORDER BY DEM DESC
LIMIT 1) AS ANPHA;
RETURN ncity;
END $$
DELIMITER ;

-- GỌI RA
SELECT CITY_NHIU_khach_hang_nhat();



-- FUNCTION Tìm ra thành phố có nhiều dan số nhất trong nước mà mình muốn
DELIMITER $$
CREATE FUNCTION CITY_WANT (WANT VARCHAR(50)) RETURNS VARCHAR(50)
READS SQL DATA
DETERMINISTIC
BEGIN
-- khai báo biến hứng dữ liệu 
DECLARE ncity VARCHAR(50);
SELECT city INTO ncity
FROM
(SELECT city ,CustomerNumber,COUNT(CustomerNumber) AS DEM
FROM customers
WHERE country = WANT
GROUP BY city 
ORDER BY DEM DESC
LIMIT 1) AS ANPHA;
RETURN ncity;
END $$
DELIMITER ;
SELECT CITY_WANT('France');
-- xóa 
DROP FUNCTION CITY_WANT;

-- bổ sung self JOin nghĩa là 1 bảng tự join vs chính nó
-- vi dụ: tìm sếp của ông nhân viên 
SELECT manage_id,COUNT(ID_emploee)
FROM Employee e
JOIN Employee m
-- lấy ông sếp của bảng e =  ông nhân viên của bảng m (m là sếp của e (ID_emploee++)) , tương tự tìm sếp của ông sếp vẫn thế
ON e.manage_id = m.ID_emploee;

-- lí thuyết 45p / 25 câu 
