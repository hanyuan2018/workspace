/*
 Navicat Premium Data Transfer

 Source Server         : common_test
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 47.99.201.84:3306
 Source Schema         : common_dev

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 20/01/2019 12:48:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for SYS_RIGHT_CONFIG
-- ----------------------------
DROP TABLE IF EXISTS `SYS_RIGHT_CONFIG`;
CREATE TABLE `SYS_RIGHT_CONFIG`  (
  `ROLE_ID` int(16) NOT NULL COMMENT '角色ID',
  `RIGHT_ID` int(16) NOT NULL COMMENT '权限ID',
  `RESOURCE_FLAG` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '资源区分(0:菜单；1:资源)'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
