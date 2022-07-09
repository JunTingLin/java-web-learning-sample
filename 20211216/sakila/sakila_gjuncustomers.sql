-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: sakila
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `gjuncustomers`
--

DROP TABLE IF EXISTS `gjuncustomers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gjuncustomers` (
  `customerid` char(5) COLLATE utf8_bin NOT NULL,
  `companyname` varchar(50) COLLATE utf8_bin NOT NULL,
  `address` varchar(100) COLLATE utf8_bin NOT NULL,
  `phone` varchar(30) COLLATE utf8_bin NOT NULL,
  `country` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='巨匠客戶資料表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gjuncustomers`
--

LOCK TABLES `gjuncustomers` WRITE;
/*!40000 ALTER TABLE `gjuncustomers` DISABLE KEYS */;
INSERT INTO `gjuncustomers` VALUES ('AB001','GJUN','台北市公園路','+8862232323232','台灣'),('B0001','巨匠電腦','高雄市新興區','07-4565656','中華民國'),('C0001','中華電信','KHH','+886958050228','台灣'),('C0002','巨匠電腦','台北市公園路','2232323232','台灣'),('C0003','巨匠電腦高認','高雄市中山路','2232323232','台灣'),('C0022','中華電信','KHH','+886958050228','台灣'),('C0023','巨匠電腦','台北市公園路','+8862232323232','台灣');
/*!40000 ALTER TABLE `gjuncustomers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-16 19:25:05
