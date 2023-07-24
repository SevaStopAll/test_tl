CREATE TABLE category(
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE,
    parent_category_id int REFERENCES category(id)
);

CREATE TABLE sku(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(128),
    price FLOAT
);

CREATE TABLE sku_category(
  id BIGSERIAL PRIMARY KEY,
  sku_id BIGINT REFERENCES sku(id),
  category_id INTEGER REFERENCES category(id)
);

CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(32) NOT NULL UNIQUE,
    password VARCHAR(16) NOT NULL,
    email varchar(64) NOT NULL UNIQUE
);

CREATE TABLE orders(
    id BIGSERIAL PRIMARY KEY,
    order_time TIMESTAMP DEFAULT NOW(),
    user_id BIGSERIAL REFERENCES users(id)
);

CREATE TABLE sku_order(
  id BIGSERIAL PRIMARY KEY,
  sku_id BIGSERIAL REFERENCES sku(id),
  order_id BIGSERIAL REFERENCES orders(id)
);