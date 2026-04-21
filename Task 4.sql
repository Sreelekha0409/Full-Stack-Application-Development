CREATE DATABASE OrderManagementDB;
USE OrderManagementDB;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(50),
    Email VARCHAR(50)
) ENGINE=InnoDB;
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(50),
    Price DECIMAL(10,2)
) ENGINE=InnoDB;
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    ProductID INT,
    Quantity INT,
    OrderDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
) ENGINE=InnoDB;
INSERT INTO Customers VALUES
(1, 'Alice', 'alice@gmail.com'),
(2, 'Bob', 'bob@gmail.com'),
(3, 'Charlie', 'charlie@gmail.com');
INSERT INTO Products VALUES
(101, 'Laptop', 60000),
(102, 'Mobile', 25000),
(103, 'Headphones', 3000);
INSERT INTO Orders VALUES
(1001, 1, 101, 1, '2024-01-10'),
(1002, 1, 102, 2, '2024-01-12'),
(1003, 2, 103, 3, '2024-01-15'),
(1004, 3, 101, 1, '2024-01-20'),
SELECT
    c.CustomerName,
    p.ProductName,
    o.Quantity,
    o.OrderDate
FROM Orders o
JOIN Customers c ON o.CustomerID = c.CustomerID
JOIN Products p ON o.ProductID = p.ProductID
ORDER BY o.OrderDate;
SELECT
    o.OrderID,
    c.CustomerName,
    (o.Quantity * p.Price) AS OrderValue
FROM Orders o
JOIN Customers c ON o.CustomerID = c.CustomerID
JOIN Products p ON o.ProductID = p.ProductID
WHERE (o.Quantity * p.Price) = (
    SELECT MAX(o2.Quantity * p2.Price)
    FROM Orders o2
    JOIN Products p2 ON o2.ProductID = p2.ProductID
);
SELECT
    c.CustomerName,
    COUNT(o.OrderID) AS TotalOrders
FROM Customers c
JOIN Orders o ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerName
ORDER BY TotalOrders DESC
LIMIT 1;













