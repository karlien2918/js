DROP TABLE IF EXISTS demo;
CREATE TABLE demo(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    title   varchar(100) NOT NULL,
    contents varchar(100) NOT NULL,
    price DECIMAL NOT NULL,
    version INTEGER NOT NULL
);