/*
Navicat MySQL Data Transfer

Source Server         : Local MySQL
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-03-19 16:17:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_quartz
-- ----------------------------
DROP TABLE IF EXISTS `t_quartz`;
CREATE TABLE `t_quartz` (
  `job_id` varchar(100) NOT NULL,
  `job_group` varchar(256) DEFAULT NULL COMMENT '任务组',
  `trigger_group` varchar(256) DEFAULT NULL COMMENT '触发器组',
  `job_name` varchar(128) DEFAULT NULL COMMENT '任务名',
  `trigger_name` varchar(128) DEFAULT NULL COMMENT '触发器名',
  `class_name` varchar(128) DEFAULT NULL COMMENT '执行代码的类名',
  `enable_status` varchar(2) DEFAULT '1' COMMENT '是否禁用:0禁用;1启用',
  `trigger_cron` varchar(128) DEFAULT NULL COMMENT '触发器类型(时间) */5 * * * * ?',
  `trigger_status` varchar(2) DEFAULT NULL COMMENT '任务状态:0关闭;1运行中;2暂停;',
  `crate_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `desc_ript` varchar(1024) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_quartz
-- ----------------------------
INSERT INTO `t_quartz` VALUES ('1', 'jgname', 'tgname', 'jobname', 'tname', 'com.zxk175.ssm.task.QuartzTask', '1', '0/3 * * * * ?', '1', '2017-04-04 22:24:15', '2017-03-02 22:24:23', '');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
  `user_pwd` varchar(32) DEFAULT NULL COMMENT '加盐后用户密码',
  `user_sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '是否删除，0-未删除；1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';