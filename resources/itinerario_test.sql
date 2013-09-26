-- MySQL dump 10.13  Distrib 6.0.6-alpha, for Win32 (ia32)
--
-- Host: localhost    Database: itinerario_test
-- ------------------------------------------------------
-- Server version	6.0.6-alpha-community

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
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `empresa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'65.253.565/0001-26','','Av. Cap. Mor Gouveia, 125 - Quintas, Natal-RN CEP: 59060-400','http://www.tguanabara.com.br/img/logo.gif','Transportes Guanabara Ltda','www.transportesguanabara.com.br','(84) 3311-3311'),(2,'78.334.855/0001-46','santamariaa@uol.com.br','R. Cidade do Sol, 2166 - Pitimbú, Natal-RN CEP 59067-720','','Auto Ônibus Santa Maria Transportes e Turismo Ltda','','(84) 4006-9197/(84) 4006-9179'),(3,'13.260.614/0001-54','www.transportesconceicao.com.br','R. Maristela Alves, 23 - Felipe Camarão, Natal-RN CEP 59074-340','','Empresa de Transportes Nossa Senhora da Conceição Ltda','','(84) 3194-1800'),(4,'27.774.570/0001-95','viasul@viasultransportes.net','R. Prof. Francisco. Luciano Oliveira, 50A - Neópolis, Natal-RN CEP 59066-060','','Transflor Ltda. (Via Sul)','www.viasultransportes.net','(84) 4009-3150'),(5,'71.391.481/0001-51','contato@viacaoriograndense.com.br','R. Interventor Mário Câmara, 2442 - Cidade da Esperança, Natal/RN. CEP 59060-600','','Viação Riograndense Ltda','www.viacaoriograndense.com.br','(84) 3614-4164/3662-4560'),(6,'24.856.247/0001-72','','Av. Cap. Mor Gouveia, 847 - Bom Pastor, Natal-RN CEP 59060-400 ','http://www.transportescidadedonatal.com/pics/logo-novo.png','Transportes Cidade do Natal Ltda','www.transportescidadedonatal.com','(84) 3205-3690'),(7,'38.876.689/0001-95','reunidas008@uol.com.br','Av. Dr. João Medeiros Filho, 4701 - Pajuçara, Natal-RN CEP 59122-365 ','','Reunidas Transportes Urbanos Ltda','','(84) 4008-5454'),(8,'75.617.363/0001-70','','Rua São João de Deus, 231 – Rocas, Natal/RN CEP: 59.010-690','http://www.autoviacaocampos.com.br/images/logo.png','Auto Viação Campos Ltda','www.autoviacaocampos.com.br','84) 3230.6133/(84) 3230.6227'),(9,'85.538.887/0001-29','','Avenida Capitão-mor Gouveia, 126 – Quintas, Natal/RN CEP: 59.260-000','http://www.expresso-oceano.com.br/img/logo.gif','Expresso Oceano Ltda','www.expresso-oceano.com.br','Fone: (84) 3205.8222'),(10,'71.632.269/0001-39','administrativo@parnamirimfield.com.br','Rodovia RN 101 – nº 910/A – Emaús, Parnamirim RN CEP: 59.148.160','','Parnamirim Field Transportes Ltda','www.parnamirimfield.com.br','(84) 3645.1419'),(11,'22.782.415/0001-05','dunas@r7.com','Av. Cap. Mor Gouveia, 847 - Bom Pastor, Natal-RN CEP 59060-400','','Viação Cidade das Dunas Ltda','','(84) 3205-5000'),(12,'39.614.884/0001-00','','Rua Francisco Ferreira da Silva, 639 – Rosa dos Ventos, Parnamirim/RN CEP: 59.142.060','http://www.trampolimdavitoria.com/templates/trampolim/images/logo.png','Transportes Trampolim da Vitória Ltda','www.trampolimdavitoria.com','(84) 3272.3234'),(13,'65.967.762/0001-07','','Avenida Rio Grande do Norte, 137 – Cidade Nova, Natal/RN CEP: 59.070-500','','Empresa Barros Ltda','','(84) 4006.0880'),(14,'86.733.671/0001-87','','','','Empresa para teste de atualização','',''),(23,'17.273.812/0001-03',NULL,NULL,NULL,'Empresa para teste de remoção',NULL,NULL);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa_linha`
--

