CREATE DATABASE northwind;

CREATE TABLE `northwind`.`user` (
  `user_id` VARCHAR(8) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`));


CREATE TABLE `northwind`.`task` (
  `task_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  `priority` INT NOT NULL,
  `due_date` DATE NOT NULL,
  `user_id` VARCHAR(8) NOT NULL
  PRIMARY KEY (`task_id`));
