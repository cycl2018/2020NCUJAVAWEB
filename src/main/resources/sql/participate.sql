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
-- 参会记录的表
-- ----------------------------
DROP TABLE IF EXISTS `participate`;
CREATE TABLE `participate` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  /*参会记录的表*/
  `conferenceId` int(4) NOT NULL,
  `attendeeId` int(4) NOT NULL,
  `hotelId` int(4) NOT NULL,
  `driverId` int(4),
  `roomId` int(4),
  `departtime` datetime NOT NULL,
  `returntime` datetime NOT NULL,
  /*会议的开始时间*/
  `datetime` datetime NOT NULL,
  `need` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



