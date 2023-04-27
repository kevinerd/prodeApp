CREATE DATABASE `prode_app` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE prode_app;

-- prode_app.equipo definition
CREATE TABLE `equipo` (
	`id` INT UNSIGNED NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`nombre` varchar(50) NOT NULL
);

INSERT INTO prode_app.equipo (nombre) VALUES
	('Rayos del Sur'),
	('Lobos Plateados'),
	('Halcones del Este'),
	('Toros del Oeste'),
	('Dragones de la Montaña'),
	('Tigres del Norte'),
	('Escorpiones de la Costa'),
	('Águilas de la Pampa'),
	('Leones del Río'),
	('Centauros de la Cordillera');
INSERT INTO prode_app.equipo (nombre) VALUES
	('Piratas del Atlántico'),
	('Fénix de la Ciudad'),
	('Titanes del Interior'),
	('Zorros del Litoral'),
	('Panteras del Desierto'),
	('Tormentas del Sur');

-- prode_app.usuario definition
CREATE TABLE `usuario` (
	`dni` INT UNSIGNED NOT NULL PRIMARY KEY,
	`nombre` varchar(50) NOT NULL
);

INSERT INTO prode_app.usuario (dni, nombre) VALUES
	(40752822,'SOFIA FERNANDEZ'),
	(36980143,'MARCOS GONZALEZ'),
	(43529384,'VALENTINA RUIZ'),
	(38476957,'TOMAS SANCHEZ'),
	(42921618,'FLORENCIA GARCIA');

-- prode_app.partido definition
CREATE TABLE `partido` (
	`id` INT UNSIGNED NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `num_fase` INT UNSIGNED NOT NULL,
    `num_ronda` INT UNSIGNED NOT NULL,
	`equipo_id1` INT UNSIGNED NOT NULL,
	`goles_eq1` INT UNSIGNED NOT NULL,
	`goles_eq2` INT UNSIGNED NOT NULL,
	`equipo_id2` INT UNSIGNED NOT NULL,
	FOREIGN KEY (equipo_id1) REFERENCES equipo(id),
	FOREIGN KEY (equipo_id2) REFERENCES equipo(id)
);

INSERT INTO prode_app.partido(num_fase,num_ronda,equipo_id1,goles_eq1,goles_eq2,equipo_id2) VALUES
	(1,1,1,3,2,6),
	(1,1,3,1,0,13),
	(1,1,5,2,2,11),
	(1,1,7,4,1,14),
	(1,1,8,2,0,12),
	(1,1,9,3,1,15),
	(1,1,2,2,1,16),
	(1,1,4,0,0,10),
	(1,2,1,2,1,10),
	(1,2,3,3,2,16);
INSERT INTO prode_app.partido(num_fase,num_ronda,equipo_id1,goles_eq1,goles_eq2,equipo_id2) VALUES
	(1,2,5,1,1,15),
	(1,2,7,2,0,12),
	(1,2,8,1,2,14),
	(1,2,9,2,1,11),
	(1,2,2,1,0,13),
	(1,2,4,1,1,6),
	(2,1,1,2,1,4),
	(2,1,2,1,2,5),
	(2,1,3,3,0,9),
	(2,1,16,0,1,8);
INSERT INTO prode_app.partido(num_fase,num_ronda,equipo_id1,goles_eq1,goles_eq2,equipo_id2) VALUES
	(2,1,6,2,2,7),
	(2,1,13,1,0,14),
	(2,1,11,1,3,10),
	(2,1,12,2,1,15),
	(2,2,1,2,1,15),
	(2,2,2,3,2,12),
	(2,2,3,1,0,11),
	(2,2,16,2,2,13),
	(2,2,6,2,1,14),
	(2,2,4,0,1,7);
INSERT INTO prode_app.partido(num_fase,num_ronda,equipo_id1,goles_eq1,goles_eq2,equipo_id2) VALUES
	(2,2,5,2,2,8),
	(2,2,9,3,1,10);

-- prode_app.ticket definition
CREATE TABLE `ticket` (
	`id` INT UNSIGNED NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`usuario_dni` INT UNSIGNED NOT NULL,
	`partido_id` INT UNSIGNED NOT NULL,
	`pronostico` INT UNSIGNED NOT NULL,
	FOREIGN KEY (usuario_dni) REFERENCES usuario(dni),
	FOREIGN KEY (partido_id) REFERENCES partido(id)
);

