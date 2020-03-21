/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.24 : Database - mm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mm`;

/*Table structure for table `member_info_case` */

DROP TABLE IF EXISTS `member_info_case`;

CREATE TABLE `member_info_case` (
  `case_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用例编号',
  `test_team` varchar(32) DEFAULT NULL COMMENT '测试团队',
  `product` varchar(32) DEFAULT NULL COMMENT '项目所属的产品线',
  `env` tinyint(2) NOT NULL COMMENT '测试环境：1-7 测试环境、8 UAT 环境、9 预发布环境、0 生产环境',
  `host` varchar(32) NOT NULL COMMENT 'ip 和 port',
  `service_name` varchar(32) DEFAULT NULL COMMENT '接口所属的服务名',
  `request_mapping` varchar(128) DEFAULT NULL COMMENT '请求路径（工程路径）',
  `version` varchar(16) NOT NULL COMMENT '接口版本',
  `method` varchar(128) NOT NULL COMMENT '接口名称（方法名）',
  `parameters` varchar(255) DEFAULT NULL COMMENT '测试参数 json 格式',
  `response` varchar(255) DEFAULT NULL COMMENT '存放当前请求的响应报文',
  `secret_type` varchar(32) DEFAULT NULL COMMENT '加密类型（加密类型还没考虑好，是用 int 表示，如：0, 1, 2；还是用 varchar 直接定义，如：DES、RSA）',
  `key` varchar(255) DEFAULT NULL COMMENT '加密 key',
  `is_res_assert` tinyint(2) DEFAULT NULL COMMENT '是否断言响应结果：0 不做断言，1 做断言',
  `expected` varchar(255) DEFAULT NULL COMMENT '预期结果',
  `is_run` tinyint(2) NOT NULL COMMENT '是否执行：0 不执行、1 执行',
  `is_db_assert` tinyint(2) DEFAULT NULL COMMENT '是否断言业务数据库（如果判断数据库字段，则需要连接业务数据库，而不是用例数据库。还需要考虑 DB 断言的代码是写在测试程序里面，还是通过字段约定骨传值规则。）',
  `case_type` tinyint(2) DEFAULT NULL COMMENT '用例类型（扩展字段，暂时未考虑具体应用场景。）',
  `case_status` tinyint(2) DEFAULT NULL COMMENT '用例状态（扩展字段，暂时未考虑具体应用场景。）',
  `create_tester` varchar(16) NOT NULL COMMENT '用例创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `before_case` varchar(255) DEFAULT NULL COMMENT '测试用例前置依赖方法，如：内容为 null 表示不需要前置依赖；填写方法名，表示依赖当前这个方法。（如果某个接口，存在多个前置依赖接口，这种情况还未考虑。以后也可以尝试是否需要定义为数组。）',
  `after_case` varchar(255) DEFAULT NULL COMMENT '测试用例后置依赖方法，如：内容为 null 表示不需要后置依赖；填写方法名，表示依赖当前这个方法。',
  `description` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='测试用例表';

/*Data for the table `member_info_case` */

