/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - securedynamic
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `securedynamic`;

USE `securedynamic`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `admin_code` int(5) NOT NULL auto_increment,
  `admin_id` char(30) NOT NULL,
  `admin_password` char(15) NOT NULL,
  `admin_name` char(50) NOT NULL,
  `public_key` varchar(20) default NULL,
  `private_key` varchar(20) default NULL,
  PRIMARY KEY  (`admin_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`admin_code`,`admin_id`,`admin_password`,`admin_name`,`public_key`,`private_key`) values (1,'admin','admin','admin','79771~233','79771~11897');

/*Table structure for table `m_cloud` */

DROP TABLE IF EXISTS `m_cloud`;

CREATE TABLE `m_cloud` (
  `c_code` int(20) NOT NULL auto_increment,
  `c_url` varchar(50) default NULL,
  `c_uname` varchar(50) default NULL,
  `c_pwd` varchar(50) default NULL,
  PRIMARY KEY  (`c_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_cloud` */

insert into `m_cloud` (`c_code`,`c_url`,`c_uname`,`c_pwd`) values (1,'ftp.drivehq.com','blrstore1','*blrstore123');

/*Table structure for table `m_file` */

DROP TABLE IF EXISTS `m_file`;

CREATE TABLE `m_file` (
  `f_no` int(10) NOT NULL auto_increment,
  `f_name` varchar(20) default NULL,
  `key_word` varchar(40000) default NULL,
  `total` int(20) default NULL,
  PRIMARY KEY  (`f_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_file` */

insert into `m_file` (`f_no`,`f_name`,`key_word`,`total`) values (1,'testtt.txt','bangalore-city-',2);
insert into `m_file` (`f_no`,`f_name`,`key_word`,`total`) values (2,'ff.txt','bangalore-citybangalore-',3);
insert into `m_file` (`f_no`,`f_name`,`key_word`,`total`) values (3,'trr.txt','bangalore-shanu-hassan-',5);

/*Table structure for table `m_file_weightage` */

DROP TABLE IF EXISTS `m_file_weightage`;

CREATE TABLE `m_file_weightage` (
  `result_no` int(10) NOT NULL auto_increment,
  `f_name` varchar(30) default NULL,
  `sk1_frequence_term` varchar(20) default NULL,
  `sk2_frequency_term` varchar(20) default NULL,
  `sk1_idft` varchar(20) default NULL,
  `sk2_idft` varchar(20) default NULL,
  `sk1_weight` varchar(20) default NULL,
  `sk2_weight` varchar(20) default NULL,
  PRIMARY KEY  (`result_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_file_weightage` */

/*Table structure for table `m_grade` */

DROP TABLE IF EXISTS `m_grade`;

CREATE TABLE `m_grade` (
  `s_no` int(11) NOT NULL auto_increment,
  `grade_level` varchar(30) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_grade` */

insert into `m_grade` (`s_no`,`grade_level`) values (1,'Grade1');
insert into `m_grade` (`s_no`,`grade_level`) values (2,'Grade2');
insert into `m_grade` (`s_no`,`grade_level`) values (3,'Grade3');

/*Table structure for table `m_hashtable` */

DROP TABLE IF EXISTS `m_hashtable`;

CREATE TABLE `m_hashtable` (
  `s_no` int(11) NOT NULL auto_increment,
  `key_word` varchar(50) default NULL,
  `fileno` varchar(4) default NULL,
  `key_no` varchar(3) default NULL,
  `rank_val` varchar(10) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_hashtable` */

insert into `m_hashtable` (`s_no`,`key_word`,`fileno`,`key_no`,`rank_val`) values (1,'886e4c5958c0a9775899ff732bcf3fef','1','1','50');
insert into `m_hashtable` (`s_no`,`key_word`,`fileno`,`key_no`,`rank_val`) values (2,'569de6d840c296ee34972b855a5f863a','1','2','50');
insert into `m_hashtable` (`s_no`,`key_word`,`fileno`,`key_no`,`rank_val`) values (3,'886e4c5958c0a9775899ff732bcf3fef','2','3','66.67');
insert into `m_hashtable` (`s_no`,`key_word`,`fileno`,`key_no`,`rank_val`) values (4,'d2119f360479e9e675de49eec9d1b42e','2','4','33.33');
insert into `m_hashtable` (`s_no`,`key_word`,`fileno`,`key_no`,`rank_val`) values (5,'886e4c5958c0a9775899ff732bcf3fef','3','5','40');
insert into `m_hashtable` (`s_no`,`key_word`,`fileno`,`key_no`,`rank_val`) values (6,'4556c8f329f00a8ac46a42975fbc78c4','3','6','20');
insert into `m_hashtable` (`s_no`,`key_word`,`fileno`,`key_no`,`rank_val`) values (7,'3ec1ef0727a0f6f17531425ceabc620c','3','7','40');

/*Table structure for table `m_request_secfile` */

DROP TABLE IF EXISTS `m_request_secfile`;

CREATE TABLE `m_request_secfile` (
  `req_no` int(50) NOT NULL auto_increment,
  `userid` varchar(100) default NULL,
  `status` varchar(50) default NULL,
  PRIMARY KEY  (`req_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_request_secfile` */

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_no` int(10) NOT NULL auto_increment,
  `u_id` varchar(150) default NULL,
  `u_pass` varchar(200) default NULL,
  `u_name` varchar(50) default NULL,
  `u_email` varchar(30) default NULL,
  `u_phone` varchar(10) default NULL,
  `grade` varchar(30) default NULL,
  PRIMARY KEY  (`u_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_no`,`u_id`,`u_pass`,`u_name`,`u_email`,`u_phone`,`grade`) values (1,'vivek','vivek','vevik','shanusharugowda@gmail.com','9876898788','1');

/*Table structure for table `multi_index__level3` */

DROP TABLE IF EXISTS `multi_index__level3`;

CREATE TABLE `multi_index__level3` (
  `m_l3_code` int(11) NOT NULL auto_increment,
  `m_l2_code` int(11) default NULL,
  `m_l3_bytes` varchar(30) default NULL,
  `f_no` varchar(10) default NULL,
  PRIMARY KEY  (`m_l3_code`),
  KEY `m_l2_code` (`m_l2_code`),
  CONSTRAINT `multi_index__level3_ibfk_1` FOREIGN KEY (`m_l2_code`) REFERENCES `multi_index_level2` (`m_l2_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `multi_index__level3` */

/*Table structure for table `multi_index_level1` */

DROP TABLE IF EXISTS `multi_index_level1`;

CREATE TABLE `multi_index_level1` (
  `m_l1_code` int(11) NOT NULL default '0',
  `m_l1_byte` varchar(4) default 'NULL',
  PRIMARY KEY  (`m_l1_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `multi_index_level1` */

insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (0,'00');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (1,'01');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (2,'02');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (3,'03');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (4,'04');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (5,'05');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (6,'06');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (7,'07');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (8,'08');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (9,'09');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (10,'0a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (11,'0b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (12,'0c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (13,'0d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (14,'0e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (15,'0f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (16,'10');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (17,'11');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (18,'12');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (19,'13');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (20,'14');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (21,'15');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (22,'16');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (23,'17');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (24,'18');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (25,'19');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (26,'1a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (27,'1b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (28,'1c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (29,'1d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (30,'1e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (31,'1f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (32,'20');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (33,'21');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (34,'22');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (35,'23');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (36,'24');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (37,'25');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (38,'26');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (39,'27');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (40,'28');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (41,'29');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (42,'2a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (43,'2b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (44,'2c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (45,'2d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (46,'2e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (47,'2f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (48,'30');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (49,'31');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (50,'32');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (51,'33');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (52,'34');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (53,'35');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (54,'36');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (55,'37');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (56,'38');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (57,'39');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (58,'3a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (59,'3b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (60,'3c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (61,'3d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (62,'3e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (63,'3f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (64,'40');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (65,'41');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (66,'42');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (67,'43');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (68,'44');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (69,'45');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (70,'46');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (71,'47');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (72,'48');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (73,'49');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (74,'4a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (75,'4b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (76,'4c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (77,'4d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (78,'4e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (79,'4f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (80,'50');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (81,'51');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (82,'52');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (83,'53');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (84,'54');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (85,'55');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (86,'56');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (87,'57');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (88,'58');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (89,'59');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (90,'5a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (91,'5b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (92,'5c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (93,'5d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (94,'5e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (95,'5f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (96,'60');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (97,'61');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (98,'62');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (99,'63');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (100,'64');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (101,'65');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (102,'66');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (103,'67');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (104,'68');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (105,'69');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (106,'6a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (107,'6b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (108,'6c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (109,'6d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (110,'6e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (111,'6f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (112,'70');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (113,'71');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (114,'72');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (115,'73');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (116,'74');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (117,'75');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (118,'76');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (119,'77');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (120,'78');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (121,'79');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (122,'7a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (123,'7b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (124,'7c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (125,'7d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (126,'7e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (127,'7f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (128,'80');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (129,'81');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (130,'82');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (131,'83');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (132,'84');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (133,'85');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (134,'86');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (135,'87');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (136,'88');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (137,'89');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (138,'8a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (139,'8b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (140,'8c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (141,'8d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (142,'8e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (143,'8f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (144,'90');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (145,'91');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (146,'92');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (147,'93');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (148,'94');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (149,'95');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (150,'96');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (151,'97');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (152,'98');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (153,'99');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (154,'9a');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (155,'9b');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (156,'9c');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (157,'9d');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (158,'9e');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (159,'9f');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (160,'a0');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (161,'a1');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (162,'a2');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (163,'a3');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (164,'a4');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (165,'a5');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (166,'a6');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (167,'a7');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (168,'a8');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (169,'a9');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (170,'aa');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (171,'ab');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (172,'ac');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (173,'ad');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (174,'ae');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (175,'af');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (176,'b0');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (177,'b1');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (178,'b2');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (179,'b3');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (180,'b4');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (181,'b5');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (182,'b6');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (183,'b7');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (184,'b8');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (185,'b9');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (186,'ba');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (187,'bb');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (188,'bc');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (189,'bd');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (190,'be');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (191,'bf');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (192,'c0');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (193,'c1');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (194,'c2');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (195,'c3');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (196,'c4');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (197,'c5');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (198,'c6');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (199,'c7');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (200,'c8');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (201,'c9');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (202,'ca');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (203,'cb');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (204,'cc');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (205,'cd');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (206,'ce');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (207,'cf');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (208,'d0');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (209,'d1');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (210,'d2');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (211,'d3');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (212,'d4');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (213,'d5');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (214,'d6');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (215,'d7');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (216,'d8');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (217,'d9');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (218,'da');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (219,'db');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (220,'dc');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (221,'dd');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (222,'de');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (223,'df');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (224,'e0');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (225,'e1');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (226,'e2');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (227,'e3');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (228,'e4');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (229,'e5');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (230,'e6');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (231,'e7');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (232,'e8');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (233,'e9');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (234,'ea');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (235,'eb');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (236,'ec');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (237,'ed');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (238,'ee');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (239,'ef');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (240,'f0');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (241,'f1');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (242,'f2');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (243,'f3');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (244,'f4');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (245,'f5');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (246,'f6');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (247,'f7');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (248,'f8');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (249,'f9');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (250,'fa');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (251,'fb');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (252,'fc');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (253,'fd');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (254,'fe');
insert into `multi_index_level1` (`m_l1_code`,`m_l1_byte`) values (255,'ff');

/*Table structure for table `multi_index_level2` */

DROP TABLE IF EXISTS `multi_index_level2`;

CREATE TABLE `multi_index_level2` (
  `m_l2_code` int(11) NOT NULL auto_increment,
  `m_l1_code` int(11) default NULL,
  `m_l2_byte` varchar(4) default NULL,
  `f_no` varchar(11) default NULL,
  PRIMARY KEY  (`m_l2_code`),
  KEY `m_l1_code` (`m_l1_code`),
  CONSTRAINT `multi_index_level2_ibfk_1` FOREIGN KEY (`m_l1_code`) REFERENCES `multi_index_level1` (`m_l1_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `multi_index_level2` */

/*Table structure for table `t_count` */

DROP TABLE IF EXISTS `t_count`;

CREATE TABLE `t_count` (
  `t_no` int(20) NOT NULL auto_increment,
  `f_no` int(10) default NULL,
  `key_word` varchar(50) default NULL,
  `weightage` int(10) default NULL,
  `key_rank` varchar(50) default NULL,
  PRIMARY KEY  (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_count` */

insert into `t_count` (`t_no`,`f_no`,`key_word`,`weightage`,`key_rank`) values (1,1,'bangalore',1,'50');
insert into `t_count` (`t_no`,`f_no`,`key_word`,`weightage`,`key_rank`) values (2,1,'city',1,'50');
insert into `t_count` (`t_no`,`f_no`,`key_word`,`weightage`,`key_rank`) values (3,2,'bangalore',2,'66.67');
insert into `t_count` (`t_no`,`f_no`,`key_word`,`weightage`,`key_rank`) values (4,2,'citybangalore',1,'33.33');
insert into `t_count` (`t_no`,`f_no`,`key_word`,`weightage`,`key_rank`) values (5,3,'bangalore',2,'40');
insert into `t_count` (`t_no`,`f_no`,`key_word`,`weightage`,`key_rank`) values (6,3,'shanu',1,'20');
insert into `t_count` (`t_no`,`f_no`,`key_word`,`weightage`,`key_rank`) values (7,3,'hassan',2,'40');

/*Table structure for table `t_word` */

DROP TABLE IF EXISTS `t_word`;

CREATE TABLE `t_word` (
  `f_code` int(10) NOT NULL auto_increment,
  `f_word` varchar(30) default NULL,
  PRIMARY KEY  (`f_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_word` */

insert into `t_word` (`f_code`,`f_word`) values (1,'is');
insert into `t_word` (`f_code`,`f_word`) values (2,'was');
insert into `t_word` (`f_code`,`f_word`) values (3,'that');
insert into `t_word` (`f_code`,`f_word`) values (4,'this');
insert into `t_word` (`f_code`,`f_word`) values (5,'where');
insert into `t_word` (`f_code`,`f_word`) values (6,'the');
insert into `t_word` (`f_code`,`f_word`) values (7,'am');
insert into `t_word` (`f_code`,`f_word`) values (8,'he');
insert into `t_word` (`f_code`,`f_word`) values (9,'she');
insert into `t_word` (`f_code`,`f_word`) values (10,'it');
insert into `t_word` (`f_code`,`f_word`) values (11,'they');
insert into `t_word` (`f_code`,`f_word`) values (12,'hello');
insert into `t_word` (`f_code`,`f_word`) values (13,'are');
insert into `t_word` (`f_code`,`f_word`) values (14,'how');
insert into `t_word` (`f_code`,`f_word`) values (15,'you');
insert into `t_word` (`f_code`,`f_word`) values (17,'where');
insert into `t_word` (`f_code`,`f_word`) values (18,'short');
insert into `t_word` (`f_code`,`f_word`) values (19,'tall');
insert into `t_word` (`f_code`,`f_word`) values (20,'big');
insert into `t_word` (`f_code`,`f_word`) values (21,'with');
insert into `t_word` (`f_code`,`f_word`) values (22,'all');
insert into `t_word` (`f_code`,`f_word`) values (23,'etc');
insert into `t_word` (`f_code`,`f_word`) values (24,'see');
insert into `t_word` (`f_code`,`f_word`) values (25,'saw');
insert into `t_word` (`f_code`,`f_word`) values (26,'my');
insert into `t_word` (`f_code`,`f_word`) values (27,'am');
insert into `t_word` (`f_code`,`f_word`) values (28,'i');
insert into `t_word` (`f_code`,`f_word`) values (29,'do');
insert into `t_word` (`f_code`,`f_word`) values (30,'was');
insert into `t_word` (`f_code`,`f_word`) values (31,'is');
insert into `t_word` (`f_code`,`f_word`) values (32,'not');
insert into `t_word` (`f_code`,`f_word`) values (33,'nor');
insert into `t_word` (`f_code`,`f_word`) values (34,'either');
insert into `t_word` (`f_code`,`f_word`) values (35,'neither');
insert into `t_word` (`f_code`,`f_word`) values (36,'that');
insert into `t_word` (`f_code`,`f_word`) values (37,'over');
insert into `t_word` (`f_code`,`f_word`) values (38,'out');
insert into `t_word` (`f_code`,`f_word`) values (39,'keep');
insert into `t_word` (`f_code`,`f_word`) values (40,'and');
insert into `t_word` (`f_code`,`f_word`) values (41,'from');
insert into `t_word` (`f_code`,`f_word`) values (42,'form');
insert into `t_word` (`f_code`,`f_word`) values (43,'full');
insert into `t_word` (`f_code`,`f_word`) values (44,'the');
insert into `t_word` (`f_code`,`f_word`) values (45,'off');
insert into `t_word` (`f_code`,`f_word`) values (46,'an');
insert into `t_word` (`f_code`,`f_word`) values (47,'or');
insert into `t_word` (`f_code`,`f_word`) values (48,'had');
insert into `t_word` (`f_code`,`f_word`) values (49,'as');
insert into `t_word` (`f_code`,`f_word`) values (50,'to');
insert into `t_word` (`f_code`,`f_word`) values (51,'him');
insert into `t_word` (`f_code`,`f_word`) values (52,'self');
insert into `t_word` (`f_code`,`f_word`) values (53,'data');
insert into `t_word` (`f_code`,`f_word`) values (54,'bad');
insert into `t_word` (`f_code`,`f_word`) values (55,'free');
insert into `t_word` (`f_code`,`f_word`) values (56,'could');
insert into `t_word` (`f_code`,`f_word`) values (57,'can');
insert into `t_word` (`f_code`,`f_word`) values (58,'shall');
insert into `t_word` (`f_code`,`f_word`) values (59,'should');
insert into `t_word` (`f_code`,`f_word`) values (60,'kept');
insert into `t_word` (`f_code`,`f_word`) values (61,'also');
insert into `t_word` (`f_code`,`f_word`) values (62,'on');
insert into `t_word` (`f_code`,`f_word`) values (63,'down');
insert into `t_word` (`f_code`,`f_word`) values (64,'have');
insert into `t_word` (`f_code`,`f_word`) values (65,'has');
insert into `t_word` (`f_code`,`f_word`) values (66,'one');
insert into `t_word` (`f_code`,`f_word`) values (67,'only');
insert into `t_word` (`f_code`,`f_word`) values (68,'in');
insert into `t_word` (`f_code`,`f_word`) values (69,'therefore');
insert into `t_word` (`f_code`,`f_word`) values (70,'then');
insert into `t_word` (`f_code`,`f_word`) values (71,'take');
insert into `t_word` (`f_code`,`f_word`) values (72,'took');
insert into `t_word` (`f_code`,`f_word`) values (73,'need');
insert into `t_word` (`f_code`,`f_word`) values (74,'we');
insert into `t_word` (`f_code`,`f_word`) values (75,'you');
insert into `t_word` (`f_code`,`f_word`) values (76,'yours');
insert into `t_word` (`f_code`,`f_word`) values (77,'one');
insert into `t_word` (`f_code`,`f_word`) values (78,'your');
insert into `t_word` (`f_code`,`f_word`) values (79,'a');
insert into `t_word` (`f_code`,`f_word`) values (80,'be');
insert into `t_word` (`f_code`,`f_word`) values (81,'being');
insert into `t_word` (`f_code`,`f_word`) values (82,'because');
insert into `t_word` (`f_code`,`f_word`) values (83,'cannot');
insert into `t_word` (`f_code`,`f_word`) values (84,'would');
insert into `t_word` (`f_code`,`f_word`) values (85,'not');
insert into `t_word` (`f_code`,`f_word`) values (86,'for');
insert into `t_word` (`f_code`,`f_word`) values (87,'off');
insert into `t_word` (`f_code`,`f_word`) values (88,'of');
insert into `t_word` (`f_code`,`f_word`) values (89,'soon');
insert into `t_word` (`f_code`,`f_word`) values (90,'nothing');
insert into `t_word` (`f_code`,`f_word`) values (91,'top');
insert into `t_word` (`f_code`,`f_word`) values (92,'bottom');
insert into `t_word` (`f_code`,`f_word`) values (93,'down');
insert into `t_word` (`f_code`,`f_word`) values (94,'up');
insert into `t_word` (`f_code`,`f_word`) values (95,'list');
insert into `t_word` (`f_code`,`f_word`) values (96,'start');
insert into `t_word` (`f_code`,`f_word`) values (97,'stop');
insert into `t_word` (`f_code`,`f_word`) values (98,'how');
insert into `t_word` (`f_code`,`f_word`) values (99,'see');
insert into `t_word` (`f_code`,`f_word`) values (100,'sea');
insert into `t_word` (`f_code`,`f_word`) values (101,'these');
insert into `t_word` (`f_code`,`f_word`) values (102,'this');
insert into `t_word` (`f_code`,`f_word`) values (103,'if');
insert into `t_word` (`f_code`,`f_word`) values (104,'else');
insert into `t_word` (`f_code`,`f_word`) values (105,'much');
insert into `t_word` (`f_code`,`f_word`) values (106,'more');
insert into `t_word` (`f_code`,`f_word`) values (107,'most');
insert into `t_word` (`f_code`,`f_word`) values (108,'give');
insert into `t_word` (`f_code`,`f_word`) values (109,'gave');
insert into `t_word` (`f_code`,`f_word`) values (110,'given');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
