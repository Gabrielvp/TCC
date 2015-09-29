-- MySQL Script generated by MySQL Workbench
-- 08/31/15 13:46:40
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bd_tcc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_tcc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_tcc` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `db_tcc` ;

-- -----------------------------------------------------
-- Table `bd_tcc`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `completo` TINYINT(1) NULL,
  `rua` VARCHAR(45) NULL,
  `numero` INT NULL,
  `cep` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `rg` VARCHAR(45) NULL,
  `telResidencial` VARCHAR(45) NULL,
  `telCelular` VARCHAR(45) NULL,
  `telComercial` VARCHAR(45) NULL,
  `observacoes` VARCHAR(300) NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_tcc`.`Agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Agendamento` (
  `idAgendamento` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `dia` VARCHAR(45) NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idAgendamento`, `idPessoa`),
  INDEX `fk_Agendamento_Pessoa` (`idPessoa` ASC),
  CONSTRAINT `fk_Agendamento_Pessoa`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_tcc`.`Orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Orcamento` (
  `idOrcamento` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `cliente` varchar(150) NOT NULL,
  `total` double NOT NULL,
  `desconto` double DEFAULT NULL,
  `idPessoa` int(11) NOT NULL,
  `aprovado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idOrcamento`),
  KEY `fk_orcamento_pessoa` (`idPessoa`),
  CONSTRAINT `fk_orcamento_pessoa` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_tcc`.`Fatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Fatura` (
  `idFatura` INT NOT NULL AUTO_INCREMENT,
  `fatura` VARCHAR(45) NOT NULL,
  `total` DOUBLE NOT NULL,
  `dt_emissao` DATE NOT NULL,
  `quitado` TINYINT(1) NOT NULL,
  `forma_pagamento` VARCHAR(45) NOT NULL,
  `Orcamento_idOrcamento` INT NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idFatura`),
  INDEX `fk_Fatura_Orcamento` (`Orcamento_idOrcamento` ASC),
  INDEX `fk_Fatura_Pessoa` (`idPessoa` ASC),
  CONSTRAINT `fk_Fatura_Orcamento`
    FOREIGN KEY (`Orcamento_idOrcamento`)
    REFERENCES `db_tcc`.`Orcamento` (`idOrcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fatura_Pessoa`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `db_tcc`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_tcc`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `cod_barras` varchar(20) NOT NULL,
  `quantidade` double NOT NULL,
  `valor_venda` double NOT NULL,
  `valor_compra` double NOT NULL,
  `unidade` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `fornecedor` varchar(100) NOT NULL,
  `referencia` varchar(45) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`idProduto`)
ENGINE = InnoDB;

CREATE TABLE `produto_orcamento` (
  `idProduto_orcamento` int(11) NOT NULL AUTO_INCREMENT,
  `idProduto` int(11) NOT NULL,
  `idOrcamento` int(11) NOT NULL,
  `produto` varchar(150) NOT NULL,
  `qtd` double NOT NULL,
  `valor` double NOT NULL,
  `desconto` double DEFAULT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`idProduto_orcamento`),
  KEY `fk_produto_orcamento_produto` (`idProduto`),
  KEY `fk_produto_orcamento_orcamento` (`idOrcamento`),
  CONSTRAINT `fk_produto_orcamento_orcamento` FOREIGN KEY (`idOrcamento`) REFERENCES `orcamento` (`idOrcamento`),
  CONSTRAINT `fk_produto_orcamento_produto` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `bd_tcc`.`Produto_Orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Produto_Orcamento` (
  `idProduto` INT NOT NULL,
  `idOrcamento` INT NOT NULL,
  PRIMARY KEY (`idProduto`, `idOrcamento`),
  INDEX `fk_Produto_has_Orcamento_Orcamento` (`idOrcamento` ASC),
  INDEX `fk_Produto_has_Orcamento_Produto` (`idProduto` ASC),
  CONSTRAINT `fk_Produto_has_Orcamento_Produto`
    FOREIGN KEY (`idProduto`)
    REFERENCES `db_tcc`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Orcamento_Orcamento`
    FOREIGN KEY (`idOrcamento`)
    REFERENCES `Orcamento` (`idOrcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_tcc`.`Configuracao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Configuracao` (
  `idConfiguracao` INT NOT NULL AUTO_INCREMENT,
  `horaInicial` TIME NOT NULL,
  `horaFinal` TIME NOT NULL,
  `intervalo` INT NOT NULL,
  `almocoInicio` TIME NOT NULL,
  `almocoFim` TIME NOT NULL,
  `dia` INT NOT NULL,
  PRIMARY KEY (`idConfiguracao`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


