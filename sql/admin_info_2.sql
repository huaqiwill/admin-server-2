/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : admin_info_2

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 15/06/2024 18:06:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_country
-- ----------------------------
DROP TABLE IF EXISTS `u_country`;
CREATE TABLE `u_country`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` bigint(20) NOT NULL DEFAULT 0 COMMENT '国家编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '国家名称',
  `port_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '港口名称',
  `is_trader` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '是否贸易国',
  `status` tinyint(4) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '国家' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_country
-- ----------------------------
INSERT INTO `u_country` VALUES (1, 1001, '中国', '辽宁省大连港', '否', 1);
INSERT INTO `u_country` VALUES (3, 2001, '澳大利亚', 'Aotyu', '是', 1);
INSERT INTO `u_country` VALUES (4, 2002, '美国', 'USAauro', '是', 1);
INSERT INTO `u_country` VALUES (5, 2003, '韩国', 'Hanaro', '是', 1);
INSERT INTO `u_country` VALUES (8, 12, '德国', '', '是', 1);
INSERT INTO `u_country` VALUES (9, 1, '中国1', '', '否', 0);

-- ----------------------------
-- Table structure for u_country_find
-- ----------------------------
DROP TABLE IF EXISTS `u_country_find`;
CREATE TABLE `u_country_find`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `organ_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '生物名称',
  `country_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '国家名称',
  `found_time` date NOT NULL COMMENT '发现时间',
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '国家发现' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_country_find
-- ----------------------------
INSERT INTO `u_country_find` VALUES (1, '链状裸甲藻', '澳大利亚', '2011-09-23', '66.8778', '117.9878');
INSERT INTO `u_country_find` VALUES (2, 'Gymnodiniu', '韩国', '2001-03-24', '34.8765', '88.7656');
INSERT INTO `u_country_find` VALUES (3, '链状裸甲藻', '美国', '1987-08-12', '67.5646', '110.6578');
INSERT INTO `u_country_find` VALUES (4, 'Gymnodiniu', '澳大利亚', '1987-04-03', '65.7689', '116.5684');
INSERT INTO `u_country_find` VALUES (5, '1', '1', '2024-06-12', '0', '0');
INSERT INTO `u_country_find` VALUES (6, '121', '2', '2024-06-25', '12', '12');
INSERT INTO `u_country_find` VALUES (7, '12', '12', '2024-06-11', '12', '12');
INSERT INTO `u_country_find` VALUES (8, '1', '1', '2024-06-20', '1', '1');

