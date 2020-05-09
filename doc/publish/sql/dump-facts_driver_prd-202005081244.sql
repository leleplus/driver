-- MySQL dump 10.13  Distrib 5.7.29, for Win64 (x86_64)
--
-- Host: www.leleplus.fun    Database: facts_driver_prd
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `QRTZ_BLOB_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_BLOB_TRIGGERS`
--

LOCK TABLES `QRTZ_BLOB_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_BLOB_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_BLOB_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_CALENDARS`
--

DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_CALENDARS` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_CALENDARS`
--

LOCK TABLES `QRTZ_CALENDARS` WRITE;
/*!40000 ALTER TABLE `QRTZ_CALENDARS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_CALENDARS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_CRON_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_CRON_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_CRON_TRIGGERS`
--

LOCK TABLES `QRTZ_CRON_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_CRON_TRIGGERS` DISABLE KEYS */;
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('DriverScheduler','TASK_CLASS_NAME1','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('DriverScheduler','TASK_CLASS_NAME2','DEFAULT','0/15 * * * * ?','Asia/Shanghai'),('DriverScheduler','TASK_CLASS_NAME3','DEFAULT','0/20 * * * * ?','Asia/Shanghai');
/*!40000 ALTER TABLE `QRTZ_CRON_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_FIRED_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_FIRED_TRIGGERS`
--

LOCK TABLES `QRTZ_FIRED_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_FIRED_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_FIRED_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_JOB_DETAILS`
--

DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_JOB_DETAILS` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_JOB_DETAILS`
--

LOCK TABLES `QRTZ_JOB_DETAILS` WRITE;
/*!40000 ALTER TABLE `QRTZ_JOB_DETAILS` DISABLE KEYS */;
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('DriverScheduler','TASK_CLASS_NAME1','DEFAULT',NULL,'com.leleplus.common.utils.job.QuartzDisallowConcurrentExecution','0','1','0','0',_binary '�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0*com.leleplus.project.monitor.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.leleplus.core.web.domain.BaseEntity\0\0\0\0\0\0\0\0L\0	beginTimeq\0~\0	L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0	dataScopeq\0~\0	L\0endTimeq\0~\0	L\0idq\0~\0\n[\0idst\0[Ljava/lang/Long;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,\�)\�xpppppt\0\0pppt\01t\00/10 * * * * ?t\0ryTask.ryNoParamst\0DEFAULTsr\0java.lang.Long;�\�̏#\�\0J\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0\0\0\0\0t\0系统默认（无参）t\03t\01x\0'),('DriverScheduler','TASK_CLASS_NAME2','DEFAULT',NULL,'com.leleplus.common.utils.job.QuartzDisallowConcurrentExecution','0','1','0','0',_binary '�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0*com.leleplus.project.monitor.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.leleplus.core.web.domain.BaseEntity\0\0\0\0\0\0\0\0L\0	beginTimeq\0~\0	L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0	dataScopeq\0~\0	L\0endTimeq\0~\0	L\0idq\0~\0\n[\0idst\0[Ljava/lang/Long;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,\�)\�xpppppt\0\0pppt\01t\00/15 * * * * ?t\0ryTask.ryParams(\'ry\')t\0DEFAULTsr\0java.lang.Long;�\�̏#\�\0J\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0\0\0\0\0t\0系统默认（有参）t\03t\01x\0'),('DriverScheduler','TASK_CLASS_NAME3','DEFAULT',NULL,'com.leleplus.common.utils.job.QuartzDisallowConcurrentExecution','0','1','0','0',_binary '�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0*com.leleplus.project.monitor.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.leleplus.core.web.domain.BaseEntity\0\0\0\0\0\0\0\0L\0	beginTimeq\0~\0	L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0	dataScopeq\0~\0	L\0endTimeq\0~\0	L\0idq\0~\0\n[\0idst\0[Ljava/lang/Long;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,\�)\�xpppppt\0\0pppt\01t\00/20 * * * * ?t\08ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)t\0DEFAULTsr\0java.lang.Long;�\�̏#\�\0J\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0\0\0\0\0t\0系统默认（多参）t\03t\01x\0');
/*!40000 ALTER TABLE `QRTZ_JOB_DETAILS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_LOCKS`
--

DROP TABLE IF EXISTS `QRTZ_LOCKS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_LOCKS` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_LOCKS`
--

LOCK TABLES `QRTZ_LOCKS` WRITE;
/*!40000 ALTER TABLE `QRTZ_LOCKS` DISABLE KEYS */;
INSERT INTO `QRTZ_LOCKS` VALUES ('DriverScheduler','STATE_ACCESS'),('DriverScheduler','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `QRTZ_LOCKS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_PAUSED_TRIGGER_GRPS`
--

DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_PAUSED_TRIGGER_GRPS`
--

LOCK TABLES `QRTZ_PAUSED_TRIGGER_GRPS` WRITE;
/*!40000 ALTER TABLE `QRTZ_PAUSED_TRIGGER_GRPS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_PAUSED_TRIGGER_GRPS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_SCHEDULER_STATE`
--

DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SCHEDULER_STATE` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_SCHEDULER_STATE`
--

LOCK TABLES `QRTZ_SCHEDULER_STATE` WRITE;
/*!40000 ALTER TABLE `QRTZ_SCHEDULER_STATE` DISABLE KEYS */;
INSERT INTO `QRTZ_SCHEDULER_STATE` VALUES ('DriverScheduler','localhost1588594195269',1588913068619,15000);
/*!40000 ALTER TABLE `QRTZ_SCHEDULER_STATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_SIMPLE_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_SIMPLE_TRIGGERS`
--

LOCK TABLES `QRTZ_SIMPLE_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_SIMPLE_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_SIMPLE_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_SIMPROP_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_SIMPROP_TRIGGERS`
--

LOCK TABLES `QRTZ_SIMPROP_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_SIMPROP_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_SIMPROP_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_TRIGGERS` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `QRTZ_JOB_DETAILS` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_TRIGGERS`
--

LOCK TABLES `QRTZ_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_TRIGGERS` DISABLE KEYS */;
INSERT INTO `QRTZ_TRIGGERS` VALUES ('DriverScheduler','TASK_CLASS_NAME1','DEFAULT','TASK_CLASS_NAME1','DEFAULT',NULL,1588594200000,-1,5,'PAUSED','CRON',1588594199000,0,NULL,2,''),('DriverScheduler','TASK_CLASS_NAME2','DEFAULT','TASK_CLASS_NAME2','DEFAULT',NULL,1588594200000,-1,5,'PAUSED','CRON',1588594199000,0,NULL,2,''),('DriverScheduler','TASK_CLASS_NAME3','DEFAULT','TASK_CLASS_NAME3','DEFAULT',NULL,1588594200000,-1,5,'PAUSED','CRON',1588594199000,0,NULL,2,'');
/*!40000 ALTER TABLE `QRTZ_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `achievement` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `user_info_id` bigint(255) NOT NULL COMMENT '用户信息表主键',
  `subject` varchar(50) DEFAULT NULL COMMENT '考试科目',
  `score` varchar(20) DEFAULT NULL COMMENT '成绩',
  `is_pass` tinyint(2) DEFAULT NULL COMMENT '是否合格（1，合格 0，不合格）',
  `type` varchar(64) DEFAULT '' COMMENT '考试类型',
  `exam_time` datetime DEFAULT NULL COMMENT '考试时间',
  `exam_room` varchar(64) DEFAULT '' COMMENT '考场',
  `device_no` varchar(64) DEFAULT '' COMMENT '设备机器号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `achievement_fk` (`user_info_id`),
  CONSTRAINT `achievement_fk` FOREIGN KEY (`user_info_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment_record`
--

DROP TABLE IF EXISTS `appointment_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment_record` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `user_info_id` bigint(255) NOT NULL COMMENT '预约人',
  `reservation_begin_time` datetime DEFAULT NULL COMMENT '预约开始时间',
  `reservation_end_time` datetime DEFAULT NULL COMMENT '预约结束时间',
  `subject` varchar(50) DEFAULT NULL COMMENT '预约科目',
  `details` varchar(500) DEFAULT NULL COMMENT '预约详细信息',
  `status` varchar(50) DEFAULT NULL COMMENT '预约状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `appointment_record_fk` (`user_info_id`),
  CONSTRAINT `appointment_record_fk` FOREIGN KEY (`user_info_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_record`
--

LOCK TABLES `appointment_record` WRITE;
/*!40000 ALTER TABLE `appointment_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coach_car`
--

DROP TABLE IF EXISTS `coach_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coach_car` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `number_plate` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `model` varchar(500) DEFAULT NULL COMMENT '车辆型号',
  `width` varchar(50) DEFAULT NULL COMMENT '宽度',
  `hight` varchar(50) DEFAULT NULL COMMENT '高度',
  `length` varchar(50) DEFAULT NULL COMMENT '车长',
  `color` varchar(50) DEFAULT NULL COMMENT '车辆颜色',
  `purchase_date` datetime DEFAULT NULL COMMENT '购买日期',
  `price` varchar(50) DEFAULT NULL COMMENT '价格',
  `is_valid` tinyint(2) DEFAULT NULL COMMENT '数据是否有效',
  `deleted` tinyint(2) DEFAULT NULL COMMENT '删除标志',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教练车信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coach_car`
--

LOCK TABLES `coach_car` WRITE;
/*!40000 ALTER TABLE `coach_car` DISABLE KEYS */;
/*!40000 ALTER TABLE `coach_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coach_car_association`
--

DROP TABLE IF EXISTS `coach_car_association`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coach_car_association` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `coach_id` bigint(255) NOT NULL COMMENT '教练id',
  `car_id` bigint(255) NOT NULL COMMENT '车id',
  `deleted` tinyint(2) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `coach_car_association_fk` (`car_id`),
  KEY `coach_car_association_fk_1` (`coach_id`),
  CONSTRAINT `coach_car_association_fk` FOREIGN KEY (`car_id`) REFERENCES `coach_car` (`id`),
  CONSTRAINT `coach_car_association_fk_1` FOREIGN KEY (`coach_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教练教练车关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coach_car_association`
--

LOCK TABLES `coach_car_association` WRITE;
/*!40000 ALTER TABLE `coach_car_association` DISABLE KEYS */;
/*!40000 ALTER TABLE `coach_car_association` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_license`
--

DROP TABLE IF EXISTS `driver_license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver_license` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(64) DEFAULT '' COMMENT '驾驶证代号',
  `allow_car_type` varchar(64) DEFAULT '' COMMENT '准假车型',
  `other_types` varchar(64) DEFAULT '' COMMENT '准予驾驶的其他车辆',
  `deleted` tinyint(2) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COMMENT='驾驶证类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_license`
--

LOCK TABLES `driver_license` WRITE;
/*!40000 ALTER TABLE `driver_license` DISABLE KEYS */;
INSERT INTO `driver_license` VALUES (33,'A1','大型载客汽车','A3、B1、B2、C1、C2、C3、C4、M',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(34,'A2','重型、中型全挂、半挂汽车列车','B1、B2、C1、C2、C3、C4、M',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(35,'A3','核载10人以上的城市公共汽车','C1、C2、C3、C4',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(36,'B1','中型载客汽车(含核载10人以上、19人以下的城市公共汽车)','C1、C2、C3、C4、M',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(37,'B2','重型、中型载货汽车,大、重、中型专项作业车','C1、C2、C3、C4、M',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(38,'C1','小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车','C2、C3、C4',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(39,'C2','小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车','',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(40,'C3','低速载货汽车(原四轮农用运输车)','C4',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(41,'C4','三轮汽车(原三轮农用运输车)','',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(42,'C5','残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)','',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(43,'D','普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车','E、F',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(44,'E','普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车','F',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(45,'F','轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车','',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(46,'M','轮式自行机械车','',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(47,'N','无轨电车无轨电车','',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(48,'P','有轨电车有轨电车','',0,'2020-04-11 23:47:19','witt','',NULL,NULL,NULL,NULL),(49,'A1','大型载客汽车','A3、B1、B2、C1、C2、C3、C4、M',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(50,'A2','重型、中型全挂、半挂汽车列车','B1、B2、C1、C2、C3、C4、M',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(51,'A3','核载10人以上的城市公共汽车','C1、C2、C3、C4',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(52,'B1','中型载客汽车(含核载10人以上、19人以下的城市公共汽车)','C1、C2、C3、C4、M',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(53,'B2','重型、中型载货汽车,大、重、中型专项作业车','C1、C2、C3、C4、M',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(54,'C1','小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车','C2、C3、C4',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(55,'C2','小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车','',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(56,'C3','低速载货汽车(原四轮农用运输车)','C4',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(57,'C4','三轮汽车(原三轮农用运输车)','',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(58,'C5','残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)','',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(59,'D','普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车','E、F',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(60,'E','普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车','F',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(61,'F','轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车','',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(62,'M','轮式自行机械车','',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(63,'N','无轨电车无轨电车','',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(64,'P','有轨电车有轨电车','',0,'2020-04-13 17:35:33','witt','',NULL,NULL,NULL,NULL),(65,'A1','大型载客汽车','A3、B1、B2、C1、C2、C3、C4、M',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(66,'A2','重型、中型全挂、半挂汽车列车','B1、B2、C1、C2、C3、C4、M',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(67,'A3','核载10人以上的城市公共汽车','C1、C2、C3、C4',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(68,'B1','中型载客汽车(含核载10人以上、19人以下的城市公共汽车)','C1、C2、C3、C4、M',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(69,'B2','重型、中型载货汽车,大、重、中型专项作业车','C1、C2、C3、C4、M',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(70,'C1','小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车','C2、C3、C4',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(71,'C2','小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车','',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(72,'C3','低速载货汽车(原四轮农用运输车)','C4',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(73,'C4','三轮汽车(原三轮农用运输车)','',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(74,'C5','残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)','',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(75,'D','普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车','E、F',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(76,'E','普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车','F',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(77,'F','轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车','',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(78,'M','轮式自行机械车','',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(79,'N','无轨电车无轨电车','',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(80,'P','有轨电车有轨电车','',0,'2020-04-13 18:40:45','witt','',NULL,NULL,NULL,NULL),(81,'A1','大型载客汽车','A3、B1、B2、C1、C2、C3、C4、M',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(82,'A2','重型、中型全挂、半挂汽车列车','B1、B2、C1、C2、C3、C4、M',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(83,'A3','核载10人以上的城市公共汽车','C1、C2、C3、C4',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(84,'B1','中型载客汽车(含核载10人以上、19人以下的城市公共汽车)','C1、C2、C3、C4、M',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(85,'B2','重型、中型载货汽车,大、重、中型专项作业车','C1、C2、C3、C4、M',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(86,'C1','小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车','C2、C3、C4',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(87,'C2','小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车','',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(88,'C3','低速载货汽车(原四轮农用运输车)','C4',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(89,'C4','三轮汽车(原三轮农用运输车)','',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(90,'C5','残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)','',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(91,'D','普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车','E、F',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(92,'E','普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车','F',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(93,'F','轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车','',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(94,'M','轮式自行机械车','',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(95,'N','无轨电车无轨电车','',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(96,'P','有轨电车有轨电车','',0,'2020-04-14 12:02:34','witt','',NULL,NULL,NULL,NULL),(97,'A1','大型载客汽车','A3、B1、B2、C1、C2、C3、C4、M',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(98,'A2','重型、中型全挂、半挂汽车列车','B1、B2、C1、C2、C3、C4、M',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(99,'A3','核载10人以上的城市公共汽车','C1、C2、C3、C4',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(100,'B1','中型载客汽车(含核载10人以上、19人以下的城市公共汽车)','C1、C2、C3、C4、M',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(101,'B2','重型、中型载货汽车,大、重、中型专项作业车','C1、C2、C3、C4、M',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(102,'C1','小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车','C2、C3、C4',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(103,'C2','小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车','',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(104,'C3','低速载货汽车(原四轮农用运输车)','C4',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(105,'C4','三轮汽车(原三轮农用运输车)','',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(106,'C5','残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)','',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(107,'D','普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车','E、F',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(108,'E','普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车','F',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(109,'F','轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车','',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(110,'M','轮式自行机械车','',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(111,'N','无轨电车无轨电车','',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(112,'P','有轨电车有轨电车','',0,'2020-04-14 12:03:29','witt','',NULL,NULL,NULL,NULL),(113,'A1','大型载客汽车','A3、B1、B2、C1、C2、C3、C4、M',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(114,'A2','重型、中型全挂、半挂汽车列车','B1、B2、C1、C2、C3、C4、M',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(115,'A3','核载10人以上的城市公共汽车','C1、C2、C3、C4',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(116,'B1','中型载客汽车(含核载10人以上、19人以下的城市公共汽车)','C1、C2、C3、C4、M',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(117,'B2','重型、中型载货汽车,大、重、中型专项作业车','C1、C2、C3、C4、M',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(118,'C1','小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车','C2、C3、C4',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(119,'C2','小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车','',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(120,'C3','低速载货汽车(原四轮农用运输车)','C4',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(121,'C4','三轮汽车(原三轮农用运输车)','',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(122,'C5','残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)','',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(123,'D','普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车','E、F',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(124,'E','普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车','F',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(125,'F','轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车','',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(126,'M','轮式自行机械车','',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(127,'N','无轨电车无轨电车','',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(128,'P','有轨电车有轨电车','',0,'2020-04-25 02:07:42','witt','',NULL,NULL,NULL,NULL),(129,'A1','大型载客汽车','A3、B1、B2、C1、C2、C3、C4、M',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(130,'A2','重型、中型全挂、半挂汽车列车','B1、B2、C1、C2、C3、C4、M',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(131,'A3','核载10人以上的城市公共汽车','C1、C2、C3、C4',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(132,'B1','中型载客汽车(含核载10人以上、19人以下的城市公共汽车)','C1、C2、C3、C4、M',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(133,'B2','重型、中型载货汽车,大、重、中型专项作业车','C1、C2、C3、C4、M',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(134,'C1','小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车','C2、C3、C4',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(135,'C2','小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车','',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(136,'C3','低速载货汽车(原四轮农用运输车)','C4',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(137,'C4','三轮汽车(原三轮农用运输车)','',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(138,'C5','残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)','',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(139,'D','普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车','E、F',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(140,'E','普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车','F',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(141,'F','轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车','',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(142,'M','轮式自行机械车','',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(143,'N','无轨电车无轨电车','',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL),(144,'P','有轨电车有轨电车','',0,'2020-04-25 02:10:50','witt','',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `driver_license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gen_table`
--

DROP TABLE IF EXISTS `gen_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table`
--

LOCK TABLES `gen_table` WRITE;
/*!40000 ALTER TABLE `gen_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `gen_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gen_table_column`
--

DROP TABLE IF EXISTS `gen_table_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table_column`
--

LOCK TABLES `gen_table_column` WRITE;
/*!40000 ALTER TABLE `gen_table_column` DISABLE KEYS */;
/*!40000 ALTER TABLE `gen_table_column` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdman_db_version`
--

DROP TABLE IF EXISTS `pdman_db_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdman_db_version` (
  `DB_VERSION` varchar(256) DEFAULT NULL,
  `VERSION_DESC` varchar(1024) DEFAULT NULL,
  `CREATED_TIME` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdman_db_version`
--

LOCK TABLES `pdman_db_version` WRITE;
/*!40000 ALTER TABLE `pdman_db_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `pdman_db_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rfid_card`
--

DROP TABLE IF EXISTS `rfid_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rfid_card` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `phy_number` varchar(64) DEFAULT '' COMMENT '物理卡号',
  `color` varchar(64) DEFAULT '' COMMENT '卡片颜色',
  `size` varchar(64) DEFAULT '' COMMENT '卡片尺寸',
  `type` varchar(64) DEFAULT '' COMMENT '卡片类型',
  `status` varchar(64) DEFAULT '' COMMENT '卡片状态',
  `deleted` tinyint(2) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='RFID卡登记表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfid_card`
--

LOCK TABLES `rfid_card` WRITE;
/*!40000 ALTER TABLE `rfid_card` DISABLE KEYS */;
INSERT INTO `rfid_card` VALUES (1,'89041DB3','白色','10*10','','管理员授权',1,'2020-04-20 06:40:55','admin','',NULL,NULL,NULL,'自动创建');
/*!40000 ALTER TABLE `rfid_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_coach`
--

DROP TABLE IF EXISTS `student_coach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_coach` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `student_id` bigint(255) NOT NULL COMMENT '学员id',
  `coach_id` bigint(255) NOT NULL COMMENT '教练id',
  `bind_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '绑定时间',
  `is_untie_bind` tinyint(2) DEFAULT NULL COMMENT '是否解绑',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `student_coach_fk` (`student_id`),
  KEY `student_coach_fk_1` (`coach_id`),
  CONSTRAINT `student_coach_fk` FOREIGN KEY (`student_id`) REFERENCES `sys_user_info` (`id`),
  CONSTRAINT `student_coach_fk_1` FOREIGN KEY (`coach_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员教练关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_coach`
--

LOCK TABLES `student_coach` WRITE;
/*!40000 ALTER TABLE `student_coach` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `swipe_rfid_record`
--

DROP TABLE IF EXISTS `swipe_rfid_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `swipe_rfid_record` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `rfid_id` bigint(255) NOT NULL COMMENT 'RFID表主键',
  `user_info_id` bigint(255) NOT NULL COMMENT '用户信息表主键',
  `swipe_type` varchar(50) DEFAULT NULL COMMENT '刷卡类型',
  `status` varchar(20) DEFAULT NULL COMMENT '记录状态',
  `action` varchar(50) DEFAULT NULL COMMENT '活动记录',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `swipe_rfid_record_fk` (`rfid_id`),
  KEY `swipe_rfid_record_fk_1` (`user_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='刷卡记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `swipe_rfid_record`
--

LOCK TABLES `swipe_rfid_record` WRITE;
/*!40000 ALTER TABLE `swipe_rfid_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `swipe_rfid_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='参数配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','初始化密码 123456'),(3,'主框架页-侧边栏主题','sys.index.sideTheme','theme-dark','Y','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','深色主题theme-dark，浅色主题theme-light');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (100,0,'0','若依科技',0,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(101,100,'0,100','深圳总公司',1,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(102,100,'0,100','长沙分公司',2,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(103,101,'0,100,101','研发部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(104,101,'0,100,101','市场部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(105,101,'0,100,101','测试部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(106,101,'0,100,101','财务部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(107,101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(108,102,'0,100,102','市场部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00'),(109,102,'0,100,102','财务部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00');
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='字典数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` VALUES (1,1,'男','0','sys_user_sex','','','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态'),(10,1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','默认分组'),(11,2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统分组'),(12,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统默认是'),(13,2,'否','N','sys_yes_no','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统默认否'),(14,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知'),(15,2,'公告','2','sys_notice_type','','success','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','公告'),(16,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(17,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','关闭状态'),(18,1,'新增','1','sys_oper_type','','info','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','新增操作'),(19,2,'修改','2','sys_oper_type','','info','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','修改操作'),(20,3,'删除','3','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','删除操作'),(21,4,'授权','4','sys_oper_type','','primary','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','授权操作'),(22,5,'导出','5','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','导出操作'),(23,6,'导入','6','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','导入操作'),(24,7,'强退','7','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','强退操作'),(25,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','生成操作'),(26,9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','清空操作'),(27,1,'成功','0','sys_common_status','','primary','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','正常状态'),(28,2,'失败','1','sys_common_status','','danger','N','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','停用状态'),(29,1,'汉族','na_1','nationa_type',NULL,NULL,'Y','0','',NULL,'',NULL,'民族汉'),(30,2,'回族','na_2','nationa_type',NULL,NULL,'N','0','',NULL,'',NULL,'民族回');
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` VALUES (1,'用户性别','sys_user_sex','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','任务状态列表'),(5,'任务分组','sys_job_group','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','任务分组列表'),(6,'系统是否','sys_yes_no','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统是否列表'),(7,'通知类型','sys_notice_type','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知类型列表'),(8,'通知状态','sys_notice_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知状态列表'),(9,'操作类型','sys_oper_type','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','操作类型列表'),(10,'系统状态','sys_common_status','0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','登录状态列表'),(11,'民族选项','nationa_type','0','admin','2020-04-11 22:53:59','',NULL,'民族类型下拉选项');
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job`
--

DROP TABLE IF EXISTS `sys_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job`
--

LOCK TABLES `sys_job` WRITE;
/*!40000 ALTER TABLE `sys_job` DISABLE KEYS */;
INSERT INTO `sys_job` VALUES (1,'系统默认（无参）','DEFAULT','ryTask.ryNoParams','0/10 * * * * ?','3','1','1','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(2,'系统默认（有参）','DEFAULT','ryTask.ryParams(\'ry\')','0/15 * * * * ?','3','1','1','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(3,'系统默认（多参）','DEFAULT','ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)','0/20 * * * * ?','3','1','1','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','');
/*!40000 ALTER TABLE `sys_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job_log`
--

DROP TABLE IF EXISTS `sys_job_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job_log`
--

LOCK TABLES `sys_job_log` WRITE;
/*!40000 ALTER TABLE `sys_job_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_job_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_logininfor`
--

DROP TABLE IF EXISTS `sys_logininfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_logininfor` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `account` varchar(30) NOT NULL COMMENT '用户登录使用的账户',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_logininfor`
--

LOCK TABLES `sys_logininfor` WRITE;
/*!40000 ALTER TABLE `sys_logininfor` DISABLE KEYS */;
INSERT INTO `sys_logininfor` VALUES (103,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','验证码已失效','2020-04-01 19:38:24'),(104,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','No message found under code \'user.logincertificate.not.match\' for locale \'zh_CN\'.','2020-04-01 19:38:38'),(105,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','验证码错误','2020-04-01 19:39:08'),(106,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','No message found under code \'user.logincertificate.not.match\' for locale \'zh_CN\'.','2020-04-01 19:39:15'),(107,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','验证码已失效','2020-04-01 19:41:34'),(108,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','校验用户凭证出现问题，请联系管理员','2020-04-01 19:41:39'),(109,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','校验用户凭证出现问题，请联系管理员','2020-04-01 19:42:13'),(110,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','校验用户凭证出现问题，请联系管理员','2020-04-01 19:45:36'),(111,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-01 19:53:27'),(112,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','验证码已失效','2020-04-01 20:01:35'),(113,'admin','127.0.0.1','内网IP','Chrome','Windows 10','1','验证码已失效','2020-04-01 20:04:31'),(114,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-01 20:04:38'),(115,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-01 20:05:26'),(116,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-01 20:09:05'),(117,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-01 20:25:26'),(118,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-01 20:29:45'),(119,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-01 20:32:26'),(120,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-01 20:38:43'),(121,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 20:38:05'),(122,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 20:38:50'),(123,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 20:41:12'),(124,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 20:53:13'),(125,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 20:55:18'),(126,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 20:56:02'),(127,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 21:09:51'),(128,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 21:41:10'),(129,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 21:42:12'),(130,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 21:44:53'),(131,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 21:45:43'),(132,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-02 21:45:57'),(133,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 13:24:34'),(134,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 13:24:47'),(135,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 13:29:47'),(136,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 13:45:15'),(137,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 13:45:44'),(138,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 14:01:32'),(139,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 14:01:46'),(140,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 14:03:02'),(141,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 14:03:15'),(142,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 14:10:44'),(143,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 14:10:58'),(144,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 14:42:42'),(145,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 14:43:25'),(146,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 14:55:44'),(147,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 14:55:55'),(148,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 15:21:32'),(149,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 15:22:14'),(150,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 15:40:27'),(151,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 15:40:40'),(152,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 16:04:14'),(153,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 16:04:54'),(154,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 16:06:53'),(155,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 16:07:06'),(156,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 16:36:32'),(157,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 16:36:55'),(158,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 16:40:39'),(159,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 16:40:58'),(160,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 16:41:48'),(161,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 16:41:59'),(162,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 16:51:00'),(163,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 16:51:23'),(164,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 16:53:28'),(165,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 16:53:43'),(166,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 17:19:07'),(167,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 17:23:14'),(168,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 17:23:23'),(169,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 17:24:54'),(170,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 17:25:05'),(171,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 18:35:22'),(172,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 18:35:37'),(173,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 18:38:45'),(174,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 18:39:08'),(175,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 18:45:17'),(176,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 19:05:37'),(177,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 19:05:50'),(178,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 19:32:14'),(179,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 19:32:26'),(180,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 19:33:48'),(181,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 19:33:59'),(182,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 19:35:05'),(183,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 19:35:15'),(184,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 19:43:16'),(185,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 19:43:27'),(186,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 19:44:15'),(187,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 19:56:51'),(188,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 19:57:03'),(189,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-04 21:08:46'),(190,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 21:09:00'),(191,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 21:52:50'),(192,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-04 23:05:02'),(193,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-05 12:15:24'),(194,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','退出成功','2020-04-05 13:25:58'),(195,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-05 13:26:12'),(196,'admin','127.0.0.1','内网IP','Chrome','Windows 10','0','登录成功','2020-04-06 20:55:00'),(197,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','验证码错误','2020-04-11 15:31:09'),(198,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','用户不存在/密码错误','2020-04-11 15:32:17'),(199,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','用户不存在/密码错误','2020-04-11 15:32:55'),(200,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','用户不存在/密码错误','2020-04-11 15:33:04'),(201,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','用户不存在/密码错误','2020-04-11 15:33:21'),(202,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','验证码已失效','2020-04-11 15:36:42'),(203,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 15:36:49'),(204,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','退出成功','2020-04-11 15:40:29'),(205,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 15:41:19'),(206,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 18:06:49'),(207,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 20:08:14'),(208,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 21:16:38'),(209,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','退出成功','2020-04-11 21:22:31'),(210,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 21:22:43'),(211,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','退出成功','2020-04-11 21:22:59'),(212,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 21:23:53'),(213,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','退出成功','2020-04-11 21:27:10'),(214,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 21:27:40'),(215,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 21:57:02'),(216,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 21:58:44'),(217,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 22:29:53'),(218,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-11 23:56:15'),(219,'admin','127.0.0.1','内网IP','Downloading Tool','Unknown','1','验证码已失效','2020-04-12 23:11:06'),(220,'admin','127.0.0.1','内网IP','Downloading Tool','Unknown','1','验证码已失效','2020-04-12 23:11:17'),(221,'admin','127.0.0.1','内网IP','Downloading Tool','Unknown','0','登录成功','2020-04-12 23:14:52'),(222,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','验证码已失效','2020-04-13 00:05:40'),(223,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-13 00:37:25'),(224,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-14 12:13:44'),(225,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-20 19:31:51'),(226,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','验证码错误','2020-04-20 19:43:41'),(227,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-20 19:43:48'),(228,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','退出成功','2020-04-20 19:45:50'),(229,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-20 19:46:03'),(230,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','验证码错误','2020-04-20 20:37:49'),(231,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-20 20:37:58'),(232,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-20 20:38:25'),(233,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-20 20:39:52'),(234,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','1','用户不存在/密码错误','2020-04-25 00:31:12'),(235,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 00:32:17'),(236,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 01:17:02'),(237,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 01:17:18'),(238,'admin','127.0.0.1','内网IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 01:18:10'),(239,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 02:22:36'),(240,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','0','退出成功','2020-04-25 02:23:17'),(241,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 02:23:27'),(242,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','0','退出成功','2020-04-25 02:24:06'),(243,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 02:27:37'),(244,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','1','验证码错误','2020-04-25 08:22:58'),(245,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','1','验证码错误','2020-04-25 08:23:07'),(246,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 08:23:15'),(247,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','1','验证码错误','2020-04-25 11:28:06'),(248,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','1','验证码错误','2020-04-25 11:28:13'),(249,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 11:28:19'),(250,'admin','223.65.51.134','江苏 南京','Chrome 8','Windows 10','0','退出成功','2020-04-25 11:45:55'),(251,'admin','223.65.51.134','Unknown IP','Chrome 8','Windows 10','0','登录成功','2020-04-25 11:47:51'),(252,'admin','118.181.103.78','Unknown IP','Chrome 8','Windows 10','1','验证码错误','2020-05-03 20:09:56'),(253,'admin','118.181.103.78','Unknown IP','Chrome 8','Windows 10','1','验证码错误','2020-05-03 20:11:36'),(254,'admin','118.181.103.78','Unknown IP','Chrome 8','Windows 10','0','登录成功','2020-05-03 20:13:50'),(255,'admin','118.181.103.78','Unknown IP','Chrome 8','Windows 10','0','登录成功','2020-05-03 20:14:15'),(256,'admin','118.181.103.78','Unknown IP','Unknown','Unknown','1','验证码已失效','2020-05-03 20:23:24');
/*!40000 ALTER TABLE `sys_logininfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `is_frame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2004 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理',0,1,'system',NULL,1,'M','0','','system','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','系统管理目录'),(100,'用户管理',1,1,'user','system/user/index',1,'C','0','system:user:list','user','admin','2018-03-16 11:33:00','admin','2020-04-25 00:40:38','用户管理菜单'),(101,'角色管理',1,2,'role','system/role/index',1,'C','0','system:role:list','peoples','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','角色管理菜单'),(102,'菜单管理',1,3,'menu','system/menu/index',1,'C','0','system:menu:list','tree-table','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','菜单管理菜单'),(107,'通知公告',1,8,'notice','system/notice/index',1,'C','0','system:notice:list','message','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','通知公告菜单'),(108,'日志管理',0,9,'log','system/log/index',1,'M','0','','log','admin','2018-03-16 11:33:00','admin','2020-04-25 00:36:08','日志管理菜单'),(500,'操作日志',108,1,'operlog','monitor/operlog/index',1,'C','0','monitor:operlog:list','form','admin','2018-03-16 11:33:00','admin','2020-04-25 00:38:29','操作日志菜单'),(501,'登录日志',108,2,'logininfor','monitor/logininfor/index',1,'C','0','monitor:logininfor:list','logininfor','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','登录日志菜单'),(1001,'用户查询',100,1,'','',1,'F','0','system:user:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1002,'用户新增',100,2,'','',1,'F','0','system:user:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1003,'用户修改',100,3,'','',1,'F','0','system:user:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1004,'用户删除',100,4,'','',1,'F','0','system:user:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1005,'用户导出',100,5,'','',1,'F','0','system:user:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1006,'用户导入',100,6,'','',1,'F','0','system:user:import','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1007,'重置密码',100,7,'','',1,'F','0','system:user:resetPwd','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1008,'角色查询',101,1,'','',1,'F','0','system:role:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1009,'角色新增',101,2,'','',1,'F','0','system:role:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1010,'角色修改',101,3,'','',1,'F','0','system:role:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1011,'角色删除',101,4,'','',1,'F','0','system:role:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1012,'角色导出',101,5,'','',1,'F','0','system:role:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1013,'菜单查询',102,1,'','',1,'F','0','system:menu:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1014,'菜单新增',102,2,'','',1,'F','0','system:menu:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1015,'菜单修改',102,3,'','',1,'F','0','system:menu:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1016,'菜单删除',102,4,'','',1,'F','0','system:menu:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1017,'部门查询',103,1,'','',1,'F','0','system:dept:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1018,'部门新增',103,2,'','',1,'F','0','system:dept:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1019,'部门修改',103,3,'','',1,'F','0','system:dept:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1020,'部门删除',103,4,'','',1,'F','0','system:dept:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1021,'岗位查询',104,1,'','',1,'F','0','system:post:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1022,'岗位新增',104,2,'','',1,'F','0','system:post:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1023,'岗位修改',104,3,'','',1,'F','0','system:post:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1024,'岗位删除',104,4,'','',1,'F','0','system:post:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1025,'岗位导出',104,5,'','',1,'F','0','system:post:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1026,'字典查询',105,1,'#','',1,'F','0','system:dict:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1027,'字典新增',105,2,'#','',1,'F','0','system:dict:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1028,'字典修改',105,3,'#','',1,'F','0','system:dict:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1029,'字典删除',105,4,'#','',1,'F','0','system:dict:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1030,'字典导出',105,5,'#','',1,'F','0','system:dict:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1031,'参数查询',106,1,'#','',1,'F','0','system:config:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1032,'参数新增',106,2,'#','',1,'F','0','system:config:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1033,'参数修改',106,3,'#','',1,'F','0','system:config:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1034,'参数删除',106,4,'#','',1,'F','0','system:config:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1035,'参数导出',106,5,'#','',1,'F','0','system:config:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1036,'公告查询',107,1,'#','',1,'F','0','system:notice:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1037,'公告新增',107,2,'#','',1,'F','0','system:notice:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1038,'公告修改',107,3,'#','',1,'F','0','system:notice:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1039,'公告删除',107,4,'#','',1,'F','0','system:notice:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1040,'操作查询',500,1,'#','',1,'F','0','monitor:operlog:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1041,'操作删除',500,2,'#','',1,'F','0','monitor:operlog:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1042,'日志导出',500,4,'#','',1,'F','0','monitor:operlog:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1043,'登录查询',501,1,'#','',1,'F','0','monitor:logininfor:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1044,'登录删除',501,2,'#','',1,'F','0','monitor:logininfor:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1045,'日志导出',501,3,'#','',1,'F','0','monitor:logininfor:export','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1046,'在线查询',109,1,'#','',1,'F','0','monitor:online:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1047,'批量强退',109,2,'#','',1,'F','0','monitor:online:batchLogout','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1048,'单条强退',109,3,'#','',1,'F','0','monitor:online:forceLogout','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1049,'任务查询',110,1,'#','',1,'F','0','monitor:job:query','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1050,'任务新增',110,2,'#','',1,'F','0','monitor:job:add','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1051,'任务修改',110,3,'#','',1,'F','0','monitor:job:edit','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1052,'任务删除',110,4,'#','',1,'F','0','monitor:job:remove','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(1053,'状态修改',110,5,'#','',1,'F','0','monitor:job:changeStatus','#','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(2000,'用户信息查询',100,8,'',NULL,1,'F','0','system:userinfo:query','#','admin','2020-04-11 22:00:42','',NULL,''),(2001,'卡片管理',2002,10,'RFIDCard','RFID/card/index',1,'C','0','','list','admin','2020-04-20 19:45:26','admin','2020-04-20 20:32:55',''),(2002,'RFID管理',0,3,'rfidMenu',NULL,1,'M','0','','clipboard','admin','2020-04-20 20:26:38','admin','2020-04-25 00:34:54',''),(2003,'刷卡管理',2002,2,'SwipeRFIDRecord','RFID/swipe/index',1,'C','0',NULL,'clipboard','admin','2020-04-25 01:06:16','',NULL,'');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='通知公告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
INSERT INTO `sys_notice` VALUES (2,'1111','2','<p><strong>111111</strong></p>','0','admin','2020-05-03 20:25:16','',NULL,NULL),(3,'XXXXXX','2','<p><strong>ccccccc</strong></p>','0','admin','2020-05-03 20:26:44','',NULL,NULL);
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oper_log`
--

DROP TABLE IF EXISTS `sys_oper_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oper_log`
--

LOCK TABLES `sys_oper_log` WRITE;
/*!40000 ALTER TABLE `sys_oper_log` DISABLE KEYS */;
INSERT INTO `sys_oper_log` VALUES (1,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"log\",\"orderNum\":\"9\",\"menuName\":\"日志管理\",\"path\":\"log\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":108,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":2,\"component\":\"system/log/index\",\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 14:10:15'),(2,'通知公告',3,'com.leleplus.project.system.controller.SysNoticeController.remove()','DELETE',1,'admin',NULL,'/system/notice/2','127.0.0.1','内网IP','{noticeIds=2}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 14:47:44'),(3,'用户管理',1,'com.leleplus.project.system.controller.SysUserController.add()','POST',1,'admin',NULL,'/system/user','127.0.0.1','内网IP','{\"student\":false,\"roles\":[],\"admin\":false,\"loginDate\":1521171180000,\"remark\":\"管理员\",\"delFlag\":\"0\",\"password\":\"$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2\",\"loginIp\":\"127.0.0.1\",\"id\":1,\"email\":\"ry@163.com\",\"nickName\":\"boss\",\"avatar\":\"\",\"params\":{},\"userInfoId\":1,\"createBy\":\"admin\",\"createTime\":1521171180000,\"telphone\":\"15888888888\",\"coach\":false,\"status\":\"0\",\"username\":\"admin\"}','{\"msg\":\"新增用户\'admin\'失败，登录账号已存在\",\"code\":500}',0,NULL,'2020-04-04 16:23:16'),(4,'菜单管理',1,'com.leleplus.project.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"peoples\",\"orderNum\":\"1\",\"menuName\":\"学员管理\",\"path\":\"/student\",\"children\":[],\"isFrame\":\"1\",\"visible\":\"0\",\"params\":{},\"parentId\":100,\"createBy\":\"admin\",\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 16:40:25'),(5,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"peoples\",\"orderNum\":\"1\",\"menuName\":\"学员管理\",\"path\":\"/student\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":100,\"createTime\":1585989625000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 16:41:36'),(6,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"1\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"component\":\"\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 16:50:15'),(7,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"1\",\"menuName\":\"学员管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":100,\"component\":\"system/user/index\",\"createTime\":1585989625000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 16:50:51'),(8,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"log\",\"orderNum\":\"9\",\"menuName\":\"日志管理\",\"path\":\"log\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":108,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"component\":\"system/log/index\",\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 16:53:22'),(9,'菜单管理',1,'com.leleplus.project.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"5\",\"menuName\":\"用户管理\",\"path\":\"system\",\"children\":[],\"isFrame\":\"1\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"createBy\":\"admin\",\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 17:24:36'),(10,'菜单管理',3,'com.leleplus.project.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/system/menu/1061','127.0.0.1','内网IP','{menuId=1061}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 19:08:07'),(11,'菜单管理',3,'com.leleplus.project.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/system/menu/1062','127.0.0.1','内网IP','{menuId=1062}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-04 19:45:02'),(12,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"1\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:23:21'),(13,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"system\",\"orderNum\":\"2\",\"menuName\":\"系统管理\",\"path\":\"system\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:24:30'),(14,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"guide\",\"orderNum\":\"5\",\"menuName\":\"乐乐站点\",\"path\":\"http://www.leleplus.fun\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"0\",\"menuId\":4,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:24:43'),(15,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"tool\",\"orderNum\":\"4\",\"menuName\":\"系统工具\",\"path\":\"tool\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":3,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:24:46'),(16,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"monitor\",\"orderNum\":\"3\",\"menuName\":\"系统监控\",\"path\":\"monitor\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:24:51'),(17,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"peoples\",\"orderNum\":\"2\",\"menuName\":\"角色管理\",\"path\":\"role\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":101,\"perms\":\"system:role:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/role/index\",\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:29:27'),(18,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"peoples\",\"orderNum\":\"8\",\"menuName\":\"角色管理\",\"path\":\"role\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":101,\"perms\":\"system:role:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/role/index\",\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:30:10'),(19,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"peoples\",\"orderNum\":\"1\",\"menuName\":\"角色管理\",\"path\":\"role\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":101,\"perms\":\"system:role:list\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"component\":\"system/role/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:31:27'),(20,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"9\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:31:56'),(21,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"9\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"component\":\"system/user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:32:14'),(22,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"9\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:32:54'),(23,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"9\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:33:53'),(24,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"9\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:34:44'),(25,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"9\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"component\":\"system/user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:35:41'),(26,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"peoples\",\"orderNum\":\"1\",\"menuName\":\"角色管理\",\"path\":\"role\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":101,\"perms\":\"system:role:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/role/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:36:54'),(27,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"peoples\",\"orderNum\":\"1\",\"menuName\":\"角色管理\",\"path\":\"role\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":101,\"perms\":\"system:role:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/role/index\",\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:37:19'),(28,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"peoples\",\"orderNum\":\"1\",\"menuName\":\"角色管理\",\"path\":\"role\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":101,\"perms\":\"system:role:list\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"component\":\"system/role/index\",\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:38:04'),(29,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"tree\",\"orderNum\":\"1\",\"menuName\":\"角色管理1\",\"path\":\"system\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-05 13:39:53'),(40,'通知公告',3,'com.leleplus.project.system.controller.SysNoticeController.remove()','DELETE',1,'admin',NULL,'/system/notice/1','127.0.0.1','内网IP','{noticeIds=1}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-20 20:35:47'),(41,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"clipboard\",\"orderNum\":\"3\",\"menuName\":\"RFID管理\",\"path\":\"rfid\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2002,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"createTime\":1587385598000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-20 20:41:17'),(42,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"clipboard\",\"orderNum\":\"3\",\"menuName\":\"RFID管理\",\"path\":\"rfidMenu\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2002,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"createTime\":1587385598000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-20 20:45:18'),(43,'菜单管理',3,'com.leleplus.project.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/system/menu/4','127.0.0.1','内网IP','{menuId=4}','{\"msg\":\"菜单已分配,不允许删除\",\"code\":500}',0,NULL,'2020-04-25 00:32:34'),(44,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"clipboard\",\"orderNum\":\"3\",\"menuName\":\"RFID管理\",\"path\":\"rfidMenu\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2002,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"createTime\":1587385598000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-25 00:34:54'),(45,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"log\",\"orderNum\":\"9\",\"menuName\":\"日志管理\",\"path\":\"log\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":108,\"perms\":\"\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/log/index\",\"createTime\":1521171180000,\"menuType\":\"M\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-25 00:36:09'),(46,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"form\",\"orderNum\":\"1\",\"menuName\":\"操作日志\",\"path\":\"operlog\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":500,\"perms\":\"monitor:operlog:list\",\"visible\":\"0\",\"params\":{},\"parentId\":108,\"component\":\"monitor/operlog/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-25 00:38:29'),(47,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"1\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":0,\"component\":\"system/user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-25 00:39:27'),(48,'菜单管理',2,'com.leleplus.project.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"user\",\"orderNum\":\"1\",\"menuName\":\"用户管理\",\"path\":\"user\",\"children\":[],\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":100,\"perms\":\"system:user:list\",\"visible\":\"0\",\"params\":{},\"parentId\":1,\"component\":\"system/user/index\",\"createTime\":1521171180000,\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-25 00:40:38'),(49,'菜单管理',1,'com.leleplus.project.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/system/menu','127.0.0.1','内网IP','{\"icon\":\"clipboard\",\"orderNum\":\"2\",\"menuName\":\"刷卡管理\",\"path\":\"SwipeRFIDRecord\",\"children\":[],\"isFrame\":\"1\",\"visible\":\"0\",\"params\":{},\"parentId\":2002,\"component\":\"RFID/swipe/index\",\"createBy\":\"admin\",\"menuType\":\"C\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-04-25 01:06:16'),(50,'通知公告',1,'com.leleplus.project.system.controller.SysNoticeController.add()','POST',1,'admin',NULL,'/system/notice','118.181.103.78','甘肃 庆阳','{\"noticeType\":\"1\",\"params\":{},\"noticeTitle\":\"11111\",\"createBy\":\"admin\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-05-03 20:24:34'),(51,'通知公告',3,'com.leleplus.project.system.controller.SysNoticeController.remove()','DELETE',1,'admin',NULL,'/system/notice/1','118.181.103.78','Unknown IP','{noticeIds=1}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-05-03 20:24:45'),(52,'通知公告',1,'com.leleplus.project.system.controller.SysNoticeController.add()','POST',1,'admin',NULL,'/system/notice','118.181.103.78','甘肃 庆阳','{\"noticeType\":\"2\",\"params\":{},\"noticeTitle\":\"XXXXXX\",\"noticeContent\":\"<p><strong>ccccccc</strong></p>\",\"createBy\":\"admin\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2020-05-03 20:26:44');
/*!40000 ALTER TABLE `sys_oper_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES (1,'ceo','董事长',1,'0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(2,'se','项目经理',2,'0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(3,'hr','人力资源',3,'0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00',''),(4,'user','普通员工',4,'0','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','');
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','ADMIN',1,'1','0','0','witt','2020-04-02 22:00:48','witt','2020-04-02 22:00:48','管理员'),(2,'教练','COACH',2,'2','0','0','witt','2020-04-02 22:00:48','witt','2020-04-02 22:00:48','教练'),(3,'学员','STUDENT',3,'3','0','0','witt','2020-04-02 22:00:48','witt','2020-04-02 22:00:48','学员');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_dept`
--

DROP TABLE IF EXISTS `sys_role_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_dept`
--

LOCK TABLES `sys_role_dept` WRITE;
/*!40000 ALTER TABLE `sys_role_dept` DISABLE KEYS */;
INSERT INTO `sys_role_dept` VALUES (2,100),(2,101),(2,105);
/*!40000 ALTER TABLE `sys_role_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `sys_role_menu_fk_1` (`menu_id`),
  CONSTRAINT `sys_role_menu_fk` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (2,1),(2,2),(2,3),(2,100),(2,101),(2,102),(2,103),(2,104),(2,105),(2,106),(2,107),(2,108),(2,109),(2,110),(2,111),(2,112),(2,113),(2,114),(2,115),(2,500),(2,501),(2,1001),(2,1002),(2,1003),(2,1004),(2,1005),(2,1006),(2,1007),(2,1008),(2,1009),(2,1010),(2,1011),(2,1012),(2,1013),(2,1014),(2,1015),(2,1016),(2,1017),(2,1018),(2,1019),(2,1020),(2,1021),(2,1022),(2,1023),(2,1024),(2,1025),(2,1026),(2,1027),(2,1028),(2,1029),(2,1030),(2,1031),(2,1032),(2,1033),(2,1034),(2,1035),(2,1036),(2,1037),(2,1038),(2,1039),(2,1040),(2,1041),(2,1042),(2,1043),(2,1044),(2,1045),(2,1046),(2,1047),(2,1048),(2,1049),(2,1050),(2,1051),(2,1052),(2,1053),(2,1054),(2,1055),(2,1056),(2,1057),(2,1058),(2,1059),(2,1060);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `telphone` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `id_card` varchar(25) NOT NULL COMMENT '身份证号',
  `user_info_id` bigint(255) DEFAULT NULL COMMENT '用户信息表id',
  PRIMARY KEY (`id`),
  KEY `sys_user_fk` (`user_info_id`),
  CONSTRAINT `sys_user_fk` FOREIGN KEY (`user_info_id`) REFERENCES `sys_user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','管理员','00','ry@163.com','15888888888','1','','$2a$10$MGQjAKwVbcN89bAnoIvWTeLxTZhfKsWgXHmRlwQp82zY9mRzk2ETG','0','0','127.0.0.1','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','管理员','',1),(2,'ry','若依','00','ry@qq.com','15666666666','1','','$2a$10$S6OsyYPnvRNGk/oOwoDwLOZstexr.yWfQFMM2OKRwK7fKTCEdQs1O','0','0','127.0.0.1','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','ry','2018-03-16 11:33:00','测试员','',NULL),(3,'lele','乐乐','00','1989161762@qq.com','13629365547','1','','$2a$10$S6OsyYPnvRNGk/oOwoDwLOZstexr.yWfQFMM2OKRwK7fKTCEdQs1O','0','0','',NULL,'',NULL,'',NULL,'管理员','622223199709082335',NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_info`
--

DROP TABLE IF EXISTS `sys_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_info` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `gender` varchar(20) DEFAULT NULL COMMENT '性别',
  `id_photo` varchar(255) DEFAULT NULL COMMENT '证件照',
  `national` varchar(255) DEFAULT NULL COMMENT '民族',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `paper_file_number` varchar(200) DEFAULT NULL COMMENT '纸质档案编号',
  `driver_type` bigint(255) DEFAULT NULL COMMENT '报考驾照类型',
  `medical_time` datetime DEFAULT NULL COMMENT '体检时间',
  `agent` varchar(200) DEFAULT NULL COMMENT '经办人',
  `sign_date` datetime DEFAULT NULL COMMENT '报名日期',
  `expiration_time` datetime DEFAULT NULL COMMENT '过期时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  `end_time` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `begin_time` varchar(50) DEFAULT NULL COMMENT '开始时间',
  `data_scope` varchar(100) DEFAULT NULL COMMENT '数据范围',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  `search_value` varchar(100) DEFAULT NULL COMMENT '搜索值',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `dept_id` bigint(255) DEFAULT NULL COMMENT '部门id',
  `wage` varchar(100) DEFAULT NULL COMMENT '工资',
  PRIMARY KEY (`id`),
  KEY `sys_user_info_fk` (`driver_type`),
  CONSTRAINT `sys_user_info_fk` FOREIGN KEY (`driver_type`) REFERENCES `driver_license` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_info`
--

LOCK TABLES `sys_user_info` WRITE;
/*!40000 ALTER TABLE `sys_user_info` DISABLE KEYS */;
INSERT INTO `sys_user_info` VALUES (1,'管理员',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
INSERT INTO `sys_user_post` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `sys_user_role_fk_1` (`role_id`),
  CONSTRAINT `sys_user_role_fk` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_user_role_fk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(3,1),(2,2),(3,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rfid`
--

DROP TABLE IF EXISTS `user_rfid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_rfid` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_info_id` bigint(255) NOT NULL COMMENT '用户信息表id',
  `rfid_id` bigint(255) NOT NULL COMMENT 'rfid卡id',
  `deleted` tinyint(2) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `user_rfid_fk` (`user_info_id`),
  KEY `user_rfid_fk_1` (`rfid_id`),
  CONSTRAINT `user_rfid_fk` FOREIGN KEY (`user_info_id`) REFERENCES `sys_user_info` (`id`),
  CONSTRAINT `user_rfid_fk_1` FOREIGN KEY (`rfid_id`) REFERENCES `rfid_card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户RFID关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rfid`
--

LOCK TABLES `user_rfid` WRITE;
/*!40000 ALTER TABLE `user_rfid` DISABLE KEYS */;
INSERT INTO `user_rfid` VALUES (1,3,1,0,NULL,'','',NULL,NULL,NULL,'测试数据');
/*!40000 ALTER TABLE `user_rfid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'facts_driver_prd'
--

--
-- Dumping routines for database 'facts_driver_prd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-08 12:44:38
