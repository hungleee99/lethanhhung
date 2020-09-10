
-- index
-- variable (biến) gồm có 3 dạng system(global),session,local
-- DECLARE v_name = value;
-- Global 
-- SET @@global.v_name =value;
-- SET GLOBAL.v_name =value;

-- CREATE INDEX I_name ON table_name (column1,column2...) ;

-- trigger
-- tạo trigger
-- DELIMITER $$
-- CREATE TRIGGER tri_name ()
-- BEFORE/AFTER  INSERT/UPDATE/DELETE ON `Table_name`
-- FOR each ROW 
-- BEGIN
-- OLD/NEW
-- END $$
-- DELIMITER ;

-- xóa 1 department , trước khi xóa xem có account nào khong còn thì ko xóa , ko còn thì xóa.
USE qlybaithi;
DELIMITER $$
CREATE TRIGGER delete_dep 
BEFORE DELETE ON `Department`
FOR each ROW 
BEGIN
	DECLARE C INT;
	SELECT A.`COUNT` INTO C FROM(SELECT COUNT(departmentID) AS `COUNT` FROM `account` 
			WHERE departmentID = OLD.departmentID) AS A;

	 IF(C!=0) 
	 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'KHONG THE XOA';
	 END IF;
END $$
DELIMITER ;
DELETE FROM Department WHERE departmentID=2;

