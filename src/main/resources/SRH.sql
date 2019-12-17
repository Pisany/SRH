CREATE TABLE `users` (
    `userID` int(3) NOT NULL AUTO_INCREMENT,
    `accType` int(1)NOT NULL,
    `userLogin` varchar(12)NOT NULL,
    `password` varchar(50) NOT NULL,
	PRIMARY KEY(`userID`));

CREATE TABLE `userDetails` (
    `userID` int(3) NOT NULL,
    `name` varchar(15) NOT NULL,
    `surname` varchar(25) NOT NULL,
    `phone` int(9),
    `email` varchar(25),
    FOREIGN KEY(`userID`) REFERENCES users(`userID`));

CREATE TABLE `userAdress` (
    `userID` int(3) NOT NULL,
    `city` varchar(15) NOT NULL,
    `post-code` int(5),
    `street` varchar(25),
	FOREIGN KEY(`userID`) REFERENCES users(`userID`));

CREATE TABLE `userInfo` (
    `ID` int(3) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `userID` int(3) NOT NULL,
    `userLogin` varchar(12) NOT NULL,
    `loginTime` datetime NOT NULL,
    `logoutTime` time,
    `IPadress` int(12),
    FOREIGN KEY(`userID`) REFERENCES users(`userID`));

CREATE TABLE `loginAttempt`(
    `attemptID` int(3) NOT NULL AUTO_INCREMENT,
    `userLogin` varchar(12),
    `password` varchar(50),
    `loginTime` datetime NOT NULL,
    `IPadress` int(12),
    PRIMARY KEY(`attemptID`));

INSERT INTO `users`(`userID`, `accType`, `userLogin`, `password`) VALUES (0, 'admin', 'root', '922052');
