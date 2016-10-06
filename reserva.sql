-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema reserva
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema reserva
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `reserva` DEFAULT CHARACTER SET latin1 ;
USE `reserva` ;

-- -----------------------------------------------------
-- Table `reserva`.`hospede`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva`.`hospede` (
  `idHospede` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `Nome` VARCHAR(40) NOT NULL COMMENT '',
  `CPF` VARCHAR(11) NULL DEFAULT NULL COMMENT '',
  `EndRua` VARCHAR(40) NULL DEFAULT NULL COMMENT '',
  `EndNumero` INT(11) NULL DEFAULT NULL COMMENT '',
  `EndComplemento` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `EndBairro` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `EndCidade` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `EndCEP` INT(8) NULL DEFAULT NULL COMMENT '',
  `DataNascimento` DATE NULL DEFAULT NULL COMMENT '',
  `TelefoneResidencia` INT(12) NULL DEFAULT NULL COMMENT '',
  `TelefoneCelular` INT(12) NOT NULL COMMENT '',
  `Identidade` VARCHAR(8) NULL DEFAULT NULL COMMENT '',
  `Email` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  `Senha` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idHospede`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `reserva`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva`.`reserva` (
  `idReserva` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `Data` DATE NULL DEFAULT NULL COMMENT '',
  `Responsavel` VARCHAR(40) NULL DEFAULT NULL COMMENT '',
  `InicioPeriodo` DATE NOT NULL COMMENT '',
  `FimPeriodo` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`idReserva`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `reserva`.`hospede_reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva`.`hospede_reserva` (
  `idHospede` INT(11) NOT NULL COMMENT '',
  `idReserva` INT(11) NOT NULL COMMENT '',
  `HospedePrincipal` TINYINT(1) NOT NULL COMMENT '',
  `Funcionario` VARCHAR(40) NOT NULL COMMENT '',
  PRIMARY KEY (`idHospede`, `idReserva`)  COMMENT '',
  INDEX `idReserva` (`idReserva` ASC)  COMMENT '',
  CONSTRAINT `hospede_reserva_ibfk_1`
    FOREIGN KEY (`idReserva`)
    REFERENCES `reserva`.`reserva` (`idReserva`),
  CONSTRAINT `hospede_reserva_ibfk_2`
    FOREIGN KEY (`idHospede`)
    REFERENCES `reserva`.`hospede` (`idHospede`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `reserva`.`quarto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva`.`quarto` (
  `idQuarto` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `Localizacao` VARCHAR(10) NULL DEFAULT NULL COMMENT '',
  `Andar` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `Tipo` VARCHAR(10) NOT NULL COMMENT '',
  `ArCondicionado` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `ValorDiaria` DECIMAL(4,2) NOT NULL COMMENT '',
  PRIMARY KEY (`idQuarto`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `reserva`.`reserva_quarto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva`.`reserva_quarto` (
  `idQuarto` INT(11) NOT NULL COMMENT '',
  `idReserva` INT(11) NOT NULL COMMENT '',
  `Funcionario` VARCHAR(40) NULL DEFAULT NULL COMMENT '',
  `ValorDiaria` DECIMAL(4,2) NOT NULL COMMENT '',
  `Desconto` DECIMAL(4,2) NULL DEFAULT NULL COMMENT '',
  `ValorTotalReserva` DECIMAL(4,2) NOT NULL COMMENT '',
  PRIMARY KEY (`idQuarto`, `idReserva`)  COMMENT '',
  INDEX `idReserva` (`idReserva` ASC)  COMMENT '',
  CONSTRAINT `reserva_quarto_ibfk_1`
    FOREIGN KEY (`idQuarto`)
    REFERENCES `reserva`.`quarto` (`idQuarto`),
  CONSTRAINT `reserva_quarto_ibfk_2`
    FOREIGN KEY (`idReserva`)
    REFERENCES `reserva`.`reserva` (`idReserva`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
