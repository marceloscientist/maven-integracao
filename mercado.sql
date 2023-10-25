-- Exclui o banco de dados 'mercado' se ele já existir
DROP DATABASE IF EXISTS mercado;

-- Cria o banco de dados 'mercado'
CREATE DATABASE mercado;

-- Ativa o banco de dados 'mercado'
USE mercado;

-- Cria a tabela 'produto' no banco de dados 'mercado'
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `preco` decimal(10,0) DEFAULT NULL,
  `quantidadeEstoque` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
