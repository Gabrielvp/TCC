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
    inativo boolean not null,
  PRIMARY KEY (`idPessoa`)
  );

CREATE TABLE forma_pagamento (
  idForma_pagamento int(11) NOT NULL AUTO_INCREMENT,
  descricao varchar(50) NOT NULL,
  parcela int(11) NOT NULL,
  intervalo int(11) NOT NULL,
  aVista tinyint(1) NOT NULL,
  PRIMARY KEY (idForma_pagamento)
);

create table cPagar(
    idCPagar integer not null auto_increment primary key,
    formPagamento varchar(50) not null,
    fatura varchar(20) not null,
    total double not null,
    data date not null,
    vencimento date not null,
    parcelas int not null,
    idPessoa int not null,
    aVista boolean not null,
    
    constraint FK_pessoa_pagar foreign key (idPessoa) references pessoa (idPessoa)
);

create table parcelas_cPagar(
    idParcelas_cPagar int not null auto_increment primary key,
    fatura varchar(50) not null,
    parcela varchar(50) not null,
    valor double not null,
    entrada Date not null,
    vencimento Date not null,
    intervalo int,   
    idCPagar int not null,
    quitado boolean not null,
    valor_pago double,
    data_pgto date,
    constraint fk_cPagar foreign key (idCPagar) references cPagar (idCPagar)
);

create table cReceber(
    idCReceber integer not null auto_increment primary key,
    formPagamento varchar(50) not null,
    fatura varchar(20) not null,
    total double not null,
    data date not null,
    vencimento date not null,
    parcelas int,   
    idPessoa int not null,
    pessoa varchar(150) not null,
    aVista boolean not null,

    constraint FK_pessoa_receber foreign key (idPessoa) references pessoa (idPessoa)
);

create table parcelas_cReceber(
    idParcelas_cReceber int not null auto_increment primary key,
    fatura varchar(50) not null,
    parcela varchar(50) not null,
    valor double not null,
    entrada Date not null,
    vencimento Date not null,
    intervalo int,
    idOrcamento int not null,
    idCReceber int not null,
    quitado boolean not null,
    valor_pago double,
    data_pgto date,
    
    constraint FK_orcamento foreign key (idOrcamento) references orcamento(idOrcamento),
    constraint fk_cReceber foreign key (idCReceber) references cReceber (idCReceber)
);

-- -----------------------------------------------------
-- Table `bd_tcc`.`Agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Agendamento` (
  `idAgendamento` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `descricao` VARCHAR(300) NOT NULL,
  `dia` VARCHAR(45) NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idAgendamento`, `idPessoa`),
  INDEX `fk_Agendamento_Pessoa` (`idPessoa` ASC),
  CONSTRAINT `fk_Agendamento_Pessoa`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



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
   lancado boolean not null,  
  PRIMARY KEY (`idOrcamento`),
  KEY `fk_orcamento_pessoa` (`idPessoa`),
  CONSTRAINT `fk_orcamento_pessoa` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`)
);


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
    ON UPDATE NO ACTION
    );

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
);

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
);


-- -----------------------------------------------------
-- Table `bd_tcc`.`Configuracao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_tcc`.`Configuracoes` (
  `idConfiguracao` INT NOT NULL AUTO_INCREMENT,
  `horaInicial` TIME NOT NULL,
  `horaFinal` TIME NOT NULL,
  `intervalo` INT NOT NULL,  
  `dia` INT NOT NULL,
    PRIMARY KEY (`idConfiguracao`)
  );

INSERT INTO pessoa
	(Nome,email, completo, rua, numero, cep, bairro, cidade, estado, cpf, rg, telResidencial, telCelular,telComercial, observacoes, inativo )
    VALUES ('Exemplo da Silva', 'exemplo@exemplo.com.br', 1, 'Rua do Exemplo', 123, '88111-888', 'exemplo', 'exemplo', 'EX', '123.456.789-98', '12345678', '(48)3223-3223', '(48)8463-6384', '(48)3243-4332',' ', 0);

INSERT INTO produto
	(descricao, cod_barras, quantidade, valor_venda, valor_compra, unidade, marca, modelo, fornecedor, referencia, ativo)
	VALUES ('exemplo', '123456789', '50', 100, 50, '1', 'Exemplo', 'AB123', 'Exemplo', 'CD456', 0);

INSERT INTO forma_pagamento
	(descricao, parcela, intervalo, aVista)
	VALUES ('A Vista', 0, 0, 1);

INSERT INTO forma_pagamento
	(descricao, parcela, intervalo, aVista)
	VALUES ('A Prazo 10x', 10, 30, 0);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
;