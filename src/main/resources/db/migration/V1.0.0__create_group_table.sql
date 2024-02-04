-- auto-generated definition
create table "group"
(
    id            bigint not null primary key,
    name          varchar(255),
    status        varchar(255)
        constraint group_status_check
            check ((status)::text = ANY
                   ((ARRAY ['ACTIVE'::character varying, 'DISABLED'::character varying, 'DELETED'::character varying])::text[])),
    creation_date date
    );
