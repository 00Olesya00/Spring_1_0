CREATE DATABASE IF NOT EXISTS usersdb;

USE usersdb;
# alter table all_products
    #     change price cost int null;
/*DROP TABLE  All_products;*/
CREATE TABLE IF NOT EXISTS User
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255)
);

