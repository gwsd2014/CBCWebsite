# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table class (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  grade_low                 integer,
  grade_high                integer,
  deployed                  tinyint(1) default 0,
  disavowed                 tinyint(1) default 0,
  instructor_id             bigint,
  created_time              datetime not null,
  updated_time              datetime not null,
  constraint pk_class primary key (id))
;

create table class_record (
  id                        bigint auto_increment not null,
  cleared                   tinyint(1) default 0,
  disavowed                 tinyint(1) default 0,
  user_id                   bigint,
  course_id                 bigint,
  created_time              datetime not null,
  updated_time              datetime not null,
  constraint pk_class_record primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  email                     varchar(255),
  username                  varchar(255),
  password                  varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  grade                     integer,
  type                      integer,
  disavowed                 tinyint(1) default 0,
  created_time              datetime not null,
  updated_time              datetime not null,
  constraint ck_user_type check (type in (0,1,2)),
  constraint uq_user_email unique (email),
  constraint uq_user_username unique (username),
  constraint pk_user primary key (id))
;


create table class_user (
  class_id                       bigint not null,
  user_id                        bigint not null,
  constraint pk_class_user primary key (class_id, user_id))
;
alter table class add constraint fk_class_instructor_1 foreign key (instructor_id) references user (id) on delete restrict on update restrict;
create index ix_class_instructor_1 on class (instructor_id);
alter table class_record add constraint fk_class_record_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_class_record_user_2 on class_record (user_id);
alter table class_record add constraint fk_class_record_course_3 foreign key (course_id) references class (id) on delete restrict on update restrict;
create index ix_class_record_course_3 on class_record (course_id);



alter table class_user add constraint fk_class_user_class_01 foreign key (class_id) references class (id) on delete restrict on update restrict;

alter table class_user add constraint fk_class_user_user_02 foreign key (user_id) references user (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table class;

drop table class_user;

drop table class_record;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

