/*
 Navicat Premium Data Transfer

 Source Server         : shitiana本地
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : shiro_boot

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 16/09/2020 18:57:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for easy_user
-- ----------------------------
DROP TABLE IF EXISTS `easy_user`;
CREATE TABLE `easy_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL,
  `pass` varchar(16) DEFAULT NULL,
  `role` varchar(16) DEFAULT NULL,
  `permission` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easy_user
-- ----------------------------
BEGIN;
INSERT INTO `easy_user` VALUES (1, '张无忌', '1234', 'admin', 'all,half,no');
INSERT INTO `easy_user` VALUES (2, '杨逍', '1234', 'manager', 'half,no');
INSERT INTO `easy_user` VALUES (3, '小昭', '12345', 'emp', 'no');
INSERT INTO `easy_user` VALUES (4, '杨不悔', '1236', 'emp', 'half,no');
INSERT INTO `easy_user` VALUES (5, '说不得', '21', 'manager', 'half,no');
INSERT INTO `easy_user` VALUES (6, '殷天正', '21234', 'manager', 'all,half,no');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
