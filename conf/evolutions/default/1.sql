# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table konta (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  pozicia                   varchar(255),
  constraint pk_konta primary key (email))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table konta;

SET FOREIGN_KEY_CHECKS=1;

