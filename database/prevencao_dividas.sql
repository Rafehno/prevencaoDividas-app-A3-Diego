
CREATE DATABASE prevencao_dividas;

USE prevencao_dividas;

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cpf` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `renda_mensal` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `emprestimo`;

CREATE TABLE `emprestimo` (
  `id` bigint NOT NULL,
  `banco` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `parcelas` int DEFAULT NULL,
  `taxa_juros` double DEFAULT NULL,
  `valor_emprestado` double DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6n4khp9r51vk81ksiq1cx5bg0` (`cliente_id`),
  CONSTRAINT `FK6n4khp9r51vk81ksiq1cx5bg0` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `gasto`;

CREATE TABLE `gasto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `tipo` enum('COMPRA','DIVIDA') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente` (`cliente_id`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



DROP TABLE IF EXISTS `meta_financeira`;

CREATE TABLE `meta_financeira` (
  `id` bigint NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `prazo` date DEFAULT NULL,
  `valor_alvo` double DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6egrmko3p4bi5ycs0nf34rr4w` (`cliente_id`),
  CONSTRAINT `FK6egrmko3p4bi5ycs0nf34rr4w` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `receita_extra`;

CREATE TABLE `receita_extra` (
  `id` bigint NOT NULL,
  `data` date DEFAULT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf35hm1w4l7wcyojmu55k2yhfg` (`cliente_id`),
  CONSTRAINT `FKf35hm1w4l7wcyojmu55k2yhfg` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
