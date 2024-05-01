CREATE TABLE IF NOT EXISTS mark_price(
    id          SERIAL PRIMARY KEY,
    symbol      VARCHAR(255),
    mark_price  VARCHAR(255),
    UNIQUE (symbol)
);