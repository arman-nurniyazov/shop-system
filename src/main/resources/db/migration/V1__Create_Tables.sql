DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS transactions;

CREATE TABLE category
(
    id serial,
    name character varying,
    PRIMARY KEY (id)
);

CREATE TABLE product
(
    id serial,
    name character varying,
    price double precision,
    count integer,
    category_id int,
    PRIMARY KEY (id),
    CONSTRAINT fk_category_id FOREIGN KEY (category_id)
        REFERENCES category (id)
);

CREATE TABLE transactions
(
    id serial,
    product_id int,
    count int,
    type character varying,
    PRIMARY KEY (id),
    CONSTRAINT fk_product_id FOREIGN KEY (product_id)
        REFERENCES product (id)
);