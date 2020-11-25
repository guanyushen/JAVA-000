
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(64) NOT NULL  CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `mobile` varchar(32)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '手机号',
  `email` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '邮箱',
  `real_name` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '真名',
  `s_did` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '证件号',
  `did_type` varchar(16)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '证件类型',
  `is_business` int  COMMENT '是否为商家 1是 0不是',
  `address` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '用户/商家地址',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间', 
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE 
) ENGINE = InnoDB CHARACTER SET = utf8mb4;

   
-- ----------------------------
-- 商品表
-- ----------------------------
DROP TABLE IF EXISTS `good_info`;
CREATE TABLE `good_info`  (
  `good_id` varchar(64) NOT NULL CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品id',
  `good_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品名称',
  `good_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品类型',
  `good_num` int  COMMENT '商品数量',
  `good_status` int  COMMENT '商品状态 0正常 1下架 2删除',
  `good_price` decimal(12,2) COMMENT '商品单价',
  `good_desp` text  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '商品介绍',
  `image_url` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '商品图片',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间', 
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`good_id`) USING BTREE 
) ENGINE = InnoDB CHARACTER SET = utf8mb4;

 
-- ----------------------------
-- 订单表
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `order_id` varchar(64) NOT NULL CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单id',
  `order_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '唯一订单号',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '买家id',
  `good_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品id',
  `order_status` int  COMMENT '订单状态 0未支付 1已支付 2已发出 3已送达 4已评价', 
  `pay_amount` decimal(12,2) COMMENT '付款金额',
  `real_amount` decimal(12,2) COMMENT '真实付款金额',
  `payaccno` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '缴费账号(卡号)',
  `track_no` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '快递号',
  `remark` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '订单备注',
  `pay_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '付款时间', 
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间', 
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`good_id`) USING BTREE 
) ENGINE = InnoDB CHARACTER SET = utf8mb4;
 




