CREATE DATABASE db_zlikun;

CREATE TABLE db_zlikun.tbl_user (
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY,
	`username` VARCHAR(64) NOT NULL UNIQUE,
	`password` CHAR(40) NOT NULL,
	`ctime` DATETIME NOT NULL
);