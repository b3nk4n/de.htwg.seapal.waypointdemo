# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table waypoint (
  id                        varchar(255),
  name                      varchar(255),
  position                  varchar(255),
  note                      varchar(255),
  btm                       integer,
  dtm                       integer,
  cog                       integer,
  sog                       integer,
  maneuver                  integer,
  fore_sail                 integer,
  main_sail                 integer,
  constraint ck_waypoint_maneuver check (maneuver in (0,1,2,3,4,5,6,7,8,9)),
  constraint ck_waypoint_fore_sail check (fore_sail in (0,1,2,3,4,5,6,7)),
  constraint ck_waypoint_main_sail check (main_sail in (0,1,2,3)))
;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists waypoint;

SET REFERENTIAL_INTEGRITY TRUE;

