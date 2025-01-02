-- Create database
CREATE DATABASE LostAndFoundDB;
GO
USE LostAndFoundDB;
GO

-- Users table
CREATE TABLE Users (
    UserId BIGINT PRIMARY KEY IDENTITY,
    Name NVARCHAR(100) NOT NULL,
    Password NVARCHAR(255) NOT NULL,
    Email NVARCHAR(100) NOT NULL UNIQUE,
    StudentId NVARCHAR(50) NOT NULL UNIQUE,
    Role NVARCHAR(50) NOT NULL,
    MeritPoints INT DEFAULT 0
);

-- Items table
CREATE TABLE Items (
    ItemId BIGINT PRIMARY KEY IDENTITY,
    ItemName NVARCHAR(100) NOT NULL,
    Category NVARCHAR(50) NOT NULL,
    Description NVARCHAR(255),
    Status NVARCHAR(50) NOT NULL,
    ReportDate DATETIME NOT NULL DEFAULT GETDATE(),
    Location NVARCHAR(50) NOT NULL,
    Room NVARCHAR(50),
    ContactInfo NVARCHAR(100),
    ReportedBy BIGINT NOT NULL FOREIGN KEY REFERENCES Users(UserId)
);

-- Reports table
CREATE TABLE Reports (
    ReportId BIGINT PRIMARY KEY IDENTITY,
    ReportType NVARCHAR(50) NOT NULL,
    ReportDate DATETIME NOT NULL DEFAULT GETDATE(),
    ItemId BIGINT NOT NULL FOREIGN KEY REFERENCES Items(ItemId),
    UserId BIGINT NOT NULL FOREIGN KEY REFERENCES Users(UserId)
);

-- AdminActions table
CREATE TABLE AdminActions (
    ActionId BIGINT PRIMARY KEY IDENTITY,
    AdminId BIGINT NOT NULL FOREIGN KEY REFERENCES Users(UserId),
    ActionType NVARCHAR(100) NOT NULL,
    ActionDate DATETIME NOT NULL DEFAULT GETDATE(),
    Details NVARCHAR(255)
);

-- Matches table
CREATE TABLE Matches (
    MatchId BIGINT PRIMARY KEY IDENTITY,
    LostItemId BIGINT NOT NULL FOREIGN KEY REFERENCES Items(ItemId),
    FoundItemId BIGINT NOT NULL FOREIGN KEY REFERENCES Items(ItemId),
    MatchDate DATETIME NOT NULL DEFAULT GETDATE()
);

-- Chats table
CREATE TABLE Chats (
    ChatId INT PRIMARY KEY IDENTITY,
    UserId BIGINT NOT NULL FOREIGN KEY REFERENCES Users(UserId),
    Content NVARCHAR(MAX) NOT NULL,
    IsSystemMessage BIT NOT NULL DEFAULT 0,
    Timestamp DATETIME NOT NULL DEFAULT GETDATE()
);

-- Insert sample data
-- Insert Users
INSERT INTO Users (Name, Password, Email, StudentId, Role, MeritPoints)
VALUES 
('Quyen', '123', 'quyenmai1912@gmail.com', 'ITCSIU23032', 'Admin', 50),
('Duy', '123', 'baoduy.song@gmail.com', 'ITCSIU23006', 'User', 55),
('VA', '123', 'anhoconnell@gmail.com', 'ITCSIU23050', 'User', 65);

-- Insert Items
INSERT INTO Items (ItemName, Category, Description, Status, ReportDate, Location, Room, ContactInfo, ReportedBy)
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
INSERT INTO Reports (ReportType, ReportDate, ItemId, UserId)
VALUES 
('Lost', GETDATE(), 1, 2),
('Found', GETDATE(), 2, 1),
('Lost', GETDATE(), 3, 3),
('Found', GETDATE(), 4, 1);

-- Insert Admin Actions
INSERT INTO AdminActions (AdminId, ActionType, ActionDate, Details)
VALUES 
(1, 'ApproveItemReturn', GETDATE(), 'Approved the return of item 2 to user 2'),
(1, 'BanUser', GETDATE(), 'Banned user 3 for spamming reports'),
(1, 'UpdateItemStatus', GETDATE(), 'Updated status of item 4 to Returned');

-- Insert Matches
INSERT INTO Matches (LostItemId, FoundItemId, MatchDate)
VALUES 
(1, 2, GETDATE()),
(3, 4, GETDATE());

-- Insert Chats
INSERT INTO Chats (UserId, Content, IsSystemMessage, Timestamp)
VALUES 
(2, 'Hi, I lost my water bottle in the library.', 0, GETDATE()),
(1, 'We found a blue water bottle in the campus library, 2nd floor.', 1, GETDATE()),
(3, 'I lost my laptop at A1 Building, can you help?', 0, GETDATE()),
(1, 'Sure, we are on it.', 1, GETDATE()),
(2, 'Thank you for helping me find my notebook!', 0, GETDATE());