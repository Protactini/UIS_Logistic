-- Drop all tables, views, and other relations
DROP SCHEMA public CASCADE;

-- Recreate the public schema
CREATE SCHEMA public;

-- Restore default privileges
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;

-- Users Table
CREATE TABLE Users (
  ID SERIAL  PRIMARY KEY,
  username VARCHAR(255),
  companyid INTEGER,
  created_at TIMESTAMP,
  password VARCHAR(255)
);

CREATE TABLE user_roles (
    user_id INTEGER,
    role_id INTEGER,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id) -- Assumes there is a roles table with an ID
);

-- Companies Table
CREATE TABLE companies (
    id SERIAL PRIMARY KEY,
    companyname VARCHAR(255)
);


CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
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

