USE classicmodels;
-- Q1
SELECT 			SUM(priceEach) AS tong
FROM 			orders o
JOIN			orderdetails ot
ON 				o.orderNumber = ot.orderNumber
WHERE			o.`status` = 'shipped'
AND				o.shippedDate BETWEEN '2004/8/1' AND '2004/8/30';

-- q2 
SELECT 			c.customerName,p.amount AS profit
FROM 			orders o
JOIN			customers c
ON 				o.customerNumber = c.customerNumber
JOIN			payments p
ON 				c.customerNumber = p.customerNumber
WHERE			o.`status` = 'shipped'
GROUP BY		c.customerNumber;

-- Q3
SELECT 			p.productName , SUM(ot.orderLineNumber*p.buyPrice) AS revenue
FROM 			products p
JOIN			orderdetails ot
ON 				p.productCode = ot.productCode
GROUP BY 		ot.productCode;