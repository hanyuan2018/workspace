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

 Date: 20/01/2019 12:47:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for SYS_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER_ROLE`;
CREATE TABLE `SYS_USER_ROLE`  (
  `USER_ID` int(16) NOT NULL COMMENT '用户ID',
  `ROLE_ID` int(16) NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
