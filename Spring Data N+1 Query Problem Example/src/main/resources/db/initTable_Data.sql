CREATE SCHEMA IF NOT EXISTS `w3stacks-example-jpa-1toN` DEFAULT CHARACTER SET utf8 ;
USE `w3stacks-example-jpa-1toN` ;

CREATE TABLE IF NOT EXISTS `w3stacks-example-jpa-1toN`.`Languages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `w3stacks-example-jpa-1toN`.`Frameworks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(75) NOT NULL,
  `classification` VARCHAR(65) NOT NULL,
  `language_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Frameworks_Language_idx` (`language_id` ASC),
  CONSTRAINT `fk_Frameworks_Language`
    FOREIGN KEY (`language_id`)
    REFERENCES `w3stacks-example-jpa-1toN`.`Languages` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO `w3stacks-example-jpa-1ton`.`languages` (`id`, `name`) VALUES ('1', 'PHP');
INSERT INTO `w3stacks-example-jpa-1ton`.`languages` (`id`, `name`) VALUES ('2', 'Java');
INSERT INTO `w3stacks-example-jpa-1ton`.`languages` (`id`, `name`) VALUES ('3', 'Python');

INSERT INTO `w3stacks-example-jpa-1ton`.`frameworks` (`id`, `name`, `classification`, `language_id`) VALUES ('1', 'Cake PHP', 'Fullstack', '1');
INSERT INTO `w3stacks-example-jpa-1ton`.`frameworks` (`id`, `name`, `classification`, `language_id`) VALUES ('2', 'Laravel', 'Fullstack', '1');
INSERT INTO `w3stacks-example-jpa-1ton`.`frameworks` (`id`, `name`, `classification`, `language_id`) VALUES ('3', 'Slim', 'Micro', '1');
INSERT INTO `w3stacks-example-jpa-1ton`.`frameworks` (`id`, `name`, `classification`, `language_id`) VALUES ('4', 'Spring Boot', 'Fullstack', '2');
INSERT INTO `w3stacks-example-jpa-1ton`.`frameworks` (`id`, `name`, `classification`, `language_id`) VALUES ('5', 'Django', 'Fullstack', '3');
