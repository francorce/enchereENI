-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 14 avr. 2022 à 12:33
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ekip_eni`
--
CREATE DATABASE IF NOT EXISTS `ekip_eni` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ekip_eni`;

-- --------------------------------------------------------

--
-- Structure de la table `articles_vendus`
--

DROP TABLE IF EXISTS `articles_vendus`;
CREATE TABLE IF NOT EXISTS `articles_vendus` (
  `no_article` int(11) NOT NULL AUTO_INCREMENT,
  `nom_article` varchar(30) NOT NULL,
  `description` varchar(300) NOT NULL,
  `photo` longblob,
  `date_debut_encheres` datetime NOT NULL,
  `date_fin_encheres` datetime NOT NULL,
  `prix_initial` int(11) DEFAULT NULL,
  `prix_vente` int(11) DEFAULT NULL,
  `no_utilisateur` int(11) NOT NULL,
  `no_categorie` int(11) NOT NULL,
  `isSold` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`no_article`),
  KEY `articles_vendus_categories_fk` (`no_categorie`),
  KEY `ventes_utilisateur_fk` (`no_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `no_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) NOT NULL,
  PRIMARY KEY (`no_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `encheres`
--

DROP TABLE IF EXISTS `encheres`;
CREATE TABLE IF NOT EXISTS `encheres` (
  `no_enchere` int(11) NOT NULL AUTO_INCREMENT,
  `date_enchere` datetime(3) NOT NULL,
  `montant_enchere` int(11) NOT NULL,
  `no_article` int(11) NOT NULL,
  `no_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`no_enchere`),
  KEY `encheres_utilisateur_fk` (`no_utilisateur`),
  KEY `encheres_no_article_fk` (`no_article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `retraits`
--

DROP TABLE IF EXISTS `retraits`;
CREATE TABLE IF NOT EXISTS `retraits` (
  `no_article` int(11) NOT NULL AUTO_INCREMENT,
  `rue` varchar(30) NOT NULL,
  `code_postal` varchar(15) NOT NULL,
  `ville` varchar(30) NOT NULL,
  PRIMARY KEY (`no_article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `no_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `rue` varchar(50) NOT NULL,
  `code_postal` varchar(10) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `mot_de_passe` varchar(30) NOT NULL,
  `credit` int(11) NOT NULL,
  `administrateur` tinyint(4) NOT NULL,
  `UUID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`no_utilisateur`),
  UNIQUE KEY `pseudo` (`pseudo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `articles_vendus`
--
ALTER TABLE `articles_vendus`
  ADD CONSTRAINT `articles_vendus_categories_fk` FOREIGN KEY (`no_categorie`) REFERENCES `categories` (`no_categorie`),
  ADD CONSTRAINT `ventes_utilisateur_fk` FOREIGN KEY (`no_utilisateur`) REFERENCES `utilisateurs` (`no_utilisateur`) ON DELETE CASCADE;

--
-- Contraintes pour la table `encheres`
--
ALTER TABLE `encheres`
  ADD CONSTRAINT `encheres_no_article_fk` FOREIGN KEY (`no_article`) REFERENCES `articles_vendus` (`no_article`) ON DELETE CASCADE,
  ADD CONSTRAINT `encheres_utilisateur_fk` FOREIGN KEY (`no_utilisateur`) REFERENCES `utilisateurs` (`no_utilisateur`) ON DELETE CASCADE;

--
-- Contraintes pour la table `retraits`
--
ALTER TABLE `retraits`
  ADD CONSTRAINT `retrait_article_fk` FOREIGN KEY (`no_article`) REFERENCES `articles_vendus` (`no_article`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
