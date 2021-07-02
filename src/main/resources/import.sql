INSERT INTO utilisateur (prenom, nom, email, mot_passe, privilege, date_inscription) VALUES ('Federico', 'Desmoulin', 'desmoulin.federico@gmail.com', '9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 'MEMBRE', '2020-02-01 11:11:11');
INSERT INTO utilisateur (prenom, nom, email, mot_passe, privilege, date_inscription) VALUES ('Mathieu', 'Desmoulin', 'desmoulin.mathieu@gmail.com', '9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 'UTILISATEUR', '2020-02-01 11:11:12');
INSERT INTO utilisateur (prenom, nom, email, mot_passe, privilege, date_inscription) VALUES ('Guy', 'Desmoulin', 'desmoulin.guy@gmail.com', '9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 'UTILISATEUR', '2020-02-01 11:11:13');
INSERT INTO utilisateur (prenom, nom, email, mot_passe, privilege, date_inscription) VALUES ('Eugenia', 'Gomez', 'desmoulin.eugenia@gmail.com', '9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 'UTILISATEUR', '2020-02-01 11:11:14');

INSERT INTO site (nom,  region, utilisateur_id) VALUES ('Le chemin de la Marmotte', 'Provence-Alpes-Côte d''Azur', '1');
INSERT INTO site (nom,  region, utilisateur_id) VALUES ('Le Pic', 'Auvergne-Rhône-Alpes', '2');

INSERT INTO commentaire (commentaire, utilisateur_id, site_id) VALUES ('Pour les débutants', '1', '1');
INSERT INTO commentaire (commentaire, utilisateur_id, site_id) VALUES ('Trop facile...', '2', '1');
INSERT INTO commentaire (commentaire, utilisateur_id, site_id) VALUES ('Pas pour tout le monde !!!', '4', '1');
INSERT INTO commentaire (commentaire, utilisateur_id, site_id) VALUES ('A la pointe !', '2', '2');
INSERT INTO commentaire (commentaire, utilisateur_id, site_id) VALUES ('Quelle vue...', '1', '2');
INSERT INTO commentaire (commentaire, utilisateur_id, site_id) VALUES ('Pas facile...', '3', '2');

INSERT INTO secteur (nom, utilisateur_id, site_id) VALUES ('La Petite Marmotte', '1', '1');
INSERT INTO secteur (nom, utilisateur_id, site_id) VALUES ('La Grande Marmotte', '3', '1');
INSERT INTO secteur (nom, utilisateur_id, site_id) VALUES ('Le Vertigineux', '2', '2');
INSERT INTO secteur (nom, utilisateur_id, site_id) VALUES ('Le Grandiose', '2', '2');

INSERT INTO voie (nom, equipe, cotation, utilisateur_id, secteur_id) VALUES ('Le réveil de la Marmotte', '1', '4', '1', '1');
INSERT INTO voie (nom, equipe, cotation, utilisateur_id, secteur_id) VALUES ('L''éffroyable Marmotte', '0', '6b', '3', '2');
INSERT INTO voie (nom, equipe, cotation, utilisateur_id, secteur_id) VALUES ('Pour commencer', '0', '7', '2', '3');
INSERT INTO voie (nom, equipe, cotation, utilisateur_id, secteur_id) VALUES ('Le Panorama', '0', '8a', '2', '4');

INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 1', '4b', '1', '1');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 2', '5a', '1', '1');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 3', '5b', '1', '1');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 4', '5a', '1', '1');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 1', '6b', '3', '2');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 2', '5c', '4', '2');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 3', '6a', '4', '2');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 4', '6a', '4', '2');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 1', '6c', '2', '3');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 2', '7a', '2', '3');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 3', '7b', '2', '3');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 4', '7a', '2', '3');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 1', '7c', '2', '4');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 2', '8a', '2', '4');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 3', '8b', '2', '4');
INSERT INTO longueur (nom, cotation, utilisateur_id, voie_id) VALUES ('Longueur 4', '8a', '2', '4');