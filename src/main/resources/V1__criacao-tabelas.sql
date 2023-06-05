CREATE DATABASE IF NOT EXISTS minas_cafe;
USE minas_cafe;
--
-- Estrutura da tabela `cad_cafe_coco`
--
CREATE TABLE IF NOT EXISTS `cad_cafe_coco` (
  `lote` int(7) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(60) NOT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `data` date NOT NULL,
  `sacos` int NOT NULL,
  `quilos` float NOT NULL,
  `humidade` float DEFAULT NULL,
  `barracao` int DEFAULT NULL,
  `subproduto` varchar(150) DEFAULT NULL,
  `numero_nota` int DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int(2) DEFAULT NULL,
  `peneira` int DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `referencia` varchar(7) DEFAULT NULL,
  `meieiro` VARCHAR(60) DEFAULT NULL,
  `porcentagem_produtor` int(2),
  `porcentagem_meieiro` int(2),
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Estrutura da tabela `cad_cafe_beneficiado`
--
CREATE TABLE IF NOT EXISTS `cad_cafe_beneficiado` (
  `lote` int NOT NULL AUTO_INCREMENT,
  `produtor` varchar(60) NOT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int NOT NULL,
  `quilos` float NOT NULL,
  `humidade` float DEFAULT NULL,
  `barracao` int DEFAULT NULL,
  `subproduto` varchar(150) DEFAULT NULL,
  `numero_nota` int DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int DEFAULT NULL,
  `peneira` int DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `meieiro` varchar(60) DEFAULT NULL,
  `porcentagem_produtor` int,
  `porcentagem_meieiro` int,
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `cad_cafe_baixado` (
  `lote` int NOT NULL AUTO_INCREMENT,
  `produtor` varchar(60) NOT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int NOT NULL,
  `quilos` float NOT NULL,
  `barracao` int DEFAULT NULL,
  `subproduto` varchar(150) DEFAULT NULL,
  `numero_nota` int DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int DEFAULT NULL,
  `peneira` int DEFAULT NULL,
  `humidade` float DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `referencia` varchar(7) DEFAULT NULL,
  `meieiro` VARCHAR(60) DEFAULT NULL,
  `porcentagem_produtor` int(2),
  `porcentagem_meieiro` int(2),
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--
-- Estrutura da tabela `cad_cafe_maquina`
--
CREATE TABLE IF NOT EXISTS `cad_cafe_maquina` (
  `lote` int NOT NULL AUTO_INCREMENT,
  `produtor` varchar(60) NOT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int NOT NULL,
  `quilos` float NOT NULL,
  `barracao` int DEFAULT NULL,
  `subproduto` varchar(150) DEFAULT NULL,
  `numero_nota` int DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int DEFAULT NULL,
  `peneira` int DEFAULT NULL,
  `humidade` float DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `referencia` varchar(7) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `meieiro` VARCHAR(60) DEFAULT NULL,
  `porcentagem_produtor` int,
  `porcentagem_meieiro` int,
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Estrutura da tabela `produtor`
--
CREATE TABLE IF NOT EXISTS `ficha_produtor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lote` varchar(7) DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `telefone` varchar(27) DEFAULT NULL,
  `data` date NOT NULL,
  `entrada_saida` varchar(150) DEFAULT NULL,
  `renda` int DEFAULT NULL,
  `humidade` float DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `banco` VARCHAR(25) DEFAULT NULL,
  `agencia` VARCHAR(7) DEFAULT NULL,
  `operacao` VARCHAR(4) DEFAULT NULL,
  `tipo_conta` VARCHAR(14) DEFAULT NULL,
  `numero_conta` VARCHAR(13) DEFAULT NULL,
  `nome_correntista` VARCHAR(50) DEFAULT NULL,
  `chave_pix` VARCHAR(60) DEFAULT NULL,
  `aniversario` DATE,
  `saldo_duro_sacos` int DEFAULT NULL,
  `saldo_duro_quilos` float DEFAULT NULL,
  `saldo_riado_sacos` int DEFAULT NULL,
  `saldo_riado_quilos` float DEFAULT NULL,
  `saldo_rio_sacos` int DEFAULT NULL,
  `saldo_rio_quilos` float DEFAULT NULL,
  `saldo_escolha_sacos` int DEFAULT NULL,
  `saldo_escolha_quilos` float DEFAULT NULL,
  `saldo_mooca_sacos` int DEFAULT NULL,
  `saldo_mooca_quilos` float DEFAULT NULL,
  `preco` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;