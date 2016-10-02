-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 02, 2016 at 01:50 AM
-- Server version: 5.5.49-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `panaderiagil4`
--
CREATE DATABASE IF NOT EXISTS `panaderiagil5` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `panaderiagil5`;

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarPan`(IN var_idPan INT,
                                     IN var_codigoPan VARCHAR(10),
                                     IN var_nombre VARCHAR(25), 
                                     IN var_descripcion VARCHAR(50),
                                     IN var_precioP DOUBLE,
                                     IN var_precioV DOUBLE)
BEGIN       
        /*Iniciamos una transacción para asegurar la integridad de los registros:*/
        START TRANSACTION;
            /*Actualizamos la tabla persona:*/
            UPDATE panes SET    nombre = var_nombre, codigoPan = var_codigoPan, 
                                descripcion = var_descripcion, precioP = var_precioP,
                                precioV = var_precioV                              
            WHERE idP = var_idPan;      
        /*Si no hay error, aceptamos los cambios de forma permanente:*/
            
        COMMIT;
    END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detalle`
--

CREATE TABLE IF NOT EXISTS `detalle` (
  `idD` int(11) NOT NULL AUTO_INCREMENT,
  `folio` int(11) NOT NULL,
  `idP` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT '0',
  `importe` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`idD`),
  KEY `fk_detallePanaes` (`idP`),
  KEY `fk_detalleVentas` (`folio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=226 ;

--
-- Dumping data for table `detalle`
--

INSERT INTO `detalle` (`idD`, `folio`, `idP`, `cantidad`, `importe`, `total`) VALUES
(1, 1, 1, 5, NULL, NULL),
(2, 1, 2, 5, NULL, NULL),
(3, 2, 1, 1, 435, 435),
(4, 2, 2, 2, 23, 46),
(5, 3, 3, 11, 35, 385),
(6, 3, 4, 12, 19, 228),
(7, 4, 2, 1, 23, 23),
(8, 4, 2, 23, 234, 5382),
(9, 5, 2, 1, 23, 23),
(10, 5, 4, 2, 23, 46),
(11, 6, 2, 1, 3, 3),
(12, 7, 2, 1, 2, 2),
(13, 7, 2, 1, 32, 32),
(14, 7, 2, 1, 3, 3),
(15, 7, 2, 1, 23, 23),
(16, 7, 2, 1, 3, 3),
(17, 7, 2, 1, 23, 23),
(18, 7, 2, 1, 3, 3),
(19, 7, 2, 1, 3, 3),
(20, 7, 2, 1, 2, 2),
(21, 7, 2, 1, 3, 3),
(22, 8, 2, 1, 2.4, 2.4),
(23, 8, 2, 1, 5.37, 5.37),
(24, 8, 2, 2, 23, 46),
(25, 8, 2, 1, 3, 3),
(26, 9, 3, 1, 2, 2),
(27, 10, 3, 1, 2, 2),
(28, 11, 4, 1, 3, 3),
(29, 12, 4, 2, 3, 6),
(30, 13, 4, 1, 3, 3),
(31, 14, 4, 1, 2, 2),
(32, 14, 4, 1, 2, 2),
(33, 15, 4, 1, 3, 3),
(34, 15, 4, 1, 3, 3),
(35, 16, 3, 1, 2, 2),
(36, 17, 3, 1, 2, 2),
(37, 18, 3, 1, 34, 34),
(38, 19, 3, 2, 1, 2),
(39, 20, 3, 12, 2, 24),
(40, 21, 3, 1, 2, 2),
(41, 22, 3, 1, 2, 2),
(42, 23, 3, 1, 23, 23),
(43, 23, 3, 2, 234, 468),
(44, 24, 3, 1, 5, 5),
(45, 25, 3, 1, 23, 23),
(46, 25, 3, 1, 3, 3),
(47, 27, 5, 1, 1, 1),
(48, 28, 4, 2, 7.5, 15),
(49, 28, 3, 1, 9.5, 9.5),
(50, 28, 3, 1, 9.5, 9.5),
(51, 28, 3, 1, 9.5, 9.5),
(52, 28, 3, 1, 9.5, 9.5),
(53, 28, 3, 1, 9.5, 9.5),
(54, 28, 3, 1, 9.5, 9.5),
(55, 28, 3, 1, 9.5, 9.5),
(56, 28, 3, 1, 9.5, 9.5),
(57, 29, 3, 1, 9.5, 9.5),
(58, 29, 3, 1, 9.5, 9.5),
(59, 29, 3, 1, 9.5, 9.5),
(60, 29, 3, 1, 9.5, 9.5),
(61, 29, 3, 1, 9.5, 9.5),
(62, 29, 3, 1, 9.5, 9.5),
(63, 29, 3, 1, 9.5, 9.5),
(64, 29, 3, 1, 9.5, 9.5),
(65, 29, 3, 1, 9.5, 9.5),
(66, 29, 3, 1, 9.5, 9.5),
(67, 29, 3, 1, 9.5, 9.5),
(68, 29, 3, 1, 9.5, 9.5),
(69, 29, 3, 1, 9.5, 9.5),
(70, 29, 3, 1, 9.5, 9.5),
(71, 29, 3, 1, 9.5, 9.5),
(72, 29, 3, 1, 9.5, 9.5),
(73, 29, 3, 1, 9.5, 9.5),
(74, 29, 3, 1, 9.5, 9.5),
(75, 29, 3, 1, 9.5, 9.5),
(76, 29, 3, 1, 9.5, 9.5),
(77, 29, 3, 1, 9.5, 9.5),
(78, 29, 3, 1, 9.5, 9.5),
(79, 29, 3, 1, 9.5, 9.5),
(80, 29, 3, 1, 9.5, 9.5),
(81, 29, 3, 1, 9.5, 9.5),
(82, 29, 3, 1, 9.5, 9.5),
(83, 29, 3, 1, 9.5, 9.5),
(84, 29, 3, 1, 9.5, 9.5),
(85, 29, 3, 1, 9.5, 9.5),
(86, 29, 3, 1, 9.5, 9.5),
(87, 29, 3, 1, 9.5, 9.5),
(88, 29, 3, 1, 9.5, 9.5),
(89, 29, 3, 1, 9.5, 9.5),
(90, 29, 3, 1, 9.5, 9.5),
(91, 29, 3, 1, 9.5, 9.5),
(92, 29, 3, 1, 9.5, 9.5),
(93, 29, 3, 1, 9.5, 9.5),
(94, 29, 3, 1, 9.5, 9.5),
(95, 29, 3, 1, 9.5, 9.5),
(96, 29, 3, 1, 9.5, 9.5),
(97, 29, 3, 1, 9.5, 9.5),
(98, 29, 3, 1, 9.5, 9.5),
(99, 30, 3, 1, 9.5, 9.5),
(100, 31, 3, 1, 9.5, 9.5),
(101, 32, 5, 1, 3.5, 3.5),
(102, 33, 2, 1, 5.5, 5.5),
(103, 33, 2, 1, 5.5, 5.5),
(104, 33, 2, 1, 5.5, 5.5),
(105, 33, 2, 1, 5.5, 5.5),
(106, 33, 2, 1, 5.5, 5.5),
(107, 33, 2, 1, 5.5, 5.5),
(108, 33, 2, 1, 5.5, 5.5),
(109, 33, 2, 1, 5.5, 5.5),
(110, 33, 2, 1, 5.5, 5.5),
(111, 33, 2, 1, 5.5, 5.5),
(112, 33, 2, 1, 5.5, 5.5),
(113, 33, 2, 1, 5.5, 5.5),
(114, 33, 2, 1, 5.5, 5.5),
(115, 33, 2, 1, 5.5, 5.5),
(116, 33, 2, 1, 5.5, 5.5),
(117, 33, 2, 1, 5.5, 5.5),
(118, 33, 2, 1, 5.5, 5.5),
(119, 33, 2, 1, 5.5, 5.5),
(120, 33, 2, 1, 5.5, 5.5),
(121, 33, 2, 1, 5.5, 5.5),
(122, 33, 2, 1, 5.5, 5.5),
(123, 33, 2, 1, 5.5, 5.5),
(124, 33, 2, 1, 5.5, 5.5),
(125, 33, 2, 1, 5.5, 5.5),
(126, 33, 2, 1, 5.5, 5.5),
(127, 34, 2, 1, 5.5, 5.5),
(128, 34, 2, 1, 5.5, 5.5),
(129, 34, 2, 1, 5.5, 5.5),
(130, 34, 2, 1, 5.5, 5.5),
(131, 34, 2, 1, 5.5, 5.5),
(132, 34, 2, 1, 5.5, 5.5),
(133, 34, 2, 1, 5.5, 5.5),
(134, 34, 2, 1, 5.5, 5.5),
(135, 34, 2, 1, 5.5, 5.5),
(136, 34, 2, 1, 5.5, 5.5),
(137, 34, 2, 1, 5.5, 5.5),
(138, 34, 2, 12, 5.5, 66),
(139, 34, 2, 1, 5.5, 5.5),
(140, 34, 2, 1, 5.5, 5.5),
(141, 35, 6, 1, 3.5, 3.5),
(142, 35, 6, 1, 3.5, 3.5),
(143, 35, 6, 1, 3.5, 3.5),
(144, 35, 6, 1, 3.5, 3.5),
(145, 35, 6, 1, 3.5, 3.5),
(146, 35, 6, 1, 3.5, 3.5),
(147, 35, 6, 1, 3.5, 3.5),
(148, 35, 6, 1, 3.5, 3.5),
(149, 35, 6, 1, 3.5, 3.5),
(150, 36, 6, 1, 3.5, 3.5),
(151, 37, 6, 10, 3.5, 3.5),
(152, 37, 6, 1, 3.5, 3.5),
(153, 37, 6, 1, 3.5, 3.5),
(154, 37, 6, 1, 3.5, 3.5),
(155, 37, 6, 1, 3.5, 3.5),
(156, 37, 6, 1, 3.5, 3.5),
(157, 37, 6, 1, 3.5, 3.5),
(158, 37, 6, 1, 3.5, 3.5),
(159, 37, 6, 1, 3.5, 3.5),
(160, 38, 6, 1, 3.5, 3.5),
(161, 38, 6, 1, 3.5, 3.5),
(162, 38, 6, 1, 3.5, 3.5),
(163, 38, 6, 1, 3.5, 3.5),
(164, 38, 6, 1, 3.5, 3.5),
(165, 38, 6, 1, 3.5, 3.5),
(166, 38, 6, 1, 3.5, 3.5),
(167, 38, 6, 1, 3.5, 3.5),
(168, 38, 6, 1, 3.5, 3.5),
(169, 38, 6, 114002080, 3.5, 3.5),
(170, 39, 6, 1, 3.5, 3.5),
(171, 39, 6, 1, 3.5, 3.5),
(172, 39, 6, 1, 3.5, 3.5),
(173, 39, 6, 1, 3.5, 3.5),
(174, 39, 6, 1, 3.5, 3.5),
(175, 39, 6, 1, 3.5, 3.5),
(176, 39, 6, 1, 3.5, 3.5),
(177, 39, 6, 1, 3.5, 3.5),
(178, 39, 6, 1, 3.5, 3.5),
(179, 39, 6, 1, 3.5, 3.5),
(180, 39, 6, 1, 3.5, 3.5),
(181, 39, 6, 1, 3.5, 3.5),
(182, 39, 6, 1, 3.5, 3.5),
(183, 40, 6, 1, 3.5, 3.5),
(184, 40, 6, 1, 3.5, 3.5),
(185, 40, 6, 1, 3.5, 3.5),
(186, 40, 6, 1, 3.5, 3.5),
(187, 40, 6, 1, 3.5, 3.5),
(188, 40, 6, 1, 3.5, 3.5),
(189, 40, 2, 1, 5.5, 5.5),
(190, 41, 6, 1, 3.5, 3.5),
(191, 41, 6, 1, 3.5, 3.5),
(192, 41, 6, 1, 3.5, 3.5),
(193, 42, 6, 1, 3.5, 3.5),
(194, 42, 6, 1, 3.5, 3.5),
(195, 42, 6, 1, 3.5, 3.5),
(196, 42, 6, 1, 3.5, 3.5),
(197, 42, 6, 1, 3.5, 3.5),
(198, 42, 6, 1, 3.5, 3.5),
(199, 42, 6, 1, 3.5, 3.5),
(200, 42, 6, 1, 3.5, 3.5),
(201, 42, 6, 1, 3.5, 3.5),
(202, 42, 6, 1, 3.5, 3.5),
(203, 42, 6, 1, 3.5, 3.5),
(204, 43, 6, 1, 3.5, 3.5),
(205, 43, 6, 1, 3.5, 3.5),
(206, 43, 6, 1, 3.5, 3.5),
(207, 43, 6, 1, 3.5, 3.5),
(208, 43, 6, 1, 3.5, 3.5),
(209, 44, 6, 1, 3.5, 3.5),
(210, 45, 6, 1, 3.5, 3.5),
(211, 45, 6, 1, 3.5, 3.5),
(212, 45, 6, 1, 3.5, 3.5),
(213, 45, 6, 1, 3.5, 3.5),
(214, 45, 6, 1, 3.5, 3.5),
(215, 45, 6, 1, 3.5, 3.5),
(216, 45, 6, 1, 3.5, 3.5),
(217, 45, 6, 1, 3.5, 3.5),
(218, 45, 6, 1, 3.5, 3.5),
(219, 46, 6, 1, 3.5, 3.5),
(220, 46, 2, 1, 5.5, 5.5),
(221, 47, 6, 1, 3.5, 3.5),
(222, 47, 5, 1, 3.5, 3.5),
(223, 47, 6, 1, 3.5, 3.5),
(224, 48, 6, 1, 3.5, 3.5),
(225, 48, 6, 1, 3.5, 3.5);

--
-- Triggers `detalle`
--
DROP TRIGGER IF EXISTS `actualizarInventario`;
DELIMITER //
CREATE TRIGGER `actualizarInventario` AFTER INSERT ON `detalle`
 FOR EACH ROW BEGIN
declare precio double;

	update inventario 
    set existencia = existencia-new.cantidad
    WHERE idP = new.idP;
    
    
    set precio = (select precioV
    from panes
    where idP = new.idP);
	
    update ventas 
    set total = total + (precio * new.cantidad)
    where folio = new.folio;
end
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `inventario`
--

CREATE TABLE IF NOT EXISTS `inventario` (
  `idI` int(11) NOT NULL AUTO_INCREMENT,
  `idP` int(11) NOT NULL,
  `existencia` int(11) DEFAULT '0',
  `fecha` date NOT NULL,
  PRIMARY KEY (`idI`),
  KEY `fk_invenatarioPanaes` (`idP`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `inventario`
--

INSERT INTO `inventario` (`idI`, `idP`, `existencia`, `fecha`) VALUES
(1, 1, 100, '2016-09-26'),
(2, 2, 48, '2016-09-26'),
(3, 3, 48, '2016-09-26'),
(4, 5, 97, '2016-09-28'),
(5, 6, 47, '2016-09-28');

-- --------------------------------------------------------

--
-- Stand-in structure for view `mostrar`
--
CREATE TABLE IF NOT EXISTS `mostrar` (
`idI` int(11)
,`idP` int(11)
,`nombre` varchar(25)
,`existencia` int(11)
,`fecha` date
);
-- --------------------------------------------------------

--
-- Table structure for table `panes`
--

CREATE TABLE IF NOT EXISTS `panes` (
  `idP` int(11) NOT NULL AUTO_INCREMENT,
  `codigoPan` varchar(10) DEFAULT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `precioP` double NOT NULL,
  `precioV` double DEFAULT NULL,
  `imagen` mediumtext,
  `estatus` int(1) DEFAULT '1',
  PRIMARY KEY (`idP`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `panes`
--

INSERT INTO `panes` (`idP`, `codigoPan`, `nombre`, `descripcion`, `precioP`, `precioV`, `imagen`, `estatus`) VALUES
(1, '15001272', 'EMPANADOTA', 'PAN DULCE RELLENO DE CHOCOLATE', 5.5, 7.5, ' ', 1),
(2, '15001461', 'DONA', 'PAN DULCE ESPOLVOREADO DE AZUCAR', 3.5, 5.5, ' ', 1),
(3, '15001530', 'MANTECADA', 'PAN DULCE SABOR VAINILLA', 6.5, 9.5, ' ', 1),
(4, '15001272', 'EMPANADA', 'PAN DULCE RELLENO', 5.5, 7.5, NULL, 1),
(5, '15001897', 'CONCHA CHOCOLATE', 'Esta bien buena', 2, 3.5, 'D', 1),
(6, '14002080', 'BOLILLO', 'BUENISIMO', 1, 3.5, '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', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `qr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `user`, `password`, `qr`) VALUES
(1, 'lalo', 'Eduardo199', '1991');

