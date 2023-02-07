-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 12 jan. 2023 à 16:40
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données : `zulenko`
--
use heroku_e635b918242fccc;
-- --------------------------------------------------------

--
-- Structure de la table `atelier`
--

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
(2, 'sotuba', 12, 'logo', 20, 'soya');

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
-- Structure de la table `collection`
--

CREATE TABLE `collection` (
  `id_collection` int(11) NOT NULL,
  `image_collection` varchar(255) DEFAULT NULL,
  `nom_collection` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `collection`
--

INSERT INTO `collection` (`id_collection`, `image_collection`, `nom_collection`) VALUES
(1, 'image.png', 'collection mega');

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
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `id_image` int(11) NOT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  `collection_id_collection` int(11) DEFAULT NULL,
  `produit_id_produit` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`id_image`, `url_image`, `collection_id_collection`, `produit_id_produit`) VALUES
(1, 'admin.jpg', NULL, 3),
(2, 'agent.png', NULL, 3),
(3, 'admin.jpg', NULL, 4),
(4, 'agent.png', NULL, 4);

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
  `client_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `date_produit` datetime DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `prix_produit` float NOT NULL,
  `atelier_id_atelier` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `collection_id_collection` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_produit`, `date_produit`, `designation`, `prix_produit`, `atelier_id_atelier`, `client_id`, `collection_id_collection`) VALUES
(3, '2023-01-12 12:26:37', 'ibk', 10000, 2, NULL, 1),
(4, '2023-01-12 12:55:12', 'ibk', 10000, 2, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit_images`
--

CREATE TABLE `produit_images` (
  `produit_id_produit` int(11) NOT NULL,
  `images_id_image` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 0),
(2, 1),
(3, 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `pass` varchar(120) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `atelier_id_atelier` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `adresse`, `email`, `nom`, `pass`, `prenom`, `tel`, `username`, `atelier_id_atelier`) VALUES
(10, 'suguba', 'tailleur3@gmail.com', 'nom', '$2a$10$FHXzIrfzzoiEj4.VeotWIOmX5ZceJmdJsX28m/3RG.hPWGnel2TUW', 'prenom', '20202423', 'tailleur3', NULL),
(9, 'suguba', 'tailleur@gmail.com', 'nom', '$2a$10$Ou6pzQ7QyyV31ufAJqO7cOsOYmUD4/W6qSL03/72iVnaMk4uLtheu', 'prenom', '20202423', 'tailleur', NULL),
(8, 'suguba', 'tailleur2@gmail.com', 'nom', '$2a$10$cB0nLm82A9ydA6m0wWLNNenC5pjKJKGNQ2DyKWXFdLVItaxY5fcE2', 'prenom', '20202423', 'tailleur2', NULL),
(11, 'suguba', 'client@gmail.com', 'nom', '$2a$10$lYe9lLBUXVmrFYmAjboKk.FFJaGgJTnIGXlKEqC6FT1MaGVASqaLC', 'prenom', '20202423', 'client', NULL),
(12, 'suguba', 'client2@gmail.com', 'nom', '$2a$10$Nmjc./XaG3rjFng84mi/Y.Uz3N3i1AVAY7vjTbW0Szbrp03/r.qni', 'prenom', '20202423', 'client2', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES
(8, 2),
(9, 2),
(10, 2),
(11, 1),
(12, 1);

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
  ADD KEY `FKrhwvy9bla2vo61u2ufgkf2sx6` (`id_client`);

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
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id_image`),
  ADD KEY `FKa66jcsdpwkevj6t0j9ck4hopq` (`collection_id_collection`),
  ADD KEY `FKeoo6iuhbnaw88dtrd7jop90j` (`produit_id_produit`);

--
-- Index pour la table `mesure`
--
ALTER TABLE `mesure`
  ADD PRIMARY KEY (`id_mesure`),
  ADD KEY `FK58ym2i9bhuuafgtj5hw3q7w19` (`client_id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `FKnmve1vcqk9bdkbl7la0w031pk` (`atelier_id_atelier`),
  ADD KEY `FK4m1l23pnae0efs1r9vjeplse4` (`client_id`),
  ADD KEY `FK1ummvnbp0sqxc9l17rug4sikn` (`collection_id_collection`);

--
-- Index pour la table `produit_images`
--
ALTER TABLE `produit_images`
  ADD UNIQUE KEY `UK_57qf246g1e0u45s49q4uk7kd8` (`images_id_image`),
  ADD KEY `FKfe0shfmha4woawngkcvi3fpmj` (`produit_id_produit`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe3i9kmqnausqyxnp1o22jkmw5` (`atelier_id_atelier`);

--
-- Index pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`roles_id`),
  ADD KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `atelier`
--
ALTER TABLE `atelier`
  MODIFY `id_atelier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `collection`
--
ALTER TABLE `collection`
  MODIFY `id_collection` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `depense`
--
ALTER TABLE `depense`
  MODIFY `id_depense` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `image`
--
ALTER TABLE `image`
  MODIFY `id_image` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `mesure`
--
ALTER TABLE `mesure`
  MODIFY `id_mesure` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
