-- phpMyAdmin SQL Dump
-- version 3.1.3
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Lun 18 Mai 2009 à 18:22
-- Version du serveur: 5.1.32
-- Version de PHP: 5.2.9-1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `formation`
--

-- --------------------------------------------------------

--
-- Structure de la table `javadb`
--

CREATE TABLE IF NOT EXISTS `javadb` (
  `personne` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `javadb`
--

INSERT INTO `javadb` (`personne`) VALUES
('Daniel');
