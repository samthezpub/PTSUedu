create table subject
(
    id          bigserial
        primary key,
    name        varchar(255)
);

alter table subject
    owner to postgres;

insert into public.subject (id, name)
values  (1, 'Английский'),
        (2, 'АЛГиПРОГ'),
        (3, 'Компьютерный дизайн'),
        (4, 'Дискретная математика'),
        (5, 'История');