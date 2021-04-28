/*
SQLyog v10.2 
MySQL - 5.5.62 : Database - kaosi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kaosi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kaosi`;

/*Table structure for table `bumen` */

DROP TABLE IF EXISTS `bumen`;

CREATE TABLE `bumen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(111) NOT NULL,
  `roleid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `bumen` */

insert  into `bumen`(`id`,`bname`,`roleid`,`userid`) values (1,'运维',0,0),(2,'开发',0,0),(3,'测试',0,0),(4,'实施',0,0);

/*Table structure for table `ls_butten` */

DROP TABLE IF EXISTS `ls_butten`;

CREATE TABLE `ls_butten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `btntype` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `ls_butten` */

insert  into `ls_butten`(`id`,`btntype`) values (1,'<button type=\'button\' lay-event=\'delFunc\' class=\'layui-btn layui-btn-danger xz\'><i class=\'layui-icon\'>&#xe640;</i>删除</button>'),(2,'<button type=\'button\' lay-event=\'addFunc\' class=\'layui-btn layui-btn-warm xz\'><i class=\'layui-icon\'>&#xe654;</i>新增</button>'),(3,'<button type=\'button\' lay-event=\'upFunc\' class=\'layui-btn layui-btn-normal xz\'><i class=\'layui-icon\'>&#xe642;</i>修改</button>'),(4,'<button type=\'button\' lay-event=\'shangFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\'layui-icon\'>&#xe681;</i>上传</button>'),(5,'<button type=\'button\' lay-event=\'xiaFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\"layui-icon\">&#xe601;</i>下载</button>'),(6,'<button type=\'button\' lay-event=\'fenFunc\' class=\'layui-btn layui-btn-primary xz\'><i class=\'layui-icon\'>&#xe654;</i>分配</button>');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `fatherid` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `btn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `menu` */

insert  into `menu`(`id`,`mname`,`fatherid`,`type`,`url`,`btn`) values (1,'角色管理',15,2,'/BShenServlet?msg=SHen/She.jsp',NULL),(2,'用户管理',15,2,'/BtnServlet?user=BG/Yhu.jsp',NULL),(3,'权限管理',15,2,'/BCaiServlet?menu=menu/menuList.jsp',NULL),(8,'增加用戶',2,3,NULL,'<input class=\"layui-btn layui-btn-warm\" lay-event=\"addUser\" type=\"button\" value=\"员工增加\">'),(9,'用户修改',2,3,NULL,'<input class=\"layui-btn layui-btn-normal\" lay-event=\"upUser\" TYPE=\"button\" VALUE=\"用户修改\">'),(10,'用户删除',2,3,NULL,'<input class=\"layui-btn layui-btn-danger\" lay-event=\"delUser\"  TYPE=\"button\" VALUE=\"用户删除\">'),(11,'权限增加',3,3,NULL,'<input class=\"layui-btn layui-btn-warm\" lay-event=\"addMenu\" TYPE=\"button\" VALUE=\"权限增加\">'),(12,'权限修改',3,3,NULL,'<input class=\"layui-btn layui-btn-normal\" lay-event = \"upMenu\"  TYPE=\"button\" VALUE=\"权限修改\">'),(13,'权限删除',3,3,NULL,'<input class=\"layui-btn layui-btn-danger\" lay-event = \"delMenu\"  TYPE=\"button\" VALUE=\"权限删除\">'),(14,'分配权限',1,3,NULL,'<button TYPE=\"button\" lay-event=\"hairMenu\" class=\"layui-btn layui-btn-primary\"><i class=\"layui-icon\">&#xe654;</i>分配权限</button>'),(15,'后台权限',0,1,NULL,NULL),(16,'全新版本',15,2,'/BNewServlet?new=role/roleList.jsp',''),(17,'全新删除',16,3,NULL,'<input class=\"layui-btn layui-btn-danger\" lay-event = \"delRole\"  TYPE=\"button\" VALUE=\"全新删除\">');

/*Table structure for table `quanxian` */

DROP TABLE IF EXISTS `quanxian`;

CREATE TABLE `quanxian` (
  `qxid` int(11) NOT NULL COMMENT '权限id',
  `userid` int(11) NOT NULL COMMENT '用户id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `quanxian` */

insert  into `quanxian`(`qxid`,`userid`) values (1,2),(1,1),(1,3),(1,4),(1,5),(1,6),(1,16);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleName` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名称',
  `yonghuid` int(11) NOT NULL,
  `qxid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `role` */

insert  into `role`(`id`,`roleName`,`yonghuid`,`qxid`) values (1,'系统管理员',0,0),(2,'经理',0,0),(3,'普通员工',0,0);

/*Table structure for table `useryuangong` */

DROP TABLE IF EXISTS `useryuangong`;

CREATE TABLE `useryuangong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `contact` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系人姓名',
  `bumen` int(11) NOT NULL,
  `zhichengid` int(11) NOT NULL,
  `jueseid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sdx` (`bumen`),
  KEY `ds` (`zhichengid`),
  KEY `dsa` (`jueseid`),
  CONSTRAINT `ds` FOREIGN KEY (`zhichengid`) REFERENCES `zhicheng` (`id`),
  CONSTRAINT `dsa` FOREIGN KEY (`jueseid`) REFERENCES `role` (`id`),
  CONSTRAINT `sdx` FOREIGN KEY (`bumen`) REFERENCES `bumen` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `useryuangong` */

insert  into `useryuangong`(`id`,`contact`,`bumen`,`zhichengid`,`jueseid`) values (1,'王丽',1,1,1),(2,'张红丽',2,2,1),(3,'任志强',3,3,2),(4,'曹颖',4,4,2),(5,'李慧',3,5,3),(6,'王国强',1,6,3),(7,'das',1,2,3),(9,'3',3,4,3);

/*Table structure for table `yonghu` */

DROP TABLE IF EXISTS `yonghu`;

CREATE TABLE `yonghu` (
  `huid` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `jueseid` int(11) NOT NULL,
  PRIMARY KEY (`huid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `yonghu` */

insert  into `yonghu`(`huid`,`userName`,`password`,`jueseid`) values (1,'admin','111',1),(2,'1','555',0),(3,'田百里','333',0),(6,'fds','fds',0),(4,'田亿里','444',0),(5,'田一例','555',0);

/*Table structure for table `yongshu` */

DROP TABLE IF EXISTS `yongshu`;

CREATE TABLE `yongshu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `realname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `yongshu` */

insert  into `yongshu`(`id`,`uname`,`realname`,`sex`,`age`) values (1,'百里','大傻逼',1,2),(2,'大概的','4',1,4),(3,'1','1',1,1),(4,'1','1',1,1),(5,'阿道夫','大师傅',2,12);

/*Table structure for table `zhicheng` */

DROP TABLE IF EXISTS `zhicheng`;

CREATE TABLE `zhicheng` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户编码',
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zhicheng` */

insert  into `zhicheng`(`id`,`userCode`,`userid`,`roleid`) values (1,'组员',1,0),(2,'组长',2,0),(3,'经理',111,0),(4,'董事长',111,0),(5,'副经理',111,0),(6,'保安',111,0),(7,'保安队长',111,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