-- ----------------------------
-- Table structure for u_local_organ
-- ----------------------------
DROP TABLE IF EXISTS `u_local_organ`;
CREATE TABLE `u_local_organ`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` bigint(20) NOT NULL DEFAULT 0 COMMENT '生物编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '生物名称',
  `men` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '生物门属',
  `found_time` date NOT NULL COMMENT '发现时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '本国生物' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_local_organ
-- ----------------------------
INSERT INTO `u_local_organ` VALUES (1, 1001, '微囊藻', '蓝藻门', '1654-07-05');
INSERT INTO `u_local_organ` VALUES (2, 10002, '色球藻', '蓝藻门', '1911-02-08');
INSERT INTO `u_local_organ` VALUES (3, 10003, '平裂藻', '蓝藻门', '1845-09-22');
INSERT INTO `u_local_organ` VALUES (4, 10004, '尖细颤藻', '蓝藻门', '1912-01-03');
INSERT INTO `u_local_organ` VALUES (5, 10005, '巨颤藻', '蓝藻门', '1934-09-08');
INSERT INTO `u_local_organ` VALUES (6, 10006, '束丝藻', '蓝藻门', '1898-10-03');
INSERT INTO `u_local_organ` VALUES (7, 20001, '单角盘星藻', '绿藻门', '1912-09-30');
INSERT INTO `u_local_organ` VALUES (8, 20002, '二角盘星藻', '绿藻门', '1875-08-07');
INSERT INTO `u_local_organ` VALUES (9, 20003, '绿球藻', '绿藻门', '1876-09-09');
INSERT INTO `u_local_organ` VALUES (10, 20004, '集星藻', '绿藻门', '1872-07-01');
INSERT INTO `u_local_organ` VALUES (11, 20005, '镰形纤维藻', '绿藻门', '1987-09-02');
INSERT INTO `u_local_organ` VALUES (12, 50002, '倒卵隐藻', '隐藻门', '1877-09-25');
INSERT INTO `u_local_organ` VALUES (13, 50001, '隐藻', '隐藻门', '1809-09-06');
INSERT INTO `u_local_organ` VALUES (14, 40001, '多甲藻', '甲藻门', '1801-08-23');
INSERT INTO `u_local_organ` VALUES (15, 30003, '异极藻', '硅藻门', '1987-09-11');
INSERT INTO `u_local_organ` VALUES (16, 30002, '小环藻', '硅藻门', '1901-02-04');
INSERT INTO `u_local_organ` VALUES (17, 30001, '海链藻', '硅藻门', '1900-04-05');
INSERT INTO `u_local_organ` VALUES (18, 60001, '裸藻', '裸藻门', '1872-07-06');
INSERT INTO `u_local_organ` VALUES (19, 60002, '扁裸藻', '裸藻门', '1811-06-04');
INSERT INTO `u_local_organ` VALUES (20, 70001, '黄管藻', '黄藻门', '1734-07-06');
INSERT INTO `u_local_organ` VALUES (21, 30004, '洛氏角毛藻', '硅藻门', '1786-09-11');
INSERT INTO `u_local_organ` VALUES (22, 30005, '尺骨针杆藻', '硅藻门', '1754-04-23');
INSERT INTO `u_local_organ` VALUES (23, 30006, '蜂腰双壁藻', '硅藻门', '1765-09-12');
INSERT INTO `u_local_organ` VALUES (24, 30007, '圆筛藻', '硅藻门', '1634-04-03');
INSERT INTO `u_local_organ` VALUES (25, 30008, '中心圆筛藻', '硅藻门', '1878-06-23');
INSERT INTO `u_local_organ` VALUES (26, 40002, '梭甲藻', '甲藻门', '1886-09-08');
INSERT INTO `u_local_organ` VALUES (27, 40003, '三角角藻', '甲藻门', '1776-09-01');
INSERT INTO `u_local_organ` VALUES (28, 40004, '大角角藻', '甲藻门', '1988-09-03');
INSERT INTO `u_local_organ` VALUES (29, 40005, '冈比甲藻', '甲藻门', '1787-07-12');
INSERT INTO `u_local_organ` VALUES (30, 40006, '具尾鳍藻', '甲藻门', '1886-09-13');
INSERT INTO `u_local_organ` VALUES (31, 20006, '小球藻', '绿藻门', '1765-09-05');
INSERT INTO `u_local_organ` VALUES (32, 20007, '栅列藻', '绿藻门', '1965-03-02');
INSERT INTO `u_local_organ` VALUES (33, 10007, '棕眉藻', '蓝藻门', '1675-05-13');
INSERT INTO `u_local_organ` VALUES (34, 10008, '颤藻', '蓝藻门', '1913-03-15');
INSERT INTO `u_local_organ` VALUES (35, 60003, '眼虫藻', '裸藻门', '1965-08-17');
INSERT INTO `u_local_organ` VALUES (36, 12, '12', '12', '2024-06-13');
INSERT INTO `u_local_organ` VALUES (37, 12, '12', '12', '2024-05-28');
INSERT INTO `u_local_organ` VALUES (38, 12, '12', '12', '2024-06-18');
INSERT INTO `u_local_organ` VALUES (39, 12, '12', '12', '2024-06-18');
INSERT INTO `u_local_organ` VALUES (40, 2, '2', '2', '2024-06-20');
INSERT INTO `u_local_organ` VALUES (41, 1, '1', '1', '2024-06-17');
INSERT INTO `u_local_organ` VALUES (42, 12, '12', '12', '2024-06-17');
INSERT INTO `u_local_organ` VALUES (43, 1, '2', '1', '2024-06-13');
INSERT INTO `u_local_organ` VALUES (44, 1, '2', '3', '2024-06-13');

-- ----------------------------
-- Table structure for u_men
-- ----------------------------
DROP TABLE IF EXISTS `u_men`;
CREATE TABLE `u_men`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` bigint(20) NOT NULL DEFAULT 0 COMMENT '门编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '1' COMMENT '门名称',
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '门' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_men
-- ----------------------------
INSERT INTO `u_men` VALUES (1, 1, '蓝藻门', 1);
INSERT INTO `u_men` VALUES (2, 2, '绿藻门', 1);
INSERT INTO `u_men` VALUES (3, 3, '硅藻门', 1);
INSERT INTO `u_men` VALUES (4, 4, '甲藻门', 1);
INSERT INTO `u_men` VALUES (5, 5, '隐藻门', 1);
INSERT INTO `u_men` VALUES (6, 6, '裸藻门', 1);
INSERT INTO `u_men` VALUES (7, 7, '黄藻门', 1);
INSERT INTO `u_men` VALUES (8, 12, '12', NULL);
INSERT INTO `u_men` VALUES (9, 1, '1', NULL);

