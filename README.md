Projet Java EE de création d'un site web pour une bibliothèque. Ce projet a pour but de valider la formation openclassrooms expert JAVA EE

Ce projet a débuté avec, dans un premier, la réalisation de l'application du projet 4. Une fois l'application terminée, j'ai intégré les nouveaux ticktes dans ce projet 

Cloner le projet (git clone https://github.com/saga06/p6.git)

Pré-requis : Liste des éléments nécessaire au projet :

JDK 8
PostgreSQL (des problèmes peuvent être rencontrés avec les versions anciennes, merci de télécharger la dernière version)
Maven
Tomcat Server
Création de la bdd :
Sous PGadmin, créer une bdd nommée p4
utiliser le backup présent à la racine du projet pour restaurer la structure et les données (il est aussi possible d'utiliser le bdd.sql présent, il n'y a qu'à lancer le script)
Configuration interne à l'application :
a) configuration du batch de lancement d'email : modifier l'adresse email et le mot de passe présents dans ce fichier : projet4-WS\batch\src\main\resources\batch.properties

b) configuration de l'accès à la bdd : modifier les identifiants présents dans le fichier : projet4-WS\projet4-provider\projet4-webservice\src\main\webapp\META-INF\context.xml

c) Pour les web-service : Choisir un port HTTP et JMX (par défaut, pour les services : 8080 et 1099, et pour le client 8081 et 1199) Choisir un application context (par défaut pour les services :"/services", et pour le client :"/application") Modifier en fonction les fichiers (pas besoin de modification si le choix par défaut est conservé): projet4-WS\projet4-client\projet4-webapp\pom.xml (configuration/wsdloption)

Démarrer l'application : a) dans un premier temps, les services b) puis le client. c) il faut bien entendu au préalable faire un mvn package des services et un mvn clean install generate-sources du client)

Un des identifiants de connexion pouvant être utilisé est : id : test@test.com mdp : test
