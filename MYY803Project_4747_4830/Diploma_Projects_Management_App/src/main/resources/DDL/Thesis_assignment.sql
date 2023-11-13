CREATE DATABASE  IF NOT EXISTS `diplomatikh_directory`;
USE `diplomatikh_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `application`;
DROP TABLE IF EXISTS `thesis`;
DROP TABLE IF EXISTS `subjects`;
DROP TABLE IF EXISTS `professor`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `users`;



CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `role` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `professor` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) DEFAULT NULL,
  `speciality` varchar(45) DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  PRIMARY KEY (`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `student` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) DEFAULT NULL,
  `year_of_studies` int DEFAULT NULL,
  `current_average_grade` float,
  `number_of_remaining_courses_for_graduation` int DEFAULT NULL,
  `assigned` TINYINT(1) DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  PRIMARY KEY (`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `objectives` varchar(45) DEFAULT NULL,
  `supervisor` int NOT NULL,
  `assigned` TINYINT(1) default NULL,
  FOREIGN KEY (supervisor) REFERENCES professor(user_id) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `thesis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subjectsid` int(11),
  `studentid` int(11),
  `implementationgrade` float,
  `reportgrade` float,
  `presentationgrade` float,
  `grade` float,
  FOREIGN KEY (subjectsid) REFERENCES subjects(id) ON DELETE CASCADE,
  FOREIGN KEY (studentid) REFERENCES student(user_id) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subjectsid` int(11),
  `studentid` int(11),
  FOREIGN KEY (subjectsid) REFERENCES subjects(id) ON DELETE CASCADE,
  FOREIGN KEY (studentid) REFERENCES student(user_id) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;