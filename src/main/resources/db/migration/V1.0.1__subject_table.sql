create table subject
(
    id          bigserial
        primary key,
    category_id bigint
        constraint fkqfnv6j3cqe07yny9u2v12glhk
            references category,
    name        varchar(255)
);

alter table subject
    owner to postgres;

insert into public.subject (id, category_id, name)
values  (1, null, 'Английский'),
        (2, null, 'АЛГиПРОГ'),
        (3, null, 'Компьютерный дизайн'),
        (4, null, 'Дискретная математика'),
        (5, null, 'История');