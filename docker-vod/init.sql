CREATE TABLE circuit
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    country varchar(255) NOT NULL,
    location varchar(255) NOT NULL
);

CREATE TABLE driver
(
    id int AUTO_INCREMENT PRIMARY KEY,
    firstname varchar(255) NOT NULL,
    lastname varchar(255) NOT NULL,
    country varchar(255) NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE team
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    city_location varchar(255) NOT NULL,
    country varchar(255) NOT NULL
);

CREATE TABLE engine_supplier
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    city_location varchar(255) NOT NULL,
    country varchar(255) NOT NULL
);

CREATE TABLE engine
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    engine_supplier_id int NOT NULL,
    FOREIGN KEY (engine_supplier_id) REFERENCES engine_supplier(id)
);

CREATE TABLE season
(
  id int AUTO_INCREMENT PRIMARY KEY,
  year varchar(5) NOT NULL UNIQUE
);

CREATE TABLE grand_prix
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    country varchar(255) NOT NULL,
    gp_date DATE NOT NULL,
    circuit_id int NOT NULL,
    season_id int NOT NULL,
    FOREIGN KEY (circuit_id) REFERENCES circuit(id),
    FOREIGN KEY (season_id) REFERENCES season(id)
);

CREATE TABLE team_entry
(
    id int AUTO_INCREMENT PRIMARY KEY,
    team_id int NOT NULL,
    engine_id int NOT NULL,
    chassis_name varchar(255) NOT NULL,
    season_id int NOT NULL,

    FOREIGN KEY (team_id) REFERENCES team(id),
    FOREIGN KEY (engine_id) REFERENCES engine(id),
    FOREIGN KEY (season_id) REFERENCES  season(id),

    CONSTRAINT uq_team_entry_season_team UNIQUE (season_id, team_id)
);

CREATE TABLE driver_entry
(
    id int AUTO_INCREMENT PRIMARY KEY,
    driver_id int NOT NULL,
    team_entry_id int NOT NULL,
    number int NOT NULL,
    FOREIGN KEY (driver_id) REFERENCES  driver(id),
    FOREIGN KEY (team_entry_id) REFERENCES team_entry(id),

    CONSTRAINT uq_driver_entry_team_number UNIQUE (team_entry_id, number),
    CONSTRAINT uq_driver_entry_team_driver UNIQUE (team_entry_id, driver_id)
);
/*
 w driverEntry modelu wystepuje pole season wiec trzeba bedzie sciagnac z teamEntry
 */

CREATE TABLE result
(
    id int AUTO_INCREMENT PRIMARY KEY ,
    position int NOT NULL,
    driver_entry_id int NOT NULL,
    race_time double NOT NULL,
    fastest_lap double,
    grand_prix_id int NOT NULL,
    FOREIGN KEY (driver_entry_id) REFERENCES driver_entry(id),
    FOREIGN KEY (grand_prix_id) REFERENCES grand_prix(id),

    CONSTRAINT uq_result_gp_driver UNIQUE (grand_prix_id, driver_entry_id)
);

/*
  ADDING GENERAL DATA
 */
 --

 INSERT INTO circuit
 VALUES (1, 'Silverstone Circuit', 'United Kingdom', 'Silverstone'),
        (2, 'Red Bull Ring', 'Austria', 'Spielberg');
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
     (10, 'Kimi', 'Antonelli', 'Italy', '1996-01-01');


INSERT INTO team
VALUES
    (1,'Mclaren', 'Woking', 'United Kingdom'),
    (2, 'Mercedes', 'Brackley', 'Germany'),
    (3, 'Scuderia Ferrari', 'Maranello', 'Italy'),
    (4, 'Red Bull', 'Milton Keynes', 'United Kingdom'),
    (5, 'Audi', 'Hinvil', 'Switzerland')
    );

INSERT INTO engine_supplier
VALUES
    (1,'Audi', 'Neuburg', 'Germany'),
    (2, 'Mercedes HPP', 'Brixworth', 'Germany'),
    (3, 'Ferrari', 'Maranello', 'Italy'),
    (4, 'Red Bull Ford Powertrains', 'Milton Keynes', 'United Kingdom');

INSERT INTO engine
VALUES
    (1, 'Audi AFR 26 Hybrid', 1),
    (2, 'Mercedes-AMG F1 M17', 2),
    (3, 'Ferrari 067/6', 3),
    (4, 'Red Bull Ford DM01',4);

INSERT INTO season
VALUES (1,'2026');

INSERT INTO grand_prix
VALUES
    (1, 'British Grand Prix', 'United Kingdom', '2026-07-12', 1, 1),
    (2, 'Austrian Grand Prix', 'Austria', '2026-07-05', 2, 1);

INSERT INTO team_entry
VALUES
    (1, 1, 2, 'MCL40',1),
    (2, 3, 3, 'SF-26', 1),
    (3, 2, 2, 'W17', 1),
    (4, 4, 4, 'RB22', 1),
    (5, 5, 1, 'R26', 1);

INSERT INTO driver_entry
VALUES
    (1, 1, 4, 3),
    (2, 2, 2, 16),
    (3, 3, 4, 6),
    (4, 4, 5, 5),
    (5, 5, 5, 27),
    (6, 6, 2, 44),
    (7, 7, 1, 1),
    (8, 8, 1, 81),
    (9, 9, 3, 63),
    (10, 10, 3, 12);

INSERT INTO result
VALUES
    /*
     AUSTRIA
     */
    (1, 1, 1, 5000.0, 73.0, 2),
    (2, 2, 2, 5005.0, 74.0, 2),
    (3, 3, 3, 5010.0, 75.0, 2),
    (4, 4, 4, 5011.0, 76.0, 2),
    (5, 5, 5, 5012.0, 77.0, 2),
    (6, 6, 6, 5013.0, 78.0, 2),
    (7, 7, 7, 5015.0, 75.0, 2),
    (8, 8, 8, 5020.0, 78.0, 2),
    (9, 9, 9, 5030.0, 79.0, 2),
    (10, 10, 10, 5040.0, 80.0, 2),
    /*
     UK
     */
    (11, 1, 1, 5000.0, 73.0, 1),
    (12, 2, 2, 5005.0, 74.0, 1),
    (13, 3, 3, 5010.0, 75.0, 1),
    (14, 4, 4, 5011.0, 76.0, 1),
    (15, 5, 5, 5012.0, 77.0, 1),
    (16, 6, 6, 5013.0, 78.0, 1),
    (17, 7, 7, 5015.0, 75.0, 1),
    (18, 8, 8, 5020.0, 78.0, 1),
    (19, 9, 9, 5030.0, 79.0, 1),
    (20, 10, 10, 5040.0, 80.0, 1);
