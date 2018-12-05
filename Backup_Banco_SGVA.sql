-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lojaarms
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.32-MariaDB

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
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho` (
  `carrinho_id` int(11) NOT NULL AUTO_INCREMENT,
  `ValorCompra` decimal(16,2) DEFAULT NULL,
  `item_car_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`carrinho_id`),
  KEY `item_car_id_idx` (`item_car_id`),
  CONSTRAINT `item_car_id` FOREIGN KEY (`item_car_id`) REFERENCES `item_carrinho` (`item_car_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` varchar(100) NOT NULL,
  `nascimento` date DEFAULT NULL,
  `cpf_client` bigint(25) DEFAULT NULL,
  `data_cadas_clie` date DEFAULT NULL,
  `endereco` mediumtext,
  `telefone` varchar(30) DEFAULT NULL,
  `CPA` int(7) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'ROMEU DOS SANTOS DE OLIVEIRA','1957-10-15',66921805620,'2018-12-03','FAZENDA ARROZ, S/N','(38)32341453',10270974),(2,'JOAO SIMAO BRAGA','1947-07-17',31102360368,'2018-12-03','RUA ESAU LACERDA, 1467','(88)34321108',106540586),(3,'EDSON BARRETO SAMPAIO','1949-12-30',8474877504,'2018-12-03','AVENIDA CECILIA MEIRELES, 288','(79)999810346',30235987),(4,'ETELVINA COSTA DE QUEIROZ','1950-10-17',34687050263,'2018-12-03','R ANGICO-RAJADO, 152','(92)36719678',30235987),(5,'JOSE ALVES DE SOUZA','1953-12-12',6327826253,'2018-12-03','R ROSA DE MAIO, 61','(92)36112583',2142589);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `compra_id` int(11) NOT NULL AUTO_INCREMENT,
  `dataCompra` date DEFAULT NULL,
  `cliente_id` int(11) NOT NULL,
  `carrinho_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`compra_id`),
  KEY `cliente_id_idx` (`cliente_id`),
  KEY `carrinho_id_idx` (`carrinho_id`),
  CONSTRAINT `carrinho_id` FOREIGN KEY (`carrinho_id`) REFERENCES `carrinho` (`carrinho_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `func_id` int(11) NOT NULL AUTO_INCREMENT,
  `nomeFunc` varchar(255) NOT NULL,
  `cpf_Func` int(13) DEFAULT NULL,
  `senha` varchar(18) DEFAULT NULL,
  `login` varchar(45) NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`func_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Lucas Lima',2147483647,'123','lucas.lima'),(2,'João Igor',2147483647,'123','joao.igor'),(3,'Kcymony Moreira ',2147483647,'123','mony'),(4,'Anderson Freitas',2147483647,'admin','anderson.freitas');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_carrinho`
--

DROP TABLE IF EXISTS `item_carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_carrinho` (
  `item_car_id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id` int(11) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`item_car_id`),
  KEY `produto_id_idx` (`produto_id`),
  CONSTRAINT `produto_id` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`produto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_carrinho`
--

LOCK TABLES `item_carrinho` WRITE;
/*!40000 ALTER TABLE `item_carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `produto_id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_prod` varchar(100) NOT NULL,
  `valor_prod` double(10,2) NOT NULL,
  `descricao` mediumtext,
  `estoque` int(30) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `data_cadas_prod` date DEFAULT NULL,
  PRIMARY KEY (`produto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Revólver Taurus RT941 8 Tiros Cal .22 Magnum 4\'\' Inox Alto Brilho',4449.00,'O Revólver 941 possui capacidade para 8 cartuchos, vértice de mira ajustável e cano de 4\".',1,'revolver','2018-12-02'),(2,'Pistola Taurus TH Hammer 380 ACP - Oxidada',5749.75,'No calibre .380 ACP, é indicada para o uso civil, pois atende os principais requisitos de uma arma para defesa pessoal e patrimonial, na categoria de arma de calibre permitido.',1,'pistola','2018-12-02'),(3,'Pistola Taurus Pt 838 Cal.380 18 Tiros+1 Ambidestra - Oxidada',5539.54,'A taurus 838 é uma pistola inovadora lançada em 2015. Sua armação é em polímero, possui sistema de disparo com cão, com ação simples e dupla a ainda possui miras noturnas com trítio. ',1,'pistola','2018-12-02'),(4,'Espingarda Taurus Circuit Judge 413 Cal.36ga - Cano 18,5\" - 5 Tiros - Oxidada',3850.85,'O Circuit Judge se originou do revólver mais bem sucedido da Taurus, o Judge. O CJ 413 de calibre 36 GA, possui capacidade para 5 cartuchos e possui miras ajustáveis. Ele oferece incrível versatilidade, precisão e simplicidade no uso. Possui uma bela coronha de madeira de lei, com design moderno e ergonômico.',2,'espingarda','2018-12-02'),(5,'Espingarda Pump Taurus St12 Cal. 12 - Cano 24\" - 7 Tiros+1',2750.75,'A Espingarda ST 12 calibre 12GA, é a arma ideal para uso policial, defesa residencial e patrimonial, sendo insuperável em situações em que a confiabilidade e agilidade operacional são fundamentais.',5,'espingarda','2018-12-02'),(6,'Revolver Taurus 889 - Cal 38 - 6 Tiros - 4\" - Inox',3950.92,'Revolver taurus novo, modelo 889, com cano reforçado e ventilado',3,'revolver','2018-12-02'),(7,'Carregador Pistola Taurus Pt 138 - 15 Tiros )',390.00,'Carregador Pistola Taurus Pt 138 - 15 Tiros (op. de Modelo)',6,'carregadores','2018-12-02'),(8,'Carregador Original Taurus Pistola PT 838C Cal.380 - 15 Tiros',425.00,'Carregador sobressalente com capacidade para 15 munições, compatível apenas com a versão compacta da 838, não compatível com modelo 838 full size.',12,'carregadores','2018-12-02'),(9,'Municiador HKS para Pistolas .40',171.00,'Magazine Speed Loader / Municiador para Pistolas Modelo 940. Este Municiador é um produto líder no mercado americano por sua qualidade e simplicidade. Também por ser leve e pequeno se adapta perfeitamente para profissionais que atuam na área de segurança.',34,'municiadores','2018-12-04'),(10,'Coldre Paddle Original Taurus Para Pistola PT 100 - Canhoto',99.00,'Modelo rotatório, compatível com todas os modelos de pistola Taurus PT100, PT99, PT59.',2,'coldres','2018-12-04'),(11,'Maleta Case Original Taurus Para Taurus PT 838 / 840 e 24/7 - Airsoft ou Arma de Fogo',79.00,'Maleta case original Taurus Para Taurus PT 838 / 840 e 24/7 - Airsoft ou Arma de Fogo',5,'maletas','2018-12-04'),(12,'Maleta Taurus Para Arma Curta de Até 4 Ou 5 \'\'',40.00,'Maleta plástica preta, com porta cadeado.',1,'maletas','2018-12-04'),(13,'teste',45.00,'re',1,'teste','2018-12-05');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'lojaarms'
--

--
-- Dumping routines for database 'lojaarms'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-05  6:19:40
