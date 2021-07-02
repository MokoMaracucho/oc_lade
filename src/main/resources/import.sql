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