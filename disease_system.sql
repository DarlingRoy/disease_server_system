/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : disease_system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-06-19 10:21:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for health
-- ----------------------------
DROP TABLE IF EXISTS `health`;
CREATE TABLE `health` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '健康表id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `my_physical_condition` varchar(255) NOT NULL COMMENT '本人身体状况',
  `family_physical_condition` varchar(255) NOT NULL COMMENT '家人身体状况',
  `hu_bei` tinyint(1) NOT NULL COMMENT '最近是否去过湖北（一个月内）',
  `people_abroad` tinyint(1) NOT NULL COMMENT '人是否在国外',
  `abroad` tinyint(1) NOT NULL COMMENT '最近是否出国（一个月内）',
  `foreign_relatives` tinyint(1) NOT NULL COMMENT '是否有外国亲戚',
  `contact_case` tinyint(1) NOT NULL COMMENT '是否接触过疑似/确诊病例（一个月内）',
  `contact_foreigner` tinyint(1) NOT NULL COMMENT '最近是否接触到外国人员',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `health_user_id` (`user_id`),
  CONSTRAINT `health_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='健康状况记录表';

-- ----------------------------
-- Records of health
-- ----------------------------
INSERT INTO `health` VALUES ('1', '1', '正常', '正常', '0', '0', '0', '0', '0', '0', '2020-06-19 08:31:06', '2020-06-19 08:31:34');
INSERT INTO `health` VALUES ('2', '2', '正常', '正常', '0', '0', '0', '0', '0', '0', '2020-06-19 08:31:06', '2020-06-19 08:31:34');
INSERT INTO `health` VALUES ('3', '3', '疑似病例', '居家隔离中', '0', '0', '1', '0', '0', '1', '2020-06-19 08:31:06', '2020-06-19 08:31:34');
INSERT INTO `health` VALUES ('4', '4', '疑似病例', '居家隔离中', '1', '0', '0', '0', '0', '0', '2020-06-19 10:19:29', '2020-06-19 10:19:29');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `operation` varchar(255) NOT NULL,
  `operation_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `log_user_id` (`user_id`),
  CONSTRAINT `log_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日志表';

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '1', '更新用户', '2020-06-18 10:07:47');
INSERT INTO `log` VALUES ('2', '2', '新增用户', '2020-06-18 10:08:00');
INSERT INTO `log` VALUES ('3', '3', '删除用户', '2020-06-18 10:08:09');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父权限的id',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限的描述',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'url接口',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '增加用户记录', null, '增加用户记录', '');
INSERT INTO `permission` VALUES ('2', '更新用户记录', null, '更新用户记录', '');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'student', '2020-06-18 09:57:00', '2020-06-18 09:57:04');
INSERT INTO `role` VALUES ('2', 'teacher', '2020-06-18 09:59:36', '2020-06-18 09:59:38');
INSERT INTO `role` VALUES ('3', 'administrator', '2020-06-18 10:01:14', '2020-06-18 10:01:14');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_role_id` (`role_id`),
  KEY `sys_permission_id` (`permission_id`),
  CONSTRAINT `sys_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限中间表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户注册邮箱',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建用户的时间',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号码',
  `qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'qq号',
  `update_time` datetime DEFAULT NULL COMMENT '用户修改时间',
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '微信号',
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学院',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '专业',
  `living_city` varchar(255) NOT NULL COMMENT '现居住地',
  `hometown` varchar(255) NOT NULL COMMENT '籍贯',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Mike', '13637241723@qq.com', '2020-06-18 09:48:02', '13637241723', '4274272', '2020-06-18 11:01:34', '4274272', '软件学院', '软件工程', '广州市', '广州市', '男', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm');
INSERT INTO `user` VALUES ('2', 'Alex', '13474741203@qq.com', '2020-06-18 09:50:49', '13474741203', null, '2020-06-18 09:51:09', null, '材料学院', '高分子材料科学与工程', '广东省清远市', '广东省清远市', '女', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm');
INSERT INTO `user` VALUES ('3', 'David', '13472474274@qq.com', '2020-06-18 09:53:32', '13472474274', null, '2020-06-18 09:53:42', null, '计算机学院', '计算机科学与技术', '北京市朝阳区', '北京市朝阳区', '男', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm');
INSERT INTO `user` VALUES ('4', 'John', '13647471747@qq.com', '2020-06-19 10:18:54', '13647471747', null, null, null, '计算机学院', '网络工程', '广东省佛山市', '广东省佛山市', '男', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_foreign_key` (`user_id`),
  KEY `role_foreign_key` (`role_id`),
  CONSTRAINT `role_foreign_key` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_foreign_key` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色中间表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('3', '3', '3');
