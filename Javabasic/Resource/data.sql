DROP DATABASE IF EXISTS qlyungvien;
CREATE DATABASE qlyungvien;
USE qlyungvien;

CREATE TABLE IF NOT EXISTS `users` (
	id INT AUTO_INCREMENT,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    phone VARCHAR(12) NOT NULL,
    email VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NOT NULL,
    expInYear TINYINT,
    projectName VARCHAR(100),
    proSkill VARCHAR(50),
    
    PRIMARY KEY (id),
    UNIQUE KEY (email),
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID) ON DELETE CASCADE
);

SELECT * FROM `users`;