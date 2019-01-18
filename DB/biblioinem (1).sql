-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-01-2019 a las 21:28:57
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioinem`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `idAdmin` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idAdmin`, `nombre`, `apellidos`, `usuario`, `password`) VALUES
(1, 'raomir', 'trujillo peña', 'raomir14', 'raomir14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `idAutor` int(11) NOT NULL,
  `nombreAutor` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`idAutor`, `nombreAutor`) VALUES
(1, 'edrfgwrT'),
(2, 'PICASSO'),
(3, 'UMUM'),
(4, 'JJ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `nombreCategoria` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `nombreCategoria`) VALUES
(1, 'fvasdfga'),
(2, 'gergwergY'),
(3, 'GTG');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `idUbicacion` int(11) NOT NULL,
  `edicion` varchar(250) DEFAULT NULL,
  `pasillo` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`idUbicacion`, `edicion`, `pasillo`) VALUES
(1, 'fdqwe', 'fqwf'),
(2, 'GSED', 'GWERG'),
(3, 'U', 'U');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `idEstudiante` int(11) NOT NULL,
  `nombres` varchar(250) DEFAULT NULL,
  `apellidos` varchar(250) DEFAULT NULL,
  `documento` varchar(250) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `telefono` varchar(250) DEFAULT NULL,
  `seccion` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`idEstudiante`, `nombres`, `apellidos`, `documento`, `direccion`, `telefono`, `seccion`) VALUES
(6, 'RAOMIR', 'TRUJILLO', '1084900898', 'calle 17a sur #35-40', '3115826581', '12345678900000'),
(7, 'FGERG', 'FGWERG', '123456789', 'fqw', '165', '65465');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL,
  `editorial` varchar(250) DEFAULT NULL,
  `autor` int(11) DEFAULT NULL,
  `tema` int(11) DEFAULT NULL,
  `ubicacion` int(11) DEFAULT NULL,
  `categoria` int(11) NOT NULL,
  `titulo` varchar(250) DEFAULT NULL,
  `idioma` varchar(250) DEFAULT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`idLibro`, `editorial`, `autor`, `tema`, `ubicacion`, `categoria`, `titulo`, `idioma`, `cantidad`) VALUES
(2, 'fwqe', 1, 1, 1, 1, 'mate', 'fgqwer', 77),
(10, 'fasd', 2, 1, 2, 1, 'FASDF', 'fasd', 74),
(11, 'gwer', 2, 1, 2, 1, 'GWER', 'ggwe', 24),
(12, 'fqw', 2, 1, 2, 1, 'FW', 'fwe', 44),
(13, 'gsd', 2, 1, 2, 1, 'BGGSDF', 'gsdf', 1),
(14, 'fasd', 1, 3, 1, 1, 'FA', 'fasd', 20),
(15, 'fasd', 1, 3, 1, 1, 'FASDF', 'dfasd', 23),
(16, 'gsdf', 2, 4, 2, 2, 'GSDF', 'gsdf', 23),
(18, 'g5', 3, 3, 2, 2, 'GTG', 'g45', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL,
  `libro` int(11) DEFAULT NULL,
  `estudiante` int(11) DEFAULT NULL,
  `fechaSolicitud` date DEFAULT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`idPrestamo`, `libro`, `estudiante`, `fechaSolicitud`, `fechaDevolucion`, `estado`) VALUES
(24, 2, 6, '2019-01-01', '2019-01-01', 1),
(25, 2, 6, '2019-01-04', '2019-01-04', 1),
(26, 16, 6, '2019-01-05', '2019-01-05', 1),
(27, 2, 6, '2019-01-05', '2019-01-05', 1),
(28, 2, 6, '2019-01-05', '2019-01-05', 1),
(29, 2, 6, '2019-01-05', '2019-01-05', 1),
(30, 2, 7, '2019-01-05', '2019-01-05', 1),
(31, 2, 6, '2019-01-05', '2019-01-05', 1),
(32, 18, 7, '2019-01-05', '2019-01-05', 1),
(33, 18, 7, '2019-01-05', '2019-01-05', 1),
(34, 18, 7, '2019-01-05', '2019-01-05', 1),
(35, 18, 7, '2019-01-05', '2019-01-05', 1),
(36, 18, 7, '2019-01-05', '2019-01-05', 1),
(37, 2, 7, '2019-01-05', '2019-01-05', 1),
(38, 18, 7, '2019-01-05', '2019-01-05', 1),
(39, 18, 7, '2019-01-05', '2019-01-05', 1),
(40, 18, 7, '2019-01-05', '2019-01-05', 1),
(41, 18, 7, '2019-01-05', '2019-01-05', 1),
(42, 18, 7, '2019-01-05', '2019-01-05', 1),
(43, 18, 7, '2019-01-05', '2019-01-05', 1),
(44, 18, 7, '2019-01-05', '2019-01-05', 1),
(45, 18, 7, '2019-01-05', '2019-01-05', 1),
(46, 2, 7, '2019-01-05', '2019-01-05', 1),
(47, 2, 6, '2019-01-05', '2019-01-05', 1),
(48, 2, 6, '2019-01-05', '2019-01-05', 1),
(49, 18, 6, '2019-01-05', '2019-01-05', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema`
--

CREATE TABLE `tema` (
  `idTema` int(11) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tema`
--

INSERT INTO `tema` (`idTema`, `nombre`) VALUES
(1, 'gwergwT'),
(3, 'GWEG'),
(4, 'GEG');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`idAutor`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`idUbicacion`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`idEstudiante`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idLibro`),
  ADD KEY `libro_ibfk_1` (`autor`),
  ADD KEY `libro_ibfk_2` (`tema`),
  ADD KEY `libro_ibfk_3` (`ubicacion`),
  ADD KEY `libro_ibfk_4` (`categoria`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `libro` (`libro`),
  ADD KEY `estudiante` (`estudiante`);

--
-- Indices de la tabla `tema`
--
ALTER TABLE `tema`
  ADD PRIMARY KEY (`idTema`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `idAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `idUbicacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `idEstudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `tema`
--
ALTER TABLE `tema`
  MODIFY `idTema` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`autor`) REFERENCES `autor` (`idAutor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`tema`) REFERENCES `tema` (`idTema`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_ibfk_3` FOREIGN KEY (`ubicacion`) REFERENCES `ejemplar` (`idUbicacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_ibfk_4` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`libro`) REFERENCES `libro` (`idLibro`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`estudiante`) REFERENCES `estudiante` (`idEstudiante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