-- PERSONA 1
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(40752822,1,2),
	(40752822,2,1),
	(40752822,3,3),
	(40752822,4,2),
	(40752822,5,1),
	(40752822,6,3),
	(40752822,7,1),
	(40752822,8,3),
	(40752822,9,1),
	(40752822,10,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(40752822,11,1),
	(40752822,12,3),
	(40752822,13,2),
	(40752822,14,2),
	(40752822,15,1),
	(40752822,16,1),
	(40752822,17,2),
	(40752822,18,1),
	(40752822,19,2),
	(40752822,20,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(40752822,21,1),
	(40752822,22,2),
	(40752822,23,3),
	(40752822,24,2),
	(40752822,25,1),
	(40752822,26,2),
	(40752822,27,2),
	(40752822,28,3),
	(40752822,29,1),
	(40752822,30,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(40752822,31,2),
	(40752822,32,3);
-- FIN PERSONA 1

-- PERSONA 2
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(36980143,1,2),
	(36980143,2,3),
	(36980143,3,2),
	(36980143,4,1),
	(36980143,5,2),
	(36980143,6,1),
	(36980143,7,3),
	(36980143,8,2),
	(36980143,9,3),
	(36980143,10,1);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(36980143,11,1),
	(36980143,12,2),
	(36980143,13,2),
	(36980143,14,1),
	(36980143,15,2),
	(36980143,16,3),
	(36980143,17,3),
	(36980143,18,2),
	(36980143,19,1),
	(36980143,20,1);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(36980143,21,1),
	(36980143,22,3),
	(36980143,23,1),
	(36980143,24,1),
	(36980143,25,1),
	(36980143,26,3),
	(36980143,27,1),
	(36980143,28,2),
	(36980143,29,3),
	(36980143,30,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(36980143,31,2),
	(36980143,32,3);
-- FIN PERSONA 2

-- PERSONA 3
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(43529384,1,2),
	(43529384,2,3),
	(43529384,3,1),
	(43529384,4,2),
	(43529384,5,3),
	(43529384,6,2),
	(43529384,7,3),
	(43529384,8,1),
	(43529384,9,3),
	(43529384,10,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(43529384,11,2),
	(43529384,12,2),
	(43529384,13,3),
	(43529384,14,1),
	(43529384,15,1),
	(43529384,16,1),
	(43529384,17,3),
	(43529384,18,2),
	(43529384,19,1),
	(43529384,20,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(43529384,21,2),
	(43529384,22,2),
	(43529384,23,1),
	(43529384,24,1),
	(43529384,25,1),
	(43529384,26,3),
	(43529384,27,1),
	(43529384,28,2),
	(43529384,29,1),
	(43529384,30,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(43529384,31,1),
	(43529384,32,3);
-- FIN PERSONA 3

-- PERSONA 4
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(38476957,1,2),
	(38476957,2,2),
	(38476957,3,2),
	(38476957,4,1),
	(38476957,5,1),
	(38476957,6,3),
	(38476957,7,1),
	(38476957,8,3),
	(38476957,9,1),
	(38476957,10,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(38476957,11,1),
	(38476957,12,2),
	(38476957,13,1),
	(38476957,14,3),
	(38476957,15,1),
	(38476957,16,3),
	(38476957,17,3),
	(38476957,18,2),
	(38476957,19,1),
	(38476957,20,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(38476957,21,1),
	(38476957,22,2),
	(38476957,23,2),
	(38476957,24,3),
	(38476957,25,1),
	(38476957,26,1),
	(38476957,27,3),
	(38476957,28,2),
	(38476957,29,1),
	(38476957,30,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(38476957,31,1),
	(38476957,32,3);
-- FIN PERSONA 4

-- PERSONA 5
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(42921618,1,1),
	(42921618,2,2),
	(42921618,3,1),
	(42921618,4,3),
	(42921618,5,2),
	(42921618,6,1),
	(42921618,7,1),
	(42921618,8,3),
	(42921618,9,3),
	(42921618,10,1);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(42921618,11,2),
	(42921618,12,2),
	(42921618,13,1),
	(42921618,14,3),
	(42921618,15,2),
	(42921618,16,1),
	(42921618,17,3),
	(42921618,18,3),
	(42921618,19,1),
	(42921618,20,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(42921618,21,1),
	(42921618,22,2),
	(42921618,23,2),
	(42921618,24,3),
	(42921618,25,1),
	(42921618,26,3),
	(42921618,27,1),
	(42921618,28,3),
	(42921618,29,3),
	(42921618,30,2);
INSERT INTO prode_app.ticket (usuario_dni,partido_id,pronostico) VALUES
	(42921618,31,2),
	(42921618,32,3);
-- FIN PERSONA 5