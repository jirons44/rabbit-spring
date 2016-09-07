CREATE TABLE `fitness`.`positions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `latitude` VARCHAR(45) NOT NULL,
  `longitude` VARCHAR(45) NOT NULL,
  `altitude` VARCHAR(45) NOT NULL,
  `currenttimeitude` TIMESTAMP NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  `run_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_runs_v8`
  FOREIGN KEY (`run_id`)
  REFERENCES `fitness`.`runs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);