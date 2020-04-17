CREATE DATABASE `bookstore`;
USE `bookstore`;

CREATE TABLE `book` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `record_identifier` VARCHAR(100) NOT NULL,
    `title` VARCHAR(500) NOT NULL,
    `author` VARCHAR(500) NOT NULL,
    `release_date` DATE NOT NULL,
    `status` ENUM('ELÉRHETŐ', 'KÖLCSÖNZÖTT') NOT NULL,

    CONSTRAINT pk_book PRIMARY KEY (`id`),
    CONSTRAINT u_book UNIQUE (`record_identifier`)
);
