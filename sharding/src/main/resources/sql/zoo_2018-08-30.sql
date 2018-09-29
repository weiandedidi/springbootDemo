# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.22)
# Database: zoo
# Generation Time: 2018-08-30 07:21:42 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table department
# ------------------------------------------------------------

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;

INSERT INTO `department` (`id`, `departmentName`)
VALUES
	(1,'qidi'),
	(2,'hongli');

/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table department_201808
# ------------------------------------------------------------

DROP TABLE IF EXISTS `department_201808`;

CREATE TABLE `department_201808` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lastName` varchar(100) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `d_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table employee
# ------------------------------------------------------------

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lastName` varchar(100) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `d_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;

INSERT INTO `employee` (`id`, `lastName`, `gender`, `email`, `d_Id`)
VALUES
	(1,'qidi',1,'qdi@qq.com',1),
	(2,'hongli',2,'hongli@qq.com',2),
	(3,'qidi',1,'weiandedidi@163.com',5);

/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table employee_201808
# ------------------------------------------------------------

DROP TABLE IF EXISTS `employee_201808`;

CREATE TABLE `employee_201808` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lastName` varchar(100) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `d_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `employee_201808` WRITE;
/*!40000 ALTER TABLE `employee_201808` DISABLE KEYS */;

INSERT INTO `employee_201808` (`id`, `lastName`, `gender`, `email`, `d_Id`)
VALUES
	(4,'我是分表1',1,'weiandedidi@163.com',5),
	(5,'我是分表2',2,'weiandedidi@163.com',6);

/*!40000 ALTER TABLE `employee_201808` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table facility
# ------------------------------------------------------------

DROP TABLE IF EXISTS `facility`;

CREATE TABLE `facility` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `vendor_id` int(10) NOT NULL DEFAULT '0' COMMENT '供应商的id',
  `sn` int(10) DEFAULT '0' COMMENT '商品序列号S/N',
  `code` varchar(100) DEFAULT '' COMMENT '设备编码',
  `facility_id` int(11) DEFAULT '0' COMMENT '设备的厂商处的id',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '设备类型 1-摄像头 2-计算终端 3-货架 4-电脑 。。。',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '设备名称',
  `host` varchar(128) DEFAULT '' COMMENT '设备host地址',
  `port` int(10) DEFAULT '0' COMMENT '端口号',
  `description` varchar(255) DEFAULT '' COMMENT '描述',
  `created_time` int(10) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updated_time` int(10) DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `f_id` (`vendor_id`,`facility_id`) COMMENT '商品的厂商id唯一标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';



# Dump of table t_order_0
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_order_0`;

CREATE TABLE `t_order_0` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_order_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_order_1`;

CREATE TABLE `t_order_1` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_order_item_0
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_order_item_0`;

CREATE TABLE `t_order_item_0` (
  `order_item_id` bigint(20) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_order_item_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_order_item_1`;

CREATE TABLE `t_order_item_1` (
  `order_item_id` bigint(20) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(225) DEFAULT NULL COMMENT '密码',
  `d_group` varchar(225) NOT NULL DEFAULT '""' COMMENT '分组',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `name`, `pwd`, `d_group`)
VALUES
	(1,'qidi','123456','\"\"'),
	(2,'miaozhihao','123456','\"\"'),
	(3,'qidi3','888888','\"\"'),
	(4,'qidi4','54321','\"\"'),
	(5,'qidi5','54321','\"\"'),
	(6,'haha','xxx','\"\"'),
	(7,'haha','xxx','DGroup'),
	(8,'haha0','xxx0','DGroup0');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_201702
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_201702`;

CREATE TABLE `user_201702` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(225) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user_201808
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_201808`;

CREATE TABLE `user_201808` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(225) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
