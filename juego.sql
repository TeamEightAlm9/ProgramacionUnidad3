-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 22-05-2018 a las 19:37:47
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juego`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL COMMENT 'id de la ciudad',
  `nombre` varchar(50) NOT NULL COMMENT 'nombre de la ciudad',
  `pos` int(11) NOT NULL COMMENT 'posicion de la ciudad'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `city`
--

INSERT INTO `city` (`id`, `nombre`, `pos`) VALUES
(0, 'Thais', 303030),
(1, 'Carlin', 906090),
(2, 'Venore', 909090),
(3, 'Kazordoon', 609060),
(4, 'Ab\'dendriel', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `id` int(11) NOT NULL COMMENT 'id de la cuenta',
  `nombre` varchar(50) NOT NULL COMMENT 'nombre del usuario',
  `pass` varchar(50) NOT NULL COMMENT 'contraseña del usuario',
  `pacc` bit(1) DEFAULT NULL COMMENT 'si la cuenta es de paga',
  `p_days` int(11) NOT NULL COMMENT 'cuantos dias tiene de paga',
  `email` varchar(50) NOT NULL COMMENT 'correo electronico del usuario'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`id`, `nombre`, `pass`, `pacc`, `p_days`, `email`) VALUES
(0, 'leonardo', 'ldcmleo', b'0', 0, 'ldcmleo19@gmail.com'),
(1, 'andres', 'sada', b'1', 30, 'sadikistruikis@gmail.com'),
(2, 'jose', 'jaos', b'1', 30, 'jaos19@gmail.com'),
(3, 'louis', 'kardashian', b'1', 30, 'louis@gmail.com'),
(4, 'roberto', 'carlos', b'1', 30, 'robert@gmail.com'),
(5, 'angel', 'angel', b'1', 30, 'angel@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `magic`
--

CREATE TABLE `magic` (
  `id` int(11) NOT NULL COMMENT 'id de la magia',
  `voc_id` int(11) NOT NULL COMMENT 'id de la vocacion que la usa',
  `nombre` varchar(50) NOT NULL COMMENT 'nombre del jugador',
  `costo` int(11) NOT NULL COMMENT 'costo de mana',
  `dcp` varchar(50) NOT NULL COMMENT 'descripcion de la magia'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `magic`
--

INSERT INTO `magic` (`id`, `voc_id`, `nombre`, `costo`, `dcp`) VALUES
(0, 0, 'Exori', 115, 'Magia de daño'),
(1, 1, 'Exura sio para', 150, 'Magia de curacion'),
(2, 3, 'Exori con', 25, 'Magia de daño'),
(3, 2, 'Exori flam', 25, 'Magia de daño'),
(4, 2, 'Exevo gran mas flam', 1250, 'Hit mas fuertes de flamas'),
(6, 4, 'Exori gran ico', 300, 'Daño mas juertes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `object`
--

CREATE TABLE `object` (
  `id` int(11) NOT NULL COMMENT 'id de la magia',
  `p_id` int(11) NOT NULL COMMENT 'id del personaje',
  `nombre` varchar(50) NOT NULL COMMENT 'nombre del objeto',
  `prop` varchar(15) NOT NULL COMMENT 'propiedad que altera',
  `prop_c` int(11) NOT NULL COMMENT 'cantidad que altera',
  `dcp` varchar(50) NOT NULL COMMENT 'descripcion del objeto'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `object`
--

INSERT INTO `object` (`id`, `p_id`, `nombre`, `prop`, `prop_c`, `dcp`) VALUES
(0, 0, 'Magic plate armor', 'armor', 17, 'Armadura de caballero'),
(1, 1, 'Knight Armor', 'amor', 12, 'armadura de caballero'),
(2, 2, 'Focus cape', 'magic level', 1, 'Capa para magios'),
(3, 4, 'Leather Armor', 'armor', 5, 'una armadura chafa'),
(4, 3, 'Focus Cape', 'Magic Level', 1, 'capa de mago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `player`
--

CREATE TABLE `player` (
  `id` int(11) NOT NULL COMMENT 'id del jugador',
  `acc_id` int(11) NOT NULL COMMENT 'id de la cuenta del jugador',
  `voc_id` int(11) NOT NULL COMMENT 'id de la vocacion del jugador',
  `nombre` varchar(50) NOT NULL COMMENT 'nombre del jugador',
  `nivel` tinyint(4) NOT NULL COMMENT 'nivel del jugador',
  `vida` int(11) NOT NULL COMMENT 'vida del jugador',
  `mana` int(11) NOT NULL COMMENT 'mana del jugador',
  `atk` int(11) NOT NULL COMMENT 'ataque del jugador',
  `def` int(11) NOT NULL COMMENT 'defensa del jugador',
  `vel` int(11) NOT NULL COMMENT 'velocidad del jugador',
  `lst_log` date NOT NULL COMMENT 'ultima conexion del jugador',
  `city_id` int(11) NOT NULL COMMENT 'residencia del jugador'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `player`
--

INSERT INTO `player` (`id`, `acc_id`, `voc_id`, `nombre`, `nivel`, `vida`, `mana`, `atk`, `def`, `vel`, `lst_log`, `city_id`) VALUES
(0, 1, 0, 'El ampasitos', 111, 1600, 450, 96, 94, 100, '2018-05-16', 0),
(1, 2, 0, 'Thorarce', 49, 700, 250, 82, 86, 100, '2018-05-16', 0),
(2, 0, 2, 'El magio', 44, 360, 800, 50, 40, 100, '2018-05-16', 1),
(3, 5, 2, 'Angel', 50, 400, 1200, 50, 35, 100, '2018-05-21', 4),
(4, 3, 3, 'Louis Kardashian', 8, 150, 200, 1, 1, 99, '2018-05-21', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vocation`
--

