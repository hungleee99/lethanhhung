USE classicmodels;
-- Q1
SELECT 			SUM(priceEach*quantityOrdered) AS tong
FROM 			orders o
JOIN			orderdetails ot
ON 				o.orderNumber = ot.orderNumber
WHERE			o.`status` = 'shipped'
AND				o.shippedDate BETWEEN '2004/8/1' AND '2004/8/31';

-- q2 
SELECT 			c.customerName,SUM(ot.priceEach*ot.quantityOrdered-buyPrice*ot.quantityOrdered) AS profit
FROM 			customers c
LEFT JOIN			orders o
ON 				o.customerNumber = c.customerNumber	
LEFT JOIN			orderdetails ot
ON 				o.orderNumber = ot.orderNumber
RIGHT JOIN 			products 		p
ON 				ot.productCode = p.productCode
WHERE			o.`status` = 'shipped'
GROUP BY		c.customerName;
-- Q3
SELECT 			p.productName , SUM(ot.quantityOrdered*p.buyPrice) AS revenue
FROM 			products p
JOIN			orderdetails ot
ON 				p.productCode = ot.productCode
GROUP BY 		ot.productCode;