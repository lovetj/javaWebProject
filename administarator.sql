/*
Navicat MySQL Data Transfer

Source Server         : localhost_3308
Source Server Version : 50016
Source Host           : localhost:3308
Source Database       : person

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2019-07-06 17:48:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administarator
-- ----------------------------
DROP TABLE IF EXISTS `administarator`;
CREATE TABLE `administarator` (
  `user` varchar(255) collate utf8_unicode_ci default NULL,
  `password` varchar(255) collate utf8_unicode_ci default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of administarator
-- ----------------------------
INSERT INTO `administarator` VALUES ('root', '123');
