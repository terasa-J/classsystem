# Host: 127.0.0.1  (Version 5.5.15)
# Date: 2018-02-09 14:03:53
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `invitationCode` varchar(50) NOT NULL DEFAULT '' COMMENT '邀请码',
  `sirID` varchar(50) NOT NULL DEFAULT '' COMMENT '教师号 （外键）',
  `cname` varchar(100) NOT NULL DEFAULT '' COMMENT '课堂名字',
  `createTime` varchar(100) DEFAULT NULL COMMENT '创建时间',
  `courseID` varchar(50) NOT NULL DEFAULT '' COMMENT '课堂编号（主键）',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `courseID` (`courseID`),
  KEY `course_ibfk_1` (`sirID`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`sirID`) REFERENCES `teacher` (`sirID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='班级';

#
# Data for table "course"
#

INSERT INTO `course` VALUES (5,'VFAVQT','141542105','计算机网络Ⅱ','2018-01-26 16:22:00','5'),(6,'YOYTWQ','141542105','JAVA高级编程2','2018-01-27 12:04:22','2'),(7,'VEDCIH','141542105','数据库Oracle','2018-01-27 12:54:39','3'),(8,'AAAAAA','141542108','JAVA高级编程3','2018-01-28','1'),(11,'SBTTRE','141542105','软件测试','2018-01-30 21:59:30','10'),(12,'OTUWFB','141542105','大学语文','2018-02-06 16:44:23','80');

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL DEFAULT '' COMMENT '邮箱登录帐号',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `stuID` varchar(50) NOT NULL DEFAULT '' COMMENT '学号（主键）',
  `school` varchar(50) NOT NULL DEFAULT '广东金融学院' COMMENT '学校名字',
  `headImg` varchar(100) DEFAULT '' COMMENT '头像',
  `calssNo` varchar(50) DEFAULT NULL COMMENT '班级号（个人资料）',
  `major` varchar(100) DEFAULT NULL COMMENT '专业（个人资料）',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `stuID` (`stuID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='学生表';

#
# Data for table "student"
#

INSERT INTO `student` VALUES (5,'475890319@qq.com','6','叫','141542105','广东金融学院','upload_headImg/mmexport1516765654725.jpg','1415421','信息管理与信息系统'),(6,'475890319@qq.com','123','白色','141542106','广东金融学院',NULL,'1415421',NULL),(7,'475890319@qq.com','11111111','小明','141542101','广东金融学院',NULL,'1415421','电子商务'),(8,'475890319@qq.com','123456789','兔兔','141542107','广东金融学院','img/myself/head.png','1415421','信息管理与信息系统'),(9,'475890319@qq.com','66668888','图腾跑酷','141542110','广东金融学院','img/myself/head.png','1415421','信息管理与信息系统');

#
# Structure for table "student_course"
#

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` varchar(50) NOT NULL DEFAULT '' COMMENT '课堂编号（外键）',
  `stuID` varchar(50) NOT NULL DEFAULT '' COMMENT '学号（外键）',
  `attendTime` varchar(100) DEFAULT NULL COMMENT '加入时间',
  PRIMARY KEY (`Id`),
  KEY `student_course_ibfk_1` (`courseID`),
  KEY `student_course_ibfk_2` (`stuID`),
  CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`stuID`) REFERENCES `student` (`stuID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='学生加入课堂';

#
# Data for table "student_course"
#

INSERT INTO `student_course` VALUES (5,'2','141542105','2018-1-30'),(7,'5','141542105','2018-1-27'),(16,'1','141542105','2018-1-30'),(17,'3','141542105','2018-01-27 17:55:16'),(18,'2','141542101','2018-1-30'),(19,'2','141542106','2018-1-30'),(20,'80','141542105','2018-02-08 14:51:19');

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL DEFAULT '' COMMENT '邮箱登录帐号',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `sirID` varchar(50) NOT NULL DEFAULT '' COMMENT '教师号（主键）',
  `school` varchar(50) NOT NULL DEFAULT '广东金融学院' COMMENT '学校名字',
  `headImg` varchar(100) DEFAULT '' COMMENT '头像',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `sirID` (`sirID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='教师表';

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES (1,'475890319@qq.com','6','江大嫂','141542105','广东金融学院','upload_headImg/01.jpg'),(2,'475890319@qq.com','6','江大妹','141542108','广东金融学院','');

#
# Structure for table "notice"
#

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `noticeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sirID` varchar(50) NOT NULL DEFAULT '' COMMENT '教师号（外键）',
  `createTime` varchar(50) NOT NULL DEFAULT '' COMMENT '发布时间',
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '公告标题',
  `content` varchar(254) NOT NULL DEFAULT '' COMMENT '公告内容',
  `courseID` varchar(255) NOT NULL DEFAULT '' COMMENT '课程ID',
  PRIMARY KEY (`noticeID`),
  KEY `notice_ibfk_1` (`sirID`),
  KEY `notice_ibfk_2` (`courseID`),
  CONSTRAINT `notice_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`sirID`) REFERENCES `teacher` (`sirID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='教师公告';

#
# Data for table "notice"
#

INSERT INTO `notice` VALUES (3,'141542105','2018-02-03','停课通知','明天不用上课！','5'),(7,'141542105','2018-02-04 12:45:50','你好','123456','5'),(10,'141542105','2018-02-04 12:54:00','随便','testsssss所得税等第三方的手','5'),(13,'141542105','2018-02-06 15:21:30','看看','就看看','5'),(14,'141542105','2018-02-06 15:21:49','就看看','去啦','5'),(16,'141542105','2018-02-06 16:20:28','拉锯','路路通','5'),(17,'141542105','2018-02-06 16:42:57','第2周实验报告','新的实验报告已发到课程平台，请同学们务必按规定完成','3');

#
# Structure for table "attendance"
#

DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `attendanceID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sirID` varchar(50) NOT NULL DEFAULT '' COMMENT '教师号（外键）',
  `createTime` varchar(100) NOT NULL DEFAULT '' COMMENT '创建时间',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '考勤名称',
  `actualNumber` int(11) NOT NULL DEFAULT '0' COMMENT '应到考勤人数',
  `attendanceCode` varchar(50) DEFAULT '' COMMENT '考勤数字码',
  `courseID` varchar(50) NOT NULL DEFAULT '' COMMENT '课程ID',
  PRIMARY KEY (`attendanceID`),
  KEY `attendance_ibfk_2` (`courseID`),
  KEY `attendance_ibfk_1` (`sirID`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`sirID`) REFERENCES `teacher` (`sirID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='考勤表';

#
# Data for table "attendance"
#

INSERT INTO `attendance` VALUES (1,'141542105','2018','哈哈',52,'0101','1'),(6,'141542105','2018-01-29 18:49:56','第一周考勤',12,NULL,'3'),(7,'141542105','2018-01-29 18:57:54','JAVA考勤2',12,NULL,'2'),(8,'141542105','2018-01-30 13:26:09','JAVA考勤',52,NULL,'2'),(12,'141542105','2018-01-31 14:28:45','JAVA考勤5',5,NULL,'2'),(16,'141542105','2018-01-31 15:23:36','垃圾桶',15,NULL,'5'),(17,'141542105','2018-01-31 15:44:57','计网又考勤',13,NULL,'5'),(18,'141542105','2018-01-31 16:05:09','计网来了哈哈哈',33,NULL,'5'),(19,'141542105','2018-02-01 15:33:08','2018-02-01 Java考勤',8,NULL,'2'),(20,'141542105','2018-02-01 15:48:02','最新',25,NULL,'2'),(21,'141542105','2018-02-01 15:50:11','new',25,NULL,'2'),(22,'141542105','2018-02-01 16:16:06','忽悠忽悠萌萌哒',6,NULL,'5'),(28,'141542105','2018-02-06 16:18:43','他又',2,NULL,'5'),(29,'141542105','2018-02-06 16:39:58','第二周考勤',52,NULL,'3'),(30,'141542105','2018-02-08 14:53:26','第一周',2,NULL,'80');

#
# Structure for table "stu_attendance"
#

DROP TABLE IF EXISTS `stu_attendance`;
CREATE TABLE `stu_attendance` (
  `stuAttendID` int(11) NOT NULL AUTO_INCREMENT,
  `stuID` varchar(50) NOT NULL DEFAULT '' COMMENT '学号（外键）',
  `attendanceID` int(11) NOT NULL DEFAULT '0' COMMENT '考勤表（外键）',
  `attendanceCode` varchar(50) NOT NULL DEFAULT '' COMMENT '考勤数字码',
  `location` varchar(255) NOT NULL DEFAULT '' COMMENT '学生定位',
  `attendTime` varchar(100) DEFAULT NULL COMMENT '考勤时间',
  PRIMARY KEY (`stuAttendID`),
  KEY `stu_attendance_ibfk_2` (`attendanceID`),
  KEY `stu_attendance_ibfk_1` (`stuID`),
  CONSTRAINT `stu_attendance_ibfk_1` FOREIGN KEY (`stuID`) REFERENCES `student` (`stuID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_attendance_ibfk_2` FOREIGN KEY (`attendanceID`) REFERENCES `attendance` (`attendanceID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='学生考勤';

#
# Data for table "stu_attendance"
#

INSERT INTO `stu_attendance` VALUES (1,'141542105',8,'5224','北滘','2010-01-3'),(2,'141542101',8,'5224','北苑','2018-02-01'),(3,'141542105',7,'0101','mhmh','2018'),(4,'141542105',16,'2221','25','2018'),(5,'141542105',21,'1930','广东省深圳市福田区南园街道赤尾村京基御景华城','2018-02-01 15:50:30'),(6,'141542105',21,'1930','广东省深圳市福田区南园街道赤尾村京基御景华城','2018-02-01 15:51:03'),(8,'141542105',22,'5667','广东省深圳市福田区南园街道赤尾村京基御景华城','2018-02-01 16:21:31'),(9,'141542105',22,'5667','广东省深圳市福田区南园街道赤尾村京基御景华城','2018-02-01 16:23:15'),(14,'141542105',30,'6220','广东省佛山市顺德区北滘镇林港路18号','2018-02-08 14:55:16');
