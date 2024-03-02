-- auto-generated definition
create table homework
(
    id        bigserial
        primary key,
    text      varchar(255),
    lesson_id bigint
        constraint uk_fddwm9ubgulrbbxmq5bpmvn85
            unique
        constraint fk1hfa7auounxtrsgqvp694ixhf
            references lesson
);

alter table homework
    owner to postgres;

