-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-01-2024 a las 20:37:10
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basket`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `club`
--

CREATE TABLE `club` (
  `name` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `club`
--

INSERT INTO `club` (`name`) VALUES
('Atleti'),
('Barcelona'),
('Madrid');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gamesplayed`
--

CREATE TABLE `gamesplayed` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `games` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `results` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `club_id` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `club_id2` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `gamesplayed`
--

INSERT INTO `gamesplayed` (`id`, `date`, `games`, `results`, `club_id`, `club_id2`) VALUES
(1, '2024-01-13', 'Barcelona-Madrid', '5-0', 'Barcelona', 'Madrid'),
(2, '2024-01-10', 'Madrid-Barcelona', '2-6', 'Madrid', 'Barcelona'),
(3, '2024-01-01', 'Atleti-Madrid', '2-4', 'Atleti', 'Madrid'),
(4, '2024-01-04', 'Barcelona-Madrid', '5-1', 'Barcelona', 'Madrid'),
(5, '2023-12-06', 'Barcelona-Atleti', '6-2', 'Barcelona', 'Atleti');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`name`);

--
-- Indices de la tabla `gamesplayed`
--
ALTER TABLE `gamesplayed`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_gamesplayed_club_id` (`club_id`),
  ADD KEY `FK_gamesplayed_club_id2` (`club_id2`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `gamesplayed`
--
ALTER TABLE `gamesplayed`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `gamesplayed`
--
ALTER TABLE `gamesplayed`
  ADD CONSTRAINT `FK_gamesplayed_club_id` FOREIGN KEY (`club_id`) REFERENCES `club` (`name`),
  ADD CONSTRAINT `FK_gamesplayed_club_id2` FOREIGN KEY (`club_id2`) REFERENCES `club` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
