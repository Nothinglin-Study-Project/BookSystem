/*
Navicat MySQL Data Transfer

Source Server         : Nothinglin
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : booksystem

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2021-11-06 15:33:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books_info
-- ----------------------------
DROP TABLE IF EXISTS `books_info`;
CREATE TABLE `books_info` (
  `books_isbn` varchar(255) DEFAULT NULL,
  `books_name` varchar(255) DEFAULT NULL,
  `books_author` varchar(255) DEFAULT NULL,
  `books_intro` varchar(255) DEFAULT NULL,
  `books_position` varchar(255) DEFAULT NULL,
  `books_status` varchar(255) DEFAULT NULL,
  `books_type` varchar(255) DEFAULT NULL,
  `books_picture` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of books_info
-- ----------------------------
INSERT INTO `books_info` VALUES ('12345677', ' Mysql修炼之道', '李四', '强调面向对象程序设计的能力训练而不是拘泥于语法细节，特别是在\r\n实验环节，通过一个复杂案例的设计和实现，让学生明白多态、抽象\r\n类、接口这些语法机制是如何运用到一个真正的面对对象程序设计...', 'T303-S11003', '不在馆，已借出', '计算机类', './statics/images/mysql.png');
INSERT INTO `books_info` VALUES ('12345678', '老人与还', ' 海明威', '强调面向对象程序设计的能力训练而不是拘泥于语法细节，特别是在\r\n实验环节，通过一个复杂案例的设计和实现，让学生明白多态、抽象\r\n类、接口这些语法机制是如何运用到一个真正的面对对象程序设计...', 'T303-S11004', '不在馆，已借出', '文学类', './statics/images/老人与海.png');
INSERT INTO `books_info` VALUES ('12346777', ' Mysql修炼之道', '李四', '强调面向对象程序设计的能力训练而不是拘泥于语法细节，特别是在\r\n实验环节，通过一个复杂案例的设计和实现，让学生明白多态、抽象\r\n类、接口这些语法机制是如何运用到一个真正的面对对象程序设计...', 'T303-S11003', '在馆未借', '计算机类', './statics/images/mysql.png');
INSERT INTO `books_info` VALUES ('12456788', '老人与还', ' 海明威', '强调面向对象程序设计的能力训练而不是拘泥于语法细节，特别是在\r\n实验环节，通过一个复杂案例的设计和实现，让学生明白多态、抽象\r\n类、接口这些语法机制是如何运用到一个真正的面对对象程序设计...', 'T303-S11004', '不在馆，已借出', '文学类', './statics/images/老人与海.png');
INSERT INTO `books_info` VALUES ('12456789', 'Java语言程序设计', '张三', '强调面向对象程序设计的能力训练而不是拘泥于语法细节，特别是在\r\n实验环节，通过一个复杂案例的设计和实现，让学生明白多态、抽象\r\n类、接口这些语法机制是如何运用到一个真正的面对对象程序设计...', 'T303-S11005', '不在馆，已借出', '计算机类', './statics/images/java.png');
INSERT INTO `books_info` VALUES ('123456777', ' Mysql修炼之道', '李四', '强调面向对象程序设计的能力训练而不是拘泥于语法细节，特别是在\r\n实验环节，通过一个复杂案例的设计和实现，让学生明白多态、抽象\r\n类、接口这些语法机制是如何运用到一个真正的面对对象程序设计...', 'T303-S11003', '不在馆，已借出', '计算机类', './statics/images/mysql.png');
INSERT INTO `books_info` VALUES ('123456788', '老人与还', ' 海明威', '强调面向对象程序设计的能力训练而不是拘泥于语法细节，特别是在\r\n实验环节，通过一个复杂案例的设计和实现，让学生明白多态、抽象\r\n类、接口这些语法机制是如何运用到一个真正的面对对象程序设计...', 'T303-S11004', '在馆未借', '文学类', './statics/images/老人与海.png');
INSERT INTO `books_info` VALUES ('123456789', 'Java语言程序设计', '张三', '强调面向对象程序设计的能力训练而不是拘泥于语法细节，特别是在\r\n实验环节，通过一个复杂案例的设计和实现，让学生明白多态、抽象\r\n类、接口这些语法机制是如何运用到一个真正的面对对象程序设计...', 'T303-S11005', '在馆未借', '计算机类', './statics/images/java.png');

-- ----------------------------
-- Table structure for borrow_info
-- ----------------------------
DROP TABLE IF EXISTS `borrow_info`;
CREATE TABLE `borrow_info` (
  `readername` varchar(255) DEFAULT NULL,
  `bookname` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `bookstatus` varchar(255) DEFAULT NULL,
  `readerid` varchar(255) DEFAULT NULL,
  `backtime` varchar(255) DEFAULT NULL,
  `bookisbn` varchar(255) DEFAULT NULL,
  `readernumber` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of borrow_info
-- ----------------------------
INSERT INTO `borrow_info` VALUES ('王昭君', '老人与还', './statics/images/老人与海.png', '未归还', '123456', '2021年11月6日', '12345678', '123456');
INSERT INTO `borrow_info` VALUES ('张三', ' Mysql修炼之道', './statics/images/mysql.png', '未归还', '1453645687', '2021年11月14日', '12345677', '123456');
INSERT INTO `borrow_info` VALUES ('张三', '老人与还', './statics/images/老人与海.png', '未归还', '1453645687', '2021年11月6日', '12456788', '123456');
INSERT INTO `borrow_info` VALUES ('reader', 'Java语言程序设计', './statics/images/java.png', '未归还', '123456', '2021年11月14日', '12456789', '123456');

-- ----------------------------
-- Table structure for librarymanage_info
-- ----------------------------
DROP TABLE IF EXISTS `librarymanage_info`;
CREATE TABLE `librarymanage_info` (
  `librarymanage_id` varchar(255) DEFAULT NULL,
  `librarymanage_name` varchar(255) DEFAULT NULL,
  `librarymanage_password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of librarymanage_info
-- ----------------------------
INSERT INTO `librarymanage_info` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `bookname` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `backtime` varchar(255) DEFAULT NULL,
  `orderstatus` varchar(255) DEFAULT NULL,
  `readername` varchar(255) DEFAULT NULL,
  `readerid` varchar(255) DEFAULT NULL,
  `bookisbn` varchar(255) DEFAULT NULL,
  `readerstatus` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of order_info
-- ----------------------------

-- ----------------------------
-- Table structure for reader_info
-- ----------------------------
DROP TABLE IF EXISTS `reader_info`;
CREATE TABLE `reader_info` (
  `reader_id` varchar(255) DEFAULT NULL,
  `reader_name` varchar(255) DEFAULT NULL,
  `reader_password` varchar(255) DEFAULT NULL,
  `reader_number` varchar(11) DEFAULT NULL,
  `reader_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of reader_info
-- ----------------------------
INSERT INTO `reader_info` VALUES ('123456', 'reader', '123456', '123456', '可借书');
INSERT INTO `reader_info` VALUES ('111', '张三', '111', '1115', '黑名单');
INSERT INTO `reader_info` VALUES ('', '', '', '', '可借书');

-- ----------------------------
-- Table structure for systemmanage_info
-- ----------------------------
DROP TABLE IF EXISTS `systemmanage_info`;
CREATE TABLE `systemmanage_info` (
  `systemmanage_id` int(11) NOT NULL,
  `systemmanage_name` varchar(255) DEFAULT NULL,
  `systemmanage_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`systemmanage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemmanage_info
-- ----------------------------
INSERT INTO `systemmanage_info` VALUES ('1', 'admin', '123');
