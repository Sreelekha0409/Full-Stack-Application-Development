CREATE DATABASE PaymentDB;
USE PaymentDB;
CREATE TABLE Accounts (
    AccountId INT AUTO_INCREMENT PRIMARY KEY,
    AccountName VARCHAR(50) NOT NULL,
    AccountType ENUM('USER','MERCHANT') NOT NULL,
    Balance DECIMAL(12,2) NOT NULL CHECK (Balance >= 0)
) ENGINE=InnoDB;
INSERT INTO Accounts (AccountName, AccountType, Balance) VALUES
('Kumar', 'USER', 5000.00),
('Anita', 'USER', 2500.00),
('AmazonStore', 'MERCHANT', 10000.00),
('FlipkartStore', 'MERCHANT', 8000.00);

SELECT * FROM Accounts;

START TRANSACTION;

UPDATE Accounts
SET Balance = Balance - 1200
WHERE AccountId = 1 AND AccountType = 'USER';

UPDATE Accounts
SET Balance = Balance + 1200
WHERE AccountId = 3 AND AccountType = 'MERCHANT';

COMMIT;

START TRANSACTION;

UPDATE Accounts
SET Balance = Balance - 100
WHERE AccountId = 1;

-- Cancel it intentionally
ROLLBACK;
SELECT * FROM Accounts WHERE AccountId = 1;
SELECT * FROM Accounts;












