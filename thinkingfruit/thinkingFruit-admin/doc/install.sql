/*
Navicat MySQL Data Transfer

Source Server         : 小果园
Source Server Version : 50720
Source Host           : 106.14.177.78:3306
Source Database       : hzqsjk-wxapplet-mall

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-19 14:13:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_address
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_address`;
CREATE TABLE `t_thinkingfruit_mall_address` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `memberId` int(8) NOT NULL COMMENT '代理会员id',
  `province` varchar(20) DEFAULT NULL COMMENT '所在省',
  `city` varchar(20) DEFAULT NULL COMMENT '所在市',
  `town` varchar(20) DEFAULT NULL COMMENT '所在区',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_address
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_cash
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_cash`;
CREATE TABLE `t_thinkingfruit_mall_cash` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `memberId` int(8) NOT NULL COMMENT '用户id',
  `status` int(1) NOT NULL COMMENT '提现状态,0代表申请，1代表成功',
  `account` varchar(256) NOT NULL COMMENT '备注  ',
  `openBank` varchar(128) NOT NULL COMMENT '开户行',
  `bankNumber` varchar(20) NOT NULL COMMENT '银行卡号',
  `cash` decimal(10,2) NOT NULL COMMENT '提现金额',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_cash
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_commision
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_commision`;
CREATE TABLE `t_thinkingfruit_mall_commision` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `memberId` int(8) NOT NULL COMMENT '代理id',
  `orderNo` varchar(32) NOT NULL COMMENT '订单编号',
  `totalAmount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单总金额',
  `inviterId` int(11) NOT NULL DEFAULT '0' COMMENT '邀请者Id',
  `inviterTotalMoney` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '邀请者获得的总金额',
  `inviteMoney` decimal(10,2) unsigned zerofill NOT NULL DEFAULT '00000000.00' COMMENT '邀请金',
  `inviterUpperId` int(11) NOT NULL COMMENT '邀请者上级id',
  `commision` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '邀请者上级分得的佣金',
  `commisionProportion` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '上上级分得的佣金比例',
  `commodityId` int(8) NOT NULL COMMENT '商品id',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_commision
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_commision_person
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_commision_person`;
CREATE TABLE `t_thinkingfruit_mall_commision_person` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `memberId` int(11) NOT NULL COMMENT '用户id',
  `personTotalInviteMoney` double(4,1) NOT NULL DEFAULT '0.0' COMMENT '邀请金',
  `personTotalCommodity` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '总商品销售额',
  `personTotalCommision` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '总佣金',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_commision_person
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_commodity
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_commodity`;
CREATE TABLE `t_thinkingfruit_mall_commodity` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '商品名',
  `coverImagePath` varchar(1024) NOT NULL COMMENT '商品展示图片',
  `description` varchar(256) NOT NULL COMMENT '商品描述',
  `sales` int(8) DEFAULT '0' COMMENT '商品销量',
  `approvalNumber` varchar(32) DEFAULT NULL COMMENT '商品批准文号',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态(0：激活，1：注销)',
  `firstPrice` decimal(10,2) NOT NULL COMMENT '第一级价格',
  `secondPrice` decimal(10,2) NOT NULL COMMENT '第二级价格',
  `thirdPrice` decimal(10,2) NOT NULL COMMENT '第三级价格',
  `fourthPrice` decimal(10,2) NOT NULL COMMENT '第四级价格',
  `fifthPrice` decimal(10,2) NOT NULL COMMENT '第五级价格',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_commodity
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_commodity_images
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_commodity_images`;
CREATE TABLE `t_thinkingfruit_mall_commodity_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品图片id',
  `imagePath` varchar(1024) NOT NULL COMMENT '图片地址',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示图片未删除，1表示图片未删除',
  `commodityId` int(11) NOT NULL COMMENT '商品id',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_commodity_images
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_depot
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_depot`;
CREATE TABLE `t_thinkingfruit_mall_depot` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `memberId` int(8) NOT NULL COMMENT '会员id',
  `commodityId` int(8) NOT NULL COMMENT '商品id',
  `count` int(8) NOT NULL COMMENT '数量',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_depot
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_express
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_express`;
CREATE TABLE `t_thinkingfruit_mall_express` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `province` varchar(255) DEFAULT NULL COMMENT '省名',
  `freight` varchar(255) DEFAULT NULL COMMENT '快递费',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_express
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_logistics
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_logistics`;
CREATE TABLE `t_thinkingfruit_mall_logistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logisticsNo` varchar(255) NOT NULL COMMENT '物流编码',
  `express` varchar(255) NOT NULL COMMENT '快递公司名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_logistics
-- ----------------------------
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('1', 'YD', '韵达速递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('2', 'HTKY', '百世快递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('3', 'ZTO', '中通快递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('4', 'STO', '申通快递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('5', 'YTO', '圆通速递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('6', 'SF', '顺风快递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('7', 'YZPY', '邮政快递包裹');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('8', 'EMS', 'EMS');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('9', 'HHTT', '天天快递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('10', 'JD', '京东物流');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('11', 'QFKD', '全峰快递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('12', 'GTO', '国通快递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('13', 'UC', '优速快递');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('14', 'DBL', '德邦');
INSERT INTO `t_thinkingfruit_mall_logistics` VALUES ('15', 'FAST', '快捷快递');

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_member
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_member`;
CREATE TABLE `t_thinkingfruit_mall_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `loginName` varchar(32) NOT NULL COMMENT '登录名',
  `pswd` varchar(32) NOT NULL COMMENT '用户登录密码',
  `mobile` varchar(11) NOT NULL COMMENT '手机号码(loginName)',
  `gender` tinyint(1) DEFAULT '0' COMMENT '会员性别0代表女1代表男',
  `salt` varchar(64) NOT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `avatar` varchar(256) DEFAULT NULL COMMENT '头像路径',
  `inviterId` int(11) NOT NULL DEFAULT '0' COMMENT '邀请者Id',
  `inviterUpperId` int(11) NOT NULL COMMENT '邀请者上级id',
  `identityNo` varchar(32) DEFAULT NULL COMMENT '身份证',
  `memberLevelId` int(11) DEFAULT NULL COMMENT '代理级别',
  `balance` decimal(10,2) NOT NULL COMMENT '余额',
  `salesVolume` decimal(11,2) NOT NULL COMMENT '商品销售额',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态0代表待审核，1代表审核通过,2代表注销，',
  `upStatus` tinyint(255) NOT NULL DEFAULT '0' COMMENT '升级状态默认0(0为未申请状态),1代表升级申请',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创健日期',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  `upgradeTime` timestamp NULL DEFAULT NULL COMMENT '升级时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_member
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_member_level
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_member_level`;
CREATE TABLE `t_thinkingfruit_mall_member_level` (
  `id` int(11) NOT NULL COMMENT '代理等级id',
  `level` int(11) NOT NULL COMMENT '代理级别,1表示联创，2表示春事，3表示总监，4表示svip，5表示vip',
  `levelName` varchar(30) NOT NULL COMMENT '代理名',
  `levelingDiscount` decimal(5,2) NOT NULL COMMENT '平级分佣/邀请奖比例',
  `crossLevelDiscount` decimal(5,2) NOT NULL COMMENT '跨级分佣/邀请奖比例',
  `reverseLevelDiscount` decimal(5,2) NOT NULL COMMENT '反向级别分佣/邀请奖比例',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创健日期',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_member_level
-- ----------------------------
INSERT INTO `t_thinkingfruit_mall_member_level` VALUES ('1', '1', '联创', '0.20', '0.10', '0.00', '2018-11-23 09:41:11', '2018-11-23 14:45:09');
INSERT INTO `t_thinkingfruit_mall_member_level` VALUES ('2', '2', '春事', '0.15', '0.10', '0.15', '2018-11-23 09:41:58', null);
INSERT INTO `t_thinkingfruit_mall_member_level` VALUES ('3', '3', '总监', '0.15', '0.10', '0.15', '2018-11-23 09:45:05', null);
INSERT INTO `t_thinkingfruit_mall_member_level` VALUES ('4', '4', 'SVIP', '0.10', '0.10', '0.15', '2018-11-23 09:45:29', null);
INSERT INTO `t_thinkingfruit_mall_member_level` VALUES ('5', '5', 'VIP', '0.10', '0.00', '0.15', '2018-11-23 09:45:58', null);

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_message
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_message`;
CREATE TABLE `t_thinkingfruit_mall_message` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '消息Id',
  `content` longtext NOT NULL COMMENT '消息内容',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_news
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_news`;
CREATE TABLE `t_thinkingfruit_mall_news` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '新闻名称',
  `title` varchar(32) NOT NULL COMMENT '标题',
  `description` varchar(256) NOT NULL COMMENT '描述',
  `coverImagePath` varchar(256) DEFAULT NULL COMMENT '新闻图片',
  `content` longtext NOT NULL COMMENT '内容',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0代表新闻，1代表关于我们',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_news
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_order
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_order`;
CREATE TABLE `t_thinkingfruit_mall_order` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(32) NOT NULL COMMENT '订单编号',
  `orderMemberName` varchar(20) NOT NULL COMMENT '收件人',
  `orderMemberId` int(8) NOT NULL COMMENT '代理id',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `province` varchar(20) DEFAULT NULL COMMENT '所在省',
  `city` varchar(20) DEFAULT NULL COMMENT '所在市',
  `town` varchar(20) DEFAULT NULL COMMENT '所在区',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `remark` varchar(256) DEFAULT NULL COMMENT '订单备注',
  `sendMethod` tinyint(1) NOT NULL COMMENT '配送方式,0,邮寄,1,自取',
  `expressNo` varchar(20) DEFAULT NULL COMMENT '快递号',
  `logistics` varchar(255) DEFAULT NULL COMMENT '快递公司',
  `orderStatus` tinyint(1) NOT NULL COMMENT '订单状态,0代表待发货，1代表待收货，2代表已完成,3表示已取消',
  `commodityId` int(8) NOT NULL COMMENT '商品id',
  `commodityCount` int(11) NOT NULL COMMENT '商品数量',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `confirmTime` timestamp NULL DEFAULT NULL COMMENT '订单发货时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_order_purchase
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_order_purchase`;
CREATE TABLE `t_thinkingfruit_mall_order_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '代理购买商品订单id',
  `orderNo` varchar(32) NOT NULL COMMENT '订单号',
  `orderMemberId` int(11) NOT NULL COMMENT '会员id',
  `memberLevel` int(11) NOT NULL COMMENT '代理等级',
  `orderMemberName` varchar(20) NOT NULL COMMENT '代理名称',
  `commodityId` int(11) NOT NULL COMMENT '商品id',
  `commodityCount` int(11) NOT NULL COMMENT '商品数量',
  `commodityName` varchar(30) NOT NULL COMMENT '商品名',
  `commodityPrice` decimal(10,2) NOT NULL COMMENT '商品价格',
  `isFirst` tinyint(2) NOT NULL COMMENT '0表示注册首单，1表示正常订单，2表示升级订单',
  `orderStatus` tinyint(9) NOT NULL COMMENT '订单状态,1向上级下单，2上级同意，3表示已取消',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `orderTotalPrice` decimal(10,2) NOT NULL COMMENT '订单总价格',
  `confirmTime` timestamp NULL DEFAULT NULL COMMENT '订单完成时间',
  `inviterId` int(11) NOT NULL DEFAULT '0' COMMENT '邀请者Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_order_purchase
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_panel_statistics
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_panel_statistics`;
CREATE TABLE `t_thinkingfruit_mall_panel_statistics` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `memberTotal` int(20) NOT NULL COMMENT '会员总数',
  `transactionTotal` double(255,0) NOT NULL COMMENT '交易金额总数',
  `day` varchar(255) NOT NULL DEFAULT '',
  `month` varchar(255) NOT NULL,
  `orderTotal` int(20) NOT NULL COMMENT '订单总数',
  `commodityTotal` int(20) NOT NULL COMMENT '公司卖出商品数',
  `cashTotal` double(16,2) NOT NULL DEFAULT '0.00' COMMENT '提现支出',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_panel_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_permission`;
CREATE TABLE `t_thinkingfruit_mall_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  `url` varchar(50) NOT NULL COMMENT '权限URL',
  `parentId` int(8) NOT NULL COMMENT '父权限ID',
  `href` varchar(200) NOT NULL COMMENT '权限链接',
  `level` int(8) NOT NULL COMMENT '权限等级',
  `description` varchar(50) NOT NULL COMMENT '权限规则描述',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_permission
-- ----------------------------
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('1', '系统管理', 'system:manager', '0', 'permission', '1', '系统管理', null, '2018-06-26 17:15:35');
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('2', '用户管理', 'user:manager', '1', 'permission', '2', '用户管理', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('3', '用户列表', 'user:index', '2', 'permission', '3', '用户列表', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('4', '用户添加/修改', 'user:edit', '2', 'permission', '3', '用户添加/修改', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('5', '用户密码修改', 'user:pswd', '2', 'permission', '3', '用户密码修改', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('6', '用户删除', 'user:delete', '2', 'permission', '3', '用户删除', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('7', '角色管理', 'role:manager', '1', 'permission', '2', '角色管理', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('8', '角色列表', 'role:index', '7', 'permission', '3', '角色列表', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('9', '角色添加/修改', 'role:edit', '7', 'permission', '3', '角色添加/修改', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('10', '角色删除', 'role:delete', '7', 'permission', '3', '角色删除', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('11', '权限管理', 'permission:manager', '1', 'permission', '2', '角色管理', null, '2018-06-26 17:20:47');
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('12', '权限列表', 'permission:index', '11', 'permission', '3', '权限列表', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('13', '权限添加/修改', 'permission:edit', '11', 'permission', '3', '权限添加/修改', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('14', '权限删除', 'permission:delete', '11', 'permission', '3', '权限删除', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('15', '权限树', 'permission:tree', '11', 'permission', '3', '权限树', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('16', '管理员修改密码', 'admin:pswd', '2', 'permission', '3', '管理员修改密码', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('17', '商城管理', 'mall:manager', '0', 'permission', '1', '商城管理', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('19', '商品管理', 'commodity:manager', '17', 'permission', '2', '商品管理', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('20', '用户提现', 'cash:manager', '17', 'permission', '2', '用户提现', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('22', '订单列表', 'order:manager', '17', 'permission', '2', '订单列表', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('23', '佣金列表', 'commision:manager', '17', 'permission', '2', '佣金列表', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('24', '个人佣金', 'commision:person', '17', 'permission', '2', '个人佣金', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('25', '资讯列表', 'news:manager', '17', 'permission', '2', '资讯列表', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('26', '会员列表', 'member:manager', '17', 'permission', '2', '会员列表', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('29', '设置', 'business:manager', '17', 'permission', '2', '商家申请', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('30', '首页管理', 'home:manager', '0', 'permission', '1', '首页管理', null, '2018-08-22 16:42:50');
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('31', '首页', 'statictis:index', '30', 'permission', '2', '首页', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('32', '消息展示', 'message:index', '30', 'permission', '2', '消息展示', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('33', '总统计数据', 'total:statistic', '31', 'permission', '3', '总统计数据', null, null);
INSERT INTO `t_thinkingfruit_mall_permission` VALUES ('34', '佣金排行', 'commision:ranking', '17', 'permission', '2', '佣金排行', null, null);

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_role
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_role`;
CREATE TABLE `t_thinkingfruit_mall_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `description` varchar(200) NOT NULL COMMENT '角色描述',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1;

-- ----------------------------
-- Records of t_thinkingfruit_mall_role
-- ----------------------------
INSERT INTO `t_thinkingfruit_mall_role` VALUES ('1', 'admin', '至高无上的权利', '2017-12-22 17:35:55', '2018-08-22 17:17:53');
INSERT INTO `t_thinkingfruit_mall_role` VALUES ('3', '测试', '测试', '2018-07-19 09:57:06', '2018-12-09 17:55:14');

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_role_permission`;
CREATE TABLE `t_thinkingfruit_mall_role_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色权限关联表编号',
  `roleId` int(8) NOT NULL COMMENT '角色ID',
  `permissionId` int(8) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_role_permission
-- ----------------------------
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('99', '1', '1');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('100', '1', '2');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('101', '1', '3');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('102', '1', '4');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('103', '1', '5');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('104', '1', '6');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('105', '1', '16');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('106', '1', '7');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('107', '1', '8');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('108', '1', '9');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('109', '1', '10');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('110', '1', '11');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('111', '1', '12');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('112', '1', '13');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('113', '1', '14');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('114', '1', '15');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('115', '1', '17');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('116', '1', '18');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('117', '1', '19');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('118', '1', '20');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('119', '1', '21');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('120', '1', '22');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('121', '1', '23');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('122', '1', '24');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('123', '1', '25');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('124', '1', '26');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('125', '1', '27');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('126', '1', '28');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('127', '1', '29');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('128', '1', '34');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('129', '1', '30');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('130', '1', '31');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('131', '1', '33');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('132', '1', '32');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('147', '3', '17');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('148', '3', '22');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('149', '3', '30');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('150', '3', '31');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('151', '3', '33');
INSERT INTO `t_thinkingfruit_mall_role_permission` VALUES ('152', '3', '32');

-- ----------------------------
-- Table structure for t_thinkingfruit_mall_user
-- ----------------------------
DROP TABLE IF EXISTS `t_thinkingfruit_mall_user`;
CREATE TABLE `t_thinkingfruit_mall_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `nickname` varchar(16) DEFAULT NULL COMMENT '昵称',
  `loginName` varchar(16) DEFAULT NULL COMMENT '用户登录名称',
  `pswd` varchar(32) DEFAULT NULL COMMENT '用户登录密码',
  `sex` tinyint(1) DEFAULT '0' COMMENT '用户性别,0：男 1：女',
  `provName` varchar(12) DEFAULT NULL COMMENT '省',
  `cityName` varchar(12) DEFAULT NULL COMMENT '市',
  `townName` varchar(12) DEFAULT NULL COMMENT '区',
  `status` tinyint(1) DEFAULT '0' COMMENT '0：有效 1：无效',
  `roleId` int(8) DEFAULT NULL COMMENT '所属角色编号',
  `salt` varchar(64) DEFAULT NULL COMMENT '登录密码的随机加密秘钥',
  `lastTime` timestamp NULL DEFAULT NULL COMMENT '最后一次登录',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '最后一次更新时间',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '插入时间',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱地址',
  `loginOutTime` timestamp NULL DEFAULT NULL COMMENT '最后登出时间',
  `cityId` int(11) DEFAULT '0' COMMENT '城市的id',
  `provinceId` int(11) DEFAULT '0' COMMENT '省份id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thinkingfruit_mall_user
-- ----------------------------
INSERT INTO `t_thinkingfruit_mall_user` VALUES ('1', '超级管理员', 'admin', 'c2d63c2361ec6dcec37ba37911bb9feb', '0', '北京', '北京市', '东城区', '0', '1', '7b7b835de00939466df5e9375f294e92', null, null, '2018-06-26 09:06:50', '13636363636', 'xxx@xx.xxx', null, '0', '0');
INSERT INTO `t_thinkingfruit_mall_user` VALUES ('2', '薛', '薛', 'c2d63c2361ec6dcec37ba37911bb9feb', '0', '北京', '北京市', '东城区', '0', '3', '7b7b835de00939466df5e9375f294e92', null, null, '2018-07-14 17:42:49', '18257140424', '705805018@qq.com', null, '0', '0');
INSERT INTO `t_thinkingfruit_mall_user` VALUES ('3', '超级管理员', 'xue', 'c2d63c2361ec6dcec37ba37911bb9feb', '0', '北京', '北京市', '西城区', '0', '1', '7b7b835de00939466df5e9375f294e92', null, null, '2018-06-26 09:06:50', '13636363636', 'xxx@xx.xxx', null, '0', '0');

-- ----------------------------
-- Function structure for getChildrenList
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildrenList`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `getChildrenList`(`rootId` int) RETURNS varchar(1000) CHARSET utf8
BEGIN
	DECLARE sTemp VARCHAR(1000);
DECLARE sTempChd VARCHAR(1000);
 
 
SET sTemp = '$';
SET sTempChd =cast(rootId as CHAR);
 
 
WHILE sTempChd is not null DO
SET sTemp = concat(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM t_thinkingfruit_mall_member where FIND_IN_SET(inviterId,sTempChd)>0;
END WHILE;
RETURN sTemp;
END
;;
DELIMITER ;
