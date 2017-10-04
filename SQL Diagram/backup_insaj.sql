-- MySQL dump 10.13  Distrib 5.6.25, for Win32 (x86)
--
-- Host: localhost    Database: insaj
-- ------------------------------------------------------
-- Server version	5.6.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aulas`
--

DROP TABLE IF EXISTS `aulas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aulas` (
  `idAula` int(11) NOT NULL AUTO_INCREMENT,
  `Numero` varchar(20) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  PRIMARY KEY (`idAula`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aulas`
--

LOCK TABLES `aulas` WRITE;
/*!40000 ALTER TABLE `aulas` DISABLE KEYS */;
INSERT INTO `aulas` VALUES (3,'A-1',25),(4,'A-2',25),(5,'A-3',25),(6,'A-4',25),(7,'A-5',25),(8,'A-6',25),(9,'A-7',25),(10,'A-8',25),(11,'A-9',25);
/*!40000 ALTER TABLE `aulas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clases`
--

DROP TABLE IF EXISTS `clases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clases` (
  `idClase` int(11) NOT NULL AUTO_INCREMENT,
  `idHora` int(11) NOT NULL,
  `idAula` int(11) NOT NULL,
  `idDocente` int(11) NOT NULL,
  `idSeccion` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL,
  PRIMARY KEY (`idClase`),
  KEY `fk_hora_idx` (`idHora`),
  KEY `fk_aula_idx` (`idAula`),
  KEY `fk_docent_idx` (`idDocente`),
  KEY `fk_sec_idx` (`idSeccion`),
  KEY `fk_idmetrias_idx` (`idMateria`),
  CONSTRAINT `fk_aula_c` FOREIGN KEY (`idAula`) REFERENCES `aulas` (`idAula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_docent_c` FOREIGN KEY (`idDocente`) REFERENCES `docentes` (`idDocente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_hora_c` FOREIGN KEY (`idHora`) REFERENCES `horas` (`idHora`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idmetrias_c` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`idMateria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sec_c` FOREIGN KEY (`idSeccion`) REFERENCES `secciones` (`idSeccion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clases`
--

LOCK TABLES `clases` WRITE;
/*!40000 ALTER TABLE `clases` DISABLE KEYS */;
INSERT INTO `clases` VALUES (165,110,4,7,12,15),(166,79,10,14,15,11),(167,80,7,11,15,17),(168,152,11,11,14,17),(169,95,9,13,14,16),(170,114,11,7,14,12),(171,100,10,7,11,15),(172,97,9,14,10,18),(173,98,7,8,12,14),(174,128,11,16,13,13),(175,114,9,15,15,22),(176,150,11,10,12,23),(177,149,7,13,15,16),(178,114,4,8,15,20),(179,136,9,8,13,20),(180,113,3,14,14,18),(181,85,4,7,13,12),(182,104,7,9,14,19),(183,119,9,14,16,28),(184,134,10,11,17,22),(185,121,10,7,10,15),(186,110,5,14,10,11),(187,138,5,14,11,18),(188,140,6,11,17,26),(189,79,3,8,17,20),(190,112,5,8,11,14),(191,139,9,7,12,12),(192,108,5,14,13,11),(193,79,8,7,15,12),(194,144,11,13,10,16),(195,128,4,7,15,15),(196,133,11,13,13,16),(197,81,4,15,12,21),(198,129,7,7,13,15),(199,129,10,12,16,21),(200,91,3,11,13,17),(201,134,11,16,13,24),(202,130,3,16,11,13),(203,82,9,10,17,27),(204,128,8,8,10,14),(205,109,8,14,12,11),(206,123,5,11,12,17),(207,95,5,8,13,14),(208,107,5,9,13,19),(209,116,11,8,14,20),(210,145,9,12,15,21),(211,81,10,10,17,23),(212,100,5,14,14,11),(213,124,8,16,14,13),(214,151,3,8,12,20),(215,78,3,9,15,13),(216,100,9,8,15,14),(217,86,8,14,13,18),(218,96,6,7,10,12),(219,131,8,9,11,19),(220,85,11,14,11,11),(221,127,8,10,10,19),(222,144,4,8,10,20),(223,141,4,9,12,19),(224,146,11,8,11,20),(225,138,3,16,16,26),(226,144,5,7,14,15),(227,116,10,10,15,23),(228,90,3,11,11,17),(229,101,4,13,12,16),(230,140,10,8,14,14),(231,133,5,12,17,21),(232,126,5,7,16,15),(233,151,8,7,17,15),(234,147,10,8,16,20),(235,113,4,9,10,13),(236,109,5,16,12,13),(237,103,4,16,14,24),(238,82,3,7,10,12),(239,140,9,7,11,12),(240,108,4,10,16,27),(241,143,11,12,16,25),(242,126,8,10,16,23),(243,151,11,11,10,17),(244,145,7,13,11,16),(245,96,11,9,15,19),(246,108,8,11,12,22);
/*!40000 ALTER TABLE `clases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalledocentematerias`
--

DROP TABLE IF EXISTS `detalledocentematerias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalledocentematerias` (
  `idMateria` int(11) NOT NULL,
  `idDocente` int(11) NOT NULL,
  KEY `FK_docentes_idx` (`idDocente`),
  KEY `FK_MATERIA_idx` (`idMateria`),
  CONSTRAINT `FK_MATERI` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`idMateria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_docent` FOREIGN KEY (`idDocente`) REFERENCES `docentes` (`idDocente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalledocentematerias`
--

LOCK TABLES `detalledocentematerias` WRITE;
/*!40000 ALTER TABLE `detalledocentematerias` DISABLE KEYS */;
INSERT INTO `detalledocentematerias` VALUES (27,9),(19,9),(13,9),(25,12),(21,12),(16,13),(11,14),(28,14),(18,14),(27,10),(19,10),(23,10),(22,15),(21,15),(20,8),(14,8),(26,16),(24,16),(13,16),(15,7),(12,7),(22,19),(26,19),(17,19);
/*!40000 ALTER TABLE `detalledocentematerias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallehorario`
--

DROP TABLE IF EXISTS `detallehorario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallehorario` (
  `idHorario` int(11) DEFAULT NULL,
  `idClase` int(11) DEFAULT NULL,
  KEY `fkho_idx` (`idHorario`),
  KEY `fk_clas_idx` (`idClase`),
  CONSTRAINT `fk_clas` FOREIGN KEY (`idClase`) REFERENCES `clases` (`idClase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkho` FOREIGN KEY (`idHorario`) REFERENCES `horarios` (`idHorario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallehorario`
--

LOCK TABLES `detallehorario` WRITE;
/*!40000 ALTER TABLE `detallehorario` DISABLE KEYS */;
INSERT INTO `detallehorario` VALUES (1,197),(1,176),(1,177),(1,187),(1,232),(1,194),(1,223),(1,220),(1,190),(1,201),(1,202),(1,174),(1,209),(1,168),(1,198),(1,211),(1,244),(1,170),(1,189),(1,192),(1,231),(1,171),(1,207),(1,217),(1,240),(1,165),(1,178),(1,180),(1,175),(1,246),(1,221),(1,230),(1,243),(1,218),(1,208),(1,241),(1,237),(1,242),(1,182),(1,196),(1,184),(1,213),(1,167),(1,227),(1,205),(1,238),(1,179),(1,239),(1,204),(1,183),(1,185),(1,191),(1,235),(1,212),(1,193),(1,224),(1,219),(1,216),(1,229),(1,166),(1,234),(1,199),(1,233),(1,210),(1,228),(1,200),(1,203),(1,236),(1,181),(1,188),(1,226),(1,215),(1,186),(1,172),(1,169),(1,206),(1,214),(1,222),(1,195),(1,225),(1,173),(1,245);
/*!40000 ALTER TABLE `detallehorario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentes`
--

DROP TABLE IF EXISTS `docentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docentes` (
  `idDocente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `Contrato` varchar(45) DEFAULT NULL,
  `NumHorasPlanta` int(11) DEFAULT NULL,
  `NumHorasClases` int(11) DEFAULT NULL,
  `r` int(11) DEFAULT NULL,
  `g` int(11) DEFAULT NULL,
  `b` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDocente`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentes`
--

LOCK TABLES `docentes` WRITE;
/*!40000 ALTER TABLE `docentes` DISABLE KEYS */;
INSERT INTO `docentes` VALUES (7,'GERMAN RICARDO','VILLEDA PREZA','PLAZA',1,1,0,204,204),(8,'LUISA','FRANCIA','PLAZA',1,1,204,204,0),(9,'OLGA EMELINA','CASTILLO ALVAREZ','PLAZA',1,1,153,0,153),(10,'LUIS','PALACIOS','PLAZA',1,1,51,51,51),(11,'ANA GLADIS','AMAYA','PLAZA',1,1,255,153,204),(12,'PATRICIA','GIRON','PLAZA',1,1,102,255,102),(13,'RAUL','VEGA','PLAZA',1,1,0,102,153),(14,'YESENIA GUADALUPE','VALLEDARES DE DUEÑAS','PLAZA',1,1,0,102,102),(15,'DANIEL','ALFARO','PLAZA',1,1,204,0,0),(16,'WILFREDO','VILLEDA','PLAZA',1,1,102,102,0),(19,'nuevo','nuevo','plaza',1,1,255,255,0);
/*!40000 ALTER TABLE `docentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horarios` (
  `idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `anio` varchar(5) DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idHorario`),
  KEY `fk_us_idx` (`idUser`),
  CONSTRAINT `fk_us` FOREIGN KEY (`idUser`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'2017',1);
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horas`
--

DROP TABLE IF EXISTS `horas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horas` (
  `idHora` int(11) NOT NULL AUTO_INCREMENT,
  `Hora` varchar(45) NOT NULL,
  `Turno` varchar(45) NOT NULL,
  `Dias` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`idHora`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horas`
--

LOCK TABLES `horas` WRITE;
/*!40000 ALTER TABLE `horas` DISABLE KEYS */;
INSERT INTO `horas` VALUES (78,'7:00','AM',1),(79,'7:40','AM',1),(80,'8:40','AM',1),(81,'9:20','AM',1),(82,'10:00','AM',1),(83,'10:55','AM',1),(84,'11:35','AM',1),(85,'12:15','AM',1),(86,'1:00','PM',1),(87,'1:40','PM',1),(88,'2:30','PM',1),(89,'3:10','PM',1),(90,'3:50','PM',1),(91,'4:40','PM',1),(92,'5:20','PM',1),(93,'7:00','AM',2),(94,'7:40','AM',2),(95,'8:40','AM',2),(96,'9:20','AM',2),(97,'10:00','AM',2),(98,'10:55','AM',2),(99,'11:35','AM',2),(100,'12:15','AM',2),(101,'1:00','PM',2),(102,'1:40','PM',2),(103,'2:30','PM',2),(104,'3:10','PM',2),(105,'3:50','PM',2),(106,'4:40','PM',2),(107,'5:20','PM',2),(108,'7:00','AM',3),(109,'7:40','AM',3),(110,'8:40','AM',3),(111,'9:20','AM',3),(112,'10:00','AM',3),(113,'10:55','AM',3),(114,'11:35','AM',3),(115,'12:15','AM',3),(116,'1:00','PM',3),(117,'1:40','PM',3),(118,'2:30','PM',3),(119,'3:10','PM',3),(120,'3:50','PM',3),(121,'4:40','PM',3),(122,'5:20','PM',3),(123,'7:00','AM',4),(124,'7:40','AM',4),(125,'8:40','AM',4),(126,'9:20','AM',4),(127,'10:00','AM',4),(128,'10:55','AM',4),(129,'11:35','AM',4),(130,'12:15','AM',4),(131,'1:00','PM',4),(132,'1:40','PM',4),(133,'2:30','PM',4),(134,'3:10','PM',4),(135,'3:50','PM',4),(136,'4:40','PM',4),(137,'5:20','PM',4),(138,'7:00','AM',5),(139,'7:40','AM',5),(140,'8:40','AM',5),(141,'9:20','AM',5),(142,'10:00','AM',5),(143,'10:55','AM',5),(144,'11:35','AM',5),(145,'12:15','AM',5),(146,'1:00','PM',5),(147,'1:40','PM',5),(148,'2:30','PM',5),(149,'3:10','PM',5),(150,'3:50','PM',5),(151,'4:40','PM',5),(152,'5:20','PM',5);
/*!40000 ALTER TABLE `horas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materias` (
  `idMateria` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Tipo` varchar(25) NOT NULL,
  PRIMARY KEY (`idMateria`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (11,'LENGUAJE','BASICA'),(12,'MATEMATICA','BASICA'),(13,'CIENCIAS','BASICA'),(14,'SOCIALES','BASICA'),(15,'INGLES','OPTATIVA'),(16,'INFORMATICA','OPTATIVA'),(17,'ORIENTACION','OPTATIVA'),(18,'HABILITACION','OPTATIVA'),(19,'SEMINARIO','OPTATIVA'),(20,'ED FISICA','OPTATIVA'),(21,'TECNOLOGIA','OPTATIVA'),(22,'PRACTICA','OPT'),(23,'CREATIVIDAD','OPT'),(24,'ORTOGRAFIA','OPT'),(25,'PRAC CONTABLE','OPT'),(26,'TRAB GRADUACION','OPTATIVA'),(27,'PRAC PROFESIONAL','OPTATIVA'),(28,'TALLER PAN','OPTATIVA');
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiasporseccion`
--

DROP TABLE IF EXISTS `materiasporseccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiasporseccion` (
  `idMateria` int(11) NOT NULL DEFAULT '0',
  `idSeccion` int(11) NOT NULL,
  `idx` int(11) NOT NULL DEFAULT '0',
  KEY `fk_materia_idx` (`idMateria`),
  KEY `fk_seccion_idx` (`idSeccion`),
  CONSTRAINT `fk_materia` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`idMateria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_seccion` FOREIGN KEY (`idSeccion`) REFERENCES `secciones` (`idSeccion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiasporseccion`
--

LOCK TABLES `materiasporseccion` WRITE;
/*!40000 ALTER TABLE `materiasporseccion` DISABLE KEYS */;
INSERT INTO `materiasporseccion` VALUES (20,11,0),(17,11,0),(11,11,0),(13,11,0),(15,11,0),(19,11,0),(12,11,0),(18,11,0),(16,11,0),(14,11,0),(17,12,0),(22,12,0),(19,12,0),(11,12,0),(15,12,0),(20,12,0),(13,12,0),(14,12,0),(16,12,0),(21,12,0),(23,12,0),(12,12,0),(20,13,0),(15,13,0),(13,13,0),(17,13,0),(14,13,0),(24,13,0),(11,13,0),(18,13,0),(19,13,0),(12,13,0),(16,13,0),(14,14,0),(15,14,0),(18,14,0),(20,14,0),(13,14,0),(19,14,0),(11,14,0),(16,14,0),(17,14,0),(24,14,0),(12,14,0),(16,15,0),(14,15,0),(11,15,0),(23,15,0),(20,15,0),(22,15,0),(12,15,0),(15,15,0),(17,15,0),(21,15,0),(19,15,0),(13,15,0),(26,16,0),(27,16,0),(21,16,0),(28,16,0),(15,16,0),(20,16,0),(25,16,0),(23,16,0),(27,17,0),(23,17,0),(20,17,0),(26,17,0),(15,17,0),(21,17,0),(22,17,0),(17,10,0),(19,10,0),(11,10,0),(20,10,0),(15,10,0),(18,10,0),(16,10,0),(12,10,0),(14,10,0),(13,10,0),(12,10,0),(13,33,0),(11,35,0),(11,35,1),(13,36,0),(13,36,1),(13,36,2);
/*!40000 ALTER TABLE `materiasporseccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idRole` int(11) NOT NULL AUTO_INCREMENT,
  `Role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secciones`
--

DROP TABLE IF EXISTS `secciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secciones` (
  `idSeccion` int(11) NOT NULL AUTO_INCREMENT,
  `Especialidad` varchar(45) DEFAULT NULL,
  `Anio` varchar(45) DEFAULT NULL,
  `Seccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSeccion`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secciones`
--

LOCK TABLES `secciones` WRITE;
/*!40000 ALTER TABLE `secciones` DISABLE KEYS */;
INSERT INTO `secciones` VALUES (10,'GENERAL','1','A'),(11,'GENERAL','1','B'),(12,'TECNICO','1','A'),(13,'GENERAL','2','A'),(14,'GENERAL','2','B'),(15,'TECNICO','2','A'),(16,'TECNICO','3','N/T'),(17,'SALUD','3','N/T'),(33,'yu','78','u'),(35,'ui','78','ui'),(36,'nueva','201','a');
/*!40000 ALTER TABLE `secciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `idRole` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fkRol_idx` (`idRole`),
  CONSTRAINT `fkRol` FOREIGN KEY (`idRole`) REFERENCES `roles` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'user','user','Usuario 1',1),(2,'VISIT','VISIT','VISITANTE',1),(4,'uni','uni','uni',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-01 23:03:35
