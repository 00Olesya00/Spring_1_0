CREATE DATABASE IF NOT EXISTS productsdb;

USE productsdb;
DROP TABLE  All_products;
CREATE TABLE IF NOT EXISTS All_products
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    price INT,
    title VARCHAR(255)

);
INSERT INTO  all_products (title, price) VALUES ('Молоко', 150),('Бананы', 80), ('Яблоки', 90), ('Рис', 75),('Виноград', 150);