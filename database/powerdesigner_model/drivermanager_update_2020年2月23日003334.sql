/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/2/23 0:32:07                            */
/*==============================================================*/


drop table if exists driver_action_record;

drop table if exists driver_administrator;

drop table if exists driver_car_info;

drop table if exists driver_coach_archives;

drop table if exists driver_practice;

drop table if exists driver_rfid_record;

drop table if exists driver_student_archives;

drop table if exists driver_student_associate_coach;

drop table if exists driver_subject;

drop table if exists driver_user;

/*==============================================================*/
/* Table: driver_action_record                                  */
/*==============================================================*/
create table driver_action_record
(
   id                   bigint(255) not null auto_increment comment '用户操作记录表主键',
   user_id              bigint(255) not null comment '用户表id',
   action_time          bigint(50) comment '操作时间',
   action_content       varchar(255) comment '操作内容',
   ip_address           varchar(100) comment 'ip地址',
   city                 varchar(100) comment '操作城市',
   primary key (id)
);

alter table driver_action_record comment '用户操作记录表';

/*==============================================================*/
/* Table: driver_administrator                                  */
/*==============================================================*/
create table driver_administrator
(
   id                   bigint(255) not null auto_increment comment '管理员表主键',
   realname             varchar(50) comment '真实姓名',
   gender               varchar(255) comment '性别',
   address              varchar(255) comment '住址',
   wage                 double(10,2) comment '工资',
   job                  varchar(40) comment '职位',
   user_id              bigint(255) not null comment '用户表主键',
   primary key (id)
);

alter table driver_administrator comment '管理员表';

/*==============================================================*/
/* Table: driver_car_info                                       */
/*==============================================================*/
create table driver_car_info
(
   id                   bigint(255) not null auto_increment comment '车辆信息表主键',
   Car_license_number   varchar(200) comment '车牌号',
   purchase_date        bigint(50) comment '购买日期',
   purchase_price       double(10,2) comment '购买价格',
   vehicle_type         varchar(200) comment '车辆型号',
   brand                varchar(200) comment '品牌',
   coach_id             bigint(255) not null comment '教练id',
   primary key (id)
);

/*==============================================================*/
/* Table: driver_coach_archives                                 */
/*==============================================================*/
create table driver_coach_archives
(
   id                   bigint(255) not null auto_increment comment '教练表主键',
   user_id              bigint(255) not null comment '用户表外键',
   realname             varchar(50) comment '真实姓名',
   birthday             varchar(255) comment '出生日期',
   age                  int(5) comment '年龄',
   gender               varchar(20) comment '性别',
   id_photo             varchar(255) comment '证件照',
   user_face            varchar(255) comment '头像',
   national             varchar(255) comment '民族',
   address              varchar(255) comment '住址',
   wage                 double(10,2) comment '工资',
   driver_type          varchar(100) comment '驾照类型',
   car_info_id          bigint(255) comment '车辆信息表id',
   create_time          bigint(50) comment '创建时间',
   is_enable            int(1) comment '是否使用',
   status               varchar(50) comment '信息状态',
   primary key (id)
);

alter table driver_coach_archives comment '教练表';

/*==============================================================*/
/* Table: driver_practice                                       */
/*==============================================================*/
create table driver_practice
(
   id                   bigint(255) not null auto_increment comment '练车表主键',
   student_archive_id   bigint(255) not null comment '学员表id',
   practice_time        bigint(50) comment '练车时间',
   practice_type        varchar(200) comment '练车类型',
   status               varchar(50) comment '记录状态',
   primary key (id)
);

alter table driver_practice comment '练车表';

/*==============================================================*/
/* Table: driver_rfid_record                                    */
/*==============================================================*/
create table driver_rfid_record
(
   id                   bigint(255) not null auto_increment comment '主键',
   user_id              bigint(255) not null comment '用户表id',
   record_time          varchar(200) comment '记录时间',
   status               varchar(100) comment '记录状态',
   deleted              int(1) comment '是否失效',
   primary key (id)
);

alter table driver_rfid_record comment 'RFID记录表';

