create table question
(
    id          VARCHAR(120) primary key not null,
    question_id VARCHAR(120)             not null,
    title       VARCHAR(200)             not null,
    detail      VARCHAR(400)
);