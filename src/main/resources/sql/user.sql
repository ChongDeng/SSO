/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : sso

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-02-06 14:58:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `login_name` varchar(128) NOT NULL COMMENT '登录名',
  `password` varchar(1024) DEFAULT NULL COMMENT '密码',
  `salt` varchar(10) NOT NULL,
  `full_name` varchar(1024) DEFAULT NULL COMMENT '全名',
  `default_project_id` bigint(20) DEFAULT NULL COMMENT '默认项目ID',
  `time_zone` varchar(50) DEFAULT NULL COMMENT '时区',
  `language` varchar(50) DEFAULT NULL COMMENT '语言',
  `conx_chat_notification` tinyint(1) NOT NULL COMMENT 'ConXChat通知',
  `email_notification` tinyint(1) NOT NULL COMMENT 'Email通知',
  `conx_cloud_user_name` varchar(128) DEFAULT NULL COMMENT 'ConXCloud用户名',
  `status` int(1) NOT NULL COMMENT '0正常 1冻结 2注销',
  `created_by` varchar(64) NOT NULL,
  `created` datetime NOT NULL,
  `modified_by` varchar(64) NOT NULL,
  `modified` datetime NOT NULL,
  `is_cloud` tinyint(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `avistar` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '3', 'cdeng', null, 'asdfghjkld', null, null, null, null, '1', '1', null, '1', 'root', '2020-01-20 19:15:29', 'root', '2020-01-20 19:15:29', '1', '1@gmail.com', '1');
INSERT INTO `user` VALUES ('2', '4', 'ocean', null, 'asdfgsdfgh', null, null, null, null, '1', '1', null, '1', 'root', '2020-01-21 15:05:52', 'root', '2020-01-21 15:06:02', '1', '2@gmail.com', '2');
INSERT INTO `user` VALUES ('3', '2', 'noor', null, 'asdfghjkln', null, null, null, null, '1', '1', null, '1', 'root', '2020-01-21 15:06:39', 'root', '2020-01-21 15:06:45', '1', '3@gmail.com', '3');
INSERT INTO `user` VALUES ('4', '1', 'vinson', null, 'asdfghjklz', null, null, null, null, '1', '1', null, '0', 'root', '2020-01-21 23:07:21', 'root', '2020-01-21 23:07:21', '1', '4@gmail.com', '4');
INSERT INTO `user` VALUES ('5', '2', 'musk', '2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824', 'asdfghjklz', null, null, null, null, '1', '1', null, '0', 'root', '2020-01-23 22:17:40', 'root', '2020-01-23 22:17:40', '1', '5@gmail.com', '5');
INSERT INTO `user` VALUES ('6', '3', 'wen', '2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824', 'asdfghjkls', null, null, null, null, '1', '1', null, '0', 'root', '2020-01-23 22:33:16', 'root', '2020-01-23 22:33:16', '1', '6@gmail.com', '6');
INSERT INTO `user` VALUES ('7', '4', 'chongdeng', '2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824', 'asdfghjkln', null, null, null, null, '1', '1', null, '0', 'root', '2020-01-23 22:45:38', 'root', '2020-01-23 22:45:38', '1', '7@gmail.com', '7');
INSERT INTO `user` VALUES ('8', '2', 'huangweida', 'YTdjZTZmNDljYTIyNGQ4NzE3N2E4MmNmMWYxNjBkYWMyZTdlNDdkYnN1d2F0c3BiYmI=', 'suwatspbbb', null, null, null, null, '1', '1', null, '0', 'root', '2020-01-24 00:54:04', 'root', '2020-01-24 00:54:04', '1', '8@gmail.com', '8');
INSERT INTO `user` VALUES ('10', '-1', 'honda', 'NTU4OGYzODAxNWYyOWI0YjNhMDVhNDEyODYxMjMxMjc0M2YyYTZhMmxublpRSENNWkU=', 'lnnZQHCMZE', null, null, null, null, '1', '1', null, '1', 'root', '2020-02-05 15:00:03', 'root', '2020-02-05 15:00:03', '0', 'fqyyang@gmail.com', null);
