/-- Insert Data into Companies Table
INSERT INTO Companies (ID, companyname) VALUES
(1, 'Company A'),
(2, 'Company B');

-- Insert Data into Users Table
INSERT INTO Users (ID, Username, Role, CompanyID, Created_at) VALUES
(1, 'User1', 'Role1', 1, CURRENT_TIMESTAMP),
(2, 'User2', 'Role2', 1, CURRENT_TIMESTAMP);

-- Insert Data into Categories Table
INSERT INTO Categories (CategoryID, ParentCategoryID, Name, Description) VALUES
(1, NULL, 'Electronics', 'Electronic Items'),
(2, NULL, 'Clothing', 'Various kinds of clothing');

-- Insert Data into Items Table
INSERT INTO Items (ItemID, Name, Description, Price, Quantity, CategoryID) VALUES
(1, 'Laptop', 'High-end gaming laptop', 999.99, 10, 1),
(2, 'T-Shirt', 'Cotton t-shirt', 19.99, 50, 2);

-- Insert Data into Orders Table
INSERT INTO Orders (OrderID, OrderDate, CustomerID) VALUES
(1, CURRENT_TIMESTAMP, 1),
(2, CURRENT_TIMESTAMP, 2);

-- Insert Data into PurchasingApplication Table
INSERT INTO PurchasingApplication (OrderDetailsID, OrderID, User_ID) VALUES
(1, 1, 1),
(2, 2, 2);

-- Insert Data into PurchasingApplicationItems Join Table
INSERT INTO PurchasingApplicationItems (OrderDetailsID, ItemID, Quantity) VALUES
(1, 1, 2),
(2, 2, 3);

-- Insert Data into MDR Table
INSERT INTO MDR (MDRID, Title, Building, Status, Urgent, CompanyID) VALUES
(1, 'MDR Title 1', 101, 'Open', FALSE, 1),
(2, 'MDR Title 2', 102, 'Closed', TRUE, 2);

-- Insert Data into MDRItems Join Table
INSERT INTO MDRItems (MDRID, ItemID) VALUES
(1, 1),
(2, 2);

-- Insert Data into MDO Table
INSERT INTO MDO (MDOID, Title, Body, MDRID, Status, CreatedAt, CompanyID) VALUES
(1, 'MDO Title 1', 'Details of MDO 1', 1, 'Pending', CURRENT_TIMESTAMP, 1),
(2, 'MDO Title 2', 'Details of MDO 2', 2, 'Delivered', CURRENT_TIMESTAMP, 2);
