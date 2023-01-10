-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 06 déc. 2022 à 16:12
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `emode`
--

-- --------------------------------------------------------

--
-- Structure de la table `atelier`
--

use heroku_aef8e3d3561a933;

CREATE TABLE `atelier` (
  `id_atelier` int(11) NOT NULL,
  `adresse_atelier` varchar(255) DEFAULT NULL,
  `latitude_atelier` float NOT NULL,
  `logo_atelier` varchar(255) DEFAULT NULL,
  `longitude_atelier` float NOT NULL,
  `nom_atelier` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `atelier`
--

INSERT INTO `atelier` (`id_atelier`, `adresse_atelier`, `latitude_atelier`, `logo_atelier`, `longitude_atelier`, `nom_atelier`) VALUES
(1, 'sotuba', 12, 'logo', 20, 'soya'),
(2, 'sotuba', 10.155, 'logo', 8.4555, 'yaso mode');

-- --------------------------------------------------------

--
-- Structure de la table `atelier_clients`
--

CREATE TABLE `atelier_clients` (
  `id_atelier` int(11) NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `adresse_client` varchar(255) DEFAULT NULL,
  `email_client` varchar(255) DEFAULT NULL,
  `image_client` varchar(255) DEFAULT NULL,
  `nom_client` varchar(255) DEFAULT NULL,
  `prenom_client` varchar(255) DEFAULT NULL,
  `tel_client` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `collection`
--

CREATE TABLE `collection` (
  `id_collection` int(11) NOT NULL,
  `image_collection` varchar(255) DEFAULT NULL,
  `nom_collection` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `depense`
--

CREATE TABLE `depense` (
  `id_depense` int(11) NOT NULL,
  `date_depense` date DEFAULT NULL,
  `montant_depense` float NOT NULL,
  `motif_depense` varchar(255) DEFAULT NULL,
  `atelier_id_atelier` int(11) DEFAULT NULL,
  `produit_id_produit` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mesure`
--

CREATE TABLE `mesure` (
  `id_mesure` int(11) NOT NULL,
  `ceinture` int(11) NOT NULL,
  `cou` int(11) NOT NULL,
  `cuisse` int(11) NOT NULL,
  `epaule` int(11) NOT NULL,
  `fesse` int(11) NOT NULL,
  `longueur` int(11) NOT NULL,
  `longueur_genou` int(11) NOT NULL,
  `longueur_global` int(11) NOT NULL,
  `longueur_pied` int(11) NOT NULL,
  `manche` int(11) NOT NULL,
  `manche_courte` int(11) NOT NULL,
  `poignet` int(11) NOT NULL,
  `poitrine` int(11) NOT NULL,
  `tete` int(11) NOT NULL,
  `tour_de_masse` int(11) NOT NULL,
  `client_id_client` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `date_produit` date DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `image_produit` varchar(255) DEFAULT NULL,
  `prix_produit` float NOT NULL,
  `atelier_id_atelier` int(11) DEFAULT NULL,
  `client_id_client` int(11) DEFAULT NULL,
  `collection_id_collection` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tailleur`
--

CREATE TABLE `tailleur` (
  `id_tailleur` int(11) NOT NULL,
  `adresse_tailleur` varchar(255) DEFAULT NULL,
  `email_tailleur` varchar(255) DEFAULT NULL,
  `image_tailleur` varchar(255) DEFAULT NULL,
  `nom_tailleur` varchar(255) DEFAULT NULL,
  `prenom_tailleur` varchar(255) DEFAULT NULL,
  `tel_tailleur` varchar(255) DEFAULT NULL,
  `atelier_id_atelier` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `atelier`
--
ALTER TABLE `atelier`
  ADD PRIMARY KEY (`id_atelier`);

--
-- Index pour la table `atelier_clients`
--
ALTER TABLE `atelier_clients`
  ADD PRIMARY KEY (`id_atelier`,`id_client`),
  ADD KEY `FKt9ffp9eyde2fc6bc5otw8qfr0` (`id_client`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `collection`
--
ALTER TABLE `collection`
  ADD PRIMARY KEY (`id_collection`);

--
-- Index pour la table `depense`
--
ALTER TABLE `depense`
  ADD PRIMARY KEY (`id_depense`),
  ADD KEY `FKh7ha1lec85orpnb3n2lj32nu6` (`atelier_id_atelier`),
  ADD KEY `FK60d8k8trkienwebenfrmanjqf` (`produit_id_produit`);

--
-- Index pour la table `mesure`
--
ALTER TABLE `mesure`
  ADD PRIMARY KEY (`id_mesure`),
  ADD KEY `FKuly5ivi6441mb57f4qsb9uav` (`client_id_client`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `FKnmve1vcqk9bdkbl7la0w031pk` (`atelier_id_atelier`),
  ADD KEY `FK72w28nnfyn5qb825yj418eqjg` (`client_id_client`),
  ADD KEY `FK1ummvnbp0sqxc9l17rug4sikn` (`collection_id_collection`);

--
-- Index pour la table `tailleur`
--
ALTER TABLE `tailleur`
  ADD PRIMARY KEY (`id_tailleur`),
  ADD KEY `FKlrxwg49fi75cts4mbbw3a9bo7` (`atelier_id_atelier`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `atelier`
--
ALTER TABLE `atelier`
  MODIFY `id_atelier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `collection`
--
ALTER TABLE `collection`
  MODIFY `id_collection` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `depense`
--
ALTER TABLE `depense`
  MODIFY `id_depense` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `mesure`
--
ALTER TABLE `mesure`
  MODIFY `id_mesure` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tailleur`
--
ALTER TABLE `tailleur`
  MODIFY `id_tailleur` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
