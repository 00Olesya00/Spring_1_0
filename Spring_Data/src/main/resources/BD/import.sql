CREATE DATABASE IF NOT EXISTS productsdb;

USE productsdb;
# alter table all_products
#     change price cost int null;
/*DROP TABLE  All_products;*/
CREATE TABLE IF NOT EXISTS All_products
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cost INT,
    title VARCHAR(255)

);
INSERT INTO  all_products (title, cost) VALUES ('Молоко', 150),('Бананы', 80), ('Яблоки', 90), ('Рис', 75),('Виноград', 150);


/*DROP TABLE  consumers;
CREATE DATABASE IF NOT EXISTS consumers;

CREATE TABLE IF NOT EXISTS consumers
    (
        id  int NOT NULL PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255)
    );
INSERT INTO consumers (name) VALUES ('Виктор'),('Алексей'),('Владимир');




CREATE DATABASE IF NOT EXISTS consumers_products_stok;

DROP TABLE  consumers_products;

CREATE TABLE IF NOT EXISTS consumers_products
   (
    consumer_id int,
    product_id int,
    FOREIGN KEY (product_id) REFERENCES All_products(id), FOREIGN KEY (consumer_id) REFERENCES consumers (id)
   );
        INSERT INTO consumers_products (consumer_id, product_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (2, 2), (2, 3), (3, 3), (3, 4), (3, 5);