-- ----------------------------
-- Table structure for u_port
-- ----------------------------
DROP TABLE IF EXISTS `u_port`;
CREATE TABLE `u_port`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` bigint(20) NOT NULL DEFAULT 0 COMMENT '港口编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '港口名称',
  `country_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '所在国家',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '省份',
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '港口' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_port
-- ----------------------------
INSERT INTO `u_port` VALUES (1, 12101, '辽宁省大连港', '美国', '辽宁省', 1);
INSERT INTO `u_port` VALUES (2, 12102, '辽宁省丹东港', '美国', '辽宁省', 1);
INSERT INTO `u_port` VALUES (3, 12201, 'USAauro', '中国', ' ', 1);
INSERT INTO `u_port` VALUES (4, 12202, 'Hanaro', '美国', '  ', 1);
INSERT INTO `u_port` VALUES (5, 12203, 'Aotyu', '中国', ' ', 1);
INSERT INTO `u_port` VALUES (6, 12103, '上海港', '中国', '上海市', 1);
INSERT INTO `u_port` VALUES (7, 12104, '青岛港', '中国', '山东省', 1);
INSERT INTO `u_port` VALUES (8, 23, '23', '23', '23', 1);
INSERT INTO `u_port` VALUES (9, 1, '1', '1', '1', 1);

-- ----------------------------
-- Table structure for u_port_find
-- ----------------------------
DROP TABLE IF EXISTS `u_port_find`;
CREATE TABLE `u_port_find`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `organ_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '生物名称',
  `port_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '港口名称',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '省份',
  `superior_species` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '优势物种',
  `abundance` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '丰度',
  `abundance_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '丰度百分比',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '港口调查' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_port_find
-- ----------------------------
INSERT INTO `u_port_find` VALUES (1, '微囊藻', '辽宁省大连港', '辽宁省', '微囊藻', '112.4', '60.23');
INSERT INTO `u_port_find` VALUES (2, '单角盘星藻', '辽宁省大连港', '辽宁省', '微囊藻', '23.6', '12.2');
INSERT INTO `u_port_find` VALUES (3, '色球藻', '辽宁省大连港', '辽宁省', '微囊藻', '13.1', '6.56');
INSERT INTO `u_port_find` VALUES (4, '洛氏角毛藻', '辽宁省丹东港', '辽宁省', '小球藻', '23.4', '15.6');
INSERT INTO `u_port_find` VALUES (5, '小球藻', '辽宁省丹东港', '辽宁省', '小球藻', '23.65', '56.34');
INSERT INTO `u_port_find` VALUES (6, '梭甲藻', '辽宁省丹东港', '辽宁省', '小球藻', '15.4', '3.24');
INSERT INTO `u_port_find` VALUES (7, '巨颤藻', '上海港', '上海市', '巨颤藻', '123.45', '22.03');
INSERT INTO `u_port_find` VALUES (8, '束丝藻', '青岛港', '山东省', '束丝藻', '67.9', '23.8');
INSERT INTO `u_port_find` VALUES (9, '集星藻', '上海港', '上海市', '巨颤藻', '12.11', '9.98');
INSERT INTO `u_port_find` VALUES (10, '衣藻', '上海港', '上海市', '巨颤藻', '12.11', '10.11');
INSERT INTO `u_port_find` VALUES (11, '卵形藻', '青岛港', '山东省', '束丝藻', '34.12', '20.1');
INSERT INTO `u_port_find` VALUES (12, '异极藻', '青岛港', '山东省', '束丝藻', '67.98', '16.7');
INSERT INTO `u_port_find` VALUES (13, '12', '12', '12', '12', '10', '10');
INSERT INTO `u_port_find` VALUES (14, '12', '12', '12', '12', '12', '12');
INSERT INTO `u_port_find` VALUES (15, '23', '23', '23', '23', '23', '23');
INSERT INTO `u_port_find` VALUES (16, '23', '23', '23', '23', '23', '23');

-- ----------------------------
-- Table structure for u_trade_organ
-- ----------------------------
DROP TABLE IF EXISTS `u_trade_organ`;
CREATE TABLE `u_trade_organ`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` bigint(20) NOT NULL DEFAULT 0 COMMENT '生物编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '生物名称',
  `men` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '门',
  `gang` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '纲',
  `environment` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '生存环境',
  `shape` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '形态',
  `harm` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '危害性',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '相关贸易国生物' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_trade_organ
