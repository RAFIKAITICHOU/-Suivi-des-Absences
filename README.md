# Gestion des Absences des Étudiants
<p align="center">
  <img src="Gestion%20ABS.png" alt="Logo de l'application">
</p>
Ce projet est une application de **gestion des absences des étudiants**.
Il permet de gérer les **séances**, les **étudiants** et leurs **absences**.
L'application est développée en **Java** avec une base de données **MySQL**.

## Fonctionnalités
- **Ajouter une séance** : Permet d'ajouter une nouvelle séance avec sa matière, sa date, son heure et sa salle.
- **Inscrire un étudiant** : Permet d'ajouter un nouvel étudiant avec son nom, prénom et email.
- **Enregistrer une absence** : Permet d'enregistrer une absence pour un étudiant à une séance donnée avec une justification.
- **Filtrer les absences par matière** : Permet de lister les absences pour une matière donnée.
- **Rechercher un étudiant** : Permet de rechercher un étudiant par son nom ou son email.

## Structure de la Base de Données
La base de données MySQL **SuiviAbsences** est composée des tables suivantes :

- **Seance** : Contient les informations sur les séances.
- **Etudiant** : Contient les informations sur les étudiants.
- **Absence** : Contient les informations sur les absences des étudiants.
- **Utilisateur** : Contient les informations sur les utilisateurs de l'application.

## Schéma de la Base de Données

```sql
CREATE TABLE Seance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    matiere VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    heure TIME NOT NULL,
    salle VARCHAR(50) NOT NULL
);

CREATE TABLE Etudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    logo VARCHAR(255) -- Emplacement du logo
);

CREATE TABLE Absence (
    seance_id INT NOT NULL,
    etudiant_id INT NOT NULL,
    justification TEXT,
    PRIMARY KEY (seance_id, etudiant_id),
    FOREIGN KEY (seance_id) REFERENCES Seance(id),
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id)
);

CREATE TABLE Utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'enseignant', 'etudiant') NOT NULL
);
## 📽️ Démonstration Vidéo
👉 [▶️ Cliquez ici pour voir la démo vidéo]
voilà le lien de la video aussi : https://drive.google.com/file/d/1ov1Ox5MCQatQwRkCEIJK7a00RHMXn6Go/view?usp=drive_link

> La vidéo montre comment fonctionne l'application l'application.
