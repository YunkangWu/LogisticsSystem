/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : cd_logistics

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2017-05-18 01:09:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123');

-- ----------------------------
-- Table structure for `carssupply`
-- ----------------------------
DROP TABLE IF EXISTS `carssupply`;
CREATE TABLE `carssupply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start` varchar(255) DEFAULT NULL COMMENT '始发地',
  `end` varchar(255) DEFAULT NULL,
  `carType` int(11) DEFAULT NULL COMMENT '车型',
  `status` int(11) DEFAULT '0' COMMENT '交易状态',
  `time` date DEFAULT NULL COMMENT '发车日期',
  `belong` int(11) DEFAULT NULL COMMENT '归属用户',
  `createTime` datetime NOT NULL COMMENT '发布时间',
  `capacity` varchar(255) DEFAULT NULL COMMENT '载重',
  `price` varchar(255) DEFAULT NULL COMMENT '运价',
  `car_check` int(11) DEFAULT '1' COMMENT '信息状态，默认1：有效 0：无效',
  PRIMARY KEY (`id`),
  KEY `FK_oadai8re0w5uridkc75w37815` (`belong`),
  CONSTRAINT `FK_oadai8re0w5uridkc75w37815` FOREIGN KEY (`belong`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carssupply
-- ----------------------------
INSERT INTO `carssupply` VALUES ('1', '成都市', '重庆市', '1', '1', '2017-04-07', '1', '2017-05-01 18:22:08', '32吨', '电讯', '1');
INSERT INTO `carssupply` VALUES ('2', '青岛市', '无锡市', '2', '0', '2017-04-15', '1', '2017-05-01 18:22:39', '30吨', '电讯', '1');
INSERT INTO `carssupply` VALUES ('3', '保定市', '无锡市', '3', '0', '2017-05-01', '1', '2017-05-01 18:23:29', '30吨', '0.0042', '1');
INSERT INTO `carssupply` VALUES ('4', '上海', '成都', '2', '0', '2017-05-04', '1', '2017-05-02 15:27:33', '5吨', '3000元', '1');
INSERT INTO `carssupply` VALUES ('5', '上海', '杭州', '4', '0', '2017-05-06', '1', '2017-05-02 15:28:10', '20吨', '5000元', '1');
INSERT INTO `carssupply` VALUES ('6', '成都', '杭州', '1', '0', '2017-05-04', '1', '2017-05-02 15:53:50', '20吨', '20', '1');

-- ----------------------------
-- Table structure for `goodssupply`
-- ----------------------------
DROP TABLE IF EXISTS `goodssupply`;
CREATE TABLE `goodssupply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start` varchar(255) NOT NULL COMMENT '出发地',
  `end` varchar(255) NOT NULL,
  `quantity` varchar(255) NOT NULL COMMENT '货物量',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '交易状态：0：待交易，1：交易完成',
  `time` date NOT NULL COMMENT '配货日期',
  `belong` int(11) NOT NULL COMMENT '信息归属',
  `createTime` datetime DEFAULT NULL COMMENT '发布时间',
  `goodsName` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `price` varchar(255) DEFAULT NULL COMMENT '期望运价',
  `carType` int(11) DEFAULT NULL COMMENT '期望车型',
  `goods_check` int(11) DEFAULT '1' COMMENT '审核状态',
  PRIMARY KEY (`id`),
  KEY `goods_belong` (`belong`),
  CONSTRAINT `goods_belong` FOREIGN KEY (`belong`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodssupply
-- ----------------------------
INSERT INTO `goodssupply` VALUES ('1', '上海市', '苏州市', '15吨', '0', '2017-04-13', '2', '2017-05-01 19:00:13', '轻钢龙骨构件', '电讯', '1', '1');
INSERT INTO `goodssupply` VALUES ('2', '廊坊市', '昆明', '25吨', '0', '2017-04-08', '2', '2017-05-01 19:02:39', '快递', '电讯', '2', '1');
INSERT INTO `goodssupply` VALUES ('3', '天津市', '成都市', '150吨', '0', '2017-05-05', '2', '2017-05-01 19:08:06', '钢卷', '面议', '3', '1');
INSERT INTO `goodssupply` VALUES ('4', '上海市', '郑州市', '20吨', '0', '2017-05-02', '2', '2017-05-01 19:08:53', '快递', '面议', '3', '1');
INSERT INTO `goodssupply` VALUES ('5', '石家庄市', '韶关市', '11.00吨', '0', '2017-05-06', '2', '2017-05-01 19:10:00', '砂轮片', '电讯', '1', '1');
INSERT INTO `goodssupply` VALUES ('6', '禹州市', '兰州市', '11吨', '0', '2017-05-06', '2', '2017-05-01 19:10:52', '砂轮片', '面议', '3', '1');
INSERT INTO `goodssupply` VALUES ('7', '上海市', '苏州市', '16吨', '0', '2017-05-01', '2', null, null, null, null, '1');
INSERT INTO `goodssupply` VALUES ('8', '上海市', '成都市', '15吨', '0', '2017-04-14', '2', '2017-05-01 22:08:58', '快递', '电询', null, '1');
INSERT INTO `goodssupply` VALUES ('9', '许昌市', '兰州市', '12吨', '0', '2017-05-06', '7', '2017-05-02 09:28:09', '砂轮片', '电询', '1', '1');
INSERT INTO `goodssupply` VALUES ('10', '廊坊市', '成都市', '15吨', '0', '2017-05-04', '7', '2017-05-02 09:37:45', '快递', '电询', '1', '1');
INSERT INTO `goodssupply` VALUES ('11', '成都市', '武汉市', '15吨', '0', '2017-05-04', '7', '2017-05-02 09:38:33', '快递', '电询', '1', '1');
INSERT INTO `goodssupply` VALUES ('12', '成都', '武汉', '12吨', '0', '2017-05-05', '7', '2017-05-02 09:39:03', '水果', '2000元', '4', '1');
INSERT INTO `goodssupply` VALUES ('13', '成都', '上海', '', '0', '2017-05-04', '2', '2017-05-14 09:57:00', '23', '', '1', '1');

-- ----------------------------
-- Table structure for `jobssupply`
-- ----------------------------
DROP TABLE IF EXISTS `jobssupply`;
CREATE TABLE `jobssupply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobTitle` varchar(255) DEFAULT NULL COMMENT '职位名称',
  `companyName` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `salary` varchar(255) DEFAULT NULL COMMENT '月薪',
  `city` varchar(255) DEFAULT NULL COMMENT '工作地点',
  `createTime` datetime DEFAULT NULL COMMENT '发布时间',
  `belong` int(11) DEFAULT NULL COMMENT '信息归属',
  `job_check` int(11) DEFAULT '1' COMMENT '招聘信息状态，默认1：有效，0：无效',
  PRIMARY KEY (`id`),
  KEY `job_belong` (`belong`),
  CONSTRAINT `job_belong` FOREIGN KEY (`belong`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobssupply
-- ----------------------------
INSERT INTO `jobssupply` VALUES ('1', '办公室文员', ' 瑞狮食品(北京)有限公司 ', ' 3000-4000元', '北京', '2017-03-30 03:00:00', '2', '1');
INSERT INTO `jobssupply` VALUES ('2', '亚马逊销售运营专员', '广州力杰电子科技有限公司 ', ' 4001-6000元', '广州', '2017-03-17 00:00:00', '2', '1');
INSERT INTO `jobssupply` VALUES ('3', 'java开发', '华润', '7k', '深圳', '2017-04-02 01:18:29', '1', '0');
INSERT INTO `jobssupply` VALUES ('4', '成都', '成都', '2000', '成都', '2017-04-30 15:11:57', '2', '1');
INSERT INTO `jobssupply` VALUES ('6', '储备干部', ' 浙江东宇物流有限公司 ', '3000-5000元', '镇江', '2017-05-01 19:47:14', '5', '1');
INSERT INTO `jobssupply` VALUES ('7', '分部经理（区域经理）', '兰州顺丰速运有限公司 ', '4000-8000元', '西宁', '2017-05-01 19:48:31', '5', '1');
INSERT INTO `jobssupply` VALUES ('8', '客服专员', '北京迪信通电子商务有限公司 ', ' 3000-4000元', '广州', '2017-05-01 19:48:56', '5', '1');

-- ----------------------------
-- Table structure for `linessupply`
-- ----------------------------
DROP TABLE IF EXISTS `linessupply`;
CREATE TABLE `linessupply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start` varchar(255) NOT NULL,
  `end` varchar(255) NOT NULL,
  `belong` int(11) NOT NULL COMMENT '信息归属',
  `createTime` datetime NOT NULL COMMENT '发布时间',
  `price` varchar(255) DEFAULT NULL COMMENT '专线运价',
  `frequency` varchar(255) DEFAULT NULL COMMENT '发车频率',
  `transportTime` varchar(255) DEFAULT NULL COMMENT '运输时效',
  `line_check` int(11) DEFAULT '1' COMMENT '状态信息，默认1：可用，0：无效',
  PRIMARY KEY (`id`),
  KEY `FK_hlecvmk7hh4ko9xy8d4utcfh5` (`belong`),
  CONSTRAINT `FK_hlecvmk7hh4ko9xy8d4utcfh5` FOREIGN KEY (`belong`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linessupply
-- ----------------------------
INSERT INTO `linessupply` VALUES ('1', ' 广东省佛山市', '上海青浦区 ', '3', '2017-04-21 00:32:18', '200.00元/吨', '1天1次', '1天', '1');
INSERT INTO `linessupply` VALUES ('2', '陕西省 西安市', ' 陕西省 延安市 ', '3', '2017-04-21 00:32:23', null, '1天1次', '1天', '1');
INSERT INTO `linessupply` VALUES ('3', '成都', '广州', '3', '2017-04-02 00:59:57', null, '1天1次', '2天', '1');
INSERT INTO `linessupply` VALUES ('5', '四川省凉山州', '成都市', '3', '2017-05-01 19:13:20', '200.00元/吨', '1天1次', '1天', '1');
INSERT INTO `linessupply` VALUES ('6', '成都市', '绵阳市', '13', '2017-05-01 19:14:14', '25.00元/吨', '1天2次', '12小时', '1');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(255) NOT NULL COMMENT '新闻标题',
  `news_content` varchar(510) DEFAULT NULL,
  `news_from` varchar(255) DEFAULT NULL COMMENT '新闻来源',
  `news_date` datetime DEFAULT NULL COMMENT '新闻日期',
  `news_type` int(11) DEFAULT NULL COMMENT '新闻类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '襄阳至南漳也要通高速公路了 ', '十三五期间，我市将建设襄阳至南漳高速公路。这是记者从日前召开的2016年全市交通运输工作会上了解到的。副市长王忠运参加会议。根据规划，襄阳至南漳高速公路，起点为二广襄城尹集，终点接南漳境内麻竹高速', '襄阳网', '2017-04-13 17:40:47', '1');
INSERT INTO `news` VALUES ('2', '原油跌跌不休 物流企业九迎油价下调', '国际石油市场整体供应仍显充裕，受此打压，本计价周期内，国际油价延续震荡下滑的走势，带动原油变化率保持低位运行，市场下调预期较为浓厚。', '中国物流网', '2017-04-08 17:40:41', '2');
INSERT INTO `news` VALUES ('3', '校园设快递超市 破解“最后一公里”\r\n校园设快递超市 破解“最后一公里”\r\n校园设快递超市 破解“最后一公里”', '昨日，清华大学，学生在快递服务点取快递。该服务点利用学校的防汛门，快递员不用进校便能完成投递，学生则可在校内取件。\r\n学校与第三方机构合作，在校园中设立“快递超市”或“快递营业厅”等，将学生的大部分快件集中到这里统一收发。', '校园网', '2017-04-21 17:41:46', '1');
INSERT INTO `news` VALUES ('4', '2016中国快递业发展回顾', '2016年是我国快递业持续保持高速发展的第四个年头，是最受上至国务院下至很多地方政府关注、关心和支持的一年，也是我国快递业变化最大的一年。', '快递物流咨询网', '2017-04-21 17:43:10', '3');
INSERT INTO `news` VALUES ('5', '封闭42个小时后昆石、昆曲等高速公路陆续恢复通行', ' 寒风凛冽，落雪结冰。强冷空气南下，着实给温暖惯了的春城市民出行带来诸多不便。高速路上结冰困住上百辆车，司机们更是苦不堪言，进退两难。直到昨日中午，封闭了42个小时的昆石、昆曲等高速公路终于陆续解除交通管制，恢复通行。\r\n  寒风凛冽，落雪结冰。强冷空气南下，着实给温暖惯了的春城市民出行带来诸多不便。高速路上结冰困住上百辆车，司机们更是苦不堪言，进退两难。直到昨日中午，封闭了42个小时的昆石、昆曲等高速公路终于陆续解除交通管制，恢复通行。', 'news.56888', '2017-04-22 17:44:50', '4');
INSERT INTO `news` VALUES ('6', 'ww', '2121', '11', '2017-05-02 15:42:36', '2');

-- ----------------------------
-- Table structure for `stationinfo`
-- ----------------------------
DROP TABLE IF EXISTS `stationinfo`;
CREATE TABLE `stationinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_title` varchar(255) NOT NULL COMMENT '公告标题',
  `info_content` varchar(2000) DEFAULT NULL,
  `info_time` datetime DEFAULT NULL,
  `info_from` varchar(255) DEFAULT NULL COMMENT '公告来源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stationinfo
-- ----------------------------
INSERT INTO `stationinfo` VALUES ('1', '本站正式运营', '自2017年4月1日起，本站正式投入运营', '2017-04-01 17:29:09', '本站');
INSERT INTO `stationinfo` VALUES ('2', '牟平区开展危化品泄漏应急演练', '牟平区开展危化品泄漏应急演练', '2017-04-06 17:30:36', '长江物流');
INSERT INTO `stationinfo` VALUES ('3', '改版上线', '物流网改版即将上线，功能将更加完善，敬请期待！', '2017-05-01 17:31:21', '本站');

-- ----------------------------
-- Table structure for `storagessupply`
-- ----------------------------
DROP TABLE IF EXISTS `storagessupply`;
CREATE TABLE `storagessupply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `location` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `capacity` varchar(255) DEFAULT NULL COMMENT '容量',
  `belong` int(11) NOT NULL COMMENT '信息归属',
  `createTime` datetime DEFAULT NULL COMMENT '发布时间',
  `storageType` int(11) DEFAULT NULL COMMENT '仓储类型',
  `price` varchar(255) DEFAULT NULL COMMENT '报价',
  `storage_check` int(11) DEFAULT '1' COMMENT '仓储信息状态，默认1:有效，0：无效',
  PRIMARY KEY (`id`),
  KEY `FK_b06actsh93n4jd8q2qmvoskor` (`belong`),
  CONSTRAINT `FK_b06actsh93n4jd8q2qmvoskor` FOREIGN KEY (`belong`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storagessupply
-- ----------------------------
INSERT INTO `storagessupply` VALUES ('1', '成都', '龙泉驿', '200吨', '2', null, '1', '电询', '0');
INSERT INTO `storagessupply` VALUES ('2', '绵阳', '绵阳', '700吨', '2', null, '2', '15/平米', '1');
INSERT INTO `storagessupply` VALUES ('3', '成都', '龙泉驿', '120吨', '1', '2017-04-02 01:08:05', '3', null, '1');
INSERT INTO `storagessupply` VALUES ('4', '成都', '十陵', '120', '2', '2017-04-30 15:06:00', '1', '120', '0');
INSERT INTO `storagessupply` VALUES ('5', '成都', '武侯祠', '123', '2', '2017-04-30 15:06:55', '3', '123', '1');
INSERT INTO `storagessupply` VALUES ('7', '天津', '凯顺物流公司', '4000.00吨', '4', '2017-05-01 19:23:22', '1', '20.00元/平米', '1');
INSERT INTO `storagessupply` VALUES ('8', '成都', '天凯顺物流公司', '4000平方米', '4', '2017-05-01 19:23:51', '1', '电讯', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(255) NOT NULL DEFAULT '' COMMENT '用户登录名',
  `user_password` varchar(255) NOT NULL,
  `user_type` int(10) NOT NULL DEFAULT '1' COMMENT '1：个人用户，2：企业用户',
  `user_location` varchar(255) DEFAULT NULL COMMENT '地址',
  `user_tellphone` varchar(255) DEFAULT NULL COMMENT '电话',
  `user_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `user_check` int(11) NOT NULL DEFAULT '1' COMMENT '信息状态，默认1：有效，0：无效',
  `company_name` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `company_belong` varchar(255) DEFAULT NULL COMMENT '企业法人',
  `company_type` int(10) DEFAULT NULL COMMENT '企业类型',
  `company_industry` int(10) DEFAULT NULL COMMENT '所属行业',
  `user_question` varchar(255) DEFAULT NULL COMMENT '存放问题，用于记不起密码的找回',
  `user_key` varchar(255) DEFAULT NULL COMMENT '问题答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wyk', '123', '1', '浙江湖州', '13424324532', '323213@qq.com', '1', '', '', '0', '0', 'test', '123');
INSERT INTO `user` VALUES ('2', 'wyk2', '123', '2', '四川成都', '13232423213', '23414@sina.com', '1', '四川物捷货源公司', '陈武昌', '1', '1', '123', '123');
INSERT INTO `user` VALUES ('3', 'wyk3', '123', '2', '四川成都', '19392392313', '321313111@qq.com', '1', '四川捷达专线公司', '吴秋明', '2', '2', null, null);
INSERT INTO `user` VALUES ('4', 'wyk4', '123', '2', '四川达州', '12342423132', '312321@sina.com', '1', '四川恒德仓储公司', '陈屋顶', '3', '3', null, null);
INSERT INTO `user` VALUES ('5', 'wyk5', '123', '2', '湖北武汉', '12342357474', 'sdad@163.com', '1', '湖北承德中介公司', '刘明德', '0', '4', '密码', '123');
INSERT INTO `user` VALUES ('6', 'wyk6', '123', '1', '', '', '', '0', '', '', '0', '0', null, null);
INSERT INTO `user` VALUES ('7', 'huoyuan1', '123', '2', '成都武侯祠', '12342838238', '4123213@qq.com', '1', '物候货物公司', '陈伟华', '1', '1', '木头人', '123');
INSERT INTO `user` VALUES ('8', 'cheyuan', '123', '1', '成都龙泉驿', '14625362372', '3123232@qq.com', '1', '', '', '0', '0', null, null);
INSERT INTO `user` VALUES ('9', 'test01', '123', '1', '浙江杭州', '12345234243', '12345234243@qq.com', '1', '', '', '0', '0', '', '');
INSERT INTO `user` VALUES ('10', 'test02', '123', '2', 'chengdu', '17261762123', '', '1', '测试公司', '五大道', '1', '3', null, null);
INSERT INTO `user` VALUES ('11', 'test03', '123', '2', '', '1231', '312', '1', '312', '312', '1', '0', null, null);
INSERT INTO `user` VALUES ('13', 'test06', '123', '2', '浙江湖州', '126362636123', '211232@qq.com', '1', '鸿运', '', '2', '0', null, null);
INSERT INTO `user` VALUES ('14', 'company01', '123', '2', '湖北武汉', '1234242542', '32131@sina.com', '1', '湖北仓储公司', '胡陈华', '3', '2', null, null);
INSERT INTO `user` VALUES ('15', 'company02', '123', '2', '湖北恩施', '1324244233', '44233@qq.com', '1', '恩施土家仓储中心', '李达', '3', '3', null, null);
INSERT INTO `user` VALUES ('16', 'siji', '123', '1', '123', '', '', '0', '', '', '0', '0', '123', '123');
INSERT INTO `user` VALUES ('17', 'checheche', '123', '1', '成都', '12342357474', '312321@qq.com', '1', '', '', '0', '0', null, null);
