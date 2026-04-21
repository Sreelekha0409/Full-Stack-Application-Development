CREATE DATABASE AuditDB;
USE AuditDB;
CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(100),
    Salary DECIMAL(10,2)
);
CREATE TABLE Audit_Logs (
    LogID INT AUTO_INCREMENT PRIMARY KEY,
    TableName VARCHAR(50),
    Action VARCHAR(10),
    OldData JSON,
    NewData JSON,
    ChangedBy VARCHAR(100),
    ChangedAt DATETIME DEFAULT CURRENT_TIMESTAMP
);
DELIMITER $$

CREATE TRIGGER trg_employee_insert
AFTER INSERT ON Employees
FOR EACH ROW
BEGIN
    INSERT INTO Audit_Logs
    (TableName, Action, NewData, ChangedBy)
    VALUES
    (
        'Employees',
        'INSERT',
        JSON_OBJECT(
            'EmpID', NEW.EmpID,
            'Name', NEW.Name,
            'Salary', NEW.Salary
        ),
        USER()
    );
END$$

DELIMITER ;
DELIMITER $$

CREATE TRIGGER trg_employee_update
AFTER UPDATE ON Employees
FOR EACH ROW
BEGIN
    INSERT INTO Audit_Logs
    (TableName, Action, OldData, NewData, ChangedBy)
    VALUES
    (
        'Employees',
        'UPDATE',
        JSON_OBJECT(
            'EmpID', OLD.EmpID,
            'Name', OLD.Name,
            'Salary', OLD.Salary
        ),
        JSON_OBJECT(
            'EmpID', NEW.EmpID,
            'Name', NEW.Name,
            'Salary', NEW.Salary
        ),
        USER()
    );
END$$

DELIMITER ;
CREATE VIEW Daily_Activity_Report AS
SELECT
    DATE(ChangedAt) AS LogDate,
    Action,
    COUNT(*) AS TotalChanges
FROM Audit_Logs
GROUP BY DATE(ChangedAt), Action;
INSERT INTO Employees VALUES (1, 'John Doe', 50000);

UPDATE Employees
SET Salary = 55000
WHERE EmpID = 1;

SELECT * FROM Audit_Logs;

SELECT * FROM Daily_Activity_Report;





