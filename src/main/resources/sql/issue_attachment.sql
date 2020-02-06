/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : sso

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-02-06 14:57:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for issue_attachment
-- ----------------------------
DROP TABLE IF EXISTS `issue_attachment`;
CREATE TABLE `issue_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attachment_type` int(1) DEFAULT NULL COMMENT '1.图片2.视频.3文档',
  `issue_record_id` bigint(20) DEFAULT NULL,
  `issue_id` bigint(20) DEFAULT NULL,
  `attachment_url` varchar(1000) DEFAULT NULL COMMENT '附件链接地址',
  `creator` bigint(20) NOT NULL,
  `created_by` varchar(64) NOT NULL,
  `created` datetime NOT NULL,
  `modified_by` varchar(64) NOT NULL,
  `modified` datetime NOT NULL,
  `is_disabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of issue_attachment
-- ----------------------------
INSERT INTO `issue_attachment` VALUES ('11', null, '3', '2', 'http://127.0.0.1:8080/storage/Octocat.png_NnpHHQ-6f673d1a-a48e-4a24-817e-95cfeb1ba67c', '1', 'cdeng', '2020-02-06 22:56:08', 'cdeng', '2020-02-06 22:56:08', '0');
INSERT INTO `issue_attachment` VALUES ('12', null, '3', '2', 'http://127.0.0.1:8080/storage/dc.PNG_OWBwzy-dd6bc47f-25db-463a-a290-94d31ea7e782', '1', 'cdeng', '2020-02-06 22:56:08', 'cdeng', '2020-02-06 22:56:08', '0');
