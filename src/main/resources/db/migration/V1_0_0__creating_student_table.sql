create table teacher
(
    id          bigserial primary key,
    name        varchar(255) not null,
    last_name   varchar(255) not null,
    middle_name varchar(255) not null,
    birth       date         not null,
    subject     varchar(255) not null,
    sex         varchar(255) not null
);

create table class_room
(
    id         bigserial primary key,
    year       varchar(255) not null,
    code       varchar(255) not null,
    teacher_id bigserial,
    foreign key (teacher_id) references teacher (id)
);

create table student
(
    id            bigserial,
    name          varchar(255) not null,
    last_name     varchar(255) not null,
    middle_name   varchar(255) not null,
    birth         date         not null,
    sex           varchar(255) not null,
    present       bool,
    class_room_id bigserial,
    foreign key (class_room_id) references class_room (id)
);