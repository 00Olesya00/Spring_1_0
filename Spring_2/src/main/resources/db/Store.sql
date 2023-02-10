CREATE DATABASE IF NOT EXISTS `_store_` ;


CREATE TABLE IF NOT EXISTS `_store_`.`users` (
                                                 `id_Users` INT NOT NULL AUTO_INCREMENT,
                                                 `id_cart` INT NULL,
                                                 `user_name` VARCHAR(70) NOT NULL,
                                                 `password` VARCHAR(45) NOT NULL,
                                                 ` email` VARCHAR(100) NOT NULL,
                                                 PRIMARY KEY (`id_Users`));

CREATE TABLE IF NOT EXISTS  `_store_`.`products` (
                                                     `id_products` INT NOT NULL AUTO_INCREMENT,
                                                     `id_cart` INT NULL,
                                                     `id_cotigory` INT NOT NULL,
                                                     `title` VARCHAR(100) NOT NULL,
                                                     `cost` INT NOT NULL,
                                                     `name_category` VARCHAR(100) NOT NULL,
                                                     PRIMARY KEY (`id_products`));


CREATE TABLE IF NOT EXISTS `_store_`.`category` (
                                                    `id_category` INT NOT NULL AUTO_INCREMENT,
                                                    `name_category` VARCHAR(100) NOT NULL,
                                                    PRIMARY KEY (`id_category`));


CREATE TABLE IF NOT EXISTS `_store_`.`cart` (
                                                `id_cart` INT NOT NULL AUTO_INCREMENT,
                                                `id_user` INT NOT NULL,
                                                `id_product` INT NOT NULL,
                                                `name_product` VARCHAR(100) NOT NULL,
                                                PRIMARY KEY (`id_cart`));


/* привязываем id  категории к продукту*/
ALTER TABLE `_store_`.`products`
    ADD INDEX `fk_products_category_idx` (`id_cotigory` ASC) VISIBLE;
;
ALTER TABLE `_store_`.`products`
    ADD CONSTRAINT `fk_products_category`
        FOREIGN KEY (`id_cotigory`)
            REFERENCES `_store_`.`category` (`id_category`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

/* привязываем id  корзины */

ALTER TABLE `_store_`.`cart`
    ADD INDEX `fk_producrs_idx` (`id_product` ASC) VISIBLE;
;
ALTER TABLE `_store_`.`cart`
    ADD CONSTRAINT `fk_producrs`
        FOREIGN KEY (`id_product`)
            REFERENCES `_store_`.`products` (`id_products`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_id_user`
  FOREIGN KEY (`id_cart`)
  REFERENCES `_store_`.`users` (`id_Users`)
  ON DELETE NO ACTION
     ON UPDATE NO ACTION;

/* связываем  пользователя с корзиной*/
ALTER TABLE `_store_`.`users`
    ADD INDEX `fk_user_cart_idx` (`id_cart` ASC) VISIBLE;
;
ALTER TABLE `_store_`.`users`
    ADD CONSTRAINT `fk_user_cart`
        FOREIGN KEY (`id_cart`)
            REFERENCES `_store_`.`cart` (`id_cart`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;


/* DROP TABLE `cart`*/