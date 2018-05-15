-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 15-05-2018 a las 04:27:05
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
-- Base de datos: `hospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso`
--

CREATE TABLE `ingreso` (
  `codigoI` int(5) NOT NULL,
  `habitacion` int(3) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `codigo_m` int(11) DEFAULT NULL,
  `codigo_p` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ingreso`
--

INSERT INTO `ingreso` (`codigoI`, `habitacion`, `fecha`, `codigo_m`, `codigo_p`) VALUES
(1, 8, 'Thu Apr 26 10:12:04 CDT 2018', 3, 3),
(2, 6, 'Thu Apr 12 10:02:32 CDT 2018', 3, 3),
(3, 3, 'Thu May 17 08:22:36 CDT 2018', 3, 3),
(4, 8, 'Wed May 09 00:00:00 CDT 2018', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `codigo` int(5) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`codigo`, `nombre`, `apellidos`) VALUES
(2, 'Leo', 'Castro'),
(3, 'jose andres', 'orozco salas'),
(5, 'Leonardo', 'Castro'),
(7, 'lego', 'parts'),
(8, 'sadukis', 'trukis'),
(9, 'sadukis', 'trukis'),
(11, 'sadukis', 'trukis');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `codigoP` int(5) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`codigoP`, `nombre`, `apellidos`) VALUES
(1, 'leo', 'castro'),
(3, 'perro', 'guango'),
(4, 'gera', 'nene'),
(5, 'lampa', 'sitos'),
(6, 'lampa', 'sitos'),
(7, 'lampa', 'sitos'),
(8, 'lampa', 'sitos'),
(9, 'lampa', 'sitos'),
(10, 'lampa', 'sitos'),
(11, 'lampa', 'sitos'),
(12, 'lampa', 'sitos'),
(13, 'lampa', 'sitos'),
(14, 'lampa', 'sitos'),
(15, 'lampa', 'sitos'),
(16, 'lampa', 'sitos'),
(17, 'lampa', 'sitos'),
(18, 'lampa', 'sitos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL COMMENT 'Clave para usuarios',
  `user` varchar(15) NOT NULL COMMENT 'nombre de usuario',
  `password` varchar(15) NOT NULL COMMENT 'password del usuario',
  `gender` varchar(15) NOT NULL COMMENT 'genero'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `user`, `password`, `gender`) VALUES
(1, 'root', '123', 'mujer'),
(2, 'leonardo', 'ldcmleo', 'hombre'),
(3, 'ie', '1234', 'hombre');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ingreso`
--
ALTER TABLE `ingreso`
  ADD PRIMARY KEY (`codigoI`),
  ADD KEY `codigo_m` (`codigo_m`),
  ADD KEY `codigo_p` (`codigo_p`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`codigoP`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ingreso`
--
ALTER TABLE `ingreso`
  MODIFY `codigoI` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `codigo` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `codigoP` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Clave para usuarios', AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ingreso`
--
ALTER TABLE `ingreso`
  ADD CONSTRAINT `codigo_m` FOREIGN KEY (`codigo_m`) REFERENCES `medico` (`codigo`),
  ADD CONSTRAINT `codigo_p` FOREIGN KEY (`codigo_p`) REFERENCES `paciente` (`codigoP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
