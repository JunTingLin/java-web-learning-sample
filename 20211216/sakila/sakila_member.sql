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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `name` varchar(50) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('艾倫','allen','2222','allen@cht.com.tw','男性'),('dfdfdf','allen1','1111','brette0119@gmail.com','男性'),('dfdfdf','allen2','1111','brette0119@gmail.com','男性'),('張三','allenbill','1111','chung@cht.com.tw','男性'),('張泰山','allencung','1111','brette0119@gmail.com','男性'),('張泰山','allencung2','1111','brette0119@gmail.com','男性'),('張泰山','allencung3','1111','brette0119@gmail.com','男性'),('張泰山','allencung4','1111','brette0119@gmail.com',NULL),('張泰山','allencung5','1111','brette0119@gmail.com','男性'),('比二','billchen','22222','bill@cht.com.tw','男性'),('凱西','cathy','1111','cathy@cht.com.tw','男性'),('張三丰','chen@cht.com.tw','1234567890','brette0119@gmail.com',NULL),('泰山','chenlin@cht.com.tw','343434','chung@cht.com.tw',NULL),('張無忌','chung','1111','chung@cht.com.tw',NULL),('張三丰','eric','1111','chung@cht.com.tw','男性'),('張三丰','ericchen','1111','chung@cht.com.tw','男性'),('張泰山','ericlin','1111','chung@cht.com.tw','男性'),('琳達','linda','1111','linda@cht.com.tw','on'),('里查','richard','1111','richard@cht.com.tw','男性'),('山姆','sam','1111','sam@cht.com.tw','男性'),('艾立克','sameric','1111','eric@cht.com.tw','男性'),('生林','samlin','1111','sam@cht.com.tw','男性'),('張泰山','taisam','1111','chen@cht.com.tw',NULL),('東尼','tony','1111','tony@cht.com.tw','男性');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-16 19:24:54
