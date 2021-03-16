create database if not exists dota;
create table if not exists user
(
    id                           bigint auto_increment
    primary key,
    user_name                    varchar(12)                        not null,
    nick_name                    varchar(10)                        null,
    wechat_uuid                  varchar(20)                        null,
    steam_uuid                   varchar(20)                        null,
    user_introduction            varchar(30)                        null,
    phone_number                 int                                null,
    gender                       tinyint(1)                         null,
    profile_background_image_url varchar(400)                       not null,
    create_time                  datetime default CURRENT_TIMESTAMP null,
    profile_background_tile      varchar(5)                         null,
    favourites_count             int      default 0                 null,
    post_count                   int      default 0                 null,
    created_at                   varchar(10)                        not null comment '创建时间背景展示',
    constraint user_user_name_uindex
    unique (user_name)
    )
    comment '用户';

