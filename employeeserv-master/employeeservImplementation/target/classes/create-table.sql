CREATE TABLE `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `line1` varchar(20) NOT NULL,
  `line2` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `zip_code` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);