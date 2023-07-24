CREATE TABLE event(
  id BIGSERIAL PRIMARY KEY,
  time_of_creation TIMESTAMP,
  category_id INT REFERENCES category(id)
);