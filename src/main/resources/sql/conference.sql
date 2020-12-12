/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : restful_crud

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-03-05 10:41:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 会议参加者的表
-- ----------------------------
DROP TABLE IF EXISTS `conference`;
CREATE TABLE `conference` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  /*会议参加者的表*/
  `name` varchar(20) NOT NULL,
  `datetime` datetime NOT NULL,
  `renshu` varchar(20) NOT NULL,
  `about` varchar(200) NOT NULL,
  `organizer_name` varchar(20) NOT NULL,
  `hotel_id` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



