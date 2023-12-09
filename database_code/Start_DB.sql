-- Drop all tables, views, and other relations
DROP SCHEMA public CASCADE;

-- Recreate the public schema
CREATE SCHEMA public;

-- Restore default privileges
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;

-- Users Table
CREATE TABLE Users (
  ID integer PRIMARY KEY,
  Username varchar,
  Role varchar,
  CompanyID integer,
  Created_at timestamp
);

-- Companies Table
CREATE TABLE Companies (
  ID integer PRIMARY KEY,
  companyname varchar
);

-- Items Table
CREATE TABLE Items (
  ItemID integer PRIMARY KEY,
  Name varchar,
  Description text,
  Price decimal(10,2),
  Quantity integer,
  CategoryID integer
);

-- Categories Table
CREATE TABLE Categories (
  CategoryID integer PRIMARY KEY,
  ParentCategoryID integer NULL,
  Name varchar,
  Description text
);

-- Orders Table
CREATE TABLE Orders (
  OrderID integer PRIMARY KEY,
  OrderDate timestamp DEFAULT current_timestamp,
  CustomerID integer
  -- Additional fields like payment details can be added here
);

-- PurchasingApplication Table
CREATE TABLE PurchasingApplication (
  OrderDetailsID integer PRIMARY KEY,
  OrderID integer,
  User_ID integer
);

-- PurchasingApplicationItems Join Table
CREATE TABLE PurchasingApplicationItems (
  OrderDetailsID integer,
  ItemID integer,
  Quantity integer,
  PRIMARY KEY (OrderDetailsID, ItemID),
  FOREIGN KEY (OrderDetailsID) REFERENCES PurchasingApplication(OrderDetailsID),
  FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
);

-- MDR Table
CREATE TABLE MDR (
  MDRID integer PRIMARY KEY,
  Title varchar,
  Building integer,
  Status varchar,
  Urgent boolean,
  CompanyID integer
);

-- MDRItems Join Table
CREATE TABLE MDRItems (
  MDRID integer,
  ItemID integer,
  PRIMARY KEY (MDRID, ItemID),
  FOREIGN KEY (MDRID) REFERENCES MDR(MDRID),
  FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
);

-- MDO Table
CREATE TABLE MDO (
  MDOID integer PRIMARY KEY,
  Title varchar,
  Body text, -- Details of the delivery order
  MDRID integer, -- Assuming each order is linked to a request
  Status varchar,
  CreatedAt timestamp,
  CompanyID integer
);

-- Relationships
ALTER TABLE Items
ADD FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID);

ALTER TABLE Categories
ADD FOREIGN KEY (ParentCategoryID) REFERENCES Categories(CategoryID);

ALTER TABLE PurchasingApplication
ADD FOREIGN KEY (OrderID) REFERENCES Orders(OrderID);

ALTER TABLE Users
ADD FOREIGN KEY (CompanyID) REFERENCES Companies(ID);

ALTER TABLE MDR
ADD FOREIGN KEY (CompanyID) REFERENCES Companies(ID);

ALTER TABLE MDO
ADD FOREIGN KEY (CompanyID) REFERENCES Companies(ID),
ADD FOREIGN KEY (MDRID) REFERENCES MDR(MDRID);

