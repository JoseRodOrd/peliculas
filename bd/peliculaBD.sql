-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-02-2020 a las 07:53:23
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peliculas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `ID_PEL` int(11) NOT NULL,
  `TITULO` varchar(60) NOT NULL,
  `GENERO` varchar(60) NOT NULL,
  `SINOPSIS` varchar(600) NOT NULL,
  `TIPO` varchar(30) NOT NULL,
  `CALIFICACION` int(11) DEFAULT NULL,
  `IMAGEN` varchar(600) DEFAULT NULL,
  `ESTRENO` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`ID_PEL`, `TITULO`, `GENERO`, `SINOPSIS`, `TIPO`, `CALIFICACION`, `IMAGEN`, `ESTRENO`) VALUES
(5, 'Sherlock Holmes ', '', 'Sherlock Holmes se enfrenta ahora a su mayor desafio: El profesor Moriarty, una truculenta mente criminal que rivaliza con la genialidad del detective ingles, pero cuya capacidad para el mal y su absoluta falta de escrupulos supone una amenaza para todo el Viejo Continente. Para detenerle, Holmes y Watson deberan recorrer Europa de punta a punta en una frenetica carrera contra el tiempo.', 'pelicula', 5, 'https://www.brecorder.com/wp-content/uploads/2019/03/xsherlock-holmes.jpg.pagespeed.ic.2RNyYCGb2K.webp', '2012-02-07'),
(6, 'Mision Imposible: Protocolo Fantasma', '', 'hee Cuarta entrega de la Saga MI. De nuevo, Tom Cruise encarna a Ethan Hunt, a quien se le encarga la peligrosa mision de capturar a unos terroristas, despues de que estos incriminaran a la organizacion del MI en un atentado acaecido en Moscu.', 'pelicula', 1, 'https://1.bp.blogspot.com/-C29yY5DHG9k/Tuv7aXsmgUI/AAAAAAAABYw/QkcOj08dvt0/s400/protocolo-fantasma-cinemascomics.jpg', '2011-12-20'),
(7, 'The Green Hornet', '', 'Britt Reid (Seth Rogen) es el hijo del magnate de los medios de comunicacion mas prominente y respetado de Los Angeles y esta encantado de llevar una inutil existencia de fiesta en fiesta hasta que su padre (Tom Wilkinson) muere misteriosamente, dejandolo al mando de su vasto imperio de medios de comunicacion. ', 'pelicula', 2, 'https://www.guiadelocio.com/var/guiadelocio.com/storage/images/cine/archivo-peliculas/the-green-hornet/8320650-12-esl-ES/the-green-hornet.jpg', '2014-12-16'),
(8, 'Verbo ', 'drama', 'Esta es la historia de una chica de 15 anios un poco peculiar. Sara cuenta con un sexto sentido que sera el que le indique que tiene que existir algo mas de lo que nos rodea, que la vida no solo es esto. Hasta que el tema se convierte en su obsesion.', 'pelicula', 2, 'https://filmmelier.files.wordpress.com/2019/05/3586254.jpg?w=748&h=421', '2019-12-27'),
(9, 'Alvin y las Ardillas 3 ', 'comedia', 'Durante un crucero,Alvin y las Ardillas y Chipettes acaban naufragando en una isla tropical accidentalmente junto a su padre adoptivo, Dave. Lo cual seria un paraiso, sino fuera porque pronto descubren que no estan solos.', 'pelicula', 3, 'https://pm1.narvii.com/6443/bf2c216c4293f1943825cb7d333a7acbf79c1cbb_hq.jpg', '2013-06-19'),
(11, 'Dime con cuantos ', 'comedia', 'Durante un crucero,Alvin y las Ardillas y Chipettes acaban naufragando en una isla tropical accidentalmente junto a su padre adoptivo, Dave. Lo cual seria un paraiso, sino fuera porque pronto descubren que no estan solos.', 'pelicula', 4, 'https://images-na.ssl-images-amazon.com/images/I/71dplVKIz%2BL._SY445_.jpg', '2015-12-06'),
(12, 'Invisibles ', 'drama', 'Tres mujeres se reunen cada jueves para dar un paseo matinal antes de acudir a sus puestos de trabajo.', 'Serie', 5, 'https://www.cineycine.com/archivos/2019/05/the-invisible-man.jpg', '2017-10-06');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`ID_PEL`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `ID_PEL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
