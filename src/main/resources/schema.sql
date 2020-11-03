CREATE TABLE cities (
city_id BIGINT IDENTITY PRIMARY KEY,
city_name VARCHAR(50) NOT NULL,
state_id INT NOT NULL,
price DECIMAL(10,2) NOT NULL
);

CREATE TABLE states (
state_id INT PRIMARY KEY,
state_abv CHAR(2) NOT NULL UNIQUE,
state_tax DECIMAL(10,2) NOT NULL
);

ALTER TABLE cities ADD FOREIGN KEY(state_id) REFERENCES states (state_id);