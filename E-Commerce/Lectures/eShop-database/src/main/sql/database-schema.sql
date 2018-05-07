-- Create database
create database if not exists eshop_database;
-- Create user table
use eshop_database;

CREATE TABLE `eshop_database`.`role` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `role-name` char (255)  NOT NULL , `created_date` datetime  NOT NULL , `status` char (255)  NOT NULL , PRIMARY KEY ( `id` ) ) ;

CREATE TABLE `eshop_database`.`user` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `login_name` char (255)  NOT NULL , `status` char (255)  NOT NULL , CHECK ( ( `status` IN ( 'ACTIVE', 'DISABLED', 'BLOCKED' )  )  )  , `created_date` datetime  NOT NULL , `last_login_date` datetime  NULL , PRIMARY KEY ( `id` ) ) ;

CREATE TABLE `eshop_database`.`user_role` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `created_date` datetime  NOT NULL , `status` char (255)  NOT NULL , PRIMARY KEY ( `id` ) , `role_id` mediumint  NOT NULL, `user_id` mediumint  NOT NULL );

CREATE TABLE `eshop_database`.`product` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `created_date` datetime  NOT NULL , `name` char (255)  NOT NULL , `description` char (255)  NOT NULL , `image` binary (255)  NOT NULL , `price` double  NOT NULL , `status` char (255)  NOT NULL , PRIMARY KEY ( `id` ) ) ;

CREATE TABLE `eshop_database`.`order` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `created_date` datetime  NOT NULL , `status` char (255)  NOT NULL , `delivery-address` char (255)  NOT NULL , `delivery-date` datetime  NOT NULL , `total-amount` double  NOT NULL , PRIMARY KEY ( `id` ) , `user_data_id` mediumint  NOT NULL , `payment_id` mediumint  NOT NULL ) ;

CREATE TABLE `eshop_database`.`user_data` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `created_date` datetime  NOT NULL , `status` char (255)  NOT NULL , `password` char (255)  NOT NULL , `first_name` char (255)  NOT NULL , `second_name` char (255)  NOT NULL , `email` char (255)  NOT NULL , `mobile_phone` char (255)  NOT NULL , PRIMARY KEY ( `id` ) , `user_id` mediumint  NOT NULL ) ;

CREATE TABLE `eshop_database`.`order_item` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `created_date` datetime  NOT NULL , `status` char (255)  NOT NULL , `quantaty` tinyint  NOT NULL , CHECK ( ( `quantaty` >= 1 )  AND ( `quantaty` <= 10 )  )  , PRIMARY KEY ( `id` ) , `product_id` mediumint  NOT NULL , `order_id` mediumint  NOT NULL ) ;

CREATE TABLE `eshop_database`.`payment` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `payment-type` char (255)  NOT NULL , `created_date` datetime  NOT NULL , `status` char (255)  NOT NULL , PRIMARY KEY ( `id` ) ) ;

CREATE TABLE `eshop_database`.`review` (
`id` mediumint  NOT NULL , CHECK ( ( `id` >= 1 )  AND ( `id` <= 1000000 )  )  , `created_date` datetime  NOT NULL , `status` char (255)  NOT NULL , `text` char (255)  NOT NULL , PRIMARY KEY ( `id` ) , `user_data_id` mediumint  NOT NULL ) ;

---- Add releations
ALTER TABLE `eshop_database`.`user_role` ADD CONSTRAINT `FK_user_roleTOrole` FOREIGN KEY ( `role_id` ) REFERENCES `role` ( `id` ) ;

ALTER TABLE `eshop_database`.`user_role` ADD CONSTRAINT `FK_user_roleTOuser` FOREIGN KEY ( `user_id` ) REFERENCES `user` ( `id` ) ;

ALTER TABLE `eshop_database`.`order_item` ADD CONSTRAINT `FK_order_itemTOproduct` FOREIGN KEY ( `product_id` ) REFERENCES `product` ( `id` ) ;

ALTER TABLE `eshop_database`.`order` ADD CONSTRAINT `FK_orderTOuser_data` FOREIGN KEY ( `user_data_id` ) REFERENCES `user_data` ( `id` ) ;

ALTER TABLE `eshop_database`.`review` ADD CONSTRAINT `FK_reviewTOuser_data` FOREIGN KEY ( `user_data_id` ) REFERENCES `user_data` ( `id` ) ;

ALTER TABLE `eshop_database`.`order_item` ADD CONSTRAINT `FK_order_itemTOorder` FOREIGN KEY ( `order_id` ) REFERENCES `order` ( `id` ) ;

ALTER TABLE `eshop_database`.`user_data` ADD CONSTRAINT `FK_user_dataTOuser` FOREIGN KEY ( `user_id` ) REFERENCES `user` ( `id` ) ;

ALTER TABLE `eshop_database`.`order` ADD CONSTRAINT `FK_orderTOpayment` FOREIGN KEY ( `payment_id` ) REFERENCES `payment` ( `id` ) ;


