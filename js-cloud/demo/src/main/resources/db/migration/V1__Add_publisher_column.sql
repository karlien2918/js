CREATE TABLE demo
(
    id                 BIGSERIAL PRIMARY KEY NOT NULL,
    title              varchar(255) UNIQUE   NOT NULL,
    contents           varchar(255)          NOT NULL,
    price              DECIMAL               NOT NULL,
    create_date        TIMESTAMP             NOT NULL,
    last_modified_date TIMESTAMP             NOT NULL,
    version            INTEGER               NOT NULL
);