-- Create database
CREATE DATABASE LostAndFoundDB;
GO
USE LostAndFoundDB;
GO

-- Users table
CREATE TABLE Users (
    User_Id BIGINT PRIMARY KEY IDENTITY,
    Name NVARCHAR(100) NOT NULL,
    Password NVARCHAR(255) NOT NULL,
    Email NVARCHAR(100) NOT NULL UNIQUE,
    Student_Id NVARCHAR(50) NOT NULL UNIQUE,
    Role NVARCHAR(50) NOT NULL,
    Merit_Points INT DEFAULT 0
);

-- Items table
CREATE TABLE Items (
    Item_Id BIGINT PRIMARY KEY IDENTITY,
    Item_Name NVARCHAR(100) NOT NULL,
    Category NVARCHAR(50) NOT NULL,
    Description NVARCHAR(255),
    Status NVARCHAR(50) NOT NULL,
    Report_Date DATETIME NOT NULL DEFAULT GETDATE(),
    Location NVARCHAR(50) NOT NULL,
    Room NVARCHAR(50),
    Contact_Info NVARCHAR(100),
    Reported_By BIGINT NOT NULL FOREIGN KEY REFERENCES Users(User_Id)
);

-- Reports table
CREATE TABLE Reports (
    Report_Id BIGINT PRIMARY KEY IDENTITY,
    Report_Type NVARCHAR(50) NOT NULL,
    Report_Date DATETIME NOT NULL DEFAULT GETDATE(),
    Item_Id BIGINT NOT NULL FOREIGN KEY REFERENCES Items(Item_Id),
    User_Id BIGINT NOT NULL FOREIGN KEY REFERENCES Users(User_Id)
);

-- Admin_Actions table
CREATE TABLE Admin_Actions (
    Action_Id BIGINT PRIMARY KEY IDENTITY,
    Admin_Id BIGINT NOT NULL FOREIGN KEY REFERENCES Users(User_Id),
    Action_Type NVARCHAR(100) NOT NULL,
    Action_Date DATETIME NOT NULL DEFAULT GETDATE(),
    Details NVARCHAR(255)
);

-- Matches table
CREATE TABLE Matches (
    Match_Id BIGINT PRIMARY KEY IDENTITY,
    Lost_Item_Id BIGINT NOT NULL FOREIGN KEY REFERENCES Items(Item_Id),
    Found_Item_Id BIGINT NOT NULL FOREIGN KEY REFERENCES Items(Item_Id),
    Match_Date DATETIME NOT NULL DEFAULT GETDATE()
);

-- Chats table
CREATE TABLE Chats (
    Chat_Id INT PRIMARY KEY IDENTITY,
    User_Id BIGINT NOT NULL FOREIGN KEY REFERENCES Users(User_Id),
    Content NVARCHAR(MAX) NOT NULL,
    Is_System_Message BIT NOT NULL DEFAULT 0,
    Timestamp DATETIME NOT NULL DEFAULT GETDATE()
);

-- Insert sample data
-- Insert Users
INSERT INTO Users (Name, Password, Email, Student_Id, Role, Merit_Points)
VALUES 
('Quyen', '123', 'quyenmai1912@gmail.com', 'ITCSIU23032', 'Admin', 50),
('Duy', '123', 'baoduy.song@gmail.com', 'ITCSIU23006', 'User', 55),
('VA', '123', 'anhoconnell@gmail.com', 'ITCSIU23050', 'User', 65);

-- Insert Items
INSERT INTO Items (Item_Name, Category, Description, Status, Report_Date, Location, Room, Contact_Info, Reported_By)
VALUES 
('Blue Water Bottle', 'Accessories', 'Lost in library', 'Lost', GETDATE(), 'LIBRARY', '2nd floor', 'jane.smith@gmail.com', 2),
('Red Notebook', 'Stationery', 'Found in cafeteria', 'Found', GETDATE(), 'CANTEEN', 'Zero Coffee', 'admin@lostfound.com', 1),
('Dell Laptop', 'Electronics', 'Lost at A1 Building', 'Lost', GETDATE(), 'BLOCK_A1', '302', 'mike.johnson@gmail.com', 3),
('Black Umbrella', 'Accessories', 'Found near parking area', 'Found', GETDATE(), 'PARKING_AREA', 'Lot A2', 'admin@lostfound.com', 1),
('Physics Textbook', 'Books', 'Lost in library', 'Lost', GETDATE(), 'CENTRAL_LIBRARY', 'L108', 'jane.smith@gmail.com', 2),
('Leather Wallet', 'Accessories', 'Found in A2 Building', 'Found', GETDATE(), 'BLOCK_A2', '511', 'admin@lostfound.com', 1),
('iPhone 13', 'Electronics', 'Lost at ER Institute', 'Lost', GETDATE(), 'ER_INSTITUTE', 'C421', 'mike.johnson@gmail.com', 3),
('Sketchbook', 'Stationery', 'Found in library', 'Found', GETDATE(), 'LIBRARY', '1st floor', 'jane.smith@gmail.com', 2),
('Keychain', 'Accessories', 'Found at canteen', 'Found', GETDATE(), 'CANTEEN', 'Near HD Court', 'admin@lostfound.com', 1),
('Leather Bag', 'Clothing', 'Lost at parking area', 'Lost', GETDATE(), 'PARKING_AREA', 'Lot A1', 'mike.johnson@gmail.com', 3);

-- Insert Reports
INSERT INTO Reports (Report_Type, Report_Date, Item_Id, User_Id)
VALUES 
('Lost', GETDATE(), 1, 2),
('Found', GETDATE(), 2, 1),
('Lost', GETDATE(), 3, 3),
('Found', GETDATE(), 4, 1);

-- Insert Admin Actions
INSERT INTO Admin_Actions (Admin_Id, Action_Type, Action_Date, Details)
VALUES 
(1, 'Approve_Item_Return', GETDATE(), 'Approved the return of item 2 to user 2'),
(1, 'Ban_User', GETDATE(), 'Banned user 3 for spamming reports'),
(1, 'Update_Item_Status', GETDATE(), 'Updated status of item 4 to Returned');

-- Insert Matches
INSERT INTO Matches (Lost_Item_Id, Found_Item_Id, Match_Date)
VALUES 
(1, 2, GETDATE()),
(3, 4, GETDATE());

-- Insert Chats
INSERT INTO Chats (User_Id, Content, Is_System_Message, Timestamp)
VALUES 
(2, 'Hi, I lost my water bottle in the library.', 0, GETDATE()),
(1, 'We found a blue water bottle in the campus library, 2nd floor.', 1, GETDATE()),
(3, 'I lost my laptop at A1 Building, can you help?', 0, GETDATE()),
(1, 'Sure, we are on it.', 1, GETDATE()),
(2, 'Thank you for helping me find my notebook!', 0, GETDATE());