DROP TABLE IF EXISTS `empresa_linha`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `empresa_linha` (
  `Empresa_id` bigint(20) NOT NULL,
  `linhas_id` bigint(20) NOT NULL,
  UNIQUE KEY `linhas_id` (`linhas_id`),
  KEY `FK5796E7D48045D9F7` (`Empresa_id`),
  KEY `FK5796E7D45B3A5618` (`linhas_id`),
  CONSTRAINT `FK5796E7D45B3A5618` FOREIGN KEY (`linhas_id`) REFERENCES `linha` (`id`),
  CONSTRAINT `FK5796E7D48045D9F7` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `empresa_linha`
--

LOCK TABLES `empresa_linha` WRITE;
/*!40000 ALTER TABLE `empresa_linha` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_linha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itinerario`
--

DROP TABLE IF EXISTS `itinerario`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `itinerario` (
  `idItinerario` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idItinerario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `itinerario`
--

LOCK TABLES `itinerario` WRITE;
/*!40000 ALTER TABLE `itinerario` DISABLE KEYS */;
/*!40000 ALTER TABLE `itinerario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itinerario_ponto`
--

DROP TABLE IF EXISTS `itinerario_ponto`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `itinerario_ponto` (
  `Itinerario_idItinerario` bigint(20) NOT NULL,
  `pontos_id` bigint(20) NOT NULL,
  UNIQUE KEY `pontos_id` (`pontos_id`),
  KEY `FK496AFFDF19466E91` (`Itinerario_idItinerario`),
  KEY `FK496AFFDF310DA998` (`pontos_id`),
  CONSTRAINT `FK496AFFDF19466E91` FOREIGN KEY (`Itinerario_idItinerario`) REFERENCES `itinerario` (`idItinerario`),
  CONSTRAINT `FK496AFFDF310DA998` FOREIGN KEY (`pontos_id`) REFERENCES `ponto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `itinerario_ponto`
--

LOCK TABLES `itinerario_ponto` WRITE;
/*!40000 ALTER TABLE `itinerario_ponto` DISABLE KEYS */;
/*!40000 ALTER TABLE `itinerario_ponto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linha`
--

DROP TABLE IF EXISTS `linha`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `linha` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigoLinha` varchar(255) DEFAULT NULL,
  `distancia` double DEFAULT NULL,
  `qtdOnibus` int(11) DEFAULT NULL,
  `tarifa` double DEFAULT NULL,
  `fim` varchar(255) DEFAULT NULL,
  `inicio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `linha`
--

LOCK TABLES `linha` WRITE;
/*!40000 ALTER TABLE `linha` DISABLE KEYS */;
INSERT INTO `linha` VALUES (1,'01A',NULL,NULL,2.4,'Parque dos Coqueiros','Cidade da Esperança'),(2,'01B',NULL,NULL,2.4,'Gramoré','Cidade da Esperança'),(3,'02',NULL,NULL,2.4,'Mirassol','Gramoré'),(4,'04',NULL,NULL,2.4,'Mirassol','Amarante'),(5,'05',NULL,NULL,2.4,'Petrópolis','Vale Dourado'),(6,'08',NULL,NULL,2.4,'Mirassol','Redinha'),(7,'10-29 ',NULL,NULL,2.4,'N. Descoberta via Campus','Nova Natal'),(8,'12-14',NULL,NULL,2.4,'Ribeira','Soledade I'),(9,'13',NULL,NULL,2.4,'Urbana (Domingos e Feriados)','Redinha'),(10,'13A',NULL,NULL,2.4,'Ribeira via ponte Newton Navarro','Redinha'),(11,'13B',NULL,NULL,2.4,'Petrópolis(via Ponte de Igapó)','Redinha'),(12,'15-16',NULL,NULL,2.4,'Petrópolis','Pajuçara'),(13,'17-78',NULL,NULL,2.4,'Petrópolis','Gramoré'),(14,'18',NULL,NULL,2.4,'Campus (Dias Úteis)','Bairro Nordeste'),(15,'19',NULL,NULL,2.4,'Ribeira','Rodoviária Nova'),(16,'19',NULL,NULL,2.4,'Ribeira  via Bairro Nordeste (Domingos e Feriados)','Rodoviária Nova'),(17,'20',NULL,NULL,2.4,'Ribeira','Cidade da Esperança'),(18,'23-69',NULL,NULL,2.4,'Alecrim, via Jardim América','Felipe Camarão II'),(19,'25',NULL,NULL,2.4,'Petrópolis (Dias Úteis e Sábados)','Bairro Nordeste'),(20,'588',NULL,NULL,2.4,'Circular Campus Universitário (Dias Úteis)','Circular Campus Universitário (Dias Úteis)'),(21,'58A',NULL,NULL,2.4,'Redinha (Dfomingos e Feriados)','Parque dos Coqueiros'),(22,'592',NULL,NULL,2.4,'Santa Cecília','Soledade I'),(23,'593',NULL,NULL,2.4,'Residencial Redinha','Circular'),(24,'60',NULL,NULL,2.4,'Mirassol','Pajuçara'),(25,'600',NULL,NULL,2.4,'Norte Shopping','Parque dos Coqueiros'),(26,'61-62',NULL,NULL,2.4,'Petrópolis','Soledade I'),(27,'64',NULL,NULL,2.4,'Petrópolis','Nova Natal'),(28,'67',NULL,NULL,2.4,'Petrópolis via Vila Paraíso','Vale Dourado'),(29,'70',NULL,NULL,2.4,'Petrópolis','Parque dos Coqueiros'),(30,'72',NULL,NULL,2.4,'Mirassol','Vale Dourado'),(31,'75 A',NULL,NULL,2.4,'Ribeira via Ponte Newton Navarro','Parque das Dunas'),(32,'75 B',NULL,NULL,2.4,'Petrópolis  via Ponte de Igapó','Parque das Dunas'),(33,'76',NULL,NULL,2.4,'Pq. das Dunas','Felipe Camarão'),(34,'76.2',NULL,NULL,2.4,'Redinha','Felipe Camarão'),(35,'77',NULL,NULL,2.4,'Mirassol','Parque dos Coqueiros'),(36,'79',NULL,NULL,2.4,'Mirassol','Parque das Dunas'),(37,'81',NULL,NULL,2.4,'Petrópolis','Vila Verde'),(38,'84',NULL,NULL,2.4,'Petrópolis, via ponte Newton Navarro','Soledade I'),(39,'B',NULL,NULL,2.4,'Nova Natal','Ribeira'),(40,'A',NULL,NULL,2.6,'Natal (Petrópolis) via aeroporto (apenas ida)','Parnamirim (Rosa dos Ventos)'),(41,'B',NULL,NULL,2.8,'Natal (Alecrim)','Parnamirim (Rosa dos Ventos)'),(42,'C',NULL,NULL,2.2,'Natal (Shopping Via Direta)','Parnamirim (Santa Tereza)'),(43,'C (Vale do Sol)',NULL,NULL,2.2,'Natal (Shopping Via Direta)','Parnamirim (Vale do Sol)'),(44,'G',NULL,NULL,2.65,'Natal (BR-226 Av. Rio Branco)','Macaíba (TRM) '),(45,'H',NULL,NULL,3.45,'Ielmo Marinho','Macaíba (TRM)'),(46,'I',NULL,NULL,2.2,'Natal (Norte Shopping)','Macaíba (TRM)'),(47,'J',NULL,NULL,2.6,'Natal (TRN / Alecrim)','Parnamirim (Passagem de Areia)'),(48,'L',NULL,NULL,2.2,'Natal (Shopping Via Direta)','Parnamirim (Cajupiranga/Liberdade)'),(49,'M',NULL,NULL,2.8,'Natal (BR-101 / Midway Mall)','Macaíba (TRM)'),(50,'K',NULL,NULL,1.7,'Macaíba','Extensão da Linha M | Natal'),(51,'N',NULL,NULL,1.1,'Cidade Verde','Caminho do Sol'),(52,'P',NULL,NULL,2.6,'Natal (Ponta Negra)','Parnamirim (Rosa dos Ventos)'),(53,'Q',NULL,NULL,1,'Alimentador Aeroporto','Extensão Linha A'),(54,'R',NULL,NULL,2.2,'Natal (Midway Mall)','São Gonçalo (Centro)'),(55,'S',NULL,NULL,2.2,'Natal (Rio Branco)','São Gonçalo (Centro)'),(56,'U',NULL,NULL,2.2,'Natal (Natal) via Norte Shopping','São Gonçalo (Poço da Pedra / Centro)'),(57,'21',NULL,NULL,2.4,NULL,NULL),(58,'22',NULL,NULL,2.4,NULL,NULL),(59,'23/69',NULL,NULL,2.4,NULL,NULL),(60,'30',NULL,NULL,2.4,NULL,NULL),(61,'31',NULL,NULL,2.4,NULL,NULL),(62,'41',NULL,NULL,2.4,NULL,NULL),(63,'59',NULL,NULL,2.4,NULL,NULL),(64,'63',NULL,NULL,2.4,NULL,NULL),(65,'71',NULL,NULL,2.4,NULL,NULL),(66,'76',NULL,NULL,2.4,NULL,NULL),(67,'83',NULL,NULL,2.4,NULL,NULL),(68,'587',NULL,NULL,2.4,NULL,NULL),(69,'6301',NULL,NULL,2.4,NULL,NULL),(70,'Noturna (905)',NULL,NULL,2.4,NULL,NULL),(71,'33',NULL,NULL,2.4,'Praia do Meio(Via Br101)','Planalto'),(72,'33 A',NULL,NULL,2.4,'Praia do Meio(Via Candelária)','Planalto'),(73,'33 B',NULL,NULL,2.4,'Lagoa Seca(Via Candelaria)','Planalto'),(74,'40',NULL,NULL,2.4,'Mãe Luiza','Planalto'),(75,'600',NULL,NULL,2.4,'Bairros','Norte '),(76,'85',NULL,NULL,2.4,'Petrópolis','Soledade I');
/*!40000 ALTER TABLE `linha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linha_ponto`
--

DROP TABLE IF EXISTS `linha_ponto`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `linha_ponto` (
  `Linha_id` bigint(20) NOT NULL,
  `pontosVolta_id` bigint(20) NOT NULL,
  `pontosIda_id` bigint(20) NOT NULL,
  UNIQUE KEY `pontosVolta_id` (`pontosVolta_id`),
  UNIQUE KEY `pontosIda_id` (`pontosIda_id`),
  KEY `FKDAB3958176997` (`Linha_id`),
  KEY `FKDAB3955BA68464` (`pontosIda_id`),
  KEY `FKDAB395DA27100A` (`pontosVolta_id`),
  CONSTRAINT `FKDAB395DA27100A` FOREIGN KEY (`pontosVolta_id`) REFERENCES `ponto` (`id`),
  CONSTRAINT `FKDAB3955BA68464` FOREIGN KEY (`pontosIda_id`) REFERENCES `ponto` (`id`),
  CONSTRAINT `FKDAB3958176997` FOREIGN KEY (`Linha_id`) REFERENCES `linha` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `linha_ponto`
--

LOCK TABLES `linha_ponto` WRITE;
/*!40000 ALTER TABLE `linha_ponto` DISABLE KEYS */;
/*!40000 ALTER TABLE `linha_ponto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linha_pontosida`
--

DROP TABLE IF EXISTS `linha_pontosida`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `linha_pontosida` (
  `Linha_id` bigint(20) NOT NULL,
  `pontosIda_id` bigint(20) NOT NULL,
  UNIQUE KEY `pontosIda_id` (`pontosIda_id`),
  KEY `FKAAAD6E888176997` (`Linha_id`),
  KEY `FKAAAD6E885BA68464` (`pontosIda_id`),
  CONSTRAINT `FKAAAD6E885BA68464` FOREIGN KEY (`pontosIda_id`) REFERENCES `ponto` (`id`),
  CONSTRAINT `FKAAAD6E888176997` FOREIGN KEY (`Linha_id`) REFERENCES `linha` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `linha_pontosida`
--

LOCK TABLES `linha_pontosida` WRITE;
/*!40000 ALTER TABLE `linha_pontosida` DISABLE KEYS */;
INSERT INTO `linha_pontosida` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),(72,83),(72,84),(72,85),(72,86),(72,87),(72,88),(72,89),(72,90),(72,91),(72,92),(72,93),(72,94),(72,95),(72,96),(72,97),(72,98),(72,99),(72,100),(72,101),(72,102),(72,103),(72,104),(72,105),(72,106),(72,107),(72,108),(72,109),(72,110),(72,111),(72,112),(72,113),(72,114),(72,115),(72,116),(72,117),(72,118),(72,119),(72,120),(72,121),(72,122),(72,123);
/*!40000 ALTER TABLE `linha_pontosida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linha_pontosvolta`
--

DROP TABLE IF EXISTS `linha_pontosvolta`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `linha_pontosvolta` (
  `Linha_id` bigint(20) NOT NULL,
  `pontosVolta_id` bigint(20) NOT NULL,
  UNIQUE KEY `pontosVolta_id` (`pontosVolta_id`),
  KEY `FKB5C855E28176997` (`Linha_id`),
  KEY `FKB5C855E2DA27100A` (`pontosVolta_id`),
  CONSTRAINT `FKB5C855E28176997` FOREIGN KEY (`Linha_id`) REFERENCES `linha` (`id`),
  CONSTRAINT `FKB5C855E2DA27100A` FOREIGN KEY (`pontosVolta_id`) REFERENCES `ponto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `linha_pontosvolta`
--

LOCK TABLES `linha_pontosvolta` WRITE;
/*!40000 ALTER TABLE `linha_pontosvolta` DISABLE KEYS */;
INSERT INTO `linha_pontosvolta` VALUES (1,51),(1,52),(1,53),(1,54),(1,55),(1,56),(1,57),(1,58),(1,59),(1,60),(1,61),(1,62),(1,63),(1,64),(1,65),(1,66),(1,67),(1,68),(1,69),(1,70),(1,71),(1,72),(1,73),(1,74),(1,75),(1,76),(1,77),(1,78),(1,79),(1,80),(1,81),(1,82),(72,124),(72,125),(72,126),(72,127),(72,128),(72,129),(72,130),(72,131),(72,132),(72,133),(72,134),(72,135),(72,136),(72,137),(72,138),(72,139),(72,140),(72,141),(72,142),(72,143),(72,144),(72,145),(72,146),(72,147),(72,148),(72,149),(72,150),(72,151),(72,152),(72,153),(72,154),(72,155),(72,156),(72,157),(72,158),(72,159),(72,160),(72,161),(72,162),(72,163),(72,164),(72,165);
/*!40000 ALTER TABLE `linha_pontosvolta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onibus`
--

DROP TABLE IF EXISTS `onibus`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `onibus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `placa` varchar(255) DEFAULT NULL,
  `empresa_id` bigint(20) DEFAULT NULL,
  `linha_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8D0E2BF68176997` (`linha_id`),
  KEY `FK8D0E2BF68045D9F7` (`empresa_id`),
  CONSTRAINT `FK8D0E2BF68045D9F7` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`),
  CONSTRAINT `FK8D0E2BF68176997` FOREIGN KEY (`linha_id`) REFERENCES `linha` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `onibus`
--

LOCK TABLES `onibus` WRITE;
/*!40000 ALTER TABLE `onibus` DISABLE KEYS */;
/*!40000 ALTER TABLE `onibus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ponto`
--

DROP TABLE IF EXISTS `ponto`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `ponto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `ponto`
--

LOCK TABLES `ponto` WRITE;
/*!40000 ALTER TABLE `ponto` DISABLE KEYS */;
INSERT INTO `ponto` VALUES (1,'RUA PERIMETRAL SUL (TERMINAL)',NULL,NULL),(2,'AV. RIO GRANDE DO SUL',NULL,NULL),(3,'AV. CEARÁ',NULL,NULL),(4,'AV. RIO GRANDE DO NORTE',NULL,NULL),(5,'AV. PARAÍBA',NULL,NULL),(6,'RUA ADOLFO GORDO',NULL,NULL),(7,'AV. CAP. MOR GOUVEIA',NULL,NULL),(8,'AV. BOM PASTOR',NULL,NULL),(9,'RUA SANTA TEREZA',NULL,NULL),(10,'RUA MANOEL MIRANDA',NULL,NULL),(11,'RUA DA CONCÓRDIA',NULL,NULL),(12,'AV. DOS PAIATIS',NULL,NULL),(13,'AV. BERNARDO VIEIRA',NULL,NULL),(14,'RUA DR. MÁRIO NEGÓCIO',NULL,NULL),(15,'AV. FELIZARDO MOURA',NULL,NULL),(16,'AV. TOMAZ LANDIM',NULL,NULL),(17,'BR 406',NULL,NULL),(18,'RUA. PEDRO ÁLVARES CABRAL',NULL,NULL),(19,'RUA. JARDIM ESPERANÇA',NULL,NULL),(20,'RUA. PARQUE DAS NAÇÕES',NULL,NULL),(21,'RUA. SAMAMBAIA',NULL,NULL),(22,'RUA. SANTA LÚZIA',NULL,NULL),(23,'AV. DAS FRONTEIRAS',NULL,NULL),(24,'RUA ACARAU',NULL,NULL),(25,'RUA QUEIXADA',NULL,NULL),(26,'AV. PAULISTANA',NULL,NULL),(27,'AV. FRONTEIRAS',NULL,NULL),(28,'AV. MARANGUAPE',NULL,NULL),(29,'AV. NOVAS RUSSAS',NULL,NULL),(30,'AV. FLORIANÓPOLIS',NULL,NULL),(31,'AV. BLUMENAU',NULL,NULL),(32,'AV. SENHOR DO BONFIM',NULL,NULL),(33,'AV. JEQUIRIÇÁ',NULL,NULL),(34,'AV. PICO DO CABUGI',NULL,NULL),(35,'AV. SERRA NEGRA',NULL,NULL),(36,'AV. RIO DOCE',NULL,NULL),(37,'RUA PROJETADA',NULL,NULL),(38,'RUA BELA VISTA',NULL,NULL),(39,'RUA BUMBA MEU BOI',NULL,NULL),(40,'AV. DA CHEGANÇA',NULL,NULL),(41,'RUA DO PASTORIL',NULL,NULL),(42,'RUA DOS GANZÁS',NULL,NULL),(43,'RUA DO ABOIO',NULL,NULL),(44,'RUA DO COCO DE RODA',NULL,NULL),(45,'AV. DA CIRANDA',NULL,NULL),(46,'AV. DOS GUARARAPES',NULL,NULL),(47,'RUA ELDORADO',NULL,NULL),(48,'RUA ATIBAIA',NULL,NULL),(49,'AV. PIRATININGA',NULL,NULL),(50,'RUA RIVERSU',NULL,NULL),(51,'AV. PIRASSUNUNGA',NULL,NULL),(52,'RUA TOCANTINEA',NULL,NULL),(53,'RUA MARQUES DE ABRANTES',NULL,NULL),(54,'RUA ARNAUD V. DE CARVALHO',NULL,NULL),(55,'RUA VISCONDE DE OURO PRETO',NULL,NULL),(56,'RUA ANTÔNIO M. DE ALCANTARA',NULL,NULL),(57,'RUA MARQUES DE ABRANTES',NULL,NULL),(58,'RUA PE. MANOEL DE NOBREGA',NULL,NULL),(59,'RUA VISCONDE DE SABÓIA',NULL,NULL),(60,'RUA BARÃO DOS COCAIS',NULL,NULL),(61,'RUA ÁLVARO OSÓRIO DE ALMEIDA',NULL,NULL),(62,'RUA UBAIRA',NULL,NULL),(63,'RUA GENERAL SOLOM',NULL,NULL),(64,'RUA DR. CARNEIRO RIBEIRO',NULL,NULL),(65,'AV. TOCANTINEA',NULL,NULL),(66,'AV. POMPÉIA',NULL,NULL),(67,'AV. RIO DOCE',NULL,NULL),(68,'AV. ITAPETINGA',NULL,NULL),(69,'AV. DR. JOÃO MEDEIROS FILHO',NULL,NULL),(70,'AV. TOMAZ LANDIM',NULL,NULL),(71,'AV. FELIZARDO MOURA',NULL,NULL),(72,'RUA JANDIRA',NULL,NULL),(73,'RUA DR. MÁRIO NEGÓCIO',NULL,NULL),(74,'AV. BERNARDO VIEIRA',NULL,NULL),(75,'AV. BOM PASTOR',NULL,NULL),(76,'AV. CAP. MOR GOUVEIA',NULL,NULL),(77,'RUA ADOLFO GORDO',NULL,NULL),(78,'AV. PARAÍBA',NULL,NULL),(79,'AV. RIO GRANDE DO NORTE',NULL,NULL),(80,'AV. CEARÁ',NULL,NULL),(81,'AV. RIO GRANDE DO SUL',NULL,NULL),(82,'RUA PERIMETRAL SUL (TERMINAL)',NULL,NULL),(83,'R Agrestina, 16740, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(84,'R Agrestina, 15548, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(85,'R Agrestina, 15104, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(86,'R Agrestina, 7970, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(87,'R Agrestina, 299, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(88,'R Agrestina, 1064, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(89,'R Agrestina, 250, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(90,'R Agrestina, 57, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(91,'R Eng. Joao Helio Alves Rocha, 1984, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(92,'R Eng. Joao Helio Alves Rocha, 1696, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(93,'R Mira Mangue, 218, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(94,'R Mira Mangue, 390, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(95,'R Mira Mangue, 634, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(96,'R Mira Mangue, 948, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(97,'R Mira Mangue, 1208, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(98,'R Mira Mangue, 1626, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(99,'R Monte Rei, 60, Rio Grande Do Norte, Cidade Nova (Natal)',NULL,NULL),(100,'R Serra Da Jurema, 5345, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(101,'R Serra Dos Carajas, 522, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(102,'R Serra Dos Carajas, 2430, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(103,'R Serra Dos Carajas, 7978, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(104,'R Serra Dos Carajas, 9984, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(105,'R Rio Gramame, 4752, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(106,'R Rio Gramame, 1266, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(107,'Av Prudente De Morais, 10859, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(108,'Av Prudente De Morais, 10425, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(109,'Av Prudente De Morais, 9815, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(110,'Av Prudente De Morais, 9577, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(111,'Av Prudente De Morais, 9179, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(112,'Av Prudente De Morais, 9059, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(113,'Av Prudente De Morais, 8137, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(114,'Av Prudente De Morais, 7717, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(115,'Av Prudente De Morais, 7491, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(116,'R Md Vasconcelos, 127, Rio Grande Do Norte, Candelaria (Natal)',NULL,NULL),(117,'Av Prudente De Morais, 6115, Rio Grande Do Norte, Tirol (Natal)',NULL,NULL),(118,'Av Prudente De Morais, 5609, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(119,'Av Prudente De Morais, 5129, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(120,'Av Prudente De Morais, 4655, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(121,'Av Prudente De Morais, 4117, Rio Grande Do Norte, Tirol (Natal)',NULL,NULL),(122,'R Alberto Silva, 1274, Rio Grande Do Norte, Lagoa Seca (Natal)',NULL,NULL),(123,'R Alberto Silva, 1378, Rio Grande Do Norte, Lagoa Seca (Natal)',NULL,NULL),(124,'Av Sen. Salgado Filho, 1174, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(125,'Av Sen. Salgado Filho, 1496, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(126,'Av Sen. Salgado Filho, 1894, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(127,'Av Prudente De Morais, 6156, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(128,'Av Prudente De Morais, 6444, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(129,'Av Prudente De Morais, 7049, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(130,'Av Prudente De Morais, 7325, Rio Grande Do Norte, Lagoa Nova (Natal)',NULL,NULL),(131,'Av Prudente De Morais, 7651, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(132,'Av Prudente De Morais, 8059, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(133,'Av Prudente De Morais, 9068, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(134,'Av Prudente De Morais, 9762, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(135,'Av Prudente De Morais, 10378, Rio Grande Do Norte, CandelÃ¡ria (Natal)',NULL,NULL),(136,'Av Dos Xavantes, 1776, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(137,'Av Dos Xavantes, 1576, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(138,'Av Dos Xavantes, 1310, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(139,'Av Dos Xavantes, 990, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(140,'R Rio Gramare, 5308, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(141,'Av Dos Xavantes, 356, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(142,'Av Dos Xavantes, 194, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(143,'R Rio Tamanduatei, 14731, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(144,'R Serra Da Jurema, 5173, Rio Grande Do Norte, Pitimbu (Natal)',NULL,NULL),(145,'R Monte Rei, 28, Rio Grande Do Norte, Cidade Nova (Natal)',NULL,NULL),(146,'R Mira Mangue, 1605, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(147,'R Mira Mangue, 1234, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(148,'R Mira Mangue, 962, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(149,'R Mira Mangue, 704, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(150,'R Mira Mangue, 542, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(151,'R Mira Mangue, 406, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(152,'R Mira Mangue, 216, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(153,'R Eng. Joao Helio Alves Rocha, 1587, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(154,'R Eng. Joao Helio Alves Rocha, 1698, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(155,'R Eng. Joao Helio Alves Rocha, 1990, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(156,'R Eng. Joao Helio Alves Rocha, 2264, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(157,'R Agrestina, 69, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(158,'R Agrestina, 250, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(159,'R Agrestina, 137, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(160,'R Agrestina, 285, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(161,'R Agrestina, 15054, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(162,'R Agrestina, 15514, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(163,'R Agrestina, 16236, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(164,'R Agrestina, 16696, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL),(165,'R S. Gregorio, 501, Rio Grande Do Norte, Planalto (Natal)',NULL,NULL);
/*!40000 ALTER TABLE `ponto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ponto_pontoreferencia`
--

DROP TABLE IF EXISTS `ponto_pontoreferencia`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `ponto_pontoreferencia` (
  `Ponto_id` bigint(20) NOT NULL,
  `pontosReferencia_id` bigint(20) NOT NULL,
  UNIQUE KEY `pontosReferencia_id` (`pontosReferencia_id`),
  KEY `FKD4211E27E5EC1197` (`Ponto_id`),
  KEY `FKD4211E27BBCF8AF8` (`pontosReferencia_id`),
  CONSTRAINT `FKD4211E27BBCF8AF8` FOREIGN KEY (`pontosReferencia_id`) REFERENCES `pontoreferencia` (`id`),
  CONSTRAINT `FKD4211E27E5EC1197` FOREIGN KEY (`Ponto_id`) REFERENCES `ponto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `ponto_pontoreferencia`
--

LOCK TABLES `ponto_pontoreferencia` WRITE;
/*!40000 ALTER TABLE `ponto_pontoreferencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `ponto_pontoreferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pontoreferencia`
--

DROP TABLE IF EXISTS `pontoreferencia`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `pontoreferencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `ponto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK550F637CE5EC1197` (`ponto_id`),
  CONSTRAINT `FK550F637CE5EC1197` FOREIGN KEY (`ponto_id`) REFERENCES `ponto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `pontoreferencia`
--

LOCK TABLES `pontoreferencia` WRITE;
/*!40000 ALTER TABLE `pontoreferencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `pontoreferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/* alteracao para relacionamento ManyToMany*/
ALTER TABLE `itinerario_test`.`linha_pontosida` DROP INDEX `pontosIda_id`,
 ADD INDEX `pontosIda_id` USING BTREE(`pontosIda_id`);
 
ALTER TABLE `itinerario_test`.`linha_pontosvolta` DROP INDEX `pontosVolta_id`,
 ADD INDEX `pontosVolta_id` USING BTREE(`pontosVolta_id`);


-- Dump completed on 2013-05-28 16:42:13
