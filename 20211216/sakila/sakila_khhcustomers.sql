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
-- Table structure for table `khhcustomers`
--

DROP TABLE IF EXISTS `khhcustomers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khhcustomers` (
  `customerid` int NOT NULL,
  `companyname` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `country` varchar(20) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客戶資料表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khhcustomers`
--

LOCK TABLES `khhcustomers` WRITE;
/*!40000 ALTER TABLE `khhcustomers` DISABLE KEYS */;
INSERT INTO `khhcustomers` VALUES (1,'巨匠公園路','台北市公園路','02-132323','KHH','中華民國'),(2,'中華電信','台北市仁愛路','02-12345678','KHH','中華民國'),(3,'高雄認證中心','高雄市','07-454545','KHH','中華民國'),(5,'中信銀行','台北市','02-1234567','台北市','中華民國'),(10,'巨匠電腦','高雄市',NULL,'高雄市','中華民國'),(12,'中信資訊','台中市',NULL,'台中市','中華民國'),(13,'巨匠逢甲','台中市','04-2323232','台中市','中華民國'),(14,'光世代公司','台北市仁愛路','02-1343434','台北市','中華民國');
/*!40000 ALTER TABLE `khhcustomers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-16 19:24:58
