-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2019 at 05:07 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carbooking`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `bookingsid` int(11) NOT NULL,
  `bookingsdate` datetime NOT NULL,
  `car` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`bookingsid`, `bookingsdate`, `car`, `user`, `quantity`) VALUES
(2, '2019-02-16 21:23:53', 10, 3, 1),
(3, '2019-02-16 21:23:53', 9, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `brands`
--

CREATE TABLE `brands` (
  `brandid` int(11) NOT NULL,
  `brandname` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `brands`
--

INSERT INTO `brands` (`brandid`, `brandname`) VALUES
(6, 'Ford'),
(7, 'Jeep'),
(8, 'Urus'),
(9, 'Mercedes'),
(10, 'Skoda'),
(11, 'Hyundai');

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `carid` int(11) NOT NULL,
  `carname` varchar(45) NOT NULL,
  `imageurl` varchar(300) NOT NULL,
  `stock` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `manufacturer` varchar(45) DEFAULT NULL,
  `brand` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`carid`, `carname`, `imageurl`, `stock`, `price`, `manufacturer`, `brand`) VALUES
(5, 'Kodiaq', 'EHS4jon.jpg', 4, 10000, 'Skoda', 6),
(6, 'AMG GT', 'X3uaW2019-mercedes-amg-gt-63-s-4-door-coupe-1.jpg', 5, 20000, 'Mercedes', 9),
(7, 'Urus', 'R0WxSqqqq.jpg', 8, 30000, 'Lamorghini', 8),
(8, 'Wangler', 'yBQN9of.jpg', 10, 50000, 'Jeep', 7),
(9, 'Creta', 'rR5Yghyundai-creta-pic-image-photo-zigwheels-12062015-m21_640x480.jpg', 11, 5000, 'Hyundai', 11),
(10, 'Eco-Sport', '5C3fP2016_ford_ecosport_4_1280x960.jpg', 1, 5000, 'Ford', 6);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phoneno` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `role` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `username`, `password`, `fname`, `lname`, `address`, `phoneno`, `email`, `role`, `status`) VALUES
(1, 'admin', '$2a$10$X7C/R6M13nl8weQYUNRyJeKqsTqInVwRLh6CydWxNdlYaE/ZIURLa', 'admin', 'admin', 'ktm', '439843948', 'admin@ooadecommer.com', 1, 1),
(3, 'binaya', '$2a$10$yyE7vkXpn1otcpce8eyvQuXXcZBz2Ni9Z9e3kLeTzKNeApRLpr5N6', 'binaya', 'binaya', 'Sitapaila Kathmandu', '9860673725', 'binaysharma511@gmail.com', 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`bookingsid`);

--
-- Indexes for table `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`brandid`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`carid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `bookingsid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `brands`
--
ALTER TABLE `brands`
  MODIFY `brandid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `carid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
