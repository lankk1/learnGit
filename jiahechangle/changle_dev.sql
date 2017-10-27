/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : changle_dev

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-08-31 17:41:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cl_comment
-- ----------------------------
DROP TABLE IF EXISTS `cl_comment`;
CREATE TABLE `cl_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` text,
  `comment_user` varchar(50) DEFAULT NULL,
  `comment_email` varchar(50) DEFAULT NULL,
  `comment_address` varchar(50) DEFAULT NULL,
  `comment_tel` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cl_comment
-- ----------------------------

-- ----------------------------
-- Table structure for cl_product
-- ----------------------------
DROP TABLE IF EXISTS `cl_product`;
CREATE TABLE `cl_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(60) DEFAULT NULL,
  `product_description` varchar(500) DEFAULT NULL,
  `product_img` varchar(120) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cl_product
-- ----------------------------
INSERT INTO `cl_product` VALUES ('1', '产品x', '嘉禾源甲壳、贝类系列 Crustacean\\n嘉禾源软体系列 Software\\n嘉禾源鱼类系列 Fish\\n', '/static/images/baoyu.jpg', '0', '2017-08-31 14:28:20', '2017-08-31 14:28:20');
