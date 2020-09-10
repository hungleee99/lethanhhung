-- SELECT [SUBQUERY] thay the dc table hay 1 values ko thay the dc 1 cot hay la truong
-- WHERE the the dược 1 values
-- HAVING THAY THẾ 1 GIÁ TRỊ 
-- LIMIT  1 values, subquery
USE classicmodels;
-- thong kê ra những sản phẩm có hàng tồn trong kho lơn hơn hàng tồn trung bình của tất cả sp

SELECT 		* 
FROM 		products
WHERE		quantityInStock >
(SELECT AVG(quantityInStock)
FROM products);
-- liet kê ra tên của các nv lam viec ơ nước mỹ
SELECT 		lastName 
FROM 		employees
WHERE		officeCode IN	(SELECT officeCode 
FROM		offices
WHERE		country = 'USA');
-- với mỗi order từ 2 sp trở lên thông kê những sp nào trong order đấy chiếm 50% giá trị

SELECT TB.* FROM (SELECT orderNumber,SUM(priceEach*quantityOrdered)/2 AS TT FROM orderdetails
GROUP BY 		orderNumber) AS TB
JOIN
(SELECT orderNumber,productCode,(priceEach*quantityOrdered) AS tong FROM orderdetails) AS B
ON TB.orderNumber = B.orderNumber
WHERE B.tong > TB.`TT`
AND TB.orderNumber IN(SELECT orderNumber FROM
orderdetails GROUP BY 		orderNumber
HAVING COUNT(productCode)>=2);
