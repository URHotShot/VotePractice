CREATE DATABASE vote_esun
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE vote_esun;

CREATE TABLE vote_item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100) NOT NULL
);

CREATE TABLE vote_record (
	id BIGINT PRIMARY KEY auto_increment,
    voter_name VARCHAR(50) NOT NULL,
    vote_item_id BIGINT NOT NULL,
    CONSTRAINT fk_vote_record
		FOREIGN KEY (vote_item_id) REFERENCES vote_item(id)
);