/*==============================================================*/
/* Table: driver_student_archives                               */
/*==============================================================*/
create table driver_student_archives
(
   id                   bigint(255) not null auto_increment comment '学员表主键',
   user_id              bigint(255) not null comment '用户表外键',
   realname             varchar(50) comment '真实姓名',
   birthday             varchar(255) comment '出生日期',
   age                  int(3) comment '年龄',
   gender               varchar(20) comment '性别',
   id_photo             varchar(255) comment '证件照',
   user_face            varchar(255) comment '头像',
   national             varchar(255) comment '民族',
   address              varchar(255) comment '住址',
   paper_file_number    varchar(200) comment '纸质档案编号',
   driver_type          varchar(20) comment '报考驾照类型',
   medical_time         bigint(50) comment '体检时间',
   agent                varchar(200) comment '经办人',
   sign_date            bigint(50) comment '报名日期',
   archive_id           bigint(255) comment '档案编号',
   expiration_time      bigint(50) comment '过期时间',
   created_time         bigint(50) comment '创建时间',
   is_enable            int(1) comment '是否可用',
   status               varchar(50) comment '信息状态',
   primary key (id)
);

alter table driver_student_archives comment '学员表';

/*==============================================================*/
/* Table: driver_student_associate_coach                        */
/*==============================================================*/
create table driver_student_associate_coach
(
   id                   bigint(255) not null auto_increment comment '学员教练关联表主键',
   student_id           bigint(255) not null comment '学员id',
   coach_id             bigint(255) not null comment '教练id',
   create_time          bigint(50) not null comment '创建时间',
   expiration_time      bigint(50) comment '过期时间',
   is_enable            int(1) not null comment '是否有效',
   status               varchar(50) comment '信息状态',
   description          varchar(255) comment '描述信息',
   primary key (id)
);

alter table driver_student_associate_coach comment '学员教练关联表';

/*==============================================================*/
/* Table: driver_subject                                        */
/*==============================================================*/
create table driver_subject
(
   id                   bigint(255) not null auto_increment comment '科目表主键',
   student_archive_id   bigint(255) not null comment '学员表id',
   sub_name             varchar(200) not null comment '科目名称',
   is_pass              int(1) comment '是否通过',
   score_a              varchar(10) comment '第一次考试成绩',
   score_b              varchar(10) comment '第二次考试成绩',
   exam_time            bigint(50) comment '考试时间',
   exam_room            varchar(200) comment '考场',
   exam_machine_no      varchar(200) comment '考车号或者机器号',
   primary key (id)
);

alter table driver_subject comment '科目表';

/*==============================================================*/
/* Table: driver_user                                           */
/*==============================================================*/
create table driver_user
(
   id                   bigint(255) not null auto_increment comment '用户主键',
   login_Id             varchar(36) comment '用户登录id,最多36长度',
   telphone             varchar(36) not null comment '手机号码,可用来登录',
   rfid_card_id         varchar(255) comment 'rfid卡片编号',
   id_card              varchar(20) not null comment '身份证号,可用来登录(登录默认账户)',
   email                varchar(255) comment '邮箱,用户邮箱，用户接收通知等，可用来登录',
   username             varchar(30) comment '用户名(昵称),可修改',
   password             varchar(2000) comment '加密之后的用户密码',
   role_name            varchar(200) not null comment '角色名',
   role_code            varchar(200) not null comment '角色编码(角色标识)',
   enable               int(1) comment '账户是否可用',
   primary key (id)
);

alter table driver_user comment '用户表';

alter table driver_action_record add constraint FK_Reference_6 foreign key (user_id)
      references driver_user (id) on delete restrict on update restrict;

alter table driver_administrator add constraint FK_Reference_2 foreign key (user_id)
      references driver_user (id) on delete restrict on update restrict;

alter table driver_car_info add constraint FK_Reference_7 foreign key (coach_id)
      references driver_coach_archives (id) on delete restrict on update restrict;

alter table driver_coach_archives add constraint FK_Reference_3 foreign key (user_id)
      references driver_user (id) on delete restrict on update restrict;

alter table driver_practice add constraint FK_Reference_9 foreign key (student_archive_id)
      references driver_student_archives (id) on delete restrict on update restrict;

alter table driver_rfid_record add constraint FK_Reference_10 foreign key (user_id)
      references driver_user (id) on delete restrict on update restrict;

alter table driver_student_archives add constraint FK_Reference_1 foreign key (user_id)
      references driver_user (id) on delete restrict on update restrict;

alter table driver_student_associate_coach add constraint FK_Reference_4 foreign key (student_id)
      references driver_student_archives (id) on delete restrict on update restrict;

alter table driver_student_associate_coach add constraint FK_Reference_5 foreign key (coach_id)
      references driver_coach_archives (id) on delete restrict on update restrict;

alter table driver_subject add constraint FK_Reference_8 foreign key (student_archive_id)
      references driver_student_archives (id) on delete restrict on update restrict;

