CREATE SCHEMA IF NOT EXISTS librarium2 CHARACTER SET=UTF8;
USE librarium2;

CREATE TABLE IF NOT EXISTS genres(
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS publishers(
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(50),
	site VARCHAR(50),
	phoneNumber VARCHAR(50),
	PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS authors(
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(60),
	PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS books(
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	price FLOAT(30),
	isbn VARCHAR(50),
	comment VARCHAR(1000),
	launchDate DATE,
	authorId BIGINT NOT NULL,
	genreId BIGINT NOT NULL,
	publisherId BIGINT NOT NULL,
	PRIMARY KEY(id),
	
	FOREIGN KEY(authorId)
	REFERENCES authors(id)
	ON UPDATE CASCADE ON DELETE RESTRICT,
	
	FOREIGN KEY(genreId)
	REFERENCES genres(id)
	ON UPDATE CASCADE ON DELETE RESTRICT,
	
	FOREIGN KEY(publisherId)
	REFERENCES publishers(id)
	ON UPDATE CASCADE ON DELETE RESTRICT
)ENGINE=INNODB;