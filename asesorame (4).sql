-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2019 at 11:01 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.2.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asesorame`
--

-- --------------------------------------------------------

--
-- Table structure for table `aprendiz`
--

CREATE TABLE `aprendiz` (
  `id_usuario` int(5) NOT NULL,
  `id_reputacion` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aprendiz`
--

INSERT INTO `aprendiz` (`id_usuario`, `id_reputacion`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `aprendiz_vs_comentario`
--

CREATE TABLE `aprendiz_vs_comentario` (
  `id_aprendiz` int(5) NOT NULL,
  `id_comentario` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `asesor`
--

CREATE TABLE `asesor` (
  `id_usuario` int(5) NOT NULL,
  `id_reputacion` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asesor`
--

INSERT INTO `asesor` (`id_usuario`, `id_reputacion`) VALUES
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `asesoria`
--

CREATE TABLE `asesoria` (
  `id_asesoria` int(5) NOT NULL,
  `id_asesor` int(5) NOT NULL,
  `fecha-hora` datetime NOT NULL,
  `lugar` varchar(100) NOT NULL,
  `tipo` int(5) NOT NULL,
  `precio` int(6) DEFAULT NULL,
  `estado` int(5) DEFAULT NULL,
  `tema` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asesoria`
--

INSERT INTO `asesoria` (`id_asesoria`, `id_asesor`, `fecha-hora`, `lugar`, `tipo`, `precio`, `estado`, `tema`) VALUES
(1, 2, '2019-12-11 00:00:00', 'Abanico', 4, 30000, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `asesor_vs_comentario`
--

CREATE TABLE `asesor_vs_comentario` (
  `id_asesor` int(5) NOT NULL,
  `id_comentario` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `asistencia`
--

CREATE TABLE `asistencia` (
  `id_asistencia` int(5) NOT NULL,
  `id_aprendiz` int(5) NOT NULL,
  `id_asesoria` int(5) NOT NULL,
  `verificado` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asistencia`
--

INSERT INTO `asistencia` (`id_asistencia`, `id_aprendiz`, `id_asesoria`, `verificado`) VALUES
(1, 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `comentario`
--

CREATE TABLE `comentario` (
  `id_comentario` int(5) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `fecha-hora` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `debilidades`
--

CREATE TABLE `debilidades` (
  `id_aprendiz` int(5) NOT NULL,
  `id_materia` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `debilidades`
--

INSERT INTO `debilidades` (`id_aprendiz`, `id_materia`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `estado`
--

CREATE TABLE `estado` (
  `id` varchar(1) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estado`
--

INSERT INTO `estado` (`id`, `nombre`) VALUES
('n', 'No Validado'),
('v', 'Validado');

-- --------------------------------------------------------

--
-- Table structure for table `estado_asesoria`
--

CREATE TABLE `estado_asesoria` (
  `id_estado` int(5) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estado_asesoria`
--

INSERT INTO `estado_asesoria` (`id_estado`, `nombre`) VALUES
(1, 'Activa'),
(2, 'Cancelada'),
(3, 'En Espera');

-- --------------------------------------------------------

--
-- Table structure for table `fortalezas`
--

CREATE TABLE `fortalezas` (
  `id_asesor` int(5) NOT NULL,
  `id_materia` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `genero`
--

CREATE TABLE `genero` (
  `id` varchar(1) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genero`
--

INSERT INTO `genero` (`id`, `nombre`) VALUES
('F', 'Femenino'),
('M', 'Masculino'),
('N', 'No Binario');

-- --------------------------------------------------------

--
-- Table structure for table `materias`
--

CREATE TABLE `materias` (
  `id` int(5) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `materias`
--

INSERT INTO `materias` (`id`, `nombre`) VALUES
(1, 'Calculo'),
(2, 'Fisica'),
(3, 'Bases de Datos');

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `id` int(5) NOT NULL,
  `nombre1` varchar(50) NOT NULL,
  `nombre2` varchar(50) DEFAULT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `fecha_nac` date NOT NULL,
  `genero` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`id`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `fecha_nac`, `genero`) VALUES
(1, 'Jhoan', 'Alfredo', 'Mancilla', 'Blanco', '1996-11-15', 'M'),
(2, 'Cristian', 'David ', 'Lopez', 'Guarin', '2000-05-16', 'M');

-- --------------------------------------------------------

--
-- Table structure for table `pregunta_seg`
--

CREATE TABLE `pregunta_seg` (
  `id_pregunta` int(5) NOT NULL,
  `descripcion` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pregunta_seg`
--

INSERT INTO `pregunta_seg` (`id_pregunta`, `descripcion`) VALUES
(1, '¿En qué ciudad naciste?'),
(2, '¿Cual es tu grupo o artista favorito?'),
(3, '¿Cual es el nombre de tu primera mascota?'),
(4, '¿cual es tu libro favorito?'),
(5, '¿Cual es tu color favorito?');

-- --------------------------------------------------------

--
-- Table structure for table `reputacion`
--

CREATE TABLE `reputacion` (
  `id_reputacion` int(5) NOT NULL,
  `valor` float(5,2) NOT NULL,
  `numero_asistencias` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reputacion`
--

INSERT INTO `reputacion` (`id_reputacion`, `valor`, `numero_asistencias`) VALUES
(1, 5.00, 2),
(2, 5.00, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_asesoria`
--

CREATE TABLE `tipo_asesoria` (
  `id_tipo` int(1) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_asesoria`
--

INSERT INTO `tipo_asesoria` (`id_tipo`, `nombre`) VALUES
(3, 'Privada'),
(4, 'Publica');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id_persona` int(5) NOT NULL,
  `fecha_reg` date NOT NULL,
  `correo` varchar(80) NOT NULL,
  `nombre_usuario` varchar(100) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `id_pregunta` int(5) NOT NULL,
  `respuesta` varchar(250) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `inst_educativa` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id_persona`, `fecha_reg`, `correo`, `nombre_usuario`, `contrasena`, `id_pregunta`, `respuesta`, `estado`, `inst_educativa`) VALUES
(1, '2019-11-05', 'jhoan0809c@gmail.com', 'RealSmoke', 'chowiesputo', 1, 'cucuta', 'v', 'UFPS'),
(2, '2019-12-17', 'juanviejocastro@gmail.com', 'newlife16', 'chowiesputo', 3, 'nose', 'v', 'UFPS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aprendiz`
--
ALTER TABLE `aprendiz`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_aprendiz_reputacion` (`id_reputacion`);

--
-- Indexes for table `aprendiz_vs_comentario`
--
ALTER TABLE `aprendiz_vs_comentario`
  ADD PRIMARY KEY (`id_aprendiz`,`id_comentario`),
  ADD KEY `fk_aprendiz_comentario-T` (`id_comentario`);

--
-- Indexes for table `asesor`
--
ALTER TABLE `asesor`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_asesor_reputacion` (`id_reputacion`);

--
-- Indexes for table `asesoria`
--
ALTER TABLE `asesoria`
  ADD PRIMARY KEY (`id_asesoria`),
  ADD KEY `IDX_fk_asesoria` (`id_asesor`) USING BTREE,
  ADD KEY `fk_asesoria_materia` (`tema`),
  ADD KEY `fk_asesoria_estado-as` (`estado`),
  ADD KEY `fk_asesoria_tipo` (`tipo`);

--
-- Indexes for table `asesor_vs_comentario`
--
ALTER TABLE `asesor_vs_comentario`
  ADD PRIMARY KEY (`id_asesor`,`id_comentario`),
  ADD KEY `fk_asesor_comentario-T` (`id_comentario`);

--
-- Indexes for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id_asistencia`),
  ADD KEY `fk_asistencia_asesoria` (`id_asesoria`),
  ADD KEY `id_aprendiz` (`id_aprendiz`);

--
-- Indexes for table `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id_comentario`);

--
-- Indexes for table `debilidades`
--
ALTER TABLE `debilidades`
  ADD PRIMARY KEY (`id_aprendiz`,`id_materia`),
  ADD KEY `fk_debilidades_materia` (`id_materia`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `estado_asesoria`
--
ALTER TABLE `estado_asesoria`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indexes for table `fortalezas`
--
ALTER TABLE `fortalezas`
  ADD PRIMARY KEY (`id_asesor`,`id_materia`),
  ADD KEY `fk_fortalezas_materia` (`id_materia`);

--
-- Indexes for table `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_persona_genero` (`genero`);

--
-- Indexes for table `pregunta_seg`
--
ALTER TABLE `pregunta_seg`
  ADD PRIMARY KEY (`id_pregunta`);

--
-- Indexes for table `reputacion`
--
ALTER TABLE `reputacion`
  ADD PRIMARY KEY (`id_reputacion`);

--
-- Indexes for table `tipo_asesoria`
--
ALTER TABLE `tipo_asesoria`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_persona`),
  ADD KEY `fk_usuario_pregunta-seg` (`id_pregunta`),
  ADD KEY `fk_usuario_estado` (`estado`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asesoria`
--
ALTER TABLE `asesoria`
  MODIFY `id_asesoria` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `id_asistencia` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `comentario`
--
ALTER TABLE `comentario`
  MODIFY `id_comentario` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `estado_asesoria`
--
ALTER TABLE `estado_asesoria`
  MODIFY `id_estado` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `materias`
--
ALTER TABLE `materias`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pregunta_seg`
--
ALTER TABLE `pregunta_seg`
  MODIFY `id_pregunta` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reputacion`
--
ALTER TABLE `reputacion`
  MODIFY `id_reputacion` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tipo_asesoria`
--
ALTER TABLE `tipo_asesoria`
  MODIFY `id_tipo` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aprendiz`
--
ALTER TABLE `aprendiz`
  ADD CONSTRAINT `fk_aprendiz_reputacion` FOREIGN KEY (`id_reputacion`) REFERENCES `reputacion` (`id_reputacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_aprendiz_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_persona`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `aprendiz_vs_comentario`
--
ALTER TABLE `aprendiz_vs_comentario`
  ADD CONSTRAINT `fk_aprendiz-comentario` FOREIGN KEY (`id_aprendiz`) REFERENCES `aprendiz` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_aprendiz_comentario-T` FOREIGN KEY (`id_comentario`) REFERENCES `comentario` (`id_comentario`) ON UPDATE CASCADE;

--
-- Constraints for table `asesor`
--
ALTER TABLE `asesor`
  ADD CONSTRAINT `fk_asesor_reputacion` FOREIGN KEY (`id_reputacion`) REFERENCES `reputacion` (`id_reputacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_asesor_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_persona`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `asesoria`
--
ALTER TABLE `asesoria`
  ADD CONSTRAINT `fk_asesoria_asesor` FOREIGN KEY (`id_asesor`) REFERENCES `asesor` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_asesoria_estado-as` FOREIGN KEY (`estado`) REFERENCES `estado_asesoria` (`id_estado`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_asesoria_materia` FOREIGN KEY (`tema`) REFERENCES `materias` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_asesoria_tipo` FOREIGN KEY (`tipo`) REFERENCES `tipo_asesoria` (`id_tipo`) ON UPDATE CASCADE;

--
-- Constraints for table `asesor_vs_comentario`
--
ALTER TABLE `asesor_vs_comentario`
  ADD CONSTRAINT `fk_asesor-comentario` FOREIGN KEY (`id_asesor`) REFERENCES `asesor` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_asesor_comentario-T` FOREIGN KEY (`id_comentario`) REFERENCES `comentario` (`id_comentario`) ON UPDATE CASCADE;

--
-- Constraints for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `fk_asistencia_aprendiz` FOREIGN KEY (`id_aprendiz`) REFERENCES `aprendiz` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_asistencia_asesoria` FOREIGN KEY (`id_asesoria`) REFERENCES `asesoria` (`id_asesoria`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `debilidades`
--
ALTER TABLE `debilidades`
  ADD CONSTRAINT `fk_debilidades_aprendiz` FOREIGN KEY (`id_aprendiz`) REFERENCES `aprendiz` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_debilidades_materia` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `fortalezas`
--
ALTER TABLE `fortalezas`
  ADD CONSTRAINT `fk_fortalezas_asesor` FOREIGN KEY (`id_asesor`) REFERENCES `asesor` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_fortalezas_materia` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_persona_genero` FOREIGN KEY (`genero`) REFERENCES `genero` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_estado` FOREIGN KEY (`estado`) REFERENCES `estado` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuario_persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuario_pregunta-seg` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta_seg` (`id_pregunta`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
