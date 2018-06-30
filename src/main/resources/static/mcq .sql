-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 30, 2018 at 05:34 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mcq`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('new user', 'ROLE_STUDENT'),
('Omkar', 'ROLE_STUDENT'),
('Omkar', 'ROLE_TEACHER'),
('omkar@omkarsh.com', 'ROLE_STUDENT'),
('omkarshivadekar.os@gmail.com', 'ROLE_STUDENT'),
('omkarshivadekar@ymail.com', 'ROLE_STUDENT'),
('Sharad', 'ROLE_ADMIN'),
('Sharad', 'ROLE_STUDENT'),
('Shubham', 'ROLE_STUDENT'),
('test2', 'ROLE_STUDENT'),
('test3', 'ROLE_STUDENT'),
('test4', 'ROLE_STUDENT'),
('testing', 'ROLE_STUDENT');

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `id` int(11) NOT NULL,
  `question` varchar(200) NOT NULL,
  `option_a` varchar(100) NOT NULL,
  `option_b` varchar(100) NOT NULL,
  `option_c` varchar(100) NOT NULL,
  `option_d` varchar(100) NOT NULL,
  `answer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`id`, `question`, `option_a`, `option_b`, `option_c`, `option_d`, `answer`) VALUES
(1, 'Which will legally declare, construct, and initialize an array?', 'int [] myList = {\"1\", \"2\", \"3\"};', 'int [] myList = (5, 8, 2);', 'int myList [] [] = {4,9,7,0};', 'int myList [] = {4, 3, 7};', 'D'),
(2, 'Which is a valid keyword in java?', 'interface', 'string', 'Float', 'unsigned', 'A'),
(3, 'Which one of the following will declare an array and initialize it with five numbers?', 'Array a = new Array(5);', 'int [] a = {23,22,21,20,19};', 'int a [] = new int[5];', 'int [5] array;', 'B'),
(4, 'Which is the valid declarations within an interface definition?', 'public double methoda();', 'public final double methoda();', 'static void methoda(double d1);', 'protected void methoda(double d1);', 'A'),
(5, 'Which is a valid declarations of a String?', 'String s1 = null;', 'String s2 = \'null\';', 'String s3 = (String) \'abc\';', 'String s4 = (String) \'\\ufeed\';', 'A'),
(6, 'What is the numerical range of a char?', '-128 to 127', '-(215) to (215) - 1', '0 to 32767', '0 to 65535', 'D');

-- --------------------------------------------------------

--
-- Table structure for table `reset`
--

CREATE TABLE `reset` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `resetToken` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reset`
--

INSERT INTO `reset` (`id`, `email`, `resetToken`) VALUES
(1, 'omkar@omkarsh.com', 'f7832d3f-3d65-446d-9799-40d6f84d72f1'),
(2, 'omkarshivadekar.os@gmail.com', NULL),
(3, 'omkarshivadekar@ymail.com', '0bcfa856-e3ff-4287-b0aa-da602be95b5f'),
(4, 'testing', NULL),
(5, 'test2', NULL),
(6, 'test3', NULL),
(7, 'test4', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('new user', '{bcrypt}$2a$10$gBIsR0RjaHWyhjS3t.n7T.Y6Yn4veqJyKJBpjne/E8N18e9FziHuG', 1),
('Omkar', '{noop}test123', 1),
('omkar@omkarsh.com', '{bcrypt}$2a$10$64CZBk3UOVZSebvYUbbPxer5LgbmNz6C4DvnS8kLLVn17pfMxAfKm', 1),
('omkarshivadekar.os@gmail.com', '{bcrypt}$2a$10$pVDEYYP5KT9AqreMrSg3Xuf1GqXcnDtwGfAwHzhddyeHUNy5XCtgG', 1),
('omkarshivadekar@ymail.com', '{bcrypt}$2a$10$epJjp.9yLJoYr8gKMjmHxOyUc962FFcnYzSdtJQ5A7TJxI1r6gepq', 1),
('Sharad', '{noop}test123', 1),
('Shubham', '{noop}test123', 1),
('test2', '{bcrypt}$2a$10$aauwAcHiO5nDHdijeqE60.D/.Dsaqt0xY0SRaY1C5hQuRhqBCQxQq', 1),
('test3', '{bcrypt}$2a$10$yWCTe0as9GuarDynyaZ.4.l8z3JG8H6eUkbXKOuldVyjO2G58ebh6', 1),
('test4', '{bcrypt}$2a$10$AUEDLJLMnSYWGaoC/g8Rg.fVD6i1rpA6G6k/.sv2j5mi1D4BxTNNy', 1),
('testing', '{bcrypt}$2a$10$fYcZN7TLqg32dlDP1Ys9d.snEAhVtsRy3sr8V26HuSMJ1M2I4nB0.', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD UNIQUE KEY `authorities_idx_1` (`username`,`authority`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reset`
--
ALTER TABLE `reset`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk` (`email`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `reset`
--
ALTER TABLE `reset`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `reset`
--
ALTER TABLE `reset`
  ADD CONSTRAINT `fk` FOREIGN KEY (`email`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
