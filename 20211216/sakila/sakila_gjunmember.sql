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
-- Table structure for table `gjunmember`
--

DROP TABLE IF EXISTS `gjunmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gjunmember` (
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `address` varchar(70) NOT NULL,
  `realname` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='服務會員資料表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gjunmember`
--

LOCK TABLES `gjunmember` WRITE;
/*!40000 ALTER TABLE `gjunmember` DISABLE KEYS */;
INSERT INTO `gjunmember` VALUES ('eric','1111','eric@cht.com.tw','高雄市','張三丰'),('linda','1111','eric@cht.com.tw','高雄市','張三丰'),('linda12','1111','eric@cht.com.tw','高雄市','張三丰'),('Ricahrd','1111','richcard@cht.com.tw','台北市仁愛路一號','里查'),('rich','1111','richcard@cht.com.tw','台北市仁愛路一號','里查'),('tony','1111','brette0119@gmail.com','高雄市鼓山區美術東八街107號16F','陳宗興'),('tony100','','richcard@cht.com.tw','台北市仁愛路一號','林先生'),('tony101','1111','richcard@cht.com.tw','台北市仁愛路一號','林先生'),('tony102','11111','richcard@cht.com.tw','台北市仁愛路一號','林先生'),('tony103','1111','richcard@cht.com.tw','台北市仁愛路一號','林先生'),('tony104','1111','richcard@cht.com.tw','台北市仁愛路一號','林先生'),('tony105','1111','richcard@cht.com.tw','台北市仁愛路一號','林先生'),('tony99','1111','richcard@cht.com.tw','台北市仁愛路一號','林先生'),('zero','1111','richcard@cht.com.tw','台北市仁愛路一號','林先生');
/*!40000 ALTER TABLE `gjunmember` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-16 19:25:04