insert  into `member_info_case`(`case_id`,`test_team`,`product`,`env`,`host`,`service_name`,`request_mapping`,`version`,`method`,`parameters`,`response`,`secret_type`,`key`,`is_res_assert`,`expected`,`is_run`,`is_db_assert`,`case_type`,`case_status`,`create_tester`,`create_time`,`update_time`,`before_case`,`after_case`,`description`) values 
(1,'3','member',0,'http://localhost:1111/',NULL,NULL,'v3/','addMemberInfo','{\"actionDate\": \"2019-10-29T07:48:18.776Z\",\"actionFlag\": 0,\"age\": \"14\",\"appId\": \"10001\",\"enabled\": 1,\"id\": 0,\"memberId\": \"101\",\"mid\": \"12345678\",\"mobilePhone\": \"13466690000\",\"password\": \"111111\",\"sex\": 1,\"userName\": \"difeng\"}',NULL,'DES','0987654321',1,'success',1,NULL,1,1,'oeardi','2019-10-30 15:32:04','2019-10-30 15:32:02','1','1','description'),
(2,'3','member',1,'http://localhost:1111/',NULL,NULL,'v3/','findMemberInfoByAnyFieldReturnOne','{\"member_id\":\"10\"}',NULL,'DES','0987654321',1,'test1',1,NULL,1,1,'oeardi','2019-10-30 15:39:47','2019-10-30 15:39:52','addMemberInfo','delete','description'),
(3,'3','member',2,'http://localhost:1111/',NULL,NULL,'v3/','editMemberInfo','{\"actionDate\": \"2019-10-29T07:48:18.776Z\",\"actionFlag\": 1,\"age\": \"99\",\"appId\": \"10086\",\"enabled\": 0,\"id\": 0,\"memberId\": \"101\",\"mid\": \"88888888\",\"mobilePhone\": \"13400001111\",\"password\": \"666666\",\"sex\": 0,\"userName\": \"test007\"}',NULL,'DES','0987654321',1,'success',1,NULL,1,1,'oeardi','2019-10-30 17:37:19','2019-10-30 17:37:23','1','1','description'),
(4,'3','member',3,'http://localhost:1111/',NULL,NULL,'v3/','removeMemberInfoByAnyField','{\"member_id\":\"101\"}',NULL,'DES','0987654321',1,'success',1,NULL,1,1,'oeardi','2019-10-30 17:38:48','2019-10-30 17:38:50','1','1','description'),
(5,'3','member',4,'http://localhost:1111/',NULL,NULL,'v3/','findMemberInfoByAnyFieldReturnList','{\"sex\":\"1\"}',NULL,'RSA','1234567890',1,'difeng',1,NULL,1,1,'oeardi','2019-10-30 14:29:17','2019-10-30 14:29:19','1','1','description'),
(6,'3','member',5,'http://localhost:1111/',NULL,NULL,'v3/','addMemberInfo','{\"actionDate\": \"2019-10-29T07:48:18.776Z\",\"actionFlag\": 0,\"age\": \"14\",\"appId\": \"10001\",\"enabled\": 1,\"id\": 0,\"memberId\": \"102\",\"mid\": \"12345678\",\"mobilePhone\": \"13466690000\",\"password\": \"111111\",\"sex\": 1,\"userName\": \"difeng\"}',NULL,'RSA','1234567890',1,'success',1,NULL,1,1,'oeardi','2019-10-30 14:35:57','2019-10-30 14:36:00','1','1','description'),
(7,'3','member',5,'http://localhost:1111/',NULL,NULL,'v3/','addMemberInfo','{\"actionDate\": \"2019-10-29T07:48:18.776Z\",\"actionFlag\": 0,\"age\": \"14\",\"appId\": \"10001\",\"enabled\": 1,\"id\": 0,\"memberId\": \"103\",\"mid\": \"12345678\",\"mobilePhone\": \"13466690000\",\"password\": \"111111\",\"sex\": 1,\"userName\": \"difeng\"}',NULL,'RSA','1234567890',1,'success',1,NULL,1,1,'oeardi','2019-10-30 14:35:57','2019-10-30 14:36:00','1','1','description'),
(8,'3','member',4,'http://localhost:1111/',NULL,NULL,'v3/','editMemberInfo','{\"actionDate\": \"2019-10-29T07:48:18.776Z\",\"actionFlag\": 1,\"age\": \"99\",\"appId\": \"10086\",\"enabled\": 0,\"id\": 0,\"memberId\": \"102\",\"mid\": \"88888888\",\"mobilePhone\": \"13400001111\",\"password\": \"666666\",\"sex\": 0,\"userName\": \"test007\"}',NULL,'RSA','1234567890',1,'success',1,NULL,1,1,'oeardi','2019-10-30 14:29:17','2019-10-30 14:29:19','1','1','description'),
(9,'3','member',3,'http://localhost:1111/',NULL,NULL,'v3/','removeMemberInfoByAnyField','{\"member_id\":\"102\"}',NULL,'DES','0987654321',1,'success',1,NULL,1,1,'oeardi','2019-10-30 17:38:48','2019-10-30 17:38:50','1','1','description');

/*Table structure for table `t_member_info` */

DROP TABLE IF EXISTS `t_member_info`;

CREATE TABLE `t_member_info` (
  `member_id` tinyint(16) NOT NULL AUTO_INCREMENT COMMENT '主键：会员id',
  `member_name` varchar(32) DEFAULT NULL,
  `member_type` tinyint(2) DEFAULT NULL COMMENT '会员类型：0 一般会员，1 超级会员',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `age` tinyint(2) DEFAULT NULL COMMENT '会员年龄',
  `sex` tinyint(2) DEFAULT NULL,
  `mobile_phone` varchar(13) DEFAULT NULL COMMENT '手机号',
  `action_flag` tinyint(2) DEFAULT NULL COMMENT '行为操作：1 注册，2 登录 ，3 实名认证 ，4 修改密码 ，5 忘记密码',
  `action_date` datetime DEFAULT NULL COMMENT '行为操作时间',
  `app_id` varchar(8) DEFAULT NULL,
  `mid` varchar(16) NOT NULL COMMENT '统一会员号',
  `is_real` tinyint(2) DEFAULT NULL COMMENT '是否实名：0 未实名，1 已实名',
  `status` tinyint(2) DEFAULT NULL COMMENT '会员状态：0 不可用，1 可用',
  `business_id` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `MID` (`mid`),
  KEY `business_id` (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员信息表';

/*Data for the table `t_member_info` */

/*Table structure for table `t_member_real_info` */

DROP TABLE IF EXISTS `t_member_real_info`;

CREATE TABLE `t_member_real_info` (
  `real_auth_id` tinyint(16) NOT NULL AUTO_INCREMENT COMMENT '会员实名 id',
  `member_id` tinyint(16) DEFAULT NULL COMMENT '主键：会员id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '会员姓名',
  `mobile_phone` varchar(13) DEFAULT NULL COMMENT '手机号',
  `cert_num` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `bank_num` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `app_id` varchar(8) DEFAULT NULL,
  `mid` varchar(16) NOT NULL COMMENT '统一会员号',
  `status` tinyint(2) DEFAULT NULL COMMENT '会员状态：0 不可用，1 可用',
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`real_auth_id`),
  KEY `member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实名信息表';

/*Data for the table `t_member_real_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
