create table "group"
(
    id   bigserial
        primary key,
    name varchar(255)
);

alter table "group"
    owner to postgres;

insert into public.group (id, name)
values  (1, 'ИБ/1-23'),
        (2, 'ИБ/2-23'),
        (3, 'ИБ/У-23'),
        (4, 'ИТ/1-23'),
        (5, 'ИТ/2-23'),
        (6, 'ИТ/3-23'),
        (7, 'ИТ/У-23');