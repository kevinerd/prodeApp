CREATE DATABASE `prode_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE prode_app;

-- prode_app.usuarios definition
CREATE TABLE `usuarios` (
	`dni` int DEFAULT NULL,
	`nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO prode_app.usuarios (dni, nombre) VALUES
	(40752822,'SOFIA FERNANDEZ'),
	(36980143,'MARCOS GONZALEZ'),
	(43529384,'VALENTINA RUIZ'),
	(38476957,'TOMAS SANCHEZ'),
	(42921618,'FLORENCIA GARCIA');

-- prode_app.equipos definition
CREATE TABLE `equipos` (
	`equipo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`partidosJugados` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO prode_app.equipos (equipo, partidosJugados) VALUES
	('Rayos del Sur',4),
	('Lobos Plateados',4),
	('Halcones del Este',4),
	('Toros del Oeste',4),
	('Dragones de la Montaña',4),
	('Tigres del Norte',4),
	('Escorpiones de la Costa',4),
	('Águilas de la Pampa',4),
	('Leones del Río',4),
	('Centauros de la Cordillera',4);
INSERT INTO prode_app.equipos (equipo, partidosJugados) VALUES
	('Piratas del Atlántico',4),
	('Fénix de la Ciudad',4),
	('Titanes del Interior',4),
	('Zorros del Litoral',4),
	('Panteras del Desierto',4),
	('Tormentas del Sur',4);

-- prode_app.partidos definition
CREATE TABLE `partidos` (
	`idPartido` int DEFAULT NULL,
    `fase` int DEFAULT NULL,
    `ronda` int DEFAULT NULL,
    `numPartido` int DEFAULT NULL,
	`equipo1` varchar(50) DEFAULT NULL,
	`golesEq1` int DEFAULT NULL,
	`golesEq2` int DEFAULT NULL,
	`equipo2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO prode_app.partidos(idPartido,fase,ronda,numPartido,equipo1,golesEq1,golesEq2,equipo2) VALUES
	(111,1,1,1,'Rayos del Sur',3,2,'Tigres del Norte'),
	(112,1,1,2,'Halcones del Este',1,0,'Titanes del Interior'),
	(113,1,1,3,'Dragones de la Montaña',2,2,'Piratas del Atlántico'),
	(114,1,1,4,'Escorpiones de la Costa',4,1,'Zorros del Litoral'),
	(115,1,1,5,'Águilas de la Pampa',2,0,'Fénix de la Ciudad'),
	(116,1,1,6,'Leones del Río',3,1,'Panteras del Desierto'),
	(117,1,1,7,'Lobos Plateados',2,1,'Tormentas del Sur'),
	(118,1,1,8,'Toros del Oeste',0,0,'Centauros de la Cordillera'),
	(121,1,2,1,'Rayos del Sur',2,1,'Centauros de la Cordillera'),
	(122,1,2,2,'Halcones del Este',3,2,'Tormentas del Sur');
INSERT INTO prode_app.partidos(idPartido,fase,ronda,numPartido,equipo1,golesEq1,golesEq2,equipo2) VALUES
	(123,1,2,3,'Dragones de la Montaña',1,1,'Panteras del Desierto'),
	(124,1,2,4,'Escorpiones de la Costa',2,0,'Fénix de la Ciudad'),
	(125,1,2,5,'Águilas de la Pampa',1,2,'Zorros del Litoral'),
	(126,1,2,6,'Leones del Río',2,1,'Piratas del Atlántico'),
	(127,1,2,7,'Lobos Plateados',1,0,'Titanes del Interior'),
	(128,1,2,8,'Toros del Oeste',1,1,'Tigres del Norte'),
	(211,2,1,1,'Rayos del Sur',2,1,'Toros del Oeste'),
	(212,2,1,2,'Lobos Plateados',1,2,'Dragones de la Montaña'),
	(213,2,1,3,'Halcones del Este',3,0,'Leones del Río'),
	(214,2,1,4,'Tormentas del Sur',0,1,'Águilas de la Pampa');
INSERT INTO prode_app.partidos(idPartido,fase,ronda,numPartido,equipo1,golesEq1,golesEq2,equipo2) VALUES
	(215,2,1,5,'Tigres del Norte',2,2,'Escorpiones de la Costa'),
	(216,2,1,6,'Titanes del Interior',1,0,'Zorros del Litoral'),
	(217,2,1,7,'Piratas del Atlántico',1,3,'Centauros de la Cordillera'),
	(218,2,1,8,'Fénix de la Ciudad',2,1,'Panteras del Desierto'),
	(221,2,2,1,'Rayos del Sur',2,1,'Panteras del Desierto'),
	(222,2,2,2,'Lobos Plateados',3,2,'Fénix de la Ciudad'),
	(223,2,2,3,'Halcones del Este',1,0,'Piratas del Atlántico'),
	(224,2,2,4,'Tormentas del Sur',2,2,'Titanes del Interior'),
	(225,2,2,5,'Tigres del Norte',2,1,'Zorros del Litoral'),
	(226,2,2,6,'Toros del Oeste',0,1,'Escorpiones de la Costa');
INSERT INTO prode_app.partidos(idPartido,fase,ronda,numPartido,equipo1,golesEq1,golesEq2,equipo2) VALUES
	(227,2,2,7,'Dragones de la Montaña',2,2,'Águilas de la Pampa'),
	(228,2,2,8,'Leones del Río',3,1,'Centauros de la Cordillera');

-- prode_app.pronosticos definition
CREATE TABLE `pronosticos` (
	`dni` int DEFAULT NULL,
	`idPartido` int NOT NULL,
	`pronostico` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- PERSONA 1
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(40752822,111,2),
	(40752822,112,1),
	(40752822,113,3),
	(40752822,114,2),
	(40752822,115,1),
	(40752822,116,3),
	(40752822,117,1),
	(40752822,118,3),
	(40752822,121,1),
	(40752822,122,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(40752822,123,1),
	(40752822,124,3),
	(40752822,125,2),
	(40752822,126,2),
	(40752822,127,1),
	(40752822,128,1),
	(40752822,211,2),
	(40752822,212,1),
	(40752822,213,2),
	(40752822,214,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(40752822,215,1),
	(40752822,216,2),
	(40752822,217,3),
	(40752822,218,2),
	(40752822,221,1),
	(40752822,222,2),
	(40752822,223,2),
	(40752822,224,3),
	(40752822,225,1),
	(40752822,226,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(40752822,227,2),
	(40752822,228,3);
-- FIN PERSONA 1

-- PERSONA 2
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(36980143,111,2),
	(36980143,112,3),
	(36980143,113,2),
	(36980143,114,1),
	(36980143,115,2),
	(36980143,116,1),
	(36980143,117,3),
	(36980143,118,2),
	(36980143,121,3),
	(36980143,122,1);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(36980143,123,1),
	(36980143,124,2),
	(36980143,125,2),
	(36980143,126,1),
	(36980143,127,2),
	(36980143,128,3),
	(36980143,211,3),
	(36980143,212,2),
	(36980143,213,1),
	(36980143,214,1);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(36980143,215,1),
	(36980143,216,3),
	(36980143,217,1),
	(36980143,218,1),
	(36980143,221,1),
	(36980143,222,3),
	(36980143,223,1),
	(36980143,224,2),
	(36980143,225,3),
	(36980143,226,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(36980143,227,2),
	(36980143,228,3);
-- FIN PERSONA 2

-- PERSONA 3
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(43529384,111,2),
	(43529384,112,3),
	(43529384,113,1),
	(43529384,114,2),
	(43529384,115,3),
	(43529384,116,2),
	(43529384,117,3),
	(43529384,118,1),
	(43529384,121,3),
	(43529384,122,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(43529384,123,2),
	(43529384,124,2),
	(43529384,125,3),
	(43529384,126,1),
	(43529384,127,1),
	(43529384,128,1),
	(43529384,211,3),
	(43529384,212,2),
	(43529384,213,1),
	(43529384,214,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(43529384,215,2),
	(43529384,216,2),
	(43529384,217,1),
	(43529384,218,1),
	(43529384,221,1),
	(43529384,222,3),
	(43529384,223,1),
	(43529384,224,2),
	(43529384,225,1),
	(43529384,226,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(43529384,227,1),
	(43529384,228,3);
-- FIN PERSONA 3

-- PERSONA 4
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(38476957,111,2),
	(38476957,112,2),
	(38476957,113,2),
	(38476957,114,1),
	(38476957,115,1),
	(38476957,116,3),
	(38476957,117,1),
	(38476957,118,3),
	(38476957,121,1),
	(38476957,122,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(38476957,123,1),
	(38476957,124,2),
	(38476957,125,1),
	(38476957,126,3),
	(38476957,127,1),
	(38476957,128,3),
	(38476957,211,3),
	(38476957,212,2),
	(38476957,213,1),
	(38476957,214,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(38476957,215,1),
	(38476957,216,2),
	(38476957,217,2),
	(38476957,218,3),
	(38476957,221,1),
	(38476957,222,1),
	(38476957,223,3),
	(38476957,224,2),
	(38476957,225,1),
	(38476957,226,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(38476957,227,1),
	(38476957,228,3);
-- FIN PERSONA 4

-- PERSONA 5
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(42921618,111,1),
	(42921618,112,2),
	(42921618,113,1),
	(42921618,114,3),
	(42921618,115,2),
	(42921618,116,1),
	(42921618,117,1),
	(42921618,118,3),
	(42921618,121,3),
	(42921618,122,1);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(42921618,123,2),
	(42921618,124,2),
	(42921618,125,1),
	(42921618,126,3),
	(42921618,127,2),
	(42921618,128,1),
	(42921618,211,3),
	(42921618,212,3),
	(42921618,213,1),
	(42921618,214,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(42921618,215,1),
	(42921618,216,2),
	(42921618,217,2),
	(42921618,218,3),
	(42921618,221,1),
	(42921618,222,3),
	(42921618,223,1),
	(42921618,224,3),
	(42921618,225,3),
	(42921618,226,2);
INSERT INTO prode_app.pronosticos (dni,idPartido,pronostico) VALUES
	(42921618,227,2),
	(42921618,228,3);
-- FIN PERSONA 5