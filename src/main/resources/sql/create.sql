/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 127.0.0.1:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 14/03/2023 09:57:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zhrj_alarm_info
-- ----------------------------
DROP TABLE IF EXISTS `zhrj_alarm_info`;
CREATE TABLE `zhrj_alarm_info`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `wan_ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '终端IP',
  `event_time` datetime NULL DEFAULT NULL COMMENT '采集时间',
  `event_type` int(11) NULL DEFAULT NULL COMMENT '事件类型(DICT: event_type)',
  `event_status` int(20) NULL DEFAULT NULL COMMENT '事件状态(DICT: event_status)',
  `event_reasons` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '事件归集原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事件表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for zhrj_dept
-- ----------------------------
DROP TABLE IF EXISTS `zhrj_dept`;
CREATE TABLE `zhrj_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `dept_no` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门编号',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 201 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zhrj_dept
-- ----------------------------
INSERT INTO `zhrj_dept` VALUES (100, 0, '0', '总公司', '1000', 0);
INSERT INTO `zhrj_dept` VALUES (101, 100, '0,100', '分公司', '1001', 1);
INSERT INTO `zhrj_dept` VALUES (102, 100, '0,100', '长沙分公司', '1002', 2);
INSERT INTO `zhrj_dept` VALUES (103, 101, '0,100,101', '研发部门', '1003', 1);
INSERT INTO `zhrj_dept` VALUES (104, 101, '0,100,101', '市场部门', '1004', 2);
INSERT INTO `zhrj_dept` VALUES (105, 101, '0,100,101', '测试部门', '1005', 3);
INSERT INTO `zhrj_dept` VALUES (106, 101, '0,100,101', '财务部门', '1006', 4);
INSERT INTO `zhrj_dept` VALUES (109, 102, '0,100,102', '财务部门', '1009', 1);
INSERT INTO `zhrj_dept` VALUES (110, 102, '0,100,102', '开发部', '1010', 2);

-- ----------------------------
-- Table structure for zhrj_menu
-- ----------------------------
DROP TABLE IF EXISTS `zhrj_menu`;
CREATE TABLE `zhrj_menu`  (
  `menu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `actual_value` int(11) NOT NULL COMMENT '实际值',
  `display_value` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示值',
  `menu_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单描述',
  PRIMARY KEY (`menu_name`, `actual_value`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zhrj_menu
-- ----------------------------
INSERT INTO `zhrj_menu` VALUES ('cause_location', 1, '终端故障', '初步原因分析');
INSERT INTO `zhrj_menu` VALUES ('cause_location', 2, '基站故障', '初步原因分析');
INSERT INTO `zhrj_menu` VALUES ('cause_location', 3, '信号干扰', '初步原因分析');
INSERT INTO `zhrj_menu` VALUES ('event_status', 1, '已确认', '事件状态');
INSERT INTO `zhrj_menu` VALUES ('event_status', 2, '未确认', '事件状态');
INSERT INTO `zhrj_menu` VALUES ('event_type', 1, '终端在线率突降', '事件类型');
INSERT INTO `zhrj_menu` VALUES ('event_type', 2, '终端大面积离线', '事件类型');
INSERT INTO `zhrj_menu` VALUES ('event_type', 3, '终端频繁投退', '事件类型');
INSERT INTO `zhrj_menu` VALUES ('event_type', 4, '遥控失败', '事件类型');
INSERT INTO `zhrj_menu` VALUES ('is_overhual', 0, '否', '基站是否检修');
INSERT INTO `zhrj_menu` VALUES ('is_overhual', 1, '是', '基站是否检修');
INSERT INTO `zhrj_menu` VALUES ('terminal_status', 0, '离线', '终端状态');
INSERT INTO `zhrj_menu` VALUES ('terminal_status', 1, '在线', '终端状态');

SET FOREIGN_KEY_CHECKS = 1;
