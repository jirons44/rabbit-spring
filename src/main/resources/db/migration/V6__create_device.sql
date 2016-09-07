CREATE TABLE `fitness`.`devices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `serial_number` INT NOT NULL,
  `version` INT NOT NULL DEFAULT 0,
  `product` VARCHAR(255) NOT NULL,
  `category`ENUM('RUN', 'SWIM', 'BIKE', 'LIFT') NULL,
  `user_id` INT NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_v6`
  FOREIGN KEY (`user_id`)
  REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);