CREATE DATABASE propellerhead;

USE propellerhead;

CREATE TABLE status(
	id_status INT NOT NULL AUTO_INCREMENT,
	status VARCHAR(30) NOT NULL,
	PRIMARY KEY (id_status)
)ENGINE = MyISAM;

INSERT INTO status (status) VALUES ('prospective'),('current'),('non-active');

CREATE TABLE customer(
	id_customer BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	id_status INT NOT NULL DEFAULT 1,
	PRIMARY KEY (id_customer),
	FOREIGN KEY (id_status) REFERENCES status(id_status) ON DELETE CASCADE ON UPDATE CASCADE 
)ENGINE = MyISAM;

INSERT INTO customer (name) VALUES ('Freddy Mercury');

CREATE TABLE email(
	id_customer BIGINT NOT NULL,
	email VARCHAR(100) NOT NULL,
	PRIMARY KEY (id_customer),
	FOREIGN KEY (id_customer) REFERENCES customer(id_customer) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = MyISAM;

INSERT INTO email VALUES (1,'queen@gmail.com');

CREATE TABLE phone(
	id_customer BIGINT NOT NULL,
	phone VARCHAR(20),
	PRIMARY KEY (id_customer),
	FOREIGN KEY (id_customer) REFERENCES customer(id_customer) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = MyISAM;

INSERT INTO phone VALUES (1,'+52 5589985665');

CREATE TABLE address(
	id_customer BIGINT NOT NULL,
	address VARCHAR(500),
	PRIMARY KEY (id_customer),
	FOREIGN KEY (id_customer) REFERENCES customer(id_customer) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = MyISAM;

INSERT INTO address VALUES (1,'Innuendo St., District Mama Mia, 566 Mama Mia, LET ME GO');

CREATE TABLE note(
	id_note BIGINT NOT NULL AUTO_INCREMENT,
	id_customer BIGINT NOT NULL,
	note VARCHAR(500),
	PRIMARY KEY (id_note),
	FOREIGN KEY (id_customer) REFERENCES customer(id_customer) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = MyISAM;