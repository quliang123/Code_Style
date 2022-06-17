create table question_updated_record
(
    question_id    varchar(120) not null,
    update_id      varchar(120),
    update_type   varchar(10)  not null,
    updated_at     timestamp    not null,
    reason         varchar(64),
    created_title  varchar(120),
    created_detail varchar(400),
    unedited_title varchar(120),
    edited_title    varchar(120),
    edited_detail   varchar(400),
    unedited_detail varchar(400)
);
