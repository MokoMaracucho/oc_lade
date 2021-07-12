Déploiement de l'application

- Installer Java version 16
- Lancer PostegreSQL
- Créer une base de donnée avec la commande : CREATE DATABASE db_lade;
- Puis lancer l'application avec la commande : java -jar oc_lade-0.0.1-SNAPSHOT.jar (Emplacement du fichier .jar : /target/oc_lade-0.0.1-SNAPSHOT.jar)
- Se rendre à l'adresse : localhost:8080/utilisateur/inscription_utilisateur pour créer un compte et accéder à l'application

La base de données est automatiquement générée par Hibernate lors du chargement de l'application
Emplacement du jeu de données : /src/main/resources/import.sql


Lien vers le GitHub : https://github.com/MokoMaracucho/oc_lade/tree/master
