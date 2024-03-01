create table lesson
(
    id      bigserial
        primary key,
    content varchar(255),
    title   varchar(255)
);

alter table lesson
    owner to postgres;

insert into public.lesson (id, content, title)
values  (1, '<p>Описание того, что там было на той вашей паре</p>', 'Первая пара'),
        (2, '<p>Какой-то текст</p>', 'Пара 2: скачать обои клеш рояль');