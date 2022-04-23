-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: personneltracking
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `permitrequests`
--

DROP TABLE IF EXISTS `permitrequests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permitrequests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tc` varchar(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `remainingPermitAmount` varchar(2) NOT NULL,
  `permitStart` varchar(11) NOT NULL,
  `permitFinish` varchar(11) NOT NULL,
  `permitType` varchar(15) NOT NULL,
  `usedPermitAmount` int NOT NULL,
  `response` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permitrequests`
--

LOCK TABLES `permitrequests` WRITE;
/*!40000 ALTER TABLE `permitrequests` DISABLE KEYS */;
INSERT INTO `permitrequests` VALUES (1,'22587416325','Ayşegül','Bursa','59','25/11/2021','26/11/2021','mazeret',1,'Onaylandı'),(2,'36527416710','Hatice','Kurt','59','08/10/2021','09/10/2021','mazeret',1,'Onaylandı'),(3,'36081475249','Feyzanur','Ağrı','14','04/05/2021','05/05/2021','mazeret',1,'Onaylandı'),(4,'26985476015','Sena','Olcar','20','28/07/2021','29/07/2021','mazeret',1,'Onaylandı'),(5,'22587416325','Ayşegül','Bursa','58','12/12/2021','13/12/2021','mazeret',1,'Beklemede');
/*!40000 ALTER TABLE `permitrequests` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-31 22:57:01
