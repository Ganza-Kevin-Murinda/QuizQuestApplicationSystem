CREATE DATABASE  IF NOT EXISTS `quiz_quest_application_db_24915` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quiz_quest_application_db_24915`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: quiz_quest_application_db_24915
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_Id` varchar(255) NOT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('JV20242','Java Programming');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedback_Id` int NOT NULL AUTO_INCREMENT,
  `isRead` bit(1) NOT NULL,
  `Text_Message` varchar(255) DEFAULT NULL,
  `user_Id_fk` int DEFAULT NULL,
  PRIMARY KEY (`feedback_Id`),
  KEY `FK_akdpa7aywlvcea89oaux5etg2` (`user_Id_fk`),
  CONSTRAINT `FK_akdpa7aywlvcea89oaux5etg2` FOREIGN KEY (`user_Id_fk`) REFERENCES `useridentity` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,_binary '\0','Well, Hello :)',3);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `instructor_Id` int NOT NULL AUTO_INCREMENT,
  `verificationCode` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`instructor_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'194913','murindakevinmulk@gmail.com','Taufic Habumugisha','instructor1','Active','Instructor');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_course`
--

DROP TABLE IF EXISTS `instructor_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_course` (
  `instructor_Id` int NOT NULL,
  `course_Id` varchar(255) NOT NULL,
  KEY `FK_hssgsaatx6snpvoa2ilyvt8xp` (`course_Id`),
  KEY `FK_oi2aicnljcldfy57f878ikla6` (`instructor_Id`),
  CONSTRAINT `FK_hssgsaatx6snpvoa2ilyvt8xp` FOREIGN KEY (`course_Id`) REFERENCES `course` (`course_Id`),
  CONSTRAINT `FK_oi2aicnljcldfy57f878ikla6` FOREIGN KEY (`instructor_Id`) REFERENCES `instructor` (`instructor_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_course`
--

LOCK TABLES `instructor_course` WRITE;
/*!40000 ALTER TABLE `instructor_course` DISABLE KEYS */;
INSERT INTO `instructor_course` VALUES (1,'JV20242');
/*!40000 ALTER TABLE `instructor_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question_Id` int NOT NULL AUTO_INCREMENT,
  `choice1` varchar(255) DEFAULT NULL,
  `choice2` varchar(255) DEFAULT NULL,
  `choice3` varchar(255) DEFAULT NULL,
  `choice4` varchar(255) DEFAULT NULL,
  `correctAnswer` varchar(255) DEFAULT NULL,
  `question_Text` varchar(255) DEFAULT NULL,
  `course_Id_fk` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_Id`),
  KEY `FK_evo4vvtil9xul0aw125ibqm7w` (`course_Id_fk`),
  CONSTRAINT `FK_evo4vvtil9xul0aw125ibqm7w` FOREIGN KEY (`course_Id_fk`) REFERENCES `course` (`course_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'JVM','JDB','JDK','JRE','JDB','Which is used to find and fix bugs in the Java programs?','JV20242'),(2,'int','object','long','void','int','What is the return type of the hashCode() method in the Object class?','JV20242'),(3,'java.util package','java.lang package','java.awt package','java.io package','java.util package','Which package contains the Random class?','JV20242'),(4,'Runnable Interface','Abstract Interface','Marker Interface','CharSequence Interface','Marker Interface','An interface with no fields or methods is known as?','JV20242'),(5,'Stack','String memory','Random storage space','Heap memory','Heap memory','In which memory a String is stored, when we create a string using new operator?','JV20242'),(6,'Runnable interface','Remote interface','Readable interface','Result interface','Remote interface','Which of the following is a marker interface?','JV20242'),(7,'import','package','extends','export','import','Which keyword is used for accessing the features of a package?','JV20242'),(8,'Java Archive Runner','Java Archive','Java Application Resource','Java Application Runner','Java Archive','In java, jar stands for?','JV20242'),(9,'java.lang.StringBuilder','java.lang.Short','java.lang.Byte','java.lang.String','java.lang.StringBuilder','Which of the following is a mutable class in java?','JV20242'),(10,'Bytecode is executed by JVM','The applet makes the Java code secure and portable','Use of exception handling','Dynamic binding between objects','Bytecode is executed by JVM','Which of the following option leads to the portability and security of Java?','JV20242');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useridentity`
--

DROP TABLE IF EXISTS `useridentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useridentity` (
  `user_Id` int NOT NULL AUTO_INCREMENT,
  `verificationCode` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useridentity`
--

LOCK TABLES `useridentity` WRITE;
/*!40000 ALTER TABLE `useridentity` DISABLE KEYS */;
INSERT INTO `useridentity` VALUES (1,'84376','murindakevinmulk@gmail.com','Ganza Kevin','Admin1','Active','SystemAdmin'),(2,'373600','ganzakevin2003@gmail.com','Kevin Murinda','murindaK','Active','SuperUser'),(3,'427065','murindakevinmulk@gmail.com','Aimable Nshuti','User1','Active','SystemUser'),(4,'156813','jeremie.auca@gmail.com','Jeremie Ukundwa','User2','Active','SystemUser'),(5,'353570','murindakevinmulk@gmail.com','Kevin','123456','Active','SystemUser');
/*!40000 ALTER TABLE `useridentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userresult`
--

DROP TABLE IF EXISTS `userresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userresult` (
  `result_Id` int NOT NULL AUTO_INCREMENT,
  `dateTime` varchar(255) DEFAULT NULL,
  `score` int NOT NULL,
  `course_Id_fk` varchar(255) DEFAULT NULL,
  `user_Id_fk` int DEFAULT NULL,
  PRIMARY KEY (`result_Id`),
  KEY `FK_p4d4or7r09r3skiapdqaf846a` (`course_Id_fk`),
  KEY `FK_5ou86pba1udvru412psu8bbsd` (`user_Id_fk`),
  CONSTRAINT `FK_5ou86pba1udvru412psu8bbsd` FOREIGN KEY (`user_Id_fk`) REFERENCES `useridentity` (`user_Id`),
  CONSTRAINT `FK_p4d4or7r09r3skiapdqaf846a` FOREIGN KEY (`course_Id_fk`) REFERENCES `course` (`course_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userresult`
--

LOCK TABLES `userresult` WRITE;
/*!40000 ALTER TABLE `userresult` DISABLE KEYS */;
INSERT INTO `userresult` VALUES (1,'2024-05-26 00:35:45',90,'JV20242',3);
/*!40000 ALTER TABLE `userresult` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-12 12:55:54
