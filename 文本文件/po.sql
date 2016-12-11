/*
Navicat MySQL Data Transfer

Source Server         : HRS
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : po

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-11 11:54:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `cycle` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `discout` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('北京', '三里屯/东单', '0.6');
INSERT INTO `address` VALUES ('北京', '东直门', '0.9');
INSERT INTO `address` VALUES ('北京', '国贸', '0.8');
INSERT INTO `address` VALUES ('北京', '小汤山', '0.9');
INSERT INTO `address` VALUES ('北京', '对外经贸', '0.9');
INSERT INTO `address` VALUES ('北京', '首都机场', '0.8');
INSERT INTO `address` VALUES ('北京', '五道口', '0.9');
INSERT INTO `address` VALUES ('北京', '双井', '0.9');
INSERT INTO `address` VALUES ('上海', '陆家嘴', '0.9');
INSERT INTO `address` VALUES ('上海', '外滩', '0.95');
INSERT INTO `address` VALUES ('上海', '南京东路', '0.9');
INSERT INTO `address` VALUES ('上海', '人民广场', '0.85');
INSERT INTO `address` VALUES ('上海', '同乐坊', '0.9');
INSERT INTO `address` VALUES ('上海', '静安寺', '0.98');
INSERT INTO `address` VALUES ('上海', '淮海路', '0.85');
INSERT INTO `address` VALUES ('上海', '虹桥', '0.7');
INSERT INTO `address` VALUES ('上海', '五角场', '0.9');
INSERT INTO `address` VALUES ('南京', '新街口地区', '0.9');
INSERT INTO `address` VALUES ('南京', '夫子庙地区', '0.85');
INSERT INTO `address` VALUES ('南京', '珠江路沿线', '0.8');
INSERT INTO `address` VALUES ('南京', '湖南路沿线', '0.8');
INSERT INTO `address` VALUES ('南京', '火车站/玄武湖', '0.85');
INSERT INTO `address` VALUES ('南京', '汤山镇', '0.88');
INSERT INTO `address` VALUES ('广州', '高德置地/花城汇', '0.9');
INSERT INTO `address` VALUES ('广州', '天河城/体育中心', '0.96');
INSERT INTO `address` VALUES ('广州', '天河北', '0.95');
INSERT INTO `address` VALUES ('广州', '石牌/龙口', '0.8');
INSERT INTO `address` VALUES ('广州', '天河公园', '0.96');
INSERT INTO `address` VALUES ('广州', '沿江路', '0.7');
INSERT INTO `address` VALUES ('深圳', '宝安南路沿线', '0.9');
INSERT INTO `address` VALUES ('深圳', '市中心区', '0.96');
INSERT INTO `address` VALUES ('深圳', '华侨城', '0.88');
INSERT INTO `address` VALUES ('深圳', '东门商业区', '0.86');
INSERT INTO `address` VALUES ('深圳', '华强北', '0.96');
INSERT INTO `address` VALUES ('深圳', '大小梅沙', '0.88');
INSERT INTO `address` VALUES ('成都', '春熙路', '0.98');
INSERT INTO `address` VALUES ('成都', '高新区', '0.8');
INSERT INTO `address` VALUES ('成都', '人民公园', '0.88');
INSERT INTO `address` VALUES ('成都', '盐市口', '0.78');
INSERT INTO `address` VALUES ('成都', '武侯祠', '0.88');
INSERT INTO `address` VALUES ('成都', '宽窄巷子', '0.78');
INSERT INTO `address` VALUES ('成都', '骡马市', '0.88');
INSERT INTO `address` VALUES ('成都', '双楠', '0.78');
INSERT INTO `address` VALUES ('成都', '科华北路', '0.83');
INSERT INTO `address` VALUES ('重庆', '解放碑', '0.98');
INSERT INTO `address` VALUES ('重庆', '观音桥', '0.98');
INSERT INTO `address` VALUES ('重庆', '大坪', '0.9');
INSERT INTO `address` VALUES ('重庆', '南坪', '0.85');
INSERT INTO `address` VALUES ('重庆', '朝天门', '0.75');
INSERT INTO `address` VALUES ('重庆', '南滨路', '0.88');
INSERT INTO `address` VALUES ('重庆', '两路口', '0.8');
INSERT INTO `address` VALUES ('重庆', '龙头寺', '0.88');
INSERT INTO `address` VALUES ('重庆', '三峡广场', '0.8');
INSERT INTO `address` VALUES ('重庆', '大学城', '0.88');
INSERT INTO `address` VALUES ('重庆', '五里店', '0.83');
INSERT INTO `address` VALUES ('重庆', '两路', '0.76');
INSERT INTO `address` VALUES ('重庆', '杨家坪', '0.86');
INSERT INTO `address` VALUES ('重庆', '巴国城', '0.8');
INSERT INTO `address` VALUES ('杭州', '龙井/虎跑', '0.95');
INSERT INTO `address` VALUES ('杭州', '西湖北线/黄龙', '0.98');
INSERT INTO `address` VALUES ('杭州', '湖滨', '0.9');
INSERT INTO `address` VALUES ('杭州', '下沙', '0.8');
INSERT INTO `address` VALUES ('杭州', '武林广场', '0.92');
INSERT INTO `address` VALUES ('杭州', '城东', '0.85');
INSERT INTO `address` VALUES ('杭州', '朝晖地区', '0.88');
INSERT INTO `address` VALUES ('苏州', '观前街地区', '0.95');
INSERT INTO `address` VALUES ('苏州', '博览中心', '0.88');
INSERT INTO `address` VALUES ('苏州', '太湖西路', '0.9');
INSERT INTO `address` VALUES ('苏州', '李公堤', '0.88');
INSERT INTO `address` VALUES ('苏州', '东岸商业街', '0.9');
INSERT INTO `address` VALUES ('苏州', '读书湖大学城', '0.88');
INSERT INTO `address` VALUES ('苏州', '十全街/凤凰街', '0.85');
INSERT INTO `address` VALUES ('天津', '围堤道沿线', '0.9');
INSERT INTO `address` VALUES ('天津', '小白楼', '0.8');
INSERT INTO `address` VALUES ('天津', '滨江道', '0.92');
INSERT INTO `address` VALUES ('天津', '老城厢', '0.88');
INSERT INTO `address` VALUES ('天津', '中山路', '0.8');
INSERT INTO `address` VALUES ('天津', '和平路', '0.83');
INSERT INTO `address` VALUES ('天津', '宾水道/体院北', '0.88');
INSERT INTO `address` VALUES ('厦门', '中山路/轮渡', '0.9');
INSERT INTO `address` VALUES ('厦门', '厦门大学', '0.88');
INSERT INTO `address` VALUES ('厦门', '环岛路沿线', '0.86');
INSERT INTO `address` VALUES ('厦门', '白鹭洲公园', '0.85');
INSERT INTO `address` VALUES ('武汉', '光谷/鲁巷', '0.88');
INSERT INTO `address` VALUES ('武汉', '水果湖', '0.8');
INSERT INTO `address` VALUES ('武汉', '汉江路步行街', '0.86');
INSERT INTO `address` VALUES ('武汉', '客运港/江滩', '0.85');
INSERT INTO `address` VALUES ('武汉', '中南路', '0.83');
INSERT INTO `address` VALUES ('武汉', '汉口火车站', '0.78');
INSERT INTO `address` VALUES ('西安', '钟楼/鼓楼', '0.95');
INSERT INTO `address` VALUES ('西安', '曲江新城', '0.88');
INSERT INTO `address` VALUES ('西安', '小寨', '0.8');
INSERT INTO `address` VALUES ('西安', '大雁塔', '0.85');
INSERT INTO `address` VALUES ('西安', '未央路沿线', '0.86');

-- ----------------------------
-- Table structure for `credit`
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `guestID` bigint(20) DEFAULT '0',
  `time` datetime DEFAULT '0001-01-01 01:01:01',
  `orderID` bigint(20) DEFAULT '0',
  `previousCredit` double DEFAULT '0',
  `afterCredit` double DEFAULT '0',
  `reason` text CHARACTER SET utf8 COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of credit
-- ----------------------------
INSERT INTO `credit` VALUES ('1234567990', '2016-02-03 03:23:00', '182720160202', '1000', '1235', '未执行->已执行');
INSERT INTO `credit` VALUES ('1234567990', '2016-03-02 05:31:00', '950820160301', '1235', '1931', '未执行->已执行');
INSERT INTO `credit` VALUES ('1234567990', '2016-07-16 06:00:00', '796020160711', '1931', '33', '未执行->异常');
INSERT INTO `credit` VALUES ('1234567990', '2016-07-16 10:21:00', '796020160711', '33', '3862', '异常->已执行');
INSERT INTO `credit` VALUES ('1234567990', '2016-11-11 06:00:00', '781720161107', '3862', '2993', '未执行->异常');
INSERT INTO `credit` VALUES ('1234567990', '2016-11-13 15:56:44', '781720161107', '2993', '3862', '异常->已撤销');

-- ----------------------------
-- Table structure for `guest`
-- ----------------------------
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest` (
  `guestID` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthday` date DEFAULT '0001-01-01',
  `enterprise` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '123456',
  `credit` double DEFAULT '1000',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`guestID`)
) ENGINE=InnoDB AUTO_INCREMENT=1234567908 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of guest
-- ----------------------------
INSERT INTO `guest` VALUES ('1234567900', '1997-04-04', '苹果Apple', '几俻枡', '二狗', '¢¨£¥ª¦ ¡', '3862', 'bfcafbfdbba');
INSERT INTO `guest` VALUES ('1234567901', '1997-09-30', '三星Samsung', '蒔鈂玺', '金玉baby', '¤', '1000', 'bfddifjffbh');
INSERT INTO `guest` VALUES ('1234567902', '1996-04-27', '人寿保险', '鬉滁', '米线宝宝他爹', '«©§', '1000', 'bfjfbjfdjdj');
INSERT INTO `guest` VALUES ('1234567903', '1996-10-24', '南京羽协', '鿋屉渭', '奶茶的姐夫', '¢¨£¥ª¦ ¡', '1000', 'bfbcdfdhgdh');
INSERT INTO `guest` VALUES ('1234567904', '1996-11-04', '一加', '玼涨苪', '学霸', '¢¨£¥ª¦ ¡', '1000', 'bdgbbbhbadd');
INSERT INTO `guest` VALUES ('1234567905', '1996-08-25', '核工厂', '忁叹仲', '大神', '¢¨£¥ª¦ ¡', '1000', 'bigcjeibajh');
INSERT INTO `guest` VALUES ('1234567906', '1996-12-09', '德芙', '玼吠忴', '学屌', '¢¨£¥ª¦ ¡', '1000', 'biibbfiabhh');

-- ----------------------------
-- Table structure for `hotel`
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `hotelID` bigint(20) NOT NULL,
  `hotelName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `circle` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `address` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `score` double DEFAULT '0',
  `introduction` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `equipment` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `commentsNum` int(11) DEFAULT '0',
  PRIMARY KEY (`hotelID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('98765441', '南京英尊假日酒店', '南京', '仙林中心', '仙林大道168号', '3', '4', '2013年开业，近九乡河东路，距地铁站步行3分钟', '24小时热水，拖鞋，独立淋浴间，吹风机，免费洗漱用品，多规格电源插座，中央空调，闹钟，针线包，遮光窗帘，手动窗帘，电话，房间内高速上网，客房WIFI覆盖免费，液晶电视，电热水壶，免费瓶装水，唤醒服务', '1309');
INSERT INTO `hotel` VALUES ('98765442', '南京天丰大酒店', '南京', '新街口', '洪武路26号', '4', '4.3', '2002年开业，位置很好，距离市中心400米', '24小时热水，拖鞋，独立淋浴间，吹风机，免费洗漱用品，洗浴间电话，多规格电源插座，普通分体空调，书桌，衣柜，房内保险箱，闹钟，针线包，遮光窗帘，手动窗帘，国内／国际长途，房间内高速上网，客房WIFI覆盖免费，有线频道，液晶电视，电热水壶，免费瓶装水，唤醒服务', '9887');
INSERT INTO `hotel` VALUES ('98765443', '南京金陵饭店', '南京', '新街口', '汉中路2号', '5', '4.7', '1983年开业，2016年装修，地处市中心，超棒', '24小时热水，拖鞋，浴室化妆放大镜，吹风机，免费洗漱用品，洗浴间电话，多规格电源插座，中央空调，书桌，衣柜，沙发，雨伞，熨衣设备，房内保险箱，闹钟，针线包，遮光窗帘，手动窗帘，国内／国际长途，房间内高速上网，客房WIFI覆盖免费，有线／卫星频道，液晶电视，电热水壶，免费瓶装水，小冰箱、迷你吧、唤醒服务，免费报纸', '20804');
INSERT INTO `hotel` VALUES ('98765444', '桔子水晶酒店（南京新街口店）', '南京', '新街口', '中山南路三元街5号', '4', '4.8', '2014年开业，近明瓦廊和程阁老巷，环境不错，超棒', '24小时热水，拖鞋，浴室化妆放大镜，浴衣，吹风机，免费洗漱用品，洗浴间电话，多规格电源插座，中央空调，书桌，房内保险箱，衣柜，针线包，遮光窗帘，手动窗帘，国内长途，房间内高速上网，客房WIFI覆盖免费，有线频道，液晶电视，电热水壶，咖啡壶／茶壶，免费瓶装水，小冰箱、迷你吧、唤醒服务，免费报纸', '10060');
INSERT INTO `hotel` VALUES ('98765445', '汉庭酒店（南京夫子庙）', '南京', '夫子庙', '大石坝街146号', '2', '4.3', '2010年开业，2016年装修，近来燕路、钞库街，很安静，很好', '24小时热水，拖鞋，免费洗漱用品，多规格电源插座，独立分体空调，书桌，国内长途，客房WIFI覆盖免费，电热水壶，免费瓶装水', '1628');
INSERT INTO `hotel` VALUES ('98765446', 'ZMAX潮漫酒店（南京夫子庙店）', '南京', '夫子庙', '夫子庙贡院街188号', '2', '4.6', '2016年开业，距夫子庙景区步行6分钟，位置好，很棒', '24小时热水，拖鞋，浴室化妆放大镜，吹风机，免费洗漱用品，洗浴间电话，多规格电源插座，中央空调，书桌，暖气，沙发，衣柜，遮光窗帘，手动窗帘，国内长途，房间内高速上网，客房WIFI覆盖免费，有线频道，液晶电视，音响，iPod音乐基座，电热水壶，免费瓶装水', '0');
INSERT INTO `hotel` VALUES ('98765447', '南京汤山御庭精品酒店', '南京', '汤山镇', '泉韵路8号', '5', '4.7', '2011年开业，距度假区驾车6分钟，房间很好，超棒', '24小时热水，拖鞋，浴室化妆放大镜，吹风机，浴衣，浴缸，免费洗漱用品，洗浴间电话，多规格电源插座，中央空调，书桌，衣柜，沙发，雨伞，电子秤，房内保险箱，闹钟，针线包，遮光窗帘，手动窗帘，国内／国际长途，房间内高速上网，客房WIFI覆盖免费，有线频道，液晶电视，iPod音乐基座，电热水壶，免费瓶装水，小冰箱、迷你吧、咖啡机', '3514');

-- ----------------------------
-- Table structure for `hotelfixedpromotion`
-- ----------------------------
DROP TABLE IF EXISTS `hotelfixedpromotion`;
CREATE TABLE `hotelfixedpromotion` (
  `hotelID` bigint(20) DEFAULT '0',
  `promotionType` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `discount` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hotelfixedpromotion
-- ----------------------------
INSERT INTO `hotelfixedpromotion` VALUES ('98765441', '会员生日折扣', '0.8');
INSERT INTO `hotelfixedpromotion` VALUES ('98765441', '企业会员折扣', '0.6');
INSERT INTO `hotelfixedpromotion` VALUES ('98765443', '会员生日折扣', '0.9');
INSERT INTO `hotelfixedpromotion` VALUES ('98765443', '企业会员折扣', '0.92');
INSERT INTO `hotelfixedpromotion` VALUES ('98765442', '会员生日折扣', '0.85');
INSERT INTO `hotelfixedpromotion` VALUES ('98765442', '企业会员折扣', '0.92');
INSERT INTO `hotelfixedpromotion` VALUES ('98765442', '三间及以上预订折扣', '0.88');
INSERT INTO `hotelfixedpromotion` VALUES ('98765441', '三间及以上预订折扣', '0.7');
INSERT INTO `hotelfixedpromotion` VALUES ('98765443', '三间及以上预订折扣', '0.88');
INSERT INTO `hotelfixedpromotion` VALUES ('98765445', '会员生日折扣', '0.87');
INSERT INTO `hotelfixedpromotion` VALUES ('98765444', '会员生日折扣', '0.75');
INSERT INTO `hotelfixedpromotion` VALUES ('98765444', '企业会员折扣', '0.88');
INSERT INTO `hotelfixedpromotion` VALUES ('98765444', '三间及以上预订折扣', '0.91');
INSERT INTO `hotelfixedpromotion` VALUES ('98765445', '企业会员折扣', '0.78');
INSERT INTO `hotelfixedpromotion` VALUES ('98765445', '三间及以上预订折扣', '0.82');
INSERT INTO `hotelfixedpromotion` VALUES ('98765446', '会员生日折扣', '0.85');
INSERT INTO `hotelfixedpromotion` VALUES ('98765446', '企业会员折扣', '0.75');
INSERT INTO `hotelfixedpromotion` VALUES ('98765446', '三间及以上预订折扣', '0.88');
INSERT INTO `hotelfixedpromotion` VALUES ('98765447', '会员生日折扣', '0.88');
INSERT INTO `hotelfixedpromotion` VALUES ('98765447', '企业会员折扣', '0.9');
INSERT INTO `hotelfixedpromotion` VALUES ('98765447', '三间及以上预订折扣', '0.95');

-- ----------------------------
-- Table structure for `hotelworker`
-- ----------------------------
DROP TABLE IF EXISTS `hotelworker`;
CREATE TABLE `hotelworker` (
  `hotelWorkerID` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '123456',
  `hotelName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`hotelWorkerID`)
) ENGINE=InnoDB AUTO_INCREMENT=98765448 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hotelworker
-- ----------------------------
INSERT INTO `hotelworker` VALUES ('98765441', '¢¨£¥ª¦ ¡bcdefg', '南京英尊假日酒店');
INSERT INTO `hotelworker` VALUES ('98765442', '¢¨£¥ª¦ ¡bcdefg', '南京天丰大酒店');
INSERT INTO `hotelworker` VALUES ('98765443', '¢¨£¥ª¦ ¡bcdefg', '南京金陵饭店');
INSERT INTO `hotelworker` VALUES ('98765444', '¢¨£¥ª¦ ¡bcdefg', '桔子水晶酒店（南京新街口店）');
INSERT INTO `hotelworker` VALUES ('98765445', '¢¨£¥ª¦ ¡bcdefg', '汉庭酒店（南京夫子庙）');
INSERT INTO `hotelworker` VALUES ('98765446', '¢¨£¥ª¦ ¡bcdefg', 'ZMAX潮漫酒店（南京夫子庙店）');
INSERT INTO `hotelworker` VALUES ('98765447', '¢¨£¥ª¦ ¡bcdefg', '南京汤山御庭精品酒店');

-- ----------------------------
-- Table structure for `market`
-- ----------------------------
DROP TABLE IF EXISTS `market`;
CREATE TABLE `market` (
  `marketName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `marketCredit` double(10,5) DEFAULT '0.00000',
  `marketBenefit` double(10,9) DEFAULT '0.000000000',
  PRIMARY KEY (`marketName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of market
-- ----------------------------
INSERT INTO `market` VALUES ('Lv1', '1500.00000', '0.950000000');
INSERT INTO `market` VALUES ('Lv2', '3000.00000', '0.900000000');
INSERT INTO `market` VALUES ('Lv3', '5000.00000', '0.850000000');
INSERT INTO `market` VALUES ('Lv4 ', '7500.00000', '0.800000000');
INSERT INTO `market` VALUES ('Lv5', '12000.00000', '0.750000000');
INSERT INTO `market` VALUES ('Lv6', '18000.00000', '0.700000000');
INSERT INTO `market` VALUES ('Lv7', '32000.00000', '0.650000000');
INSERT INTO `market` VALUES ('Lv8', '50000.00000', '0.600000000');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderID` bigint(20) NOT NULL AUTO_INCREMENT,
  `guestID` bigint(20) DEFAULT '0',
  `hotelID` bigint(20) DEFAULT '0',
  `hotelName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `hotelAddress` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `price` double DEFAULT '0',
  `expectExecuteTime` datetime DEFAULT '0001-01-01 01:01:01',
  `expectLeaveTime` datetime DEFAULT '0001-01-01 01:01:01',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `hasCommented` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'false',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `previousPrice` double DEFAULT '0',
  `createTime` datetime DEFAULT '0001-01-01 01:01:01',
  `checkInTime` datetime DEFAULT '0001-01-01 01:01:01',
  `checkOutTime` datetime DEFAULT '0001-01-01 01:01:01',
  `roomType` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `roomNumCount` int(2) DEFAULT '0',
  `roomNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `expectGuestNumCount` int(2) DEFAULT '0',
  `message` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `comment` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `score` double DEFAULT '0',
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=950820160303 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('182720160202', '1234567900', '98765441', '南京英尊假日酒店', '仙林大道168号', '235', '2016-02-03 06:00:00', '2016-02-04 04:00:00', '已执行', 'false', '几俻枡', 'bfcafbfdbba', '235', '2016-02-02 10:20:00', '2016-02-03 03:23:00', '2016-02-04 02:58:00', '单人间', '1', '301', '2', '无', '', '-1');
INSERT INTO `order` VALUES ('781720161107', '1234567900', '98765443', '南京金陵饭店', '汉中路2号', '869', '2016-11-11 06:00:00', '2016-11-12 04:00:00', '已撤销', 'false', '几俻枡', 'bfcafbfdbba', '869', '2016-11-06 18:56:00', '0001-01-01 01:01:01', '0001-01-01 01:01:01', '双人间', '1', '', '2', '无', '', '-1');
INSERT INTO `order` VALUES ('796020160711', '1234567900', '98765443', '南京金陵饭店', '汉中路2号', '1898', '2016-07-16 06:00:00', '2016-07-18 04:00:00', '已执行', 'true', '几俻枡', 'bfcafbfdbba', '1898', '2016-07-11 13:16:00', '2016-07-16 10:21:00', '2016-07-18 03:47:00', '双人间', '1', '5312', '2', '无', '地理位置特别好，交通、购物、吃饭、去景点都特别方便', '4.5');
INSERT INTO `order` VALUES ('801920161209', '1234567900', '98765446', 'ZMAX潮漫酒店（南京夫子庙店）', '夫子庙贡院街188号', '375', '2017-01-01 06:00:00', '2017-01-02 04:00:00', '未执行', 'false', '几俻枡', 'bfcafbfdbba', '375', '2016-12-09 12:06:00', '0001-01-01 01:01:01', '0001-01-01 01:01:01', '双人间', '1', '6407', '2', '无', '', '-1');
INSERT INTO `order` VALUES ('843420161107', '1234567900', '98765443', '南京金陵饭店', '汉中路2号', '869', '2016-11-11 06:00:00', '2016-11-12 04:00:00', '已撤销', 'true', '几俻枡', 'bfcafbfdbba', '869', '2016-11-06 18:56:00', '0001-01-01 01:01:01', '0001-01-01 01:01:01', '双人间', '1', '5312', '2', '无', '地理位置特别好，交通、购物、吃饭、去景点都特别方便', '4.5');
INSERT INTO `order` VALUES ('950820160301', '1234567900', '98765442', '南京天丰大酒店', '洪武路26号', '696', '2016-03-02 06:00:00', '2016-03-04 04:00:00', '已执行', 'true', '几俻枡', 'bfcafbfdbba', '696', '2016-03-01 14:20:00', '2016-03-02 05:31:00', '2016-03-04 00:58:00', '双人间', '1', '301', '2', '无', '环境很不错', '4.5');

-- ----------------------------
-- Table structure for `roominfo`
-- ----------------------------
DROP TABLE IF EXISTS `roominfo`;
CREATE TABLE `roominfo` (
  `hotelID` bigint(20) DEFAULT '0',
  `roomType` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `roomNum` int(5) DEFAULT '0',
  `remainRoomNum` int(5) DEFAULT '0',
  `price` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of roominfo
-- ----------------------------
INSERT INTO `roominfo` VALUES ('98765441', '单人间', '20', '20', '235');
INSERT INTO `roominfo` VALUES ('98765441', '双人间', '15', '15', '262');
INSERT INTO `roominfo` VALUES ('98765442', '单人间', '25', '25', '358');
INSERT INTO `roominfo` VALUES ('98765442', '双人间', '18', '18', '348');
INSERT INTO `roominfo` VALUES ('98765442', '三人间', '8', '8', '328');
INSERT INTO `roominfo` VALUES ('98765442', '商务套房', '12', '12', '228');
INSERT INTO `roominfo` VALUES ('98765442', '总统套房', '4', '4', '560');
INSERT INTO `roominfo` VALUES ('98765443', '单人间', '32', '32', '869');
INSERT INTO `roominfo` VALUES ('98765443', '双人间', '45', '45', '949');
INSERT INTO `roominfo` VALUES ('98765443', '商务套房', '16', '16', '1489');
INSERT INTO `roominfo` VALUES ('98765443', '总统套房', '8', '8', '2389');
INSERT INTO `roominfo` VALUES ('98765444', '单人间', '40', '40', '559');
INSERT INTO `roominfo` VALUES ('98765444', '双人间', '35', '35', '509');
INSERT INTO `roominfo` VALUES ('98765444', '商务套房', '28', '28', '619');
INSERT INTO `roominfo` VALUES ('98765444', '总统套房', '12', '12', '669');
INSERT INTO `roominfo` VALUES ('98765445', '单人间', '68', '68', '265');
INSERT INTO `roominfo` VALUES ('98765445', '双人间', '58', '58', '360');
INSERT INTO `roominfo` VALUES ('98765445', '三人间', '25', '25', '389');
INSERT INTO `roominfo` VALUES ('98765446', '单人间', '45', '45', '375');
INSERT INTO `roominfo` VALUES ('98765446', '双人间', '49', '49', '420');
INSERT INTO `roominfo` VALUES ('98765446', '商务套房', '30', '30', '443');
INSERT INTO `roominfo` VALUES ('98765447', '单人间', '30', '30', '858');
INSERT INTO `roominfo` VALUES ('98765447', '双人间', '30', '30', '868');
INSERT INTO `roominfo` VALUES ('98765447', '三人间', '25', '25', '1878');
INSERT INTO `roominfo` VALUES ('98765447', '商务套房', '18', '18', '2580');
INSERT INTO `roominfo` VALUES ('98765447', '总统套房', '9', '9', '4580');

-- ----------------------------
-- Table structure for `specialspanpromotion`
-- ----------------------------
DROP TABLE IF EXISTS `specialspanpromotion`;
CREATE TABLE `specialspanpromotion` (
  `userID` bigint(20) DEFAULT '0',
  `promotionName` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `discount` double DEFAULT '0',
  `startDate` date DEFAULT '0001-01-01',
  `endDate` date DEFAULT '0001-01-01'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of specialspanpromotion
-- ----------------------------
INSERT INTO `specialspanpromotion` VALUES ('98765441', '清明节', '0.75', '2016-04-03', '2016-04-05');
INSERT INTO `specialspanpromotion` VALUES ('98765441', '双十一', '0.66', '2016-11-09', '2016-11-12');
INSERT INTO `specialspanpromotion` VALUES ('98765442', '春节', '0.88', '2017-01-21', '2017-02-11');
INSERT INTO `specialspanpromotion` VALUES ('99999999', '双十一', '0.5', '2016-11-11', '2016-11-11');
INSERT INTO `specialspanpromotion` VALUES ('99999999', '春节', '0.75', '0001-01-01', '0001-01-01');

-- ----------------------------
-- Table structure for `webmanager`
-- ----------------------------
DROP TABLE IF EXISTS `webmanager`;
CREATE TABLE `webmanager` (
  `webManagerID` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '123456',
  PRIMARY KEY (`webManagerID`)
) ENGINE=InnoDB AUTO_INCREMENT=1015 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of webmanager
-- ----------------------------
INSERT INTO `webmanager` VALUES ('1010', '¢¨£¥ª¦ ¡bcdefg');
INSERT INTO `webmanager` VALUES ('1011', '¢¨£¥ª¦ ¡bcdefg');
INSERT INTO `webmanager` VALUES ('1012', '¢¨£¥ª¦ ¡bcdefg');
INSERT INTO `webmanager` VALUES ('1013', '¢¨£¥ª¦ ¡bcdefg');
INSERT INTO `webmanager` VALUES ('1014', '¢¨£¥ª¦ ¡bcdefg');

-- ----------------------------
-- Table structure for `webmarketer`
-- ----------------------------
DROP TABLE IF EXISTS `webmarketer`;
CREATE TABLE `webmarketer` (
  `webMarketerID` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '123456',
  PRIMARY KEY (`webMarketerID`)
) ENGINE=InnoDB AUTO_INCREMENT=100006 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of webmarketer
-- ----------------------------
INSERT INTO `webmarketer` VALUES ('100001', '¢¨£¥ª¦ ¡bcdefg');
INSERT INTO `webmarketer` VALUES ('100002', '¢¨£¥ª¦ ¡bcdefg');
INSERT INTO `webmarketer` VALUES ('100003', '¢¨£¥ª¦ ¡bcdefg');
INSERT INTO `webmarketer` VALUES ('100004', '¢¨£¥ª¦ ¡bcdefg');
INSERT INTO `webmarketer` VALUES ('100005', '¢¨£¥ª¦ ¡bcdefg');