-- ----------------------------
INSERT INTO `u_trade_organ` VALUES (1, 101, '链状裸甲藻', '甲藻门', '甲藻纲', '河口，海湾', '营养细胞长30-50μm宽23-38μm。细胞可形成长达16个细胞的链，通常成4-8个细胞的链。\r\n', '链状裸甲藻产生麻痹性贝类毒素（PSP毒素），贝类食用该藻后产生毒素，引起食用者中毒，严重者呼吸困难，');
INSERT INTO `u_trade_organ` VALUES (2, 102, 'Gymnodiniu', '甲藻门', '甲藻纲', '湿度较大的地方', '细胞形态多变，通常是卵形或椭圆形（有些小的细胞是双锥形），长14 μm-47 μm，宽11 μm-4', '这个种最开始被发现于美国马萨诸塞州伍兹霍尔地区的小海湾中，后来逐渐成为北温带水域中常见的藻华原因种，');
INSERT INTO `u_trade_organ` VALUES (3, 23, '23', '23', '23', '23', '23', '23');
INSERT INTO `u_trade_organ` VALUES (4, 231, '231', '231', '231', '231', '231', '231');
INSERT INTO `u_trade_organ` VALUES (5, 231, '231', '231', '231', '231', '231', '231');
INSERT INTO `u_trade_organ` VALUES (6, 12, '12', '12', '12', '12', '12', '12');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话号码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色、1：管理员 2：普通用户',
  `token` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 'admin', '123456', '管理员', '18321299982', '男', '宁波大学甬江公寓2号楼428', 'admin', NULL);
INSERT INTO `user` VALUES (13, '2656454', '123456', '裘斯与', '12313282823', '男', '宁波大学甬江公寓1号楼321室', 'user1', NULL);
INSERT INTO `user` VALUES (14, '123456', '123456', '王翀', '15321255432', '男', '宁波大学北区学生二村222室', 'user1', NULL);
INSERT INTO `user` VALUES (15, '542212', '12345', '邱思宇', NULL, NULL, NULL, 'user1', NULL);
INSERT INTO `user` VALUES (16, '12345', '12345', '苏梦宇', '13213232989', '男', '宁波大学', 'user1', NULL);
INSERT INTO `user` VALUES (17, '张飞', 'sugeyu', '张飞', '10086', '男', '三国演义', 'user1', NULL);
INSERT INTO `user` VALUES (18, '刘备', '123456', '刘备', '10086', '男', '三国演义', 'user1', NULL);
INSERT INTO `user` VALUES (20, '用户名', '123456', '1212', '1212', '男', '1212', 'user1', NULL);
INSERT INTO `user` VALUES (21, NULL, '123456', NULL, NULL, NULL, NULL, 'user1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
