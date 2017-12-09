CREATE SCHEMA `bookmanager` ;
##category
CREATE TABLE `bookmanager`.`category` (
  `id` VARCHAR(40) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
COMMENT = '图书分类';
##book
CREATE TABLE `bookmanager`.`book` (
  `id` VARCHAR(40) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `price` DECIMAL(10) NOT NULL,
  `image` VARCHAR(100) NULL,
  `description` VARCHAR(255) NULL,
  `category_id` VARCHAR(40) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `category_id_FK_idx` (`category_id` ASC),
  CONSTRAINT `category_id_FK`
    FOREIGN KEY (`category_id`)
    REFERENCES `bookmanager`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
##user
    CREATE TABLE `bookmanager`.`user` (
  `id` INT(11) NOT NULL,
  `username` VARCHAR(40) NOT NULL,
  `password` VARCHAR(40) NOT NULL,
  `phone` VARCHAR(40) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));
##orders
  CREATE TABLE `bookmanager`.`orders` (
  `id` VARCHAR(40) NOT NULL,
  `ordertime` DATETIME NOT NULL,
  `price` DECIMAL(10) NOT NULL,
  `state` INT(1) NULL,
  `user_id` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_FK_idx` (`user_id` ASC),
  CONSTRAINT `user_id_FK`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookmanager`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
##orderitem
CREATE TABLE `bookmanager`.`orderitem` (
  `id` VARCHAR(40) NOT NULL,
  `quantity` INT NULL,
  `price` DECIMAL(10) NULL,
  `order_id` VARCHAR(40) NULL,
  `book_id` VARCHAR(40) NULL,
  PRIMARY KEY (`id`),
  INDEX `order_id_FK_idx` (`order_id` ASC),
  INDEX `book_id_FK_idx` (`book_id` ASC),
  CONSTRAINT `order_id_FK`
    FOREIGN KEY (`order_id`)
    REFERENCES `bookmanager`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `book_id_FK`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookmanager`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