-- --------------------------------------------------------

--
-- Table structure for table `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `folio` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` double DEFAULT '0',
  PRIMARY KEY (`folio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=49 ;

--
-- Dumping data for table `ventas`
--

INSERT INTO `ventas` (`folio`, `fecha`, `total`) VALUES
(1, '2016-09-26', 65),
(2, '2016-09-26', 499.5),
(3, '2016-09-26', 807.5),
(4, '2016-09-27', 5537),
(5, '2016-09-27', 89.5),
(6, '2016-09-27', 8.5),
(7, '2016-09-27', 152),
(8, '2016-09-27', 84.27),
(9, '2016-09-27', 11.5),
(10, '2016-09-27', 11.5),
(11, '2016-09-27', 10.5),
(12, '2016-09-27', 21),
(13, '2016-09-27', 10.5),
(14, '2016-09-27', 19),
(15, '2016-09-27', 21),
(16, '2016-09-27', 11.5),
(17, '2016-09-27', 11.5),
(18, '2016-09-27', 43.5),
(19, '2016-09-28', 21),
(20, '2016-09-28', 138),
(21, '2016-09-28', 11.5),
(22, '2016-09-28', 11.5),
(23, '2016-09-28', 519.5),
(24, '2016-09-28', 14.5),
(25, '2016-09-28', 45),
(26, '2016-09-28', 30),
(27, '2016-09-28', 4.5),
(28, '2016-09-28', 182),
(29, '2016-09-28', 798),
(30, '2016-09-28', 19),
(31, '2016-09-28', 19),
(32, '2016-09-28', 7),
(33, '2016-09-28', 275),
(34, '2016-09-28', 275),
(35, '2016-09-28', 63),
(36, '2016-09-28', 7),
(37, '2016-09-28', 94.5),
(38, '2016-09-28', 399007346.5),
(39, '2016-09-29', 91),
(40, '2016-09-29', 53),
(41, '2016-09-29', 21),
(42, '2016-09-29', 77),
(43, '2016-09-29', 35),
(44, '2016-09-29', 7),
(45, '2016-09-29', 63),
(46, '2016-09-29', 18),
(47, '2016-09-30', 21),
(48, '2016-09-30', 14);

-- --------------------------------------------------------

--
-- Structure for view `mostrar`
--
DROP TABLE IF EXISTS `mostrar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mostrar` AS select `i`.`idI` AS `idI`,`i`.`idP` AS `idP`,`p`.`nombre` AS `nombre`,`i`.`existencia` AS `existencia`,`i`.`fecha` AS `fecha` from (`inventario` `i` join `panes` `p` on((`i`.`idP` = `p`.`idP`)));

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `fk_detallePanaes` FOREIGN KEY (`idP`) REFERENCES `panes` (`idP`),
  ADD CONSTRAINT `fk_detalleVentas` FOREIGN KEY (`folio`) REFERENCES `ventas` (`folio`);

--
-- Constraints for table `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `fk_invenatarioPanaes` FOREIGN KEY (`idP`) REFERENCES `panes` (`idP`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
