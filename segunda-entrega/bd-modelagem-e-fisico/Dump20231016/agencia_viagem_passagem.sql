CREATE DATABASE  IF NOT EXISTS `agencia_viagem` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agencia_viagem`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: agencia_viagem
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `passagem`
--

DROP TABLE IF EXISTS `passagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `compania` varchar(255) NOT NULL,
  `idaEvolta` tinyint(1) DEFAULT NULL,
  `data` datetime NOT NULL,
  `taxaServico` int NOT NULL,
  `taxaEmbarque` int NOT NULL,
  `tipoVoo` enum('direto','escala','conexao') DEFAULT NULL,
  `quantidade` int NOT NULL,
  `promocao` tinyint(1) DEFAULT NULL,
  `cnpjCompania` varchar(18) NOT NULL,
  `valor` decimal(10,0) NOT NULL,
  `idDestino` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idDestino` (`idDestino`),
  CONSTRAINT `passagem_ibfk_1` FOREIGN KEY (`idDestino`) REFERENCES `destino` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passagem`
--

LOCK TABLES `passagem` WRITE;
/*!40000 ALTER TABLE `passagem` DISABLE KEYS */;
INSERT INTO `passagem` VALUES (1,'Azul',1,'2023-10-13 00:00:00',50,30,'direto',1,1,'000-000',200,2),(2,'GOL',1,'2023-10-13 00:00:00',50,30,'direto',1,1,'111-111',300,1),(8,'Azul',0,'2023-10-16 00:00:00',10,10,'direto',2,1,'222-222',400,1),(9,'Latam',1,'2023-10-16 00:00:00',50,30,'escala',2,1,'333-333',200,3),(11,'Azul',0,'1969-12-31 21:00:00',50,30,'conexao',2,1,'1',200,3);
/*!40000 ALTER TABLE `passagem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-16 23:12:03