CREATE TABLE `vocation` (
  `id` int(11) NOT NULL COMMENT 'id de la vocacion',
  `nombre` varchar(50) NOT NULL COMMENT 'nombre de la vocacion',
  `dcp` varchar(50) NOT NULL COMMENT 'descripcion de la vocacion'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vocation`
--

INSERT INTO `vocation` (`id`, `nombre`, `dcp`) VALUES
(0, 'Knight', 'caballero'),
(1, 'Druid', 'mago curandero'),
(2, 'Sorcerer', 'mago de ataque'),
(3, 'Paladin', 'arquero'),
(4, 'Elite Knight', 'Promocion de Knight'),
(5, 'Elder Druid', 'Promocion de druid'),
(6, 'Master Sorcerer', 'Promocion de sorcerer'),
(7, 'Royal Paladin', 'Promocion de Paladin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `magic`
--
ALTER TABLE `magic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `voc_id` (`voc_id`);

--
-- Indices de la tabla `object`
--
ALTER TABLE `object`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p_id` (`p_id`);

--
-- Indices de la tabla `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`),
  ADD KEY `acc_id` (`acc_id`),
  ADD KEY `voc_id` (`voc_id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indices de la tabla `vocation`
--
ALTER TABLE `vocation`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `magic`
--
ALTER TABLE `magic`
  ADD CONSTRAINT `magic_ibfk_1` FOREIGN KEY (`voc_id`) REFERENCES `vocation` (`id`);

--
-- Filtros para la tabla `object`
--
ALTER TABLE `object`
  ADD CONSTRAINT `object_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `player` (`id`);

--
-- Filtros para la tabla `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `player_ibfk_1` FOREIGN KEY (`acc_id`) REFERENCES `cuenta` (`id`),
  ADD CONSTRAINT `player_ibfk_2` FOREIGN KEY (`voc_id`) REFERENCES `vocation` (`id`),
  ADD CONSTRAINT `player_ibfk_3` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
