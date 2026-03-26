CREATE TABLE circuit
(
    id int PRIMARY KEY,
    name varchar(255) NOT NULL,
    country varchar(255) NOT NULL,
    location varchar(255) NOT NULL
);

CREATE TABLE driver
(
    id int PRIMARY KEY,
    firstname varchar(255) NOT NULL,
    lastname varchar(255) NOT NULL,
    country varchar(255) NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE team
(
    id int PRIMARY KEY,
    name varchar(255) NOT NULL,
    city_location varchar(255) NOT NULL,
    country varchar(255) NOT NULL
);

CREATE TABLE engine_supplier
(
    id int PRIMARY KEY,
    name varchar(255) NOT NULL,
    city_location varchar(255) NOT NULL,

);

CREATE TABLE engine
(
    id int PRIMARY KEY,
    name varchar(255),
    engine_supplier_id int NOT NULL,
    FOREIGN KEY (engine_supplier_id) REFERENCES engine_supplier(id)
);

CREATE TABLE grand_prix
(
  id int PRIMARY KEY,
  name varchar(255) NOT NULL,
  country varchar(255) NOT NULL,
  date DATE NOT NULL,
  circuit_id int NOT NULL,
  season_id int NOT NULL,
  FOREIGN KEY (circuit_id) REFERENCES circuit(id),
  FOREIGN KEY (season_id) REFERENCES season(id)
);

CREATE TABLE result
(
    id int NOT NULL,
    position int NOT NULL,
    driver_id int NOT NULL,
    time double NOT NULL,
    fastest_lap double,
    grand_prix_id int NOT NULL,

    FOREIGN KEY (grand_prix_id) REFERENCES grand_prix(id)
);

CREATE TABLE season
(
  id int PRIMARY KEY,
  year varchar(255) NOT NULL,
);

CREATE TABLE driver_entry
(
    id INT PRIMARY KEY,
    driver_id INT NOT NULL,
    team_entry_id INT NOT NULL,
    number INT NOT NULL,
    FOREIGN KEY (team_entry_id) REFERENCES team_entry(id)
);

CREATE TABLE team_entry
(
    id int PRIMARY KEY,
    team_id int NOT NULL,
    engine_id int NOT NULL,
    chassis_name varchar(255) NOT NULL,
    FOREIGN KEY (team_id) REFERENCES team(id),
    FOREIGN KEY (engine_id) REFERENCES engine(id)

);


/*
  ADDING GENERAL DATA
 */
 --

 INSERT INTO circuit (VALUES (1, 'Silverstone Circuit', 'United Kingdom', 'Silverstone'),
                             (2, 'Red Bull Ring', 'Austria', 'Spielberg'));
 INSERT INTO driver
 VALUES (1,'Max', 'Verstapen', 'Netherlands', '1996-01-01'),
     (2, 'Charles', 'Leclerc', 'Monaco', '1996-01-01'),
     (3, 'Isack', 'Hadjar', 'France', '1996-01-01'),
     (4, 'Gabriel', 'Bortoleto', 'Brazil', '1996-01-01'),
     (5, 'Nico', 'Hulkenberg', 'Germany', '1996-01-01'),
     (6, 'Lewis', 'Hamilton', 'United Kingdom', '1996-01-01'),
     (7, 'Lando', 'Norris', 'United Kingdom', '1996-01-01'),
     (8, 'Oscar', 'Piastri', 'Australia', '1996-01-01'),
     (9, 'George', 'Russell', 'United Kingdom', '1996-01-01'),
     (10, 'Kimi', 'Antonelli', 'Italy', '1996-01-01'));


INSERT INTO team (
VALUES (1,'Mclaren', '')
);