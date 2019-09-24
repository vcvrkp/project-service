CREATE TABLE IF NOT EXISTS `project` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `organizationId` INT(11) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NULL DEFAULT NULL,
  `open` TINYINT(1) NULL DEFAULT '0',
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
  `description` VARCHAR(2048) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `ownerId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  `billable` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `ndx_project_organizationId` (`organizationId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8
COMMENT = 'Projects';

CREATE TABLE IF NOT EXISTS `projectrole` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `projectId` INT(11) NOT NULL,
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
  `costPerHour` DECIMAL(10,2) NOT NULL,
  `expectedHours` INT(11) NOT NULL,
  `ownerId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `ndx_projectRole_projectId` (`projectId` ASC),
  CONSTRAINT `fk_projectRole_projectId`
    FOREIGN KEY (`projectId`)
    REFERENCES `project` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `activity` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `startDate` DATETIME NULL DEFAULT '0000-00-00 00:00:00',
  `duration` INT(11) NOT NULL COMMENT 'Duración en minutos',
  `description` VARCHAR(2048) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `billable` TINYINT(1) NOT NULL DEFAULT '1',
  `roleId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_activity_roleId` (`roleId` ASC),
  CONSTRAINT `fk_activity_roleId`
    FOREIGN KEY (`roleId`)
    REFERENCES `projectrole` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `objective` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `projectId` INT(11) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NULL DEFAULT NULL,
  `state` VARCHAR(16) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `name` VARCHAR(512) CHARACTER SET 'utf8' NOT NULL,
  `log` LONGTEXT CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `ndx_objective_projectId` (`projectId` ASC),
  CONSTRAINT `fk_objective_projectId`
    FOREIGN KEY (`projectId`)
    REFERENCES `project` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `occupation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `projectId` INT(11) NOT NULL,
  `userId` INT(11) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `description` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `duration` INT(11) NOT NULL COMMENT 'Duración en minutos',
  `ownerId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `ndx_occupation_userId` (`userId` ASC),
  INDEX `ndx_occupation_projectId` (`projectId` ASC),
  CONSTRAINT `fk_occupation_projectId`
    FOREIGN KEY (`projectId`)
    REFERENCES `project` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `projectcost` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `projectId` INT(11) NOT NULL,
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
  `cost` DECIMAL(10,2) NOT NULL,
  `billable` TINYINT(1) NOT NULL DEFAULT '1',
  `ownerId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_projectCost_projectId` (`projectId` ASC),
  CONSTRAINT `fk_projectCost_projectId`
    FOREIGN KEY (`projectId`)
    REFERENCES `project` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


insert into Project(id,organizationId,startDate,name) values (1, 1, CURDATE(),'Vacaciones');
insert into Project(id,organizationId,startDate,name) values (2, 1, CURDATE(),'Permiso extraordinario');
insert into Project(id,organizationId,startDate,name) values (3, 1, CURDATE(),'Baja por enfermedad');
insert into Project(id,organizationId,startDate,name) values (4, 1, CURDATE(),'Auto-formación');
insert into Project(id,organizationId,startDate,name) values (5, 1, CURDATE(),'Histórico');
insert into Project(id,organizationId,startDate,name) values (6, 2, CURDATE(),'Testing');

INSERT INTO ProjectRole( projectId, name, costPerHour, expectedHours )   SELECT id, name, 3, 1 FROM Project;
INSERT INTO `ProjectCost` VALUES  (3,1,'Fotocopias','200.00',1,NULL,NULL,NULL,NULL),  (4,1,'Material','300.00',1,NULL,NULL,NULL,NULL);
INSERT INTO `ProjectCost` VALUES  (5,2,'Fotocopias','200.00',1,NULL,NULL,NULL,NULL),  (6,2,'Material','300.00',1,NULL,NULL,NULL,NULL);
INSERT INTO `Objective` (`id`,`userId`,`projectId`,`startDate`,`endDate`,`state`,`name`,`log`,`departmentId`,`insertDate`,`updateDate`) VALUES    (1,1,4,'2009-04-13','2009-04-14','PENDING','Entrega del pedido qweeeeeeee',NULL,1,'2009-04-13 15:32:39','2009-04-13 15:32:39');
INSERT INTO `Objective` (`id`,`userId`,`projectId`,`startDate`,`endDate`,`state`,`name`,`log`,`departmentId`,`insertDate`,`updateDate`) VALUES    (2,1,4,'2009-04-13','2009-04-14','PENDING','Entrega del pedido qweeeeeeee',NULL,1,'2009-04-13 15:33:15','2009-04-13 15:33:15');
