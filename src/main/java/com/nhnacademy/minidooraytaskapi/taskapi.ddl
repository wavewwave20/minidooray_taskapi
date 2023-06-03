use nhn_academy_16;


DROP TABLE IF EXISTS user_project;
DROP TABLE IF EXISTS user_task;
DROP TABLE IF EXISTS task_tag;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS milestone;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS user;


create table user
(
    user_uuid     VARCHAR(36) DEFAULT (UUID()) PRIMARY KEY,
    user_id       varchar(255) null,
    user_nickname varchar(255) null
);

create table project
(
    project_id          bigint auto_increment
        primary key,
    project_description varchar(255) null,
    project_name        varchar(255) null,
    project_status      int          null,
    user_uuid           varchar(255) null,
    constraint FK3d77bm4laq2ky6l8hj3q0j80x
        foreign key (user_uuid) references user (user_uuid)
);

create table milestone
(
    milestone_id        bigint auto_increment
        primary key,
    milestone_enddate   datetime(6)  null,
    milestone_name      varchar(255) null,
    milestone_startdate datetime(6)  null,
    milestone_status    int          null,
    project_id          bigint       null,
    constraint FKc3o4jxeki21gqbpy8ejyxtnus
        foreign key (project_id) references project (project_id)
);

create table task
(
    task_id           bigint auto_increment
        primary key,
    task_content      varchar(255) null,
    task_creationdate datetime(6)  null,
    task_enddate      datetime(6)  null,
    task_name         varchar(255) null,
    milestone_id      bigint       null,
    project_id        bigint       null,
    user_uuid         varchar(255) null,
    constraint FK7esxifaqpwlir473qeddcvm9p
        foreign key (user_uuid) references user (user_uuid),
    constraint FKk8qrwowg31kx7hp93sru1pdqa
        foreign key (project_id) references project (project_id),
    constraint FKt8ankrjadgekxvwc5hh9a36no
        foreign key (milestone_id) references milestone (milestone_id)
);

create table comment
(
    comment_id           bigint auto_increment
        primary key,
    comment_content      varchar(255) null,
    comment_creationdate varchar(255) null,
    task_id              bigint       null,
    user_uuid            varchar(255) null,
    constraint FKfknte4fhjhet3l1802m1yqa50
        foreign key (task_id) references task (task_id),
    constraint FKhfs2kkpjwut2mluq5shd8m0ya
        foreign key (user_uuid) references user (user_uuid)
);

create table tag
(
    tag_id     bigint auto_increment
        primary key,
    tag_name   varchar(255) null,
    project_id bigint       null,
    constraint FKbyy56vice9njgl86752up8120
        foreign key (project_id) references project (project_id)
);


create table task_tag
(
    tag_id  bigint not null,
    task_id bigint not null,
    primary key (tag_id, task_id),
    constraint FK9mp6455j6w7duvlo9cwok7s6j
        foreign key (tag_id) references tag (tag_id),
    constraint FKmnb6mkxwtvkg1utqig0ps56ne
        foreign key (task_id) references task (task_id)
);

create table user_project
(
    user_uuid  varchar(255) not null,
    project_id bigint       not null,
    primary key (project_id, user_uuid),
    constraint FK2otpfd35raoy1iqr0q431gg3g
        foreign key (user_uuid) references user (user_uuid),
    constraint FKocfkr6u2yh3w1qmybs8vxuv1c
        foreign key (project_id) references project (project_id)
);

create table user_task
(
    user_user_uuid varchar(255) not null,
    task_task_id   bigint       not null,
    primary key (task_task_id, user_user_uuid),
    constraint FK8aj9jvvrjmvohlthkpa2tl26u
        foreign key (user_user_uuid) references user (user_uuid),
    constraint FKoq3ht79t86oc05gris86o4obw
        foreign key (task_task_id) references task (task_id)
);

