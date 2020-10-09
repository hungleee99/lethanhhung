create database qlyuser;
drop database qlyuser;
use qlyuser;
CREATE TABLE IF NOT EXISTS Manager (
	idManager INT AUTO_INCREMENT,
	id INT  NOT NULL,
    fullName VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NOT NULL,
    expInYear TINYINT,
    PRIMARY KEY (idManager),
    UNIQUE KEY (email)

);

CREATE TABLE IF NOT EXISTS Employee (
	idEmployees INT AUTO_INCREMENT,
	id INT NOT NULL ,
    fullName VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NOT NULL,
    projectId INT,
    proSkill VARCHAR(50),
    PRIMARY KEY (idEmployees),
    UNIQUE KEY (email)
);
CREATE TABLE IF NOT EXISTS  Project (
	projectId INT AUTO_INCREMENT,
    teamSize INT NOT NULL,
    idManager INT NOT NULL,
    idEmployees INT NOT NULL,
        PRIMARY KEY (projectId),
		FOREIGN KEY (idManager) REFERENCES Manager (idManager),
        FOREIGN KEY (idEmployees) REFERENCES Employee (idEmployees) 
);
INSERT INTO Manager (id,fullName,email,pass,expInYear) VALUES (1,'hung','h@vti.com.vn','Hung12345678',20),(2,'van','v@vti.com.vn','Van12345678',10);
INSERT INTO Employee (id,fullName,email,pass,projectId,proSkill) VALUES (1,'hung','h@vti.com.vn','Hung12345678',1,'dev'),(2,'van','v@vti.com.vn','Van12345678',2,'test');
INSERT INTO Project (teamSize,idManager,idEmployees) VALUES (1,1,1),(2,2,2);
select *from Manager;
select *from Employee;
select *from Project;
select m.* from Manager m join Project p on m.idManager = p.idManager where  p.idManager =(select idManager from Project where projectId=1);
