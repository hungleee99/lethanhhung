USE classicmodels;
-- nếu null lấy UNKNOW , nếu có gtri trả về state
SELECT customerName ,IFNULL(state,'UNKNOW') FROM customers;
-- câu điều kiện lấy giá trị từ trái qua phải
SELECT 	customerName ,addressLine2,state,addressLine1,COALESCE(addressLine2,state,addressLine1,'UNKNOW') AS Nhan 
FROM 	customers;
-- JOIN 
SELECT 			* 
FROM 			orders
JOIN 			customers ON orders.customerNumber = customers.customerNumber
GROUP BY customers.customerNumber;

-- LEFT COUNT(1) chuyen 1 hang so vao count toi uu hoa hieu suat (1 trong truong hop nay dc coi la 1 truong)
SELECT 			c.customerName , COUNT(1) AS LAN
FROM 			orders o
JOIN 			customers c ON o.customerNumber = c.customerNumber
GROUP BY 		c.customerNumber;

-- left JOIN 
SELECT 			c.customerName , COUNT(o.orderNumber) AS LAN
FROM 			customers c
LEFT JOIN 		orders o ON o.customerNumber = c.customerNumber
GROUP BY 		c.customerNumber
ORDER BY 		LAN;
-- RIGHT JOIN
SELECT 			c.customerName , o.orderNumber 
FROM 			orders o
RIGHT JOIN 		customers c ON o.customerNumber = c.customerNumber;

-- LEFT EXCLUDING JOIN = WHERE columm IS NULL , WHERE columm IS NOT NULL = JOIN
SELECT 			c.customerName ,o.orderNumber
FROM 			customers c
LEFT  JOIN 		orders o ON o.customerNumber = c.customerNumber
WHERE 			o.customerNumber IS  Null;

-- CROSS JOIN nghia la JOIN bo ON di gop 2 bang la 1
SELECT 			c.customerName ,o.orderNumber
FROM 			customers c
CROSS JOIN 			orders o ;

-- UNION GOP ket qua cua 2 bang truy van , VA loai bo phan giong nhau
SELECT 			c.customerName ,o.orderNumber
FROM 			customers c
LEFT JOIN 		orders o ON o.customerNumber = c.customerNumber
GROUP BY 		c.customerNumber
UNION
SELECT 			c.customerName , o.orderNumber 
FROM 			orders o
RIGHT JOIN 		customers c ON o.customerNumber = c.customerNumber;

-- UNION ALL gop  ket qua cua 2 bang truy van lay ca phan giong
SELECT 			c.customerName ,o.orderNumber
FROM 			customers c
LEFT JOIN 		orders o ON o.customerNumber = c.customerNumber
GROUP BY 		c.customerNumber
UNION ALL
SELECT 			c.customerName , o.orderNumber 
FROM 			orders o
RIGHT JOIN 		customers c ON o.customerNumber = c.customerNumber;
-- CREATE VIEW
CREATE VIEW 	PS AS
SELECT 			c.customerName ,o.orderNumber
FROM 			customers c
LEFT JOIN 		orders o ON o.customerNumber = c.customerNumber
GROUP BY 		c.customerNumber
UNION ALL
SELECT 			c.customerName , o.orderNumber 
FROM 			orders o
RIGHT JOIN 		customers c ON o.customerNumber = c.customerNumber;

SELECT 			customerName FROM PS;

-- DROP VIEW Name
DROP VIEW 		PS;