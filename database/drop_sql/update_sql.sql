/**
 * date:2020年2月22日23:41:38
 * @description:修改driver_user表中password字段的长度为2000
 */
ALTER TABLE `driver-dev`.driver_user MODIFY COLUMN password varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
ALTER TABLE `driver-dev`.driver_user MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '用户主键';
ALTER TABLE `driver-dev`.driver_user MODIFY COLUMN telphone varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码,可用来登录';
ALTER TABLE `driver-dev`.driver_user MODIFY COLUMN role_code varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码(角色标识)';
ALTER TABLE `driver-dev`.driver_user MODIFY COLUMN role_name varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名';
ALTER TABLE `driver-dev`.driver_user MODIFY COLUMN login_Id varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录id,最多36长度';
ALTER TABLE `driver-dev`.driver_subject MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '科目表主键';
ALTER TABLE `driver-dev`.driver_subject MODIFY COLUMN student_archive_id bigint(255) NOT NULL COMMENT '学员表id';
ALTER TABLE `driver-dev`.driver_subject MODIFY COLUMN exam_time bigint(50) NULL COMMENT '考试时间';
ALTER TABLE `driver-dev`.driver_subject MODIFY COLUMN sub_name varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科目名称';
ALTER TABLE `driver-dev`.driver_student_associate_coach MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '学员教练关联表主键';
ALTER TABLE `driver-dev`.driver_student_associate_coach MODIFY COLUMN student_id bigint(255) NOT NULL COMMENT '学员id';
ALTER TABLE `driver-dev`.driver_student_associate_coach MODIFY COLUMN coach_id bigint(255) NOT NULL COMMENT '教练id';
ALTER TABLE `driver-dev`.driver_student_associate_coach MODIFY COLUMN create_time bigint(50) NOT NULL COMMENT '创建时间';
ALTER TABLE `driver-dev`.driver_student_associate_coach MODIFY COLUMN expiration_time bigint(50) NOT NULL COMMENT '过期时间';
ALTER TABLE `driver-dev`.driver_student_associate_coach MODIFY COLUMN is_enable int(1) NOT NULL COMMENT '是否有效';
ALTER TABLE `driver-dev`.driver_student_archives MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '学员表主键';
ALTER TABLE `driver-dev`.driver_student_archives MODIFY COLUMN user_id bigint(255) NOT NULL COMMENT '用户表外键';
ALTER TABLE `driver-dev`.driver_student_archives MODIFY COLUMN realname varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名';
ALTER TABLE `driver-dev`.driver_rfid_record MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '主键';
ALTER TABLE `driver-dev`.driver_rfid_record MODIFY COLUMN user_id bigint(255) NOT NULL COMMENT '用户表id';
ALTER TABLE `driver-dev`.driver_practice MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '练车表主键';
ALTER TABLE `driver-dev`.driver_practice MODIFY COLUMN student_archive_id bigint(255) NOT NULL COMMENT '学员表id';
ALTER TABLE `driver-dev`.driver_car_info MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '车辆信息表主键';
ALTER TABLE `driver-dev`.driver_car_info MODIFY COLUMN coach_id bigint(255) NOT NULL COMMENT '教练id';
ALTER TABLE `driver-dev`.driver_administrator MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '管理员表主键';
ALTER TABLE `driver-dev`.driver_administrator MODIFY COLUMN user_id bigint(255) NOT NULL COMMENT '用户表主键';
ALTER TABLE `driver-dev`.driver_action_record MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '用户操作记录表主键';
ALTER TABLE `driver-dev`.driver_action_record MODIFY COLUMN user_id bigint(255) NOT NULL COMMENT '用户表id';
ALTER TABLE `driver-dev`.driver_coach_archives MODIFY COLUMN id bigint(255) auto_increment NOT NULL COMMENT '教练表主键';
ALTER TABLE `driver-dev`.driver_coach_archives MODIFY COLUMN user_id bigint(255) NOT NULL COMMENT '用户表外键';
